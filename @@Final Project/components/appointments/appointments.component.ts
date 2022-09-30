import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../service.service';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {
  appointments: any;
  res: any;
  constructor(
    private http: HttpClient,
    
    private dataservice: ServiceService
  ) {}

  ngOnInit(): void {
    this.getPhysiciansName();
    //this.onSelect(this.selectedPhysician.id);
  }
  getPhysiciansName() {
    this.dataservice.getAllAppointments().subscribe((data: any) => {
      this.appointments = data;
      console.log('data', data);
    });
  }
}
