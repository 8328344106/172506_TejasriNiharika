import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Register } from '../register';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  regForm: FormGroup;

  submitted= false;
  register:Register=new Register();
  constructor(private fb: FormBuilder,private log:LoginService,private route:Router) { }

  ngOnInit() {
    this.regForm = this.fb.group({
      username: ['', [Validators.required,Validators.maxLength(20),Validators.minLength(3) ]],
  
      email: ['',[ Validators.required,Validators.pattern('[a-zA-Z0-9_.+-]+@gmail.com+$')] ],
      
      mobilenumber: ['',[Validators.required,Validators.minLength(10), Validators.maxLength(10),Validators.pattern('^[6-9]\\d{9}')]],
      
      password:['',[ Validators.required,Validators.maxLength(15),Validators.minLength(6),	Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$')] ],

      repeatpassword:['',[ Validators.required,Validators.maxLength(15),Validators.minLength(6),	Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$')] ],

      

    });
  }
  reg(){
    this.submitted = true;
    this.register=new Register();

  }
  check=false;
  onRegister(){
    this.submitted=true;
    this.check=true;
    this.log.createUser(this.register)
      .subscribe((data) =>{
            console.log(data),error=>console.error(error)
            
            this.route.navigateByUrl('register');
      });


  }


}
