import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms'
@Component({
  selector: 'app-medecin',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
  seachForm: FormGroup;
  constructor(private _apiService: ApiService, private formBuilder: FormBuilder) {
    this.seachForm = formBuilder.group(
      {
        sc: new FormControl()
      })
  }

  ngOnInit(): void {
    this.listMedecin()
  }

  movies: Array<any>;
  pages: Array<number>;
  page: number = 0;
  setPage(i, event: any) {
    event.preventDefault();
    this.page = i
    this.listMedecin();
  }

  listMedecin() {
    console.log(this.page)
    this._apiService.getMovie(this.page).subscribe(
      data => {
        console.log(data);
        this.movies = data['content'];
        this.pages = new Array(data['totalPages']);
      }
    )
  }
  listSpecialite() {

    this._apiService.getSpecialite().subscribe(
      data => {
        console.log(data);
        this.movies = data;
      }
    )
  }
  delete(id: number) {
    let conf = confirm("Etes-vous sûr ?");
    if (conf)
      console.log(id)
    this._apiService.deleteMedecin(id).subscribe(
      data => {
        console.log(data);
        this.movies = data;
        this.listMedecin()
      }
    )

  }
  search() {

    var scenaristes = this.movies
    var dataMed = this.seachForm.value
    console.log(dataMed.sc)
    this._apiService.getMedecinBySpecialite(dataMed.sc).subscribe(
      data => {
        console.log(data)
        if (dataMed.sc != null) {
          this.movies = data
        }
        else {
          this.listMedecin()
        }

      }, err => {
        this.listMedecin()
      }
    )
  }

}
