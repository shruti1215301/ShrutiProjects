var rowNum = 0;
function validateEmail() {

    var myemail = $("#email").val();

    var reexp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;



    if (reexp.test(myemail) == true) {

        return true;

    }

    else {

        alert("please check your email once");
        frm.mail.value = '';

        return false;

    }

}


function addRow(frm) {
    rowNum++;

    var Name = document.forms["myForm"]["name"].value;
    if (Name == "") {
        hasError = true;
        errorMsg = "Name must be filled out";
    } else if (Name.length <= 8) {
        hasError = true;
        errorMsg = "Length of Name Must be Greater Than 8";
    }

    validateEmail();

    var Web = document.forms["myForm"]["website"].value;
    if (Web == "") {
        hasError = true;
        errorMsg = "Website must be filled out";
        
        
    }
    var Img = document.forms["myForm"]["image"].value;

    if (Img == "") {
        hasError = true;
        errorMsg = "Image link  must be filled out";
        
       
    }

    var x = document.getElementById('id1').checked;
    if (x) {
        var gender = "Male";
    }
    else {
        var gender = "Female";
    }

    var skill = "", Java, HTML, CSS;
    Java = document.getElementById("java");
    HTML = document.getElementById("html");
    CSS = document.getElementById("css");
    if (Java.checked == true) {
        if (skill.length == 0) {
            skill = skill + Java.value;
        }
        else {
            skill = skill + " , " + Java.value;
        }
    }

    if (HTML.checked == true) {
        if (skill.length == 0) {
            skill = skill + HTML.value;
        }
        else {
            skill = skill + " , " + HTML.value;
        }
    }

    if (CSS.checked == true) {
        if (skill.length == 0) {
            skill = skill + CSS.value;
        }
        else {
            skill = skill + " , " + CSS.value;
        }
    }






    var y = '<table id="th" align="center"><tr><th id="th1">Description</th><th id="th2">Image</th></tr></table>';
if (rowNum == 1) {
    jQuery('#tableCreation').append(y);
}

var row = '<tr><td id="col1" style="padding-left: 10px; text-align: center;">' + frm.name.value + '<br>' + gender + '<br>' + frm.mail.value + '<br><a href="' + frm.website.value + '" target="_blank">' + frm.website.value + '</a><br>' + skill + '</td> <td id="col2"><img src="' + frm.image.value + '" alt="Ram" width="100px" height="100px"></td><tr>';

var table = '<table align="center"><tbody id="itemRows">' + row + '</tbody></table>';

jQuery('#tableCreation').append(table);
frm.name.value = '';
frm.mail.value = '';
frm.website.value = '';
frm.image.value = '';


}