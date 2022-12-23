export class FormDTO {
  customerId: string | null = '';
  donated: boolean = false;
  denied: boolean = false;
  healthy: boolean = false;
  eaten: boolean = false;
  dangerousJob: boolean = false;
  takingMedicine: boolean = false;
  secondState: boolean = false;
  menstruating: boolean = false;
  pregnant: boolean = false;
  donorNumber: string = '';
  date: Date = new Date();

  public constructor(obj?: any) {
    //?? kaze da ako je undefined ili null onda daje
    //vrednost desno od ??
    //u sustini ako mu damo prazan konstruktor, on
    //ce objekat popuniti sa svim podacima desno od ??
    this.customerId = obj?.customer ?? '-1';
    this.donated = obj?.donated ?? false;
    this.denied = obj?.denied ?? false;
    this.healthy = obj?.healthy ?? false;
    this.eaten = obj?.eaten ?? false;
    this.dangerousJob = obj?.dangerousJob ?? false;
    this.takingMedicine = obj?.takingMedicine ?? false;
    this.secondState = obj?.secondState ?? false;
    this.menstruating = obj?.menstruating ?? false;
    this.pregnant = obj?.pregnant ?? false;
    this.donorNumber = obj?.donorNumber ?? '';
    this.date = obj?.date ?? new Date();
  }
}
