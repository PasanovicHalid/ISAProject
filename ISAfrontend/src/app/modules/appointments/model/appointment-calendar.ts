import { Time } from "@angular/common";
import { concat } from "rxjs";

export class AppointmentCalendar {
    id: string
    title: string;
    start: string;
    end: string;
    color: string;

    /**
     *
     */
    constructor(obj?: any) {
        this.id = obj?.id ?? '-1'
        this.setTitle(obj);
        this.setTime(obj);
        this.setColor(obj);
    }

    private setTime(obj: any) {
        var temp = obj?.appointmentDate + 'T' + obj?.startTime
        if (temp == 'T')
            this.start = ""
        else
            this.start = temp
        temp = obj?.appointmentDate + 'T' + obj?.endTime
        if (temp == 'T')
            this.end = ""
        else
            this.end = temp
    }

    private setTitle(obj: any) {
        var title = obj?.takenBy?.firstName + ' ' + obj?.takenBy?.lastName;
        if (title != ' ')
            this.title = title;

        else
            this.title = "Free appointment";
    }

    private setColor(obj: any) {
        if (obj?.executed) {
            if (obj?.executed == 'DONE')
                this.color = '#1175A8'; //blue
            if (obj?.executed == 'PENDING')
                this.color = '#F6BE00'; // yellow
            if (obj?.executed == 'CANCELLED')
                this.color = '#AB2328'; // red
            if (obj?.executed == 'FREE')
                this.color = '#006E33'; // green
        } else {
            this.color = '#006E33'; // green
        }
    }
}
