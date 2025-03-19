import { ApplicationModule, Component, OnInit } from '@angular/core';
import data from '../../data/employee.json';
import { CommonModule} from '@angular/common';
import { RouterOutlet } from '@angular/router';
//import { BrowserModule } from '@angular/platform-browser';
//import { BrowserModule } from '@angular/platform-browser';
// import { RouterOutlet } from '@angular/router';
// import { CommonEngine } from '@angular/ssr/node';
// import { AppComponent } from '../app.component';
import bootstrap from '../../main.server';


interface Employee {
  id: number;
  name: string;
  email: string;
  gender: string;
}

@Component({
  selector: 'app-emp-crud',
  imports: [
    CommonModule,
    ApplicationModule,
    RouterOutlet
  ],
  templateUrl: './emp-crud.component.html',
  styleUrl: './emp-crud.component.css'
})

export class EmpCrudComponent implements OnInit {
  employee: Employee[] = [];

  constructor(private modalService: NgbModal) { }
  ngOnInit(): void {
    this.employee = data;

  }

  deleteEmp(empId : any){
    const index = this.employee.findIndex(x => x.id == empId);
    this.employee.splice(index, 1);
  }
}
