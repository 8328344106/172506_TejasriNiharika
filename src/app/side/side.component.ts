import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { MatIconRegistry } from '@angular/material';
import { DomSanitizer } from '@angular/platform-browser';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-side',
  templateUrl: './side.component.html',
  styleUrls: ['./side.component.css']
})
export class SideComponent implements OnInit {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );
     
    islogins=localStorage.getItem('islogins');
    ngOnInit(){
    }
    constructor(private breakpointObserver: BreakpointObserver,
      iconRegistry: MatIconRegistry, 
      sanitizer: DomSanitizer,
      private authservice:AuthService) {

      iconRegistry.addSvgIcon(
          'menu',
          sanitizer.bypassSecurityTrustResourceUrl('assets/menu.svg'));
    
    iconRegistry.addSvgIcon(
      'person',
      sanitizer.bypassSecurityTrustResourceUrl('assets/person.svg'));
    }
    readvalue(islogins){
      return localStorage.getItem('islogins');
    }
    logout(){
      localStorage.setItem('islogins',JSON.stringify(false));
    }

    

}
