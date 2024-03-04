insert into products
(name, quantity )
values
('Alma', '44' ) ,('Armud', '55' ) ,('Nar','66' ) ,('Heyva','77' )  ;

 

insert into users
(username,password,enabled )  
values
('admin1','{noop}1',1 )    ;

insert into authorities
(username,authority)
values
('admin1','ROLE_ADD_PRODUCT' ),
('admin1','ROLE_GET_PRODUCT' ),
('admin1','ROLE_DELETE_PRODUCT' ),
('admin1','ROLE_UPDATE_PRODUCT' ) ;