insert into students
 (name, surname )
values
('Orxan', 'Hacizade' ) ,('Gubad', 'Khushkari' ) ,('Elcin','Emirov' )  ;

insert into users
(username,password,enabled )  
values
('librarian1','{noop}12',1 )    ,
('student1','{noop}12',1 )    ;

insert into authorities
(username,authority)
values
('librarian1','ROLE_ADD_STUDENT' ),
('librarian1','ROLE_GET_STUDENT' ),
('librarian1','ROLE_DELETE_STUDENT' ),
('librarian1','ROLE_UPDATE_STUDENT' ) ,

('librarian1','ROLE_ADD_BOOK' ),
('librarian1','ROLE_GET_BOOK' ),
('librarian1','ROLE_DELETE_BOOK' ),
('librarian1','ROLE_UPDATE_BOOK' ) ;