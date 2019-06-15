package cm.example.factory.model.register;

public class RegisterModel {

    private String userAccount;

    private String userName;

    private String userPassword;

    private String userImage;

    private String userSex;

    private String userToken;



    public RegisterModel(String phone, String name, String passsword) {
       this(phone,name,passsword,null,null,null);
    }

    public RegisterModel(String userAccount, String userName, String userPassword, String userImage, String userSex, String userToken) {
        this.userAccount = userAccount;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userImage = userImage;
        this.userSex = userSex;
        this.userToken = userToken;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
