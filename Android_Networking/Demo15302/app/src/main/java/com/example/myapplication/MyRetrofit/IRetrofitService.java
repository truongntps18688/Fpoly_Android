package com.example.myapplication.MyRetrofit;

import com.example.myapplication.Models.AccessToken;
import com.example.myapplication.Models.Person;
import com.example.myapplication.Models.Product;
import com.example.myapplication.Models.ProductCategory;
import com.example.myapplication.Models.Response2PikModel;
import com.example.myapplication.Models.ResponseModel;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface IRetrofitService {

    @GET("getOne.php")
    Call<Person> getOne();

    @GET("getArray.php")
    Call<List<Person>> getArray();

    @GET("getOneByParam.php")
    Call<Person> getOneByParam(@Query("id") int id);

    @POST("post.php")
    Call<Person> post();

    @POST("views/user_login.php")
    Call<AccessToken> login(@Body Person person);

    @POST("views/product_get_all.php")
    Call<List<Product>> productGetAll();

    @POST("views/product_get_by_id.php")
    Call<Product> productGetById(@Body Product product);

    @Multipart
    @POST("/")
    Call<Response2PikModel> upload(@Part MultipartBody.Part image);

    @POST("views/product_category_get_all.php")
    Call<List<ProductCategory>> productCategoryGetAll();

    @POST("views/product_insert.php")
    Call<ResponseModel> productInsert(@Body Product product);

    @POST("views/product_update.php")
    Call<ResponseModel> productUpdate(@Body Product product);
}
