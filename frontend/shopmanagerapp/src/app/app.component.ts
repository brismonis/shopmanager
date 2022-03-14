import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from './product'; // interface I created
import { ProductService } from './product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
// THIS COMPONENT WILL HAVE ALL PRODUCTS IN IT WHEN getProducts is called
// WILL BE CALLED IN HTML
export class AppComponent implements OnInit {
  public products: Product[] = []; // holding all Products
 // holding all Products
  handleUpdateResponse: any;
  handleError: any;

  // INJECTING ProductService into AppComponent (they do not know each other)
  // getting access to Service
  constructor(private productService: ProductService){}

  // when initialised this will be called
  ngOnInit() {
    this.getProducts;
  }

  public getProducts(): void {
    this.productService.getProducts().subscribe({
      next: (response: Product[]) => { this.products = response; },
      error: (error: HttpErrorResponse) => { alert(error.message); },
      //next: this.handleUpdateResponse.bind(this),
      //error: this.handleError.bind(this)
  });

    // veraltet
    //   (response: Product[]) => {
    //     this.products = response;
    //   },
    //   (error: HttpErrorResponse) => {
    //     alert(error.message);
    //   }
    // )
  }

}
