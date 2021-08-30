window.onload = function () {

    let error_elem = document.getElementById("error_msg");

    
    let form = document.getElementById("form");

   

    form.onsubmit = function ()
     {

         let letters = /^[a-zA-Z]+$/;
		let alpha=/^[a-zA-Z0-9]+$/;
		let numbers=/^[0-9]+$/;
		let coursename=/^[0-9@$%!*:?]+$/;
        
        let id = document.getElementById("id_no").value.trim();
        let name = document.getElementById("name").value.trim();
  		let desc = document.getElementById("desc").value.trim();
        let size = document.getElementById("size").value.trim();
		let credits = document.getElementById("credits").value.trim();
        let duration = document.getElementById("duration").value.trim();
       



        if (id.length === 0 ||name.length === 0 || desc.length === 0 ||size.length === 0 || credits.length === 0 || duration.length === 0 )
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
        else if (name.match(coursename))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter only letters  for  Name.</span>";

            //alert("Please enter only letters  for First Name.");
            return false;
        }
		else if (desc.match(coursename))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter only letters  for description.</span>";

            //alert("Please enter only letters  for First Name.");
            return false;
        }
        else if (!size.match(numbers))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter only numbers</span>";

            //alert("Please enter only letters for Last Name.");
            return false;
        }
        else if (!credits.match(numbers))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter numbers only.</span>";

            //alert("Please enter letters,digits,@ and underscores only.");
            return false;
        }
		else if (!duration.match(numbers))
        {
            error_elem.innerHTML = "<span style='font-size:30px'>Please enter numbers only.</span>";

            //alert("Please enter letters,digits,@ and underscores only.");
            return false;
        }
        
        return true;
    }
}