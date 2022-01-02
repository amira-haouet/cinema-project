import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms'
import { Router } from '@angular/router';
import { CinemaService } from '../services/cinema.service';

@Component({
  selector: 'app-add-spec',
  templateUrl: './add-spec.component.html',
  styleUrls: ['./add-spec.component.css']
})
export class AddSpecComponent implements OnInit {
  addForm: FormGroup;
  constructor(private _apiService: CinemaService, private formBuilder: FormBuilder, private router: Router) {
    this.addForm = formBuilder.group(
      {
        nom: new FormControl(null, [
          Validators.required,
          Validators.minLength(2)]),
        prenom: new FormControl(null, [
          Validators.required,
          Validators.minLength(2)]),

      })
  }

  ngOnInit(): void {
  }

  add() {

    var data = this.addForm.value;

    var s = {
      nomSc: data.nom,
      prenom: data.prenom,

    }
    this._apiService.addSpecialite(s).subscribe(
      () => {

        this.router.navigate(['scenariste']).then(() => {

          window.location.reload();
        });
      }
    )

  }

}
