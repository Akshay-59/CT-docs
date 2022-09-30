import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports : [FormsModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

// 1.  Default Test Case --- Testing Component Instance Loads without any issues
  it('should create component instance', () => {
    expect(component).toBeTruthy();
  });

// 2.Testing component properties
it('result property should be empty as default value', () => {
  const strOutput:string  = component.result;
  expect(strOutput).toBe("");
});

// 3.Testing component methods
it('should result contains "Welcome to Admin" for valid user crdentials', () => {
  component.uid = "admin";
  component.pwd = "admin123";
  component.login_click();
  const strOutput:string  = component.result;
  expect(strOutput).toBe("Welcome to Admin");
});

// 4.Testing component methods
it('should result contains "Invalid user id or password" for invalid user crdentials', () => {
  component.uid = "hello";
  component.pwd = "hello123";
  component.login_click();
  const strOutput:string  = component.result;
  expect(strOutput).toBe("Invalid user id or password");
});

// 5.Testing component methods & properties
it('should result contains "Invalid user id or password" for empty user crdentials', () => {
  component.uid = "";
  component.pwd = "";
  component.login_click();
  const strOutput:string  = component.result;
  expect(strOutput).toBe("Invalid user id or password");
});

//-------------------------------------------------------
//Integration with Tempalte
//-------------------------------------------------------

// 6.Testing Component Templates --- html elements
it('should contains "Testing Angular Components" as text in h3 tag', () => {
 let headingObj = fixture.nativeElement.querySelector('h3');
 //console.log(headingObj.textContent);
  expect(headingObj.textContent).toBe('Testing Angular Components');
});

// 7.Testing Component Templates --- get/set value to textbox
it('should set the value "Scott" to user id textbox', () => {

  let inputObj = fixture.nativeElement.querySelector('input');
  inputObj.value = 'Scott';
  // console.log(inputObj.value);
   expect(inputObj.value).toBe('Scott');
 });


 // 8.Testing Component Templates --- data binding -- ngModel
it('should set the textbox value to component property', () => {

  let inputObj = fixture.nativeElement.querySelector('input');
  inputObj.value = 'Scott';

  // reflect two-way data binding
  inputObj.dispatchEvent(new Event('input'));

  // console.log("User Id : " + component.uid);
   expect(component.uid).toBe('Scott');
 });


 //9.Testing Component Templates --- events, data binding
 it('should login button click generates result in paragraph -- valid user', () => {

    const inputArray =  fixture.nativeElement.querySelectorAll("input");

		inputArray[0].value = 'admin';
		inputArray[0].dispatchEvent(new Event('input'));

		inputArray[1].value = 'admin123';
		inputArray[1].dispatchEvent(new Event('input'));

    let inputObj = fixture.nativeElement.querySelector('button');
		inputObj.dispatchEvent(new Event('click'));

    //console.log(component.result);  // should modify paragraph
    fixture.detectChanges();

    let parObj = fixture.nativeElement.querySelector('p');
    expect(parObj.textContent).toBe('Welcome to Admin');
 });


 //10.Testing Component Templates --- events, data binding
 it('should login button click generates result in paragraph -- invalid user', () => {

  const inputArray =  fixture.nativeElement.querySelectorAll("input");

  inputArray[0].value = 'scott';
  inputArray[0].dispatchEvent(new Event('input'));

  inputArray[1].value = 'scott123';
  inputArray[1].dispatchEvent(new Event('input'));

  let inputObj = fixture.nativeElement.querySelector('button');
  inputObj.dispatchEvent(new Event('click'));

  //console.log(component.result);  // should modify paragraph
  fixture.detectChanges();

  let parObj = fixture.nativeElement.querySelector('p');
  expect(parObj.textContent).toBe('Invalid user id or password');
});


});
