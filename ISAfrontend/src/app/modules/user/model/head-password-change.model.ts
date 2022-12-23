export class HeadPasswordChange {
    username: String = "";
    password: String = "";
    newPassword: String = "";

    public constructor(obj?: any) {
        if (obj){
            this.username = obj.username;
            this.password = obj.password;
            this.newPassword = obj.newPassword;
        }
    }
}
