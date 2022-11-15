import { Address } from './address.model';

export class BloodBank {
  name: string = '';
  email: string = '';
  description: string = '';
  address: Address = new Address();

  public constructor(obj?: any) {
    if (obj) {
      this.name = obj?.name ?? '';
      this.email = obj?.email ?? '';
      this.description = obj?.description ?? '';
      this.address = obj.address;
    }
  }
}
