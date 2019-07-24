import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";
import { API_URL } from "../app.constants";

@Injectable({
  providedIn: "root"
})
export class BasicAuthenticationService {
  constructor(private http: HttpClient) {}

  getAuthenticatedUser() {
    return sessionStorage.getItem("authenticatedUser");
  }

  getAuthenticatedToken() {
    return sessionStorage.getItem("token");
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("authenticatedUser");
    return user !== null;
  }

  logout() {
    sessionStorage.removeItem("authenticatedUser");
    sessionStorage.removeItem("token");
  }

  executeJWTAuthenticationService(username, password) {
    return this.http
      .post<any>(`${API_URL}/authenticate`, { username, password })
      .pipe(
        map(data => {
          sessionStorage.setItem("authenticatedUser", username);
          sessionStorage.setItem("token", `Bearer ${data.token}`);
          return data;
        })
      );
  }

  executeBasicAuthenticationService(username, password) {
    let basicAuthHeaderString =
      "Basic " + window.btoa(username + ":" + password);
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    });
    return this.http
      .get<AuthenticationBean>(`${API_URL}/basicauth`, { headers })
      .pipe(
        map(data => {
          sessionStorage.setItem("authenticatedUser", username);
          sessionStorage.setItem("token", basicAuthHeaderString);
          return data;
        })
      );
  }
}

export class AuthenticationBean {
  constructor(public message: String) {}
}
