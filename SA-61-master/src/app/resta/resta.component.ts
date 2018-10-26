import{Component, OnInit, Input}from '@angular/core';
import {RestaService}from '../resta.service';
import {Observable} from 'rxjs';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-resta',
  templateUrl: './resta.component.html',
  styleUrls: ['./resta.component.css']
})
export class RestaComponent implements OnInit {

  @Input() mylogin:LoginComponent;
  restas:Array<any>;
  member:any;
  
  constructor(private restaService: RestaService) { }

  ngOnInit() {
    this.restaService.getAllRestaurant().subscribe(data => {
    this.restas = data;
    })

    this.restaService.getMemberById(this.restaService.memberid).subscribe(data => {
      this.member = data;
      })
  }

}
