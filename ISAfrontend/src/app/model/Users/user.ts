import { Address } from "../address.model";
import { Gender } from "./gender";
import { Role } from "./role";

export abstract class User {
    id: number = -1;
    firstName: String = "";
    lastName: String = "";
    username: String = "";
    password: String = "";
    email: String = "";
    gender: Gender = Gender.OTHER;
    dob: Date = new Date();
    role: Role;
    address: Address = new Address();

    public constructor(obj?: any) {
        if (obj){
            this.id = obj.id;
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
