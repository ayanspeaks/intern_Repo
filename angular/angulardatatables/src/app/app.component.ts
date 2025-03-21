import { ApplicationModule, Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DataTablesModule } from "angular-datatables";
import studentsData from "./studentsdata.json";
import { NgbModal,NgbModule } from "@ng-bootstrap/ng-bootstrap"
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

interface Student{
  id: number;
  name: string;
  email: string;
  gender: string;
}

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,
    DataTablesModule,
    NgbModule,
    FormsModule,
    CommonModule,
    ApplicationModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angulardatatables';

  students:Student[]=studentsData;
}
