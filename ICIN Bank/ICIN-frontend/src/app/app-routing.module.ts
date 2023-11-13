import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginRegisterComponent } from './login-register/login-register.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { HomeComponent } from './home/home.component';
import { UsersComponent } from './users/users.component';
import { RegisterComponent } from './login-register/register/register.component';

const routes: Routes = [
  {path:"home", component:HomeComponent},
  {path: "login-register", component:LoginRegisterComponent,pathMatch:"full"  },
  {path:"users",component:UsersComponent,pathMatch:"full"},
  {path:"register",component:RegisterComponent,pathMatch:"full"},
  {path:"**" ,component:PagenotfoundComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}
