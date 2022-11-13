import { Gender } from "./gender";
import { Role } from "./role";

export abstract class User {
    id: number = -1;
    firstName: String = "";
    lastName: String = "";
    username: String = "";
    email: String = "";
    gender: Gender = Gender.OTHER;
    dob: Date = new Date();
    role: Role = Role.HEADADMIN;

    // public constructor(obj?: any) {
    //     this.id = obj.id;
    //     this.firstName = obj.firstName;
    //     this.lastName = obj.lastName;
    //     this.username = obj.username;
    //     this.email = obj.email;
    //     this.gender = obj.gender;
    //     this.dob = obj.dob;
    //     this.role = obj.role;
    // }
}
