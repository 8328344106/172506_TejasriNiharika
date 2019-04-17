
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AuthService{
    islogin=false;
    constructor(){}
    checkingstatus():Observable<boolean>
    {
        return of(JSON.parse(localStorage.getItem('islogin')));

    }
    logout():void{
        localStorage.removeItem('islogin');
        this.islogin=false;
    }
    valid():Observable<boolean>{
        localStorage.setItem('islogin',JSON.stringify(true));
        this.islogin = true;
        return of(true);
    }
}