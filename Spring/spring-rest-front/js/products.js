function loadProducts(){
    let xml= new XMLHttpRequest();
    xml.onload=function(){
     let array=JSON.parse(this.responseText);
 
     let tbody=document.getElementById('products-tbody');
     
     let tbodyValue='<tr>';
     for(let i=0;i<array.length;i++){
         let p=array[i];
         tbodyValue+='<td>'+p.id+"</td>";
         tbodyValue+='<td>'+p.name+"</td>";
         tbodyValue+='<td>'+p.cost+"</td>";
         tbodyValue+='<td>'+p.price+"</td>";
         tbodyValue+='<td>'+p.barcode+"</td>";
         tbodyValue+='<td>'+p.register+"</td></tr>";
     }
     tbody.innerHTML=tbodyValue;
    }
    xml.open('GET','http://localhost:8080/products',true);
    xml.setRequestHeader('Authorization',localStorage.getItem('token'));
    xml.send();
 }
 
 loadProducts();

 function openAddProductPage(){
    window.location.href='add-product.html';
 }