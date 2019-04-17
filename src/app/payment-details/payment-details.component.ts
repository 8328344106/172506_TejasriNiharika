import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Payment } from '../payment';
import { PaymentService } from '../payment.service';



@Component({
  selector: 'app-payment-details',
  templateUrl: './payment-details.component.html',
  styleUrls: ['./payment-details.component.css']
})
export class PaymentDetailsComponent implements OnInit {

  regForm: FormGroup;

  payment:Payment=new Payment();
  constructor(private fb: FormBuilder, private route: Router,private payservice:PaymentService) { }



  ngOnInit() {
    this.regForm = this.fb.group({
      cardnumber: ['', [Validators.required ]],
      expdate:['',[ Validators.required] ],
      cvv: ['', [Validators.required ]],
      cardname:['',[ Validators.required] ]
    });
  }

  pay()
  {
    this.payment= new Payment();
  }

  onPayment(){

    this.payservice.createPay(this.payment)
    .subscribe((data ) => {
      (console.log(data),error=>console.error(error));

      this.route.navigateByUrl('track');

    });
    

  }
}
