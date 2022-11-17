import { Customer } from 'src/app/model/Users/customer';
import { User } from '../edit-user/model/user';

export class Questionnaire {
  id: number = -1;
  customer: Customer = new Customer();
  donated: boolean = false;
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
    this.donorNumber = obj?.donorNumber ?? '';
    this.date = obj?.date ?? new Date();
  }
}
