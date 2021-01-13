package com.moringaschool.myrestaurants.network;

import com.moringaschool.myrestaurants.network.YelpApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YelpClient {

    private static Retrofit retrofit = null;

    public static YelpApi getClient(){

        if (retrofit == null){

            OkHttpClient okHttpClient =  new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Authorization", "J-fwdefNgfAxvQODdsPoTJBZrrTcLd3Fkb0ULQOfsK7H3M9JOC_qoGZe4AcIKpQZ3zlqeqboDRR-aRVQn6J01Ola4SgSlxMQShTfBZZmv5RRAFIwybpU9OSEw2P8X3Yx")
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl("J-fwdefNgfAxvQODdsPoTJBZrrTcLd3Fkb0ULQOfsK7H3M9JOC_qoGZe4AcIKpQZ3zlqeqboDRR-aRVQn6J01Ola4SgSlxMQShTfBZZmv5RRAFIwybpU9OSEw2P8X3Yx")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(YelpApi.class);
    }
}
