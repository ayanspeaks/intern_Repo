class Employee {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }//constructor end


        employeeDetails()
        {
            document.writeln("ID : " + this.id + " Name : " + this.name);
        }//method end

}//class end

var emp1 = new Employee(101, "Ayan");
var emp2 = new Employee(102, "Anik");

emp1.employeeDetails();
emp2.employeeDetails();
