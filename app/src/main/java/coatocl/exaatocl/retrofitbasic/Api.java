package coatocl.exaatocl.retrofitbasic;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class Api
{
    private static final String BASE_URL = "https://api.stackexchange.com";
    private static Retrofit retrofit = null;

    static Retrofit getClient() {

//        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("https://mobileappdatabase.in/").build();
//
//        ApiInterface api;
//        api = adapter.create(ApiInterface.class);
//        return api;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
