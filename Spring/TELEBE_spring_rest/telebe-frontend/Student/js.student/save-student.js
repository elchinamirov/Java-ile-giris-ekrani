let editMode=false;

let student={};
function saveStudent(event){
    event.preventDefault();
    let name=document.getElementById('student-name').value;
    let surname=document.getElementById('student-surname').value;
    let age=document.getElementById('student-age').value;
    let sinif=document.getElementById('student-sinif').value;


let student={};

student.name=name;
student.surname=surname;
student.age=age;
student.sinif=sinif;



let xml= new XMLHttpRequest();

    


    if(editMode){
        xml.onload=function(){
            alert('Telebe yadda saxlandi');
            window.location.href='students.html';
          }
        //burada redakte apisine gonder 
        
//student.id=Number(localStorage.getItem('studentId'));

xml.open('PUT','http://localhost:8080/students',true);
    xml.setRequestHeader('Authorization',localStorage.getItem('token'));
    xml.setRequestHeader('Content-Type','application/json');

    xml.send(JSON.stringify(student));

    }else{

        xml.onload=function(){
            if(this.status==400){
              alert(JSON.parse(this.responseText).message);
            }else{
              alert('Telebe yadda saxlandi');
             window.location.href='students.html';
            }
            
          }
    
    xml.open('POST','http://localhost:8080/students',true);
    xml.setRequestHeader('Authorization',localStorage.getItem('token'));
    xml.setRequestHeader('Content-Type','application/json');

    xml.send(JSON.stringify(student));  
    }
    

}

    if(localStorage.getItem('studentEditMode')=='true'){
editMode=true;
let id=Number(localStorage.getItem('studentId'));


//burada i-ye gore telebeni apiden yukle

let xml= new XMLHttpRequest();

    xml.onload=function(){
    product=JSON.parse(this.responseText);
    document.getElementById('student-name').value=student.name;
    document.getElementById('student-surname').value=student.surname;
    document.getElementById('student-age').value=student.age;
    document.getElementById('student-sinif').value=student.sinif;
 }

    xml.open('GET','http://localhost:8080/students/'+id,true);
    xml.setRequestHeader('Authorization',localStorage.getItem('token'));

    xml.send();
}