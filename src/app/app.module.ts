import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
//import { ServeComponent } from './serve/serve.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FoodListComponent } from './food-list/food-list.component';
import { SellerComponent } from './seller/seller.component';
import { PaymentDetailsComponent } from './payment-details/payment-details.component';
import { ConfirmOrderComponent } from './confirm-order/confirm-order.component';
import { TrackOrderComponent } from './track-order/track-order.component';
import { AuthGuard } from './auth.guard';
import { CarouselModule } from 'ngx-bootstrap/carousel';


@NgModule({
  declarations: [
    AppComponent,
    //ServeComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    FoodListComponent,
    SellerComponent,
    PaymentDetailsComponent,
    ConfirmOrderComponent,
    TrackOrderComponent,
    
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot( [
      { 
        path: 'home', 
        component: HomeComponent
      },
      
      { 
        path: 'login',
        component: LoginComponent
      },
      { 
        path: 'register',
        component: RegisterComponent
      },
      {
        path: 'food',
        component: FoodListComponent
      },
      {
        path:'seller',
        component:SellerComponent,
        canActivate:[AuthGuard]
      },
      {
        path:'payment',
        component:PaymentDetailsComponent
      },
      {
        path:'confirm',
        component:ConfirmOrderComponent
      },
      {
        path:'track',
        component:TrackOrderComponent
      }
      ]),
    CarouselModule.forRoot()
    ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
