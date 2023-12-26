import { Component } from '@angular/core';
import { RemoteService } from '../remote.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
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
  }

  cookieLogin() {
    
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
