import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-registration-form',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './registration-form.component.html',
  styleUrl: './registration-form.component.css'
})
export class RegistrationFormComponent {
  constructor() {
    this.firstName = "";
    this.lastName = "";
    this.username = "";
    this.password = "";
  }

  firstName: string;
  lastName: string;
  username: string;
  password: string;

  // //TODO: Explore why the event's target object has no value property?
  // firstNameChangeFunction(event: Event) {
  //   console.log("tar: ", event.target);
  // }
}