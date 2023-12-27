import { Routes } from '@angular/router';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing/landing.component';

export const routes: Routes = [
    {path: "register", component: RegistrationFormComponent},
    {path: "login", component: LoginComponent},
    {path: "landing", component: LandingComponent}
];
