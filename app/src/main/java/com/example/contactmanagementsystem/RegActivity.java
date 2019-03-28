package com.example.contactmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contactmanagementsystem.SqlLiteD.MyDBHelper;

public class RegActivity extends AppCompatActivity implements View.OnClickListener {
    Button reg, login;
    EditText mobile, password, uname;
    MyDBHelper myDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        myDBHelper = new MyDBHelper(this);

        login = (Button) findViewById(R.id.login);
        reg = (Button) findViewById(R.id.reg_register);

        mobile = (EditText) findViewById(R.id.mobile_no);
        password = (EditText) findViewById(R.id.password);
        uname = (EditText) findViewById(R.id.uname);


        login.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:
                startActivity(new Intent(RegActivity.this, MainActivity.class));
                Toast.makeText(RegActivity.this, "notification", Toast.LENGTH_LONG).show();
                break;
            case R.id.reg_register:
                register();
                break;
            default:
                Toast.makeText(RegActivity.this, "Default", Toast.LENGTH_LONG).show();
                break;
        }

    }

    private void register() {
        String mobileNo = mobile.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String username = uname.getText().toString().trim();

        long id = myDBHelper.addData(mobileNo, pass, username);
        if (id > 0) {
            Toast.makeText(RegActivity.this, "Register Success!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(RegActivity.this, LoginActivity.class));
        } else {
            Toast.makeText(RegActivity.this, "Register Faild!", Toast.LENGTH_LONG).show();
        }
    }
}
