package com.example.mycleancode.data.network;

import com.example.mycleancode.data.model.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Routes {
    @GET("users/IrfanNawawi/repos")
    Observable<List<Repo>> getRepos();
}
