window.onload = function () {

	//alert("one");

    let error_elem = document.getElementById("error_msg1");
    
    let form = document.getElementById("form");
    
     document.getElementById("mail").value="";
     document.getElementById("pwd").value="";
        

	
	
	form.onsubmit = function ()
    {
    //alert("two");
		let validmail = /^[a-zA-Z0-9@_.]+$/;
        let letters = /^[a-zA-Z]+$/;
        let validmobile = /^[0-9]+$/;
        let validpwd = /^[a-zA_Z0-9@_]+$/;
        let fin = /^[a-zA_Z0-9]+$/;
        
        

        let fname = document.getElementById("fname").value.trim();
        let lname = document.getElementById("lname").value.trim();
        let mail = document.getElementById("mail").value.trim();
        let mobile = document.getElementById("mobile").value.trim();
        let nric = document.getElementById("nric").value.trim();
        
        let pwd = document.getElementById("pwd").value.trim();
        let confirmpwd = document.getElementById("confirmpwd").value.trim();
        
        
        let firstChar = nric.charAt(0);
		let lastChar = nric.charAt(length-1);

		//alert(firstChar);
		//alert("hi");

        if (fname.length === 0 || lname.length === 0 || mail.length === 0 || mobile.length === 0 || nric.length === 0 || pwd.length === 0 || confirmpwd.length === 0 )
        {

            //alert("Please fill up all fields.");

            error_elem.innerHTML = "Please fill up all fields.";
            return false;
        }
        else if (!fname.match(letters))
        {
            error_elem.innerHTML = "Please enter only letters  for First Name.";

            //alert("Please enter only letters  for First Name.");
            return false;
        }
        else if( (!firstChar.match(letters)) &&  (!lastChar.match(letters)))
        {
            error_elem.innerHTML = "Please enter only letters for first and last character for NRIC";

            //alert("Please enter only letters  for First Name.");
            return false;
        }
        
        else if (!nric.match(fin))
        {
            error_elem.innerHTML = "Please enter only letters and numbers for NRIC";

            //alert("Please enter only letters  for First Name.");
            return false;
        }
        
        else if (!lname.match(letters))
        {
            error_elem.innerHTML = "Please enter only letters for Last Name";

            //alert("Please enter only letters for Last Name.");
            return false;
        }
        else if (!mail.match(validmail))
        {
            error_elem.innerHTML = "Please enter letters,digits,@ and underscores only.";

            //alert("Please enter letters,digits,@ and underscores only.");
            return false;
        }
        else if (!mobile.match(validmobile))
        {
            error_elem.innerHTML = "Please enter only digits for mobile no. ";

            //alert("Please enter only digits for mobile no.");
            return false;
        }
        else if (!pwd.match(validpwd))
        {
            error_elem.innerHTML = "Please enter letters,numbers,@ and underscores only. ";

            //alert("Please enter letters,numbers,@ and underscores only.");
            return false;
        }
        else if (!confirmpwd.match(validpwd))
        {
            error_elem.innerHTML = "Please enter letters,numbers,@ and underscores only.";

            //alert("Please enter letters,numbers,@ and underscores only.");
            return false;
        }
        else if (confirmpwd != pwd)
        {
            error_elem.innerHTML = "Password does not match.";

            //alert("Password does not match.");
            return false;
        }
        return true;
    }
}
