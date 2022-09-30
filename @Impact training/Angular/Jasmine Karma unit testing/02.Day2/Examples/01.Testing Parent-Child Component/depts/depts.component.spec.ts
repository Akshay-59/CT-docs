import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { DeptsComponent } from './depts.component';

describe('DeptsComponent', () => {
  let component: DeptsComponent;
  let fixture: ComponentFixture<DeptsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeptsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeptsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });


  //1. Testing Parent component Loading
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // 2. Test child component loading
  it('should render child component elements -- dept-details', () => {
    const childComponent  = fixture.debugElement.query(By.css('app-dept-details'));
    expect(childComponent).toBeTruthy();
  });


  // 3. Test all child components
  it('should render all child component elements -- dept-details', () => {
    const childComponents  = fixture.debugElement.queryAll(By.css('app-dept-details'));
    expect(childComponents.length).toBe(component.depts.length);
  });

  // 4. Test child component properties
  it('testing child component data -- dept-details', () => {
    const testObj:any = { deptno : 10, dname : "Sales", loc : "Hyd" };
    const childComponent  = fixture.debugElement.query(By.css('app-dept-details'));
    // console.log(childComponent.properties["deptObj"]);
    // expect(childComponent.properties["deptObj"]).toEqual( testObj  );
    expect(childComponent.properties["deptObj"]).toEqual( component.depts[0] );
  });

  // 5. Test child component events
  it('testing child component events -- onDeptRemove', () => {
    const childComponent  = fixture.debugElement.query(By.css('app-dept-details'));
    const dno = childComponent.properties["deptObj"].deptno;

    //console.log("Before remove : "  + component.depts.length);
    childComponent.triggerEventHandler('onDeptRemoved', dno)
    // console.log("After remove : "  + component.depts.length);

    let index = component.depts.findIndex( (item:any) => item.deptno == dno);
    expect(index).toBe(-1);
  });









});
