import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { CinemaService } from '../services/cinema.service';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  addForm: FormGroup;
  constructor(private _apiService: CinemaService, private formBuilder: FormBuilder, private router: Router) {
    this.addForm = formBuilder.group(
      {
        titre: new FormControl(null, [
          Validators.required,
          Validators.minLength(2),
          Validators.pattern('^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.-]+$')
        ]),
        prixTicket: new FormControl(null, [
          Validators.required,
          Validators.minLength(3),
          // Validators.pattern('^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.-]+$')
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
      }
    )


  }
  scenariste: Array<any>;
  ngOnInit(): void {
    this.listSpecialite();
  }
  listSpecialite() {

    this._apiService.getSpecialite().subscribe(
      data => {
        console.log(data)
        this.scenariste = data;

      }
    )
  }
  add() {

    var data = this.addForm.value;
    var sc = {
      idSc: data.sc
    }
    console.log(data.date)
    var m = {
      titre: data.titre,
      prixTicket: data.prixTicket,
      dateSortie: data.dateSortie,
      genre: data.genre,
      scenariste: sc
    }
    this._apiService.addMovie(m).subscribe(
      () => {

        this.router.navigate(['movie']);
      }
    )

  }
}
