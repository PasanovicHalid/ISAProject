import { User } from './user';

export class Customer extends User {
  jmbg: string = '';
  phoneNumber: string = '';
  profession: string = '';
  professionInfo: string = '';

  public constructor(obj?: any) {
    super(obj?.user);
    this.jmbg = obj?.jmbg ?? '';
    this.phoneNumber = obj?.phoneNumber ?? '';
    this.profession = obj?.profession ?? '';
    this.professionInfo = obj?.professionInfo ?? '';
  }
}
