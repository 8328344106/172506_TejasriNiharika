import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { Seller } from '../seller';
import { SellerService } from '../seller.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrls: ['./seller.component.css']
})
export class SellerComponent implements OnInit {

  constructor(private fb: FormBuilder, private sellerservice:SellerService,private route:Router) { }
  seller:Seller = new Seller();
  regForm: FormGroup;
  check=false;
  ngOnInit() 
  {
    this.regForm = this.fb.group({

      imageUrl:['',[Validators.required]],

      price:['',[Validators.required]],

      service:['',[Validators.required]]

    });
  }
  reg(){
    
    this.seller=new Seller();

  }
 
  onSeller(){
    this.check=true;
    this.sellerservice.addUser(this.seller)
      .subscribe((data) =>{
            console.log(data),error=>console.error(error)
            
            this.route.navigateByUrl('food');
      });
  }

}
