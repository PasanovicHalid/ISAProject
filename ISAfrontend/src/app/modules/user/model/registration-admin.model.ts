import { RegistrationUser } from "../model/registration-user.model";
import { Role } from "../../../model/Users/role";
import { Gender } from "src/app/model/Users/gender";

export class RegistrationAdmin extends RegistrationUser {
    bankEmail: String = '';
    public constructor(obj?: any) {
        super(obj.user);
        this.role = Role.ADMIN;
        this.gender = Gender.OTHER;
        this.bankEmail = obj.bankEmail;
    }
}