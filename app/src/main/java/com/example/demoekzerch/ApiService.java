package com.example.demoekzerch;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST ("/auth/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
}
