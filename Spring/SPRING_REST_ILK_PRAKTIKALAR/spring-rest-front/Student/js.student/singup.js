function openSigninPage(){
    window.location.href='index.html';
  }


  function signup(event){


    event.preventDefault();

    let username=document.getElementById('username').value;
      let password=document.getElementById('password').value;
  let userObject={username,password};
      // AJAX
  
   
     let xml= new XMLHttpRequest();
  
     xml.onload=function(){
  
        if(this.status==400){
            alert(JSON.parse(this.responseText).message);
          }else{
            alert('qeydiyyat getdi')
        }

  
      
     
  
  
    }
 
    xml.onerror=function(){
      alert('bir xeta oldu');
        }
 
 
    xml.open('POST','http://localhost:8080/users/signup',true);
    xml.setRequestHeader('Content-type','application/json');
    xml.send(JSON.stringify(userObject));
 
 }