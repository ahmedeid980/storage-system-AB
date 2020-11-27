import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class AdminIntegrationService {
  constructor(private http: HttpClient) {}

  URI = 'http://localhost:8083/demo-0.0.1-SNAPSHOT/adminServiceIntegration/'; //localhost:8080/demo-0.0.1-SNAPSHOT

}
