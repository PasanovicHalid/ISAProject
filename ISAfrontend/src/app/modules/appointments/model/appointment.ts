import { BloodBank } from "./blood-bank";

export class Appointment {
    id: number;
    appointmentDate: string;
    startTime: string;
    endTime: string;
    bloodBank: BloodBank;

    public constructor(obj?: any) {
        this.id = obj?.id ?? -1;
        this.appointmentDate = obj?.appointmentDate ?? '';
        this.startTime = obj?.startTime ?? '';
        this.endTime = obj?.endTime ?? '';
        this.bloodBank = obj?.bloodBank ?? new BloodBank();
    }
}
