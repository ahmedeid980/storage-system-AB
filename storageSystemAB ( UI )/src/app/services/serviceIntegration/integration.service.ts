import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class IntegrationService {

  constructor(private http: HttpClient) { }

  URI = 'http://localhost:8083/demo-0.0.1-SNAPSHOT/BackGYM/auth/'; //localhost:8080/demo-0.0.1-SNAPSHOT
  URLIntegration = 'http://localhost:8083/demo-0.0.1-SNAPSHOT/serviceIntegration/';

  login(loginRequest: any) { // loginRequest
    return this.http.post(this.URI+'login',loginRequest);
  }

  // register admin user
  reigsterUserAdmin(user: any, token: string) {
    const headerDict = {
      'Authorization': 'bearer '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.post(this.URLIntegration+'registerUserAdmin', user, requestOptions);
  }

}
