package com.geekbrains.RestApi;

import okhttp3.ResponseBody;
import com.geekbrains.DTO.Product;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.ArrayList;

public interface ProductService {
    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") Integer id);
    @POST("products")
    Call<Product> createProduct(@Body Product product);
    @PUT("products")
    Call<Product> modifyProduct(@Body Product product);
    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") Integer id);
    @DELETE("products")
    Call<ArrayList<Product>> getProductsWrongMethod();
}

