import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PostsComponent } from './posts/posts.component'
import { ProfileComponent } from './profile/profile.component';
import { ForgotComponent } from './forgot/forgot.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: 'login', component:LoginComponent },
  { path: 'register', component:RegisterComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'posts', component:PostsComponent},
  { path: 'profile', component:ProfileComponent},
  { path: 'home', component:HomeComponent},
  { path: 'forgot', component:ForgotComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
