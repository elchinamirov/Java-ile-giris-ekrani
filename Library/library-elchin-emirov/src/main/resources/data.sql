insert into students
(name, surname,phone,address,username,password )
values
('Elchin', 'Amirov','050-670-2868','dernegul','student1','12' )  ;
insert into users
(username,password,enabled )  
values
('librarian1','{noop}12',1 ),
('student1','{noop}12',1 )   ;

insert into authorities
(username,authority)
values
('student1','ROLE_STUDENT' ),
('librarian1','ROLE_LIBRARIAN' ) ;

insert into authoritysiyahi
(authority,admin)
values
('ROLE_STUDENT',0), 
('ROLE_LIBRARIAN',1) ;

insert into librarians
(password,username)
values
('{noop}12','librarian1'),
('{noop}12','librarian2');