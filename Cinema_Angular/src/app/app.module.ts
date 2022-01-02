import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CinemaComponent } from './cinema/cinema.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MovieComponent } from './movie/movie.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddComponent } from './add/add.component';
import { EditComponent } from './edit/edit.component';
import { ScenaristeComponent } from './scenariste/scenariste.component';
import { EditSpecComponent } from './edit-spec/edit-spec.component';
import { AddSpecComponent } from './add-spec/add-spec.component';
import { CinemaService } from './services/cinema.service';

@NgModule({
  declarations: [
    AppComponent,
    CinemaComponent,
    MovieComponent, 
    HomeComponent,
    NavbarComponent,
    MovieComponent,
    AddComponent,
    EditComponent,
    ScenaristeComponent,
    EditSpecComponent,
    AddSpecComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule, 
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
    ],
  providers: [CinemaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
