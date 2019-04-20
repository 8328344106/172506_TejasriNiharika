import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { Employee } from '../employee';
import { AuthService } from '../auth.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private islogin:boolean=false;
  constructor(private fb: FormBuilder, private route: Router, private userService:LoginService,private authservice:AuthService) { }
  regForm: FormGroup;
  submitted: boolean = false;
  response: any;
  employee:Employee=new Employee();

  @Output() change=new EventEmitter(); 

  ngOnInit() {
    this.authservice.checkingstatus().
    subscribe(val=>this.islogin=val);
    
    this.regForm = this.fb.group({
      username: ['', [Validators.required ]],
      password:['',[ Validators.required] ],
    });
   
  }
  login(){
    this.submitted=false;

    this.employee=new Employee();
  }
   check=true;
  onLogin(){
   this.submitted=true;
     this.userService.validateEmployee(this.employee)
      .subscribe((data) =>{
            (console.log(data),error=>console.error(error));
            if(data==true){
              this.check=true;
              localStorage.setItem('islogins',"true");
              this.loginstatus();
              this.route.navigateByUrl('home');
              
            }
            else{
               this.check=false;
              this.route.navigateByUrl('login');
             }
            this.employee=new Employee();
      })
      
      
   }
   loginstatus(){
     this.authservice.valid().subscribe((data) => {
       (console.log(data),error=>console.error(error));
       this.islogin=data
       
     });

   }
   logout(){
     this.authservice.logout();
     this.islogin=false;
   }
 
}

