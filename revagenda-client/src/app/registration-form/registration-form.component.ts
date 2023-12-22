import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthDto, NewUserDto, RemoteService } from '../remote.service';
import { catchError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-registration-form',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './registration-form.component.html',
  styleUrl: './registration-form.component.css'
})
export class RegistrationFormComponent {
  remoteService: RemoteService;

  constructor(remoteService: RemoteService) {
    this.firstName = "";
    this.lastName = "";
    this.username = "";
    this.password = "";
    this.remoteService = remoteService;
  }

  firstName: string;
  lastName: string;
  username: string;
  password: string;

  submitRegistration() {
    console.log("submitting registration...")
    let newUser: NewUserDto = {
      user: {
        firstName: this.firstName,
        lastName: this.lastName,
        username: this.username
      },
      auth: {
        username: this.username,
        password: this.password
      }
    }
    this.remoteService.registerNewUser(newUser)
    .subscribe({
      next: (data) => {
        alert("User registered!")
        console.log(data)
      },
      error: (error: HttpErrorResponse) => {
        alert("Couldn't Register")
        console.log(error.error)
      }
    })
  }

  handleError(error: HttpErrorResponse) {

  }

}