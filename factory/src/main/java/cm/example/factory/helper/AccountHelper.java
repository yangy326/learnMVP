package cm.example.factory.helper;

import android.content.Context;
import android.util.Log;

import com.example.base.callback.AddrCall;
import com.example.base.callback.LoginCall;
import com.example.base.callback.RegisterCall;
import com.example.base.callback.SearchCall;
import com.example.base.callback.ShowCallback;
import com.example.base.nethelper.NetWorker;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cm.example.factory.model.RspModel;
import cm.example.factory.model.db.User;
import cm.example.factory.model.login.LoginModel;
import cm.example.factory.model.register.RegisterModel;
import cm.example.factory.model.user.UserCard;
import cm.example.factory.presenter.showfriend.ShowPresenter;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class AccountHelper {



    public static void register(RegisterModel model , final RegisterCall callback){
        ApiService service = NetWorker.getRetrofit().create(ApiService.class);
        Call<RspModel> call = service.register(model);
        call.enqueue(new Callback<RspModel>() {
            @Override
            public void onResponse(Call<RspModel> call, Response<RspModel> response) {
                RspModel  rsp = response.body();
                if (rsp.isSuccess()){
                    callback.successRegister(null);
                }
                else {
                    callback.failedRegister(null);
                }
            }

            @Override
            public void onFailure(Call<RspModel> call, Throwable t) {
                callback.failedRegister(null);
            }
        });

    }
    public static void login(LoginModel model , final LoginCall callBack){
        ApiService service = NetWorker.getRetrofit().create(ApiService.class);
        Call<RspModel<User>> call = service.login(model);
        call.enqueue(new Callback<RspModel<User>>() {
            @Override
            public void onResponse(Call<RspModel<User>> call, Response<RspModel<User>> response) {
                RspModel  rsp = response.body();
                if (rsp.isSuccess()){
                    User user = (User)rsp.getData();

                    callBack.successLogin(user);
                }
                else {
                    callBack.failedLogin(null);
                }
            }

            @Override
            public void onFailure(Call<RspModel<User>> call, Throwable t) {
                callBack.failedLogin(null);
            }
        });
    }

    public static Call search(String name, Context context,final SearchCall callBack){
        ApiService service = NetWorker.getRetrofit(context).create(ApiService.class);
        Call<RspModel<List<User>>> call = service.search(name);
        call.enqueue(new Callback<RspModel<List<User>>>() {
            @Override
            public void onResponse(Call<RspModel<List<User>>> call, Response<RspModel<List<User>>> response) {
                RspModel  rsp = response.body();
                if (rsp.isSuccess()){
                    List<User> list = (List<User>) rsp.getData();

                    callBack.successSearch(list);
                }
                else {
                    callBack.failedSearch(null);
                }

            }

            @Override
            public void onFailure(Call<RspModel<List<User>>> call, Throwable t) {

            }
        });
        return call;

    }



    public static void add(int originId , int targetId, Context context,final AddrCall.AddCallback callBack){
        ApiService service = NetWorker.getRetrofit(context).create(ApiService.class);
        Call<RspModel<User>> call = service.add(originId,targetId);
        call.enqueue(new Callback<RspModel<User>>() {
            @Override
            public void onResponse(Call<RspModel<User>> call, Response<RspModel<User>> response) {
                RspModel  rsp = response.body();
                if (rsp.isSuccess()){
                    User user =  (User) rsp.getData();

                    callBack.successAdd(user);
                }
                else {
                    callBack.failedAdd(null);
                }
            }

            @Override
            public void onFailure(Call<RspModel<User>> call, Throwable t) {

            }
        });

    }

    public static void getUserInfo(int userId, Context context,final AddrCall.GetCallback callBack){
        ApiService service = NetWorker.getRetrofit(context).create(ApiService.class);
        Call<RspModel<UserCard>> call = service.getUserInfo(userId);
        call.enqueue(new Callback<RspModel<UserCard>>() {
            @Override
            public void onResponse(Call<RspModel<UserCard>> call, Response<RspModel<UserCard>> response) {
                RspModel  rsp = response.body();
                if (rsp.isSuccess()){
                    UserCard user =  (UserCard) rsp.getData();

                    callBack.successGet(user);
                }
                else {
                    callBack.failedGet(null);
                }
            }

            @Override
            public void onFailure(Call<RspModel<UserCard>> call, Throwable t) {

            }
        });

    }
    public static void getFriend(int userId , Context context, final ShowCallback.ShowPerson callBack){
        ApiService service = NetWorker.getRetrofit(context).create(ApiService.class);
        Call<RspModel<List<UserCard>>> call = service.getFriend(userId);
        call.enqueue(new Callback<RspModel<List<UserCard>>>() {
            @Override
            public void onResponse(Call<RspModel<List<UserCard>>> call, Response<RspModel<List<UserCard>>> response) {
                RspModel  rsp = response.body();
                if (rsp.isSuccess()){
                    List<UserCard> list = (List<UserCard>)rsp.getData();

                    callBack.success(list);
                }
                else {
                    callBack.failed(null);
                }
            }

            @Override
            public void onFailure(Call<RspModel<List<UserCard>>> call, Throwable t) {

            }
        });

    }
}
