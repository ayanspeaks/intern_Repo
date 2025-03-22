import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl = 'http://localhost:5578/employee/v1'; // Use your Spring Boot API URL

  constructor(private http: HttpClient) { }

  createEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.baseUrl}/create`, employee);
  }

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.baseUrl}/listall`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Employee[]> {
    return this.http.put<Employee[]>(`${this.baseUrl}/update/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Employee[]> {
    return this.http.delete<Employee[]>(`${this.baseUrl}/delete/${id}`);
  }
}