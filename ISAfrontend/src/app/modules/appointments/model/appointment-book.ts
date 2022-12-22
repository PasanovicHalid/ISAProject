export class AppointmentBook {
  appointmentId: number;
  customerId: string | null;

  public constructor(obj?: any) {
    this.appointmentId = obj?.id ?? -1;
    this.customerId = obj?.customerId ?? -1;
  }
}
