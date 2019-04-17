import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PaymentService } from '../payment.service';
import { Router } from '@angular/router';
import { Payment } from '../payment';

@Component({
  selector: 'app-confirm-order',
  templateUrl: './confirm-order.component.html',
  styleUrls: ['./confirm-order.component.css']
})
export class ConfirmOrderComponent implements OnInit {
  regForm: FormGroup;

  constructor(private fb: FormBuilder, private route: Router,private payservice:PaymentService) { }
  payment:Payment=new Payment();
  ngOnInit() {
    this.regForm = this.fb.group({
      address: ['', [Validators.required ]],
    });
  }
  address(){
    this.payment=new Payment();
  }

  onAddress(){
    this.payservice.createPay(this.payment).subscribe((data) => {
      (console.log(data),error=>console.log(error));
      this.route.navigateByUrl('payment');
    })
  }

}
