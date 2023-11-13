import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validator,FormArray } from '@angular/forms';
import { User } from 'src/app/home/user.model';
import { UserserviceService } from 'src/app/userservice.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  //creating variable of type of userinterface
  user: User[] = [];
  // creating variable of form group
 
  


  //injecting userservice in this class
  constructor(private service: UserserviceService) { }
 
  ngOnInit(): void {
    
    this.regisrationForm=new FormGroup({
      firstName: new FormControl('hahah'),
      lastName: new FormControl(''),
      email: new FormControl(''),
      number: new FormControl(''),
      password: new FormControl(''),
      age: new FormControl('')

    });
  }
  regisrationForm:FormGroup;
 


  //for registering user
  formsubmit(data: User) {
    //validating form







    //ssaving data to the database
    this.service.RegisterUserData(data).subscribe((data) => {
      alert("Form Submitted")
      console.log(data)
    }
      ,
      (Error) => console.log(Error)
    )

  }



}
