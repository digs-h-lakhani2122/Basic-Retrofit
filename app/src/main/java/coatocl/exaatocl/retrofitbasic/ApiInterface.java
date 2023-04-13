package coatocl.exaatocl.retrofitbasic;

import java.util.List;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiInterface
{
    @FormUrlEncoded
    @POST("/retrofit/register.php")
    void registration(@Field("name") String name,
                      @Field("email") String email,
                      @Field("password") String password,
                      @Field("logintype") String logintype,
                      Callback<CustomModel> callback);

    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    void getUsersList(
            Callback<List<CustomModel>> callback);

}
