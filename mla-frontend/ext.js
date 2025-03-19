function validateForm(){
    var username = document.mla.user.value;
    var password = document.mla.pwd.value;

    if(username == null || username == ""){
        alert("enter your username");
        return false;
    }
    else if(password.length < 8){
        alert("your secret password minimum length is 8 characters!");
        return false;
    }
}
