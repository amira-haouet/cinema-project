import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CinemaService {

  public host: string = "http://localhost:9090";

  constructor(private http: HttpClient) { }

  public getVilles() {
    return this.http.get(this.host + "/villes");
  }

  public getCinemas(v) {
    return this.http.get(v._links.cinemas.href);
  }

  public getSalles(c) {
    return this.http.get(c._links.salles.href);
  }

  public getProjections(salle) {
    let url = salle._links.projections.href.replace("{?projection}", "");
    return this.http.get(url + "?projection=p1");
  }

  public getTicketsPlaces(p) {
    let url = p._links.tickets.href.replace("{?projection}", "");
    return this.http.get(url + "?projection=t1");
  }

  public payerTickets(dataForm) {
    return this.http.post(this.host + "/payerTickets", dataForm);
  }

  getMovie(page: number): Observable<any> {
    return this.http.get("http://localhost:8000/project/movie/api/page?p=" + page)

  }
  getMovieById(id: number): Observable<any> {
    return this.http.get("http://localhost:8000/project/movie/api/" + id);

  }
  getSpecialiteById(id: number): Observable<any> {
    return this.http.get("http://localhost:8000/project/scenariste/api/" + id);

  }
  addMovie(m): Observable<any> {
    return this.http.post("http://localhost:8000/project/movie/api", m)
  }

  deleteMedecin(id: number): Observable<any> {
    return this.http.delete("http://localhost:8000/project/movie/api/" + id)
  }
  updateMedecin(m): Observable<any> {
    return this.http.put("http://localhost:8000/project/movie/api", m)
  }
  getMedecinBySpecialite(s): Observable<any> {
    return this.http.get("http://localhost:8000/project/movie/api/findSpec/" + s)
  }

  getSpecialite(): Observable<any> {
    return this.http.get("http://localhost:8000/project/scenariste/api")

  }
  getSpecialiteParPage(page: number): Observable<any> {
    return this.http.get("http://localhost:8000/project/scenariste/api/page?p=" + page)

  }

  deleteSpecialite(id: number): Observable<any> {
    return this.http.delete("http://localhost:8000/project/scenariste/api/" + id)
  }
  updateSpecialite(s): Observable<any> {
    return this.http.put("http://localhost:8000/project/scenariste/api", s)
  }

  addSpecialite(s): Observable<any> {
    return this.http.post("http://localhost:8000/project/scenariste/api", s)
  }

  /* produitsRecherche: [];
   rechercherParCategorie(idCat: number): Observable<any> {
     this.produitsRecherche = [];
     this.produits.forEach((cur, index) => {
       if (idCat == cur.categorie.idCat) {
         console.log("cur " + cur);
         this.produitsRecherche.push(cur);
       }
     });
     return this.produitsRecherche;
   }*/
}

