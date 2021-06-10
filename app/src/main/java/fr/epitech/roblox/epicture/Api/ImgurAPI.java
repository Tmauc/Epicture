package fr.epitech.roblox.epicture.Api;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import fr.epitech.roblox.epicture.Activities.MainActivity;
import fr.epitech.roblox.epicture.Api.DataModels.Image;
import fr.epitech.roblox.epicture.Api.DataModels.RequestResult;
import fr.epitech.roblox.epicture.App;
import fr.epitech.roblox.epicture.Auth;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImgurAPI {

    private static IImgurAPI api;

    static {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                String auth;
                if (App.authState.isAuthorized()) {
                    auth = "Bearer " + App.authState.getAccessToken();
                } else {
                    auth = "Client-ID " + Auth.CLIENT_ID;
                }
                Request request = chain.request().newBuilder().addHeader("Authorization", auth).build();
                return chain.proceed(request);
            }
        });

        OkHttpClient httpClient = httpClientBuilder.build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl("https://api.imgur.com/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ImgurAPI.api = retrofit.create(IImgurAPI.class);
    }

    public static IImgurAPI getApi() {
        return ImgurAPI.api;
    }

    public static <T> void call(final Call<RequestResult<T>> c, final ApiResponse<T> response) {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    final RequestResult<T> res = c.execute().body();

                    Handler mainHandler = new Handler(Looper.getMainLooper());
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (res.status != 200)
                                response.fail(res.status);
                            else
                                response.response(res.data);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }.execute();
    }

    public interface ApiResponse<T> {
        void response(T body);
        void fail(int responseCode);
    }

}
