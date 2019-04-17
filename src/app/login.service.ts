import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoginService{
  
    private baseUrl = 'http://localhost:8989/register';
    constructor(private http: HttpClient){

    }
    getAllEmployee(): Observable<any>{
        return this.http.get(`${this.baseUrl}`+`/all`);
    }
    getEmployee(id: String):Observable<Object>{
        return this.http.get(`${this.baseUrl}/${id}`);
    }
    createUser(register: Object): Observable<Object>{
        return this.http.post(`${this.baseUrl}`+`/add`,register);
    }
    
    validateEmployee(employee: Object): Observable<Object>{
         return this.http.post(`${this.baseUrl}`+`/validate`,employee);
     
    }
    
    addBusiness(uploadImages) {
        const obj = {uploadImages: uploadImages};
        this.http.post(`${this.baseUrl}`+`/upload`, obj)
            .subscribe(res => console.log('Done'));
    }
    images(register: Object): Observable<Object>{
        return this.http.post(`${this.baseUrl}`+`/image`,register);
    }
    

}