function loadStudent(){
    let xml= new XMLHttpRequest();
    xml.onload=function(){
     let array=JSON.parse(this.responseText);
 
     let tbody=document.getElementById('students-tbody');
     
     let tbodyValue='<tr>';
     for(let i=0;i<array.length;i++){
         let s=array[i];
         tbodyValue+='<tr><td>'+s.id+"</td>";
         tbodyValue+='<td>'+s.name+"</td>";
         tbodyValue+='<td>'+s.cost+"</td>";
         tbodyValue+='<td>'+s.price+"</td>";
         tbodyValue+='<td>'+s.barcode+"</td>";
         tbodyValue+='<td>'+s.register+"</td>";
         tbodyValue+="<td> <button class='btn btn-primary' onclick='openEditPage("+s.id+")'>Redakte";
         tbodyValue+="</button> <button class='btn btn-danger' onclick='deleteStudent("+s.id+")'>Sil</button></td></tr>";

     }
     tbody.innerHTML=tbodyValue;
    }
    xml.open('GET','http://localhost:8080/students',true);
    xml.setRequestHeader('Authorization',localStorage.getItem('token'));
    xml.send();
 }
 
 loadStudents();

 function openAddProductPage(){
    localStorage.setItem('studentEditMode','false');
    window.location.href='save-student.html';
 }

function openEditPage(id){
    localStorage.setItem('studentEditMode','true');
    localStorage.setItem('student','id');

    window.location.href='save-student.html';

}
function deleteStudent(id){
let c=confirm('Eminsen?');

if(c){
    let xml= new XMLHttpRequest();
   xml.onload=function(){
    loadStudents();
}
    
   
   xml.open('DELETE','http://localhost:8080/students/'+id,true);
   xml.setRequestHeader('Authorization',localStorage.getItem('token'));
   xml.send();

}
function logout(){
    localStorage.removeItem('token');
    window.location.href='index.html';
}
}
