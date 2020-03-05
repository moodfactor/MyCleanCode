package com.example.mycleancode.data.network;

import com.example.mycleancode.data.repo.GitRepository;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Routes {
    @GET("users/IrfanNawawi/repos")
    Call<GitRepository> getRepos();
}
