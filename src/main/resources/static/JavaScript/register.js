window.onload = function () {

    let error_elem = document.getElementById("error_msg");

   
    let form = document.getElementById("form");
		

    form.onsubmit = function () 
		{

        let validmail = /^[a-zA-Z0-9@_.]+$/;
        
        let validpwd = /^[a-zA_Z0-9@_]+$/;

          let uname = document.getElementById("uname").value.trim();
         let pwd = document.getElementById("pwd").value.trim();
        let confirmpwd = document.getElementById("confirmpwd").value.trim();

			

        if (uname.length === 0 || pwd.length === 0 || confirmpwd.length === 0 )
        {
			//alert("Please fill up all fields.");
           error_elem.innerHTML = "<span style='font-size:30px'>Please fill up all fields.</span>";
            return false;
        }
        
        else if (!uname.match(validmail))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter letters,digits,@ and underscores only.</span>";

            
            return false;
        }
        
        else if (!pwd.match(validpwd))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter letters,numbers,@ and underscores only.</span> ";

            return false;
        }
        else if (!confirmpwd.match(validpwd))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter letters,numbers,@ and underscores only.</span>";

              return false;
        }
        else if (confirmpwd != pwd)
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Password does not match.</span>";

             return false;
        }
        return true;
    }
}