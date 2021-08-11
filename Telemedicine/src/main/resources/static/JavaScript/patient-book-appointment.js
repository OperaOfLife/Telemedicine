$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/appointment/list",
            success: function(response){
              $.each(response.patients, (i, patient) => {  

              /*  <button type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#myModal">
                Open modal
              </button>*/

                /*let deleteButton = '<button ' +
                                        'id=' +
                                        '\"' + 'btn_delete_' + customer.id + '\"'+
                                        ' type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#delete-modal"' +
                                        '>&times</button>';*/

                /*let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + customer.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' + 
                                            customer.id +
                                            '</button>';*/
                
                let tr_id = 'tr_' + patient.patientId;
                let patientRow = '<tr id=\"' + tr_id + "\"" + '>' /*+
                          '<td>' + get_More_Info_Btn + '</td>'*/ +
                          '<td class=\"td_first_name\">' + patient.firstName.toUpperCase() + '</td>' /*+
                          '<td class=\"td_address\">' + customer.address + '</td>'*/ +
     /*                     '<td>' + deleteButton + '</td>' +*/
                          '</tr>';                
                $('#patientTable tbody').append(customerRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();        
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/patient-book-consultation.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});