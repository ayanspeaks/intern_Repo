import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from '../components/employee-list/employee-list.component';
import { EmployeeCreateComponent } from '../components/employee-create/employee-create.component';
import { EmployeeEditComponent } from '../components/employee-edit/employee-edit.component';

const routes: Routes = [
  { path: 'list', component: EmployeeListComponent },
  { path: 'create', component: EmployeeCreateComponent },
  { path: 'edit/:id', component: EmployeeEditComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule { }