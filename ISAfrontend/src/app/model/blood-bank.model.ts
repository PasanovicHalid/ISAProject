import { Address } from './address.model';

export class BloodBank {
  name: string = '';
  email: string = '';
  description: string = '';
  address: Address = new Address();
  rating: number = 0.0;

  public constructor(obj?: any) {
    if (obj) {
      this.name = obj?.name ?? '';
      this.email = obj?.email ?? '';
      this.description = obj?.description ?? '';
      this.address = obj.address;
      this.rating = obj?.rating ?? 0.0;
    }
  }
}
