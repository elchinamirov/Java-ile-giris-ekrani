insert into students
 (name, surname )
values
('Orxan', '	Hacizade' ) ,('Gubad', 'Khushkari' ) ,('Elcin','Emirov' )  ;

insert into users
(username,password,enabled )  
values
('admin1','{noop}1',1 )    ;

insert into authorities
(username,authority)
values
('admin1','ROLE_GET_STUDENT' );