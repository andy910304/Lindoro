package com.example.lindoro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PostService {

    String API_ROUTE = "posts";

    @GET(API_ROUTE)
    Call< List<Post> > find(@Query("q") String q);

    @GET(API_ROUTE)
    Call< List<Post> > getPost();

    @GET("posts/{id}/comments")
    Call< List<Comment> > getComments(@Path("id") int postId);

    @GET
    Call< List<Comment> > getComments(@Url String url);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@Field("userId") int userId,
                          @Field("title") String title,
                          @Field("body") String text
                          );
    @PATCH("posts/{id}")
    Call<Post> putPost(@Path("id") int userId, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int userId, @Body Post post);


}