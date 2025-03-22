import { Routes } from '@angular/router';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './components/employee-create/employee-create.component';
import { EmployeeEditComponent } from './components/employee-edit/employee-edit.component';

export const routes: Routes = [
    { path: 'employee/list', component: EmployeeListComponent },
    { path: 'employee/create', component: EmployeeCreateComponent },
    { path: 'employee/edit/:id', component: EmployeeEditComponent },
    { path: 'employee', redirectTo: 'employee/list', pathMatch: 'full' },
    { path: '', component: EmployeeListComponent }, // Display EmployeeListComponent at the root
  ];