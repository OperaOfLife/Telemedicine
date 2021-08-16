#database operation：


alter table doctor 
add 
office 
varchar
(20) not null;



UPDATE doctor
SET office
='Pediatrist'
WHERE first_name='tin';

UPDATE doctor
SET office
='Cardiologist'
WHERE first_name='cher wah';




alter table doctor 
add 
Introduction 
varchar
(1000) not null;

UPDATE doctor
SET Introduction
='Professor has extensive
clinical experience in the repair of peripheral nerve injuries, functional reconstruction of hand tendon injuries'
WHERE first_name='tin';

UPDATE doctor
SET Introduction
='Specializing
in the surgical treatment of osteoarthritis, alcohol-induced femoral head necrosis and congenital hip dysplasia'
WHERE first_name='cher wah';



//ok
