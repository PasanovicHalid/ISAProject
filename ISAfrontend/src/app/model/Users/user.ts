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
    role: Role = Role.HEADADMIN;

    public constructor(obj?: any) {
        //?? kaze da ako je undefined ili null onda daje 
        //vrednost desno od ??
        //u sustini ako mu damo prazan konstruktor, on
        //ce objekat popuniti sa svim podacima desno od ??
        this.id = obj?.id ?? -1;
        this.firstName = obj?.firstName ?? "";
        this.lastName = obj?.lastName ?? "";
        this.username = obj?.username ?? "";
        this.password = obj?.password ?? "";
        this.email = obj?.email ?? "";
        this.gender = obj?.gender ?? Gender.OTHER;
        this.dob = obj?.dob ?? new Date();
        this.role = obj?.role ?? Role.HEADADMIN;
    }
}
