import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms'
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {


  // currentFilm = this.movie;
  editForm: FormGroup;
  
  constructor(
    private _apiService: ApiService,
    private formBuilder: FormBuilder,
    private router: Router,
    private Aroute: ActivatedRoute) {

    this.editForm = formBuilder.group(
      {
        titre: new FormControl(null, [
          Validators.required,
          Validators.minLength(2),
          Validators.pattern('^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.-]+$')
        ]),
        prixTicket: new FormControl(null, [
          Validators.required,
          Validators.minLength(2),
          //  Validators.pattern('^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.-]+$')
        ]),
        dateSortie: new FormControl(null, [
          Validators.required,
        ]),
        genre: new FormControl(null, [
          Validators.required,
        ]),
        sc: new FormControl(null, [
          Validators.required,
        ])
      })
  }
// get old data
  private oldData;

  m: any;
  scenariste: Array<any>;
  id: number;
  ngOnInit(): void {

    this.Aroute.queryParams.subscribe(params => {
      this.id = params['id'];

    });

    this.getMedecinById(this.id);
    this.listSpecialite();

  }


  listSpecialite() {

    this._apiService.getSpecialite().subscribe(
      data => {
        this.scenariste = data;
      }
    )
  }

  getMedecinById(id) {
    this._apiService.getMovieById(id).subscribe(
      data => {
        this.m = data;

      }, error => console.log(error)
    )
  }
  edit() {


    let conf = confirm("si vous voulez modifier cliquer sur ok");
    if (conf)
      var data = this.editForm.value;

    var sc = {
      idSc: data.sc
    }
    console.log(data)
    var m = {
      idMovie: this.id,
      titre: data.titre,
      prixTicket: data.prixTicket,
      dateSortie: data.dateSortie,
      genre: data.genre,
      scenariste: sc
    }
    this._apiService.updateMedecin(m).subscribe(
      () => {

        this.router.navigate(['movie']);
      }, (error) => { alert("Problème lors de la modification !"); }
    )

  }

}
