import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddSpecComponent } from './add-spec/add-spec.component';
import { AddComponent } from './add/add.component';
import {CinemaComponent} from './cinema/cinema.component';
import { EditSpecComponent } from './edit-spec/edit-spec.component';
import { EditComponent } from './edit/edit.component';
import { HomeComponent } from './home/home.component';
import { MovieComponent } from './movie/movie.component';
import { ScenaristeComponent } from './scenariste/scenariste.component';


const routes: Routes = [

   { path: "cinema",
    component: CinemaComponent},

    { path: '', component: HomeComponent },
  { path: 'movie', component: MovieComponent },
  { path: 'movie/add', component: AddComponent },
  { path: 'movie/edit', component: EditComponent },
  { path: 'scenariste', component: ScenaristeComponent },
  { path: 'scenariste/edit', component: EditSpecComponent },
  { path: 'scenariste/add', component: AddSpecComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
