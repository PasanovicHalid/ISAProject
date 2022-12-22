export class HeadPasswordChange {
    username: String = "";
    oldPassword: String = "";
    newPassword: String = "";

    public constructor(obj?: any) {
        if (obj){
            this.username = obj.username;
            this.oldPassword = obj.oldPassword;
            this.newPassword = obj.newPassword;
        }
    }
}
