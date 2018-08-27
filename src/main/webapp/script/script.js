function isChecked() {
    getLocation();
    showPosition();
}

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}

function showPosition(position) {
    var latitude = position.coords.latitude;
    var longitude = position.coords.longitude;
    var isActive = document.getElementById("exampleCheck1").checked;
    var userId = document.getElementById("userId").value;
    var url = "/setUserActive";

    if (isActive) {

        var userObj = {
            "userId": userId,
            "latitude": latitude,
            "longitude": longitude,
            "isActive": true
        };


        $.ajax({
            url: url,
            method: "post",
            data: userObj,
            error: function (message) {
                console.log(message);
            },
            success: function (data) {
                console.log("success");
            }
        });
    } else {
        var userObj = {
            "userId": userId,
            "isActive": false
        };
        $.ajax({
            url: url,
            method: "post",
            data: userObj,
            error: function (message) {
                console.log(message);
            },
            success: function (data) {
                console.log("success");
            }
        });
    }
}