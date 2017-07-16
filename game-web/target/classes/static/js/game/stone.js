/* global players */

var players;
var currentTurnPlayerIndex;

/**
 * Sets click events and color classes for next user by given playerIndex
 * @param {int} playerIndex 
 */
function changeTurn(playerIndex) {

    if (playerIndex === currentTurnPlayerIndex) {
        console.log("Turn has been changed to Player -> " + playerIndex);
    } else {
        console.log("Player has another turn Player -> " + playerIndex);
    }

    currentTurnPlayerIndex = playerIndex;
    $(players[playerIndex]).addClass("green");
    $(players[playerIndex]).find(".pit").on("click", pitClickHandler);
}

/**
 * Pit click event listener 
 */
function pitClickHandler() {


    var pitIndex = $(this).index() - 1;

    /* Remove all pit click events */
    $(".playerElement").removeClass("green");
    $(".pit").off("click");

    console.log("Pit selected -> " + pitIndex);

    doMove(pitIndex);
}

function doMove(pitIndex) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8081/stonegame/play',
        data: {pitIndex: pitIndex},
        success: function (response) {
            var nextPlayerID = response.nextPlayerID;
            jQuery.each(response.players, function (i, player) {
                var playerElement = $(players[player.id]);
                jQuery.each(player.board.pits, function (j, pit) {
                    var pitElement = $(playerElement).find("td").get(pit.index + 1);
                    $(pitElement).html(pit.count);
                });
            });

            changeTurn(nextPlayerID);
        },
        fail: function (error) {
            console.error(error);
        }
    });
}

/**
 * Retrieves game data from server 
 */
function initialize() {
    doMove(null);
}

$(document).ready(function () {
    players = [$("#player1"), $("#player2")];

    $.ajaxSetup({
        xhrFields: {withCredentials: true},
        crossDomain: true
    });

    initialize();
});