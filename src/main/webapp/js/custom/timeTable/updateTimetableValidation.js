function updateTimetableValidation() {
    var name = document.forms["updateTimetable"]["name"].value;
    var startingTime = document.forms["updateTimetable"]["startingTime"].value;
    var startingPoint = document.forms["updateTimetable"]["startingPoint"].value;
    var endTime = document.forms["updateTimetable"]["endTime"].value;
    var destination = document.forms["updateTimetable"]["destination"].value;

    if (isAlphebatic1(name)) {
        if (startingTimeValidation(startingTime)) {
            if (startingPointValidation(startingPoint)) {
                if (endTimeValidation(endTime)) {
                    if (destinationValidation(destination)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    } else {
        return false;
    }
}

<!-- Empty Validation -->
function isEmpty(elemValue, field) {
    if (elemValue == "" || elemValue == null) {
        document.getElementById('eEmpty').innerHTML="You cannot have " + field + "field empty";
        return true;
    } else {
        return false;
    }
}

<!-- First Name Validation -->
function isAlphebatic1(elemValue) {
    var exp = /^[a-zA-Z]+$/;
    if (!isEmpty(elemValue, "name")) {
        if (elemValue.match(exp)) {
            return true;
        } else {
            document.getElementById('eName').innerHTML="Enter only text for you name";
            return false;
        }
    } else {
        return false;
    }
}

<!-- Starting Time Empty Validation -->
function startingTimeValidation(elemValue) {
    if (!isEmpty(elemValue, "startingTime")) {
        return true;
    } else {
        return false;
    }
}

<!-- Starting Point Empty Validation -->
function startingPointValidation(elemValue) {
    if (elemValue == "Select Starting point") {
        document.getElementById('eStartingPoint').innerHTML="Select Starting point";
        return false;
    } else {
        return true;
    }
}

<!-- End Time Empty Validation -->
function endTimeValidation(elemValue) {
    if (!isEmpty(elemValue, "endTime")) {
        return true;
    } else {
        return false;
    }
}

<!-- Destination Empty Validation -->
function destinationValidation(elemValue) {
    if (elemValue == "Select Destination") {
        document.getElementById('eStartingPoint').innerHTML="Select Destination";
        return false;
    } else {
        return true;
    }
}