$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8081/stonegame/play"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});