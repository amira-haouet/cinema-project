import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms'
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CinemaService } from '../services/cinema.service';

@Component({
  selector: 'app-edit-spec',
  templateUrl: './edit-spec.component.html',
  styleUrls: ['./edit-spec.component.css']
})
export class EditSpecComponent implements OnInit {
  editForm: FormGroup;


  constructor(
    private _apiService: CinemaService,
    private formBuilder: FormBuilder,
    private router: Router,
    private Aroute: ActivatedRoute) {

    this.editForm = formBuilder.group(
      {
        nomSc: new FormControl(null, [
          Validators.required,
          Validators.minLength(2)]),

        prenomSc: new FormControl(null, [
          Validators.required,
          Validators.minLength(2)]),
      })
  }

  s: any;
  id: number;
  scenariste: Array<any>;

  ngOnInit(): void {

    this.Aroute.queryParams.subscribe(params => {
      this.id = params['id'];

    });
    this.getSpecialiteById(this.id)
   // this.listSpecialite();

  }
  listSpecialite() {

    this._apiService.getSpecialite().subscribe(
      data => {
        this.scenariste = data;
      }
    )
  }

  getSpecialiteById(id) {
    this._apiService.getSpecialiteById(id).subscribe(
      data => {
        this.s = data;

      }, error => console.log(error)
    )
  }

  edit() {
    let conf = confirm("si vous voulez modifier cliquer sur ok");
    if (conf)
      var data = this.editForm.value;

    console.log(data)

    var s = {
      idSc: this.id,
      nomSc: data.nomSc,
      prenomSc: data.prenomSc
    }

    this._apiService.updateSpecialite(s).subscribe(
      () => {
        this.router.navigate(['scenariste']);
      }, (error) => { alert("Problème lors de la modification !"); }

    )

  }

}
