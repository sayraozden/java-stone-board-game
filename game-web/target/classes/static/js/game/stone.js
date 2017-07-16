/* global players */

var players;



function changeTurn(playerIndex) {
    $(players[playerIndex]).addClass("green");
    $(players[playerIndex]).find(".pit").on("click", pitClickHandler);
}

function pitClickHandler() {

    var pitIndex = $(this).index() - 1;

    /* Unbind all click events */

    $(".playerElement").removeClass("green");

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
            //changeTurn(nextPlayerID);
        },
        fail: function (error) {
            console.error(error);
        }
    });
}

$(document).ready(function () {
    $.ajaxSetup({
        xhrFields: {withCredentials: true},
        crossDomain: true
    });
    players = [$("#player1"), $("#player2")];
    changeTurn(0);
});