package com.example.mycleancode.ui.base;

import com.example.mycleancode.data.network.Network;
import com.example.mycleancode.data.network.Routes;

public class BaseRequest {
    private Routes routes;

    public void initialize() {
        routes = Network.builder().create(Routes.class);
    }

    public Routes getRoutes() {
        return routes;
    }
}
