import { Component } from '@angular/core';
import { RemoteService } from '../remote.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule, 
    CommonModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string
  password: string
  remoteService: RemoteService

  constructor(remoteService: RemoteService) {
    this.username = ""
    this.password = ""
    this.remoteService = remoteService;
    let something = document.cookie.split(';')
    //pretend we know there's only one cookie
    let somethingElse = something[0].split("=")
    window.location.replace("landing")//we can navigate to another route with this method
    /*
      The goal now would be to bypass the login page entirely when the cookie is detected
      (maybe we want to test it for validity, maybe we do send that info to the server to
        verify once more)
    */


    console.log("Cookie?", somethingElse[1]);
  
  }

  cookieTest() {
    this.remoteService.cookieTest().subscribe({
      next: (data) => {
        console.log(data)
      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
  }

  submitLogin() {
    this.remoteService.login({username: this.username, password: this.password})
    .subscribe({
      next: (data) => {
        alert("Access Granted!")
        console.log(data)
      },
      error: (error: HttpErrorResponse) => {
        alert("Access Denied")
        console.log(error.error)
      }
    })
  }

}
