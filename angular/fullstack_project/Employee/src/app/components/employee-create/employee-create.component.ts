import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee.model';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee-create',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent {
  employee: Employee = { id: 0, name: '', city: '', email: '' };

  constructor(private employeeService: EmployeeService, private router: Router) { }

  createEmployee(): void {
    this.employeeService.createEmployee(this.employee).subscribe(() => {
      this.router.navigate(['/employee/list']);
    });
  }
}