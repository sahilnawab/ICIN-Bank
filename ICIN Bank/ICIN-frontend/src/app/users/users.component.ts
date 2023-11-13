import { Component } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { User } from '../home/user.model';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {
  
  users:any=[];
  
  constructor(private data:UserserviceService){
   this.data.getUserData().subscribe( user=>this.users=user)
    
  
  }
  getfulldetails(){
    console.log("button clicked");
   
  }
  
}
