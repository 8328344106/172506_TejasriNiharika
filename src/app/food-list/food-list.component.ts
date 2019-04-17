import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from '../login.service';
import { bypassSanitizationTrustHtml } from '@angular/core/src/sanitization/sanitization';
import { Register } from '../register';
import { Observable } from 'rxjs';
import { Seller } from '../seller';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-food-list',
  templateUrl: './food-list.component.html',
  styleUrls: ['./food-list.component.css']
})
export class FoodListComponent implements OnInit {
  

  seller: Seller[];

  
  constructor(private bs:SellerService) { }

 

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.bs.getAllSellers().subscribe(data=>
      {
        this.seller= data as Seller[];
      });
  }


}
