import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { TrailListComponent } from './components/trail-list/trail-list.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'trails', component: TrailListComponent },
  { path: 'trails/:id', component: TrailListComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
