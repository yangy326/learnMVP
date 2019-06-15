package cm.example.factory.model.login;

public class LoginModel {
    private String userAccount;

    private String pushId;



    private String userPassword;

    public LoginModel(String userAccount,  String userPassword , String pushId) {
        this.userAccount = userAccount;
        this.pushId = pushId;
        this.userPassword = userPassword;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
