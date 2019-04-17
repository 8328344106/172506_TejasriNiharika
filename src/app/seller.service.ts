import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class SellerService{
    private baseUrl = 'http://localhost:9898/seller';
    constructor(private http: HttpClient){

    }
    getAllSellers(): Observable<any>{
        return this.http.get(`${this.baseUrl}`+`/all`);
    }
    addUser(seller: Object): Observable<Object>{
        return this.http.post(`${this.baseUrl}`+`/add`,seller);
    }

}