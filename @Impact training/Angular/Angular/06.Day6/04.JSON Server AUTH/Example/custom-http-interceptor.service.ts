import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError} from 'rxjs';
import { catchError, retry  } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class CustomHttpInterceptorService implements HttpInterceptor{

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>
  {
      // code to intercept the request
      console.log("message from custom http interceptor");
     // const authToken = '1d38d128-0671-4121-8084-f6332a992a40';
     const authToken = sessionStorage.getItem("AUTH_TOKEN");


      if(authToken == null && req.url != "http://localhost:3500/login")
      {
        alert("Token not exists. You need to login to access this resource");
        return throwError( () => new Error("Token not exists. You need to login to access this resource") );
      }

      // Generated modifed request object
      let updatedReq:HttpRequest<any> = req.clone({
       setHeaders: {
           Authorization: `Bearer ${authToken}`
       }
      });

  		return next.handle(updatedReq)
      .pipe(
        // Retry on failure,  2 ---  two times
        retry(2),

        // Handle errors
        catchError((error: HttpErrorResponse) => {
          // TODO: Add error handling logic here
         // alert(`HTTP Error: ${req.url}`);

          console.log(`Error Message from HTTP Interceptor : ${req.url}, StatusCode : ${error.status} `);

         if(error.status === 404)
         {
           console.log("The requested resource could not be found -- custom message");
         }
         else
         {
           console.log(error.message);
         }

          return throwError(() => new Error(error.message));
        })
      );
 }

}
