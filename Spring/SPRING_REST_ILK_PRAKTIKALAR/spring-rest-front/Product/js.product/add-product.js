function addProduct(event){
    event.preventDefault();
    let name=document.getElementById('product-name').value;
    let cost=document.getElementById('product-cost').value;
    let price=document.getElementById('product-price').value;
    let barcode=document.getElementById('product-barcode').value;

    
let product={};

product.name=name;
product.cost=cost;
product.price=price;
product.barcode=barcode;


}