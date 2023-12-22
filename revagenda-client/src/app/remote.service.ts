import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';

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
    this.baseUrl = "http://localhost:8080"
  }

  registerNewUser(newUserDto: NewUserDto): Observable<HttpResponse<Object>> {
    return this.httpClient.post(this.baseUrl + "/register", JSON.stringify(newUserDto), /*this.httpOptions*/
    {
      observe: 'response', 
      headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })}
    )
  }

  // test(newUserDto: NewUserDto): Observable<Object> {
  //   return this.httpClient.post(this.baseUrl + "/register", JSON.stringify(newUserDto), this.httpOptions
  //   )
  // }


  login(authDto: AuthDto): Observable<HttpResponse<Object>> {
    return this.httpClient.post(this.baseUrl + "/login", JSON.stringify(authDto),
    {observe: 'response', headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })}
    )
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