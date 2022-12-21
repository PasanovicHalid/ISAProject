import { Time } from "@angular/common";

export class AppointmentCreation {
    bankID: number;
    date: string;
    start: string;
    end: string;


    constructor(obj?: any) {
        this.bankID = obj?.bankID ?? -1;
        this.date = obj?.date ?? ""
        this.start = obj?.start ?? ""
        this.end = obj?.end ?? ""
    }
}
