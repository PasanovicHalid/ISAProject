import { Time } from "@angular/common";

export class AppointmentCreation {
    date: string;
    start: string;
    end: string;


    constructor(obj?: any) {
        this.date = obj?.date ?? ""
        this.start = obj?.start ?? ""
        this.end = obj?.end ?? ""
    }
}
