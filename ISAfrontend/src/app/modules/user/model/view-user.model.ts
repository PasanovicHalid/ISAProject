import { Address } from "../../../model/address.model";

export class ViewUser {
    firstName: String = "";
    lastName: String = "";
    username: String = "";
    password: String = "";
    email: String = "";
    gender: String = "";
    dob: Date = new Date();
    role: String = "";
    address: Address = new Address;

    public constructor(obj?: any) {
        if (obj){
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.username = obj.username;
            this.password = obj.password;
            this.email = obj.email;
            this.gender = obj.gender;
            this.dob = obj.dob;
            this.role = obj.role;
            this.address = obj.address
        }
    }
}
