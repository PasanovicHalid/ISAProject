import { Address } from "./address.model";

export class BloodBank {
    name: string = '';
    email: string = '';
    description: string = '';
    adminID: string ;
    address: Address;

    public constructor(obj?: any) {
        if (obj){
            this.name = obj.name;
            this.email = obj.email;
            this.description = obj.description;
            this.adminID = obj.adminID;
            this.address = obj.address;
        }
    }
}
