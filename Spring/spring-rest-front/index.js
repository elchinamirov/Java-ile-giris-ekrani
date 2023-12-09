function login(event){
    event.preventDefault();
    let username=document.getElementById('username').value;
    let password=document.getElementById('password').value;

   let xml= new XMLHttpRequest();

   xml.onload=function(){
    alert('Duzdu esas sehife kecmek olar');

   }



   xml.onerror=function(){
    alert('sef yazdin');
   }
   xml.open('GET','http://localhost:8080/users/login',true);
   xml.setRequestHeader('Authorization',
   'Basic '+window.btoa(username+":"+password)));
   xml.send();
}