import { Injectable } from '@angular/core';
import { Product } from './product';
import { Observable } from 'rxjs';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiServerUrl = environment.apiBaseUrl;

  // You can then inject the HttpClient service as a dependency of an application class
  constructor(private http:HttpClient) { }

  // Use the HttpClient.get() method to fetch data from a server.
  // The asynchronous method sends an HTTP request,
  // and returns an Observable that emits the requested data
  // when the response is received.
  // The get() method takes two arguments; the endpoint URL from which to fetch,
  // and an options object that is used to configure the request.
  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/all`);
  }

  addProducts(product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.apiServerUrl}/product/add`, product);
  }

  updateProducts(product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.apiServerUrl}/product/update`, product);
  }

  deleteProducts(productId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/product/delete/${productId}`);
  }
}
