import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee-edit',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  employee: Employee = { id: 0, name: '', city: '', email: '' };
  employeeId: number = 0;

  constructor(private route: ActivatedRoute, private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.employeeId = +this.route.snapshot.paramMap.get('id')!;
    this.employee.id = this.employeeId;
    this.employeeService.getAllEmployees().subscribe(employees=>{
      this.employee = employees.filter(e=> e.id === this.employeeId)[0];
    })
  }

  updateEmployee(): void {
    this.employeeService.updateEmployee(this.employeeId, this.employee).subscribe(() => {
      this.router.navigate(['/employee/list']);
    });
  }
}
