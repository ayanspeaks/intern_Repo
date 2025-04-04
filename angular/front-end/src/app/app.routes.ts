import { Routes } from '@angular/router';
import { ListDataComponent } from './list-data/list-data.component';
import { AddDataComponent } from './add-data/add-data.component';

export const routes: Routes = [
    {path: '', redirectTo: 'view-product', pathMatch: 'full'},
    {path: 'view-product', component: ListDataComponent},
    {path: 'add-product', component: AddDataComponent},
];
