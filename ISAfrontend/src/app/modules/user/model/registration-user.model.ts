import { Address } from "../../../model/address.model";
import { Gender } from "../../../model/Users/gender";
import { Role } from "../../../model/Users/role";

export abstract class RegistrationUser {
    firstName: String = "";
    lastName: String = "";
    username: String = "";
    password: String = "";
    email: String = "";
    gender: Gender = Gender.OTHER;
    dob: Date = new Date();
    role: Role;
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