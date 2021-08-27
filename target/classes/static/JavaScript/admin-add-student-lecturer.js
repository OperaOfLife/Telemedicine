window.onload = function () {

    let error_elem = document.getElementById("error_msg");

    
    let form = document.getElementById("form");

    // form.document.getElementById("uname").focus;

    form.onsubmit = function () {

        let validmail = /^[a-zA-Z0-9@_.]+$/;
        let letters = /^[a-zA-Z]+$/;
		let alpha=/^[a-zA-Z0-9]+$/;
        
        let id = document.getElementById("id_no").value.trim();
        let fname = document.getElementById("fname").value.trim();
  		let mname = document.getElementById("mname").value.trim();
        let lname = document.getElementById("lname").value.trim();
		let dt = document.getElementById("date").value.trim();
        let mail = document.getElementById("email").value.trim();
       


        if (id.length === 0 ||fname.length === 0 || mname.length === 0 ||lname.length === 0 || mail.length === 0 || dt.length === 0 )
        {

            //alert("Please fill up all fields.");

            error_elem.innerHTML = "<span style='font-size:30px'>Please fill up all fields.</span>";
            return false;
        }
		else if (!id.match(alpha))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter only letters  and numbers for id.</span>";

            //alert("Please enter only letters  for First Name.");
            return false;
        }
        else if (!fname.match(letters))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter only letters  for First Name.</span>";

            //alert("Please enter only letters  for First Name.");
            return false;
        }
		else if (!mname.match(letters))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter only letters  for Middle Name.</span>";

            //alert("Please enter only letters  for First Name.");
            return false;
        }
        else if (!lname.match(letters))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter only letters for Last Name</span>";

            //alert("Please enter only letters for Last Name.");
            return false;
        }
        else if (!mail.match(validmail))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter letters,digits,@ and underscores only.</span>";

            //alert("Please enter letters,digits,@ and underscores only.");
            return false;
        }
        
        return true;
    }
}