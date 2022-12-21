export class LoginUser {
  userName: string = '';
  password: string = '';

  public constructor(obj?: any) {
    if (obj) {
      this.userName = obj.userName;
      this.password = obj.password;
    }
  }
}
