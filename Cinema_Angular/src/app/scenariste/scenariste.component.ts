import { Component, OnInit } from '@angular/core';
import { CinemaService } from '../services/cinema.service';
@Component({
  selector: 'app-scenariste',
  templateUrl: './scenariste.component.html',
  styleUrls: ['./scenariste.component.css']
})
export class ScenaristeComponent implements OnInit {

  constructor(private _apiService: CinemaService) { }


  ngOnInit(): void {
    this.listSpecialite()
  }

  scenariste: Array<any>;
  pages: Array<number>;
  page: number = 0;
  setPage(i, event: any) {
    event.preventDefault();
    this.page = i
    this.listSpecialite();
  }
  listSpecialite() {
    console.log(this.page)
    this._apiService.getSpecialiteParPage(this.page).subscribe(
      data => {
        console.log(data);
        this.scenariste = data['content'];
        this.pages = new Array(data['totalPages']);
      }
    )
  }
  delete(id: number) {
    let conf = confirm("Etes-vous sûr ?");
    if (conf)
      console.log(id)
    this._apiService.deleteSpecialite(id).subscribe(
      data => {
        console.log(data);
        this.scenariste = data;
        this.listSpecialite()
      }
    )
  }

}
