function loadProducts(){
    let xml= new XMLHttpRequest();
    xml.onload=function(){
     let array=JSON.parse(this.responseText);
 
     let tbody=document.getElementById('products-tbody');
     
     let tbodyValue='<tr>';
     for(let i=0;i<array.length;i++){
         let p=array[i];
         tbodyValue+='<tr><td>'+p.id+"</td>";
         tbodyValue+='<td>'+p.name+"</td>";
         tbodyValue+='<td>'+p.cost+"</td>";
         tbodyValue+='<td>'+p.price+"</td>";
         tbodyValue+='<td>'+p.barcode+"</td>";
         tbodyValue+='<td>'+p.register+"</td>";
         tbodyValue+="<td> <button class='btn btn-primary' onclick='openEditPage("+p.id+")'>Redakte";
         tbodyValue+="</button> <button class='btn btn-danger' onclick='deleteProduct("+p.id+")'>Sil</button></td></tr>";

     }
     tbody.innerHTML=tbodyValue;
    }
    xml.open('GET','http://localhost:8080/products',true);
    xml.setRequestHeader('Authorization',localStorage.getItem('token'));
    xml.send();
 }
 
 loadProducts();

 function openAddProductPage(){
    localStorage.setItem('productEditMode','false');
    window.location.href='save-product.html';
 }

function openEditPage(id){
    localStorage.setItem('productEditMode','true');
    localStorage.setItem('product','id');

    window.location.href='save-product.html';

}
function deleteProduct(id){
let c=confirm('Eminsen?');

if(c){
    let xml= new XMLHttpRequest();
   xml.onload=function(){
    loadProducts();
}
    
   
   xml.open('DELETE','http://localhost:8080/products/'+id,true);
   xml.setRequestHeader('Authorization',localStorage.getItem('token'));
   xml.send();

}
}
