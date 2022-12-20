import { Component, OnInit, ViewChild } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/core'; // useful for typechecking
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import bootstrap5Plugin from '@fullcalendar/bootstrap5';

@Component({
  selector: 'app-admin-calendar',
  templateUrl: './admin-calendar.component.html',
  styleUrls: ['./admin-calendar.component.css']
})
export class AdminCalendarComponent implements OnInit {

  constructor() { }

  calendarOptions: CalendarOptions = {
    initialView: 'timeGridWeek',
    nowIndicator: true,
    plugins: [timeGridPlugin, bootstrap5Plugin],
    themeSystem: 'bootstrap5',
    events: [
      { title: 'event 1', start: '2022-12-18 12:00', end : '2022-12-18 16:00', color : 'black'},
      { title: 'event 1', start: '2022-12-18 12:10', end : '2022-12-18 16:00', color : 'black'},
      { title: 'event 1', start: '2022-12-18 12:20', end : '2022-12-18 16:00', color : 'black'},
    ]
  };

  ngOnInit(): void {
  }

}
