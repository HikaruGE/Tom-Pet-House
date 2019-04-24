// more click
$('.card-profile-stats-more-link').click(function(e){
    e.preventDefault();
    if ( $(".card-profile-stats-more-content").is(':hidden') ) {
      $('.card-profile-stats-more-link').find('i').removeClass('fa-angle-down').addClass('fa-angle-up');
    } else {
      $('.card-profile-stats-more-link').find('i').removeClass('fa-angle-up').addClass('fa-angle-down');
    }
    $(this).next('.card-profile-stats-more-content').slideToggle();
  });

  $('#edit1').click(function (e) {
    e.preventDefault();
//    $('#dogedit1').next().toggleClass('is-active');
//    $('#dogedit1').toggleClass('is-active');
    edit();
  });


 function checkDogTable() {
	 
	 var x = document.getElementById("dogtable").rows.length;
	 var appo=document.getElementById("addAppo");
	 if((x-1)==0) {
		 appo.style.display = "none";
	 } else {
		 appo.style.display = "inline-block";
	 }
	 
  }
 window.onload = checkDogTable;

function editAccount() {
    var homeaddress = document.getElementById("infohm"),
    mobileNumber = document.getElementById("infomo"),
    homenumber = document.getElementById("infohn"),
    name = document.getElementById("infoname"),
    phonenumber = document.getElementById("infopn");

    var editbutton = document.getElementById("editbu");

    var inputhm = document.getElementById("inputhm"),
    inputname = document.getElementById("inputname"),
    inputmo = document.getElementById("inputmo"),
    inputhn = document.getElementById("inputhn"),
    inputpn = document.getElementById("inputpn"),
    submit =  document.getElementById("submitbutton");

    if ($("#inputhm").css("display")=="none"){
        homeaddress.style.display = "none";
        mobileNumber.style.display = "none";
        homenumber.style.display = "none";
        phonenumber.style.display = "none";
        name.style.display = "none";

        inputhm.style.display = "inline-block";
        inputmo.style.display = "inline-block";
        inputhn.style.display = "inline-block";
        inputpn.style.display = "inline-block";
        submit.style.display = "inline-block";
        inputname.style.display = "inline-block";

        editbutton.innerText="save";
    }else {
        name.innerText = inputname.value;
        homeaddress.innerText = inputhm.value;
        mobileNumber.innerText = inputmo.value;
        homenumber.innerText = inputhn.value;
        phonenumber.innerText = inputpn.value;
        homeaddress.style.display = "inline-block";
        mobileNumber.style.display = "inline-block";
        homenumber.style.display = "inline-block";
        phonenumber.style.display = "inline-block";
        name.style.display = "inline-block";
        inputhm.style.display = "none";
        inputmo.style.display = "none";
        inputhn.style.display = "none";
        inputpn.style.display = "none";
        submit.style.display = "none";
        inputname.style.display = "none";

        editbutton.innerText="edit";
    }
}

function edit(){
    var name = document.getElementById("dogname"),
    breed = document.getElementById("dogbreed"),
    dob = document.getElementById("dob");

    var dog1 = document.getElementById("dog1"),
    breed1 = document.getElementById("breed1"),
    dob1 = document.getElementById("dob1");

    var edit1 = document.getElementById("edit1");

    var dogedit1 = document.getElementById("dogedit1");


    if (edit1.innerText=="edit") {
        edit1.innerText = "save";
        // dogedit1.next().toggleClass('is-active');
        // dogedit1.toggleClass('is-active');
    } else {
        edit1.innerText = "edit";
        dog1.innerText = name.value;
        breed1.innerText = breed.value;
        dob1.innerText = dob.value;
    }

    var markup = "<tr><td><input type='checkbox' name='record'></td><td>" + name + "</td><td>" + email + "</td></tr>";
    $(this).after(markup);


}

function remove() {
    document.getElementById("dogtable").deleteRow(1);
}


