package cm.example.factory.helper;

import java.util.List;

import cm.example.factory.model.RspModel;
import cm.example.factory.model.db.User;
import cm.example.factory.model.login.LoginModel;
import cm.example.factory.model.register.RegisterModel;
import cm.example.factory.model.user.UserCard;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @POST("/ssm_setup_war_exploded/user/register")
    Call<RspModel> register (@Body RegisterModel registerModel);

    @POST("/ssm_setup_war_exploded/user/login")
    Call<RspModel<User>> login (@Body LoginModel loginModel);

    @GET("/ssm_setup_war_exploded/user/search")
    Call<RspModel<List<User>>> search (@Query("userName") String userName);

    @GET("/ssm_setup_war_exploded/user/getuser")
    Call<RspModel<UserCard>> getUserInfo (@Query("userId") int userId);

    @GET("/ssm_setup_war_exploded/user/follow")
    Call<RspModel<User>> add (@Query("originId") int originId , @Query("targetId") int targetId);

    @GET("/ssm_setup_war_exploded/contact/search")
    Call<RspModel<List<UserCard>>> getFriend (@Query("originId") int userId );
}
