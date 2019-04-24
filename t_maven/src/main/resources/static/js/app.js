$(document).foundation()

function pwCheck(){
       var pw1 = document.getElementById("pw1").value;
       var pw2 = document.getElementById("pw2").value;
       if(pw1!=pw2){
       alert("Entered passwords differ！");
       return false;
       }
       return true;
    }

