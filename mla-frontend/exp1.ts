let mlagreet: String = 'MLA STUDENTS ARE VERY NICE';

console.log(mlagreet);

let age: number = 20;

let fname: String = "Rohit";

let message: String = `Hello hi this simple TS response name is ${fname}. the age is ${age + 5}`;

console.log(message);

class Employee1 {
    name: String;
    age: number;
}

interface Employee2 {
    name: String;
    age: number;
}

//SPA
let emp5 : Employee1[] = [{ name: 'Ayan', age: 12 },
{ name: 'Anik', age: 11 },
{ name: 'Subha', age: 10 }];

let emp7 : Employee2[] = [{ name: 'Vinod', age: 9 },
    { name: 'Dahaka', age: 69 },
    { name: 'Ashok', age: 22 }];


console.log(emp5[0].name);
console.log(emp7[0].name+' '+emp7[0].age);

let compid: string | number = 1111;
let colgid: string | number = 'ABC123';

// console.log(compid);
// console.log(colgid);

let mlatuple: [string, number, boolean, string];

mlatuple=['Kohli', 57, true, 'working'];

console.log(mlatuple);