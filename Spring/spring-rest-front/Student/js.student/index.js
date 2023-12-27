function login(event){
    event.preventDefault();
    let username=document.getElementById('username').value;
    let password=document.getElementById('password').value;


    //AJAX
    
let token='Basic '+window.btoa(username+":"+password);

   let xml= new XMLHttpRequest();

   xml.onload=function(){
    
    localStorage.setItem('token',token);

    localStorage.setItem('username',username);

    //alert('Duzdu esas sehife kecmek olar');

    localStorage.setItem('token',token);
window.location.href='students.html';
   }



   xml.onerror=function(){
    alert('sehv yazdin');
   }
   xml.open('GET','http://localhost:8080/users/login',true);
   xml.setRequestHeader('Authorization',token);
   xml.send();
}
function openSignupPage(){
    window.location.href='signup.html';
}