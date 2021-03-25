package com.example.demoekzerch;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText email = findViewById(R.id.editTextTextEmailAddress);
        EditText pass = findViewById(R.id.editTextTextPassword);
        Button btnsignin = findViewById(R.id.button);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString())||TextUtils.isEmpty(pass.getText().toString())){
                    Toast.makeText(SignIn.this,"Поля не могут быть пустыми",Toast.LENGTH_LONG);
                }
                else {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setEmail(email.getText().toString());
                    loginRequest.setPassword(pass.getText().toString());
                    LoginUsers(loginRequest);
                }
            }
        });

    }
    public void onClickSignUp(View view){
        Intent i = new Intent(SignIn.this,SignUp.class);
        startActivity(i);
    }
    public void LoginUsers(LoginRequest loginRequest) {
        Call<LoginResponse> call = ApiClient.getservice().loginUser(loginRequest);
        call.enqueue(new Callback<LoginResponse>(){
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response){
                if (response.isSuccessful()){
                    Intent intent = new Intent(SignIn.this, MainActivity.class);
                    startActivity(intent);
                }
            }
            public void onFailure(Call<LoginResponse> call,Throwable t){

            }
        });
    }
}
