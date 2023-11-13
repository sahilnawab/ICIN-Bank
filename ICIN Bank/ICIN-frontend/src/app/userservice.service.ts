import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { User } from './home/user.model';
@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http:HttpClient) { }
getUserData(){
  let url:string= "http://localhost:1010/alluser";
return this.http.get(url);
}
RegisterUserData(UserFromData:User){
  let url="http://localhost:1010/register";
  return this.http.post(url,UserFromData);
}
}
