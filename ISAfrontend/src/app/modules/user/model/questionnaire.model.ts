import { Customer } from 'src/app/model/Users/customer';
import { User } from '../edit-user/model/user';

export class Questionnaire {
  id: number = -1;
  customer: Customer = new Customer();
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
    this.id = obj?.id ?? -1;
    this.customer = obj?.customer ?? new Customer();
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
