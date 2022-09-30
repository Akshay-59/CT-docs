import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  // baseUrl:string  = "https://localhost:44307/api/StudentApi/";
  baseUrl:string  = "http://localhost:3000/students/";

  constructor(private httpObj:HttpClient) { }

  // Read All
  public getAllStudents(): Observable<any>
  {
    /*
    // we need to inject/add the security token in http request
    const hardcodedToken = '1d38d128-0671-4121-8084-f6332a992a40';
    const header = { 'Authorization' : `Bearer ${hardcodedToken}`};
    return this.httpObj.get(this.baseUrl, { headers: header});
    */

    return this.httpObj.get(this.baseUrl);
  }

  // Read Single
  public getStudentById(sid:number):any
  {
    return this.httpObj.get(this.baseUrl + sid);
  }

  // Create
  public addStudent(stObj:any):any
  {
    return this.httpObj.post(this.baseUrl, stObj);
  }

  // Update
  public updateStudent(stObj:any):any
  {
    return this.httpObj.put(this.baseUrl + stObj.studentId, stObj);
    // return this.httpObj.put(this.baseUrl, stObj);
  }


  // Delete
  public deleteStudent(sid:number):any
  {
    return this.httpObj.delete(this.baseUrl + sid);
  }

  //  Customizing the response using RxJS operators
  getStudentsByCity(city:string):Observable<any[]>
  {
    return this.httpObj.get<any[]>(this.baseUrl).pipe(
      map(res => {
        return  res.filter(item => item.city == city);
    })
    );
  }

  getStudentNames():Observable<string[]>
  {
    return this.httpObj.get<any[]>(this.baseUrl).pipe(
      map(res => {
        return res.map(item => { return item.name });
    })
    );
  }


  getStudentNameAndEmail():Observable<any[]>
  {
    return this.httpObj.get<any[]>(this.baseUrl).pipe(
      map(res => {
        return res.map(item => {
          return { 	name: item.name, email : item.email} });
    })
    );
  }


}
