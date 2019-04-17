import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class PaymentService{

    private baseUrl = 'http://localhost:9797/payment';
    constructor(private http: HttpClient){

    }
    getAll(): Observable<any>{
        return this.http.get(`${this.baseUrl}`+`/all`);
    }
    createPay(payment: Object): Observable<Object>{
        return this.http.post(`${this.baseUrl}`+`/add`,payment);
    }
    
}