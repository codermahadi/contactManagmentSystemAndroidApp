package com.example.contactmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contactmanagementsystem.SqlLiteD.MyDBHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button reg, login;
    EditText mobile, password;
    MyDBHelper myDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences = getSharedPreferences("cms", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("isLoging")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        myDBHelper = new MyDBHelper(this);

        login = (Button) findViewById(R.id.login);
        reg = (Button) findViewById(R.id.reg);

        mobile = (EditText) findViewById(R.id.mobile_no);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:
                login();
                break;
            case R.id.reg:
                startActivity(new Intent(LoginActivity.this, RegActivity.class));
                Toast.makeText(LoginActivity.this, "contact_info", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(LoginActivity.this, "Default", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void login() {
        String mobileNo = mobile.getText().toString().trim();
        String pass = password.getText().toString().trim();

        boolean isLogin = myDBHelper.login(mobileNo, pass);
        if (isLogin) {

            SharedPreferences sharedPreferences = getSharedPreferences("cms", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putBoolean("isLoging", isLogin);
            editor.commit();

            Toast.makeText(this,"Data Stored successfully", Toast.LENGTH_LONG).show();
            Log.i("Login", "Success");
            Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        } else {
            Toast.makeText(LoginActivity.this, "Login Faild!", Toast.LENGTH_LONG).show();
        }
    }

}
