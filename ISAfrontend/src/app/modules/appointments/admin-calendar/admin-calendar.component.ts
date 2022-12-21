import { Component, OnInit, ViewChild } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/core'; // useful for typechecking
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import bootstrap5Plugin from '@fullcalendar/bootstrap5';
import { AppointmentService } from '../services/appointment.service';
import { AppointmentCalendar } from '../model/appointment-calendar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-calendar',
  templateUrl: './admin-calendar.component.html',
  styleUrls: ['./admin-calendar.component.css']
})
export class AdminCalendarComponent implements OnInit {

  constructor(private appointmentService: AppointmentService, private router: Router) { }

  calendarOptions: CalendarOptions = {
    initialView: 'timeGridWeek',
    aspectRatio: 1,
    height: 650,
    plugins: [timeGridPlugin, bootstrap5Plugin],
    themeSystem: 'bootstrap5',
    slotDuration: '00:15:00',
  };

  ngOnInit(): void {
    this.LoadEventsForCalendar();
  }

  private LoadEventsForCalendar() {
    this.appointmentService.getAllAppointments().subscribe(res => {
      var result: AppointmentCalendar[] = [];
      res.forEach((element: any) => {
        result.push(new AppointmentCalendar(element));
      });
      this.calendarOptions.events = result;
    });
  }

  addApointment() {
    this.router.navigate(['create-appointment']);
  }
}