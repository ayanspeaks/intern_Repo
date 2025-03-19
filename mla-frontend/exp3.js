var products = new Map();

products.set(1, "Apple");
products.set(2, "Xiomi");
products.set(3, "HP");
products.set(4, "xx");

document.writeln(products);

document.writeln("size of map : "+products.size);
document.writeln(products);
// document.writeln("<br>"+values);

// products.array.forEach(element => {
//     document.writeln(element);
// });

function dataPrint(key, values){
    document.writeln(key+" "+values);
}

products.forEach(dataPrint);