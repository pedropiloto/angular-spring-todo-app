import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { API_URL } from "../../app.constants";

export class HelloWorldBean {
  constructor(public message: string) {}
}

@Injectable({
  providedIn: "root"
})
export class WelcomeDataService {
  constructor(private http: HttpClient) {}

  executeHelloWorldBeanService() {
    return this.http.get<HelloWorldBean>(`${API_URL}/hello-world-bean`);
  }
}
