package com.github.pires.obd.reader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.pires.obd.reader.R;

import roboguice.activity.RoboActivity;

public class Registrationpage extends RoboActivity
        implements ConfirmDialog.Listener {


    EditText _txtFname;
    EditText _txtLname;
    EditText _txtUserName;
    EditText _txtPassword;
    Button _btnregister;
    TextView _txtLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationpage);


        _txtFname = findViewById(R.id.txtFname);
        _txtLname = findViewById(R.id.txtLname);
        _txtUserName = findViewById(R.id.txtUserName);
        _txtPassword = findViewById(R.id.txtPassword);
        _btnregister = findViewById(R.id.btnRegister);
        _txtLogin = findViewById(R.id.txtlogin);

        _txtLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Loginpage.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onConfirmationDialogResponse(int id, boolean confirmed) {

    }
}
