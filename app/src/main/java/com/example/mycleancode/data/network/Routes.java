package com.example.mycleancode.data.network;

import com.example.mycleancode.data.repo.GitRepository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Routes {
    @GET("users/{username}/repos")
    Call<GitRepository> getRepos(
            @Path("username") String username,
            @Query("api_key") String apiKey);
}
