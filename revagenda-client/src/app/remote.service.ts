import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { environment } from "../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class RemoteService {
  httpClient: HttpClient;
  baseUrl: String;
  httpOptions = {
    observe: 'response', 
    headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })}

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
    this.baseUrl = environment.apiUrl;
  }

  registerNewUser(newUserDto: NewUserDto): Observable<HttpResponse<Object>> {
    return this.httpClient.post(this.baseUrl + "/register", JSON.stringify(newUserDto), /*this.httpOptions*/
    {
      observe: 'response', 
      withCredentials: true ,
      headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })}
    )
  }

  login(authDto: AuthDto): Observable<HttpResponse<Object>> {
    return this.httpClient.post(this.baseUrl + "/login", JSON.stringify(authDto), {
      observe: 'response', 
      withCredentials: true,
      headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })}
    )
  }
  
  cookieTest(): Observable<HttpResponse<Object>> {
    return this.httpClient.get(this.baseUrl + "/cookie-test", {
      observe: 'response',
      withCredentials: true ,
      headers: new HttpHeaders()
    })
  }



}



export interface NewUserDto {
  user: UserDto
  auth: AuthDto
}

export interface UserDto {
  firstName: String
  lastName: String
  username: String
}

export interface AuthDto {
  username: String
  password: String
}