package com.github.pires.obd.reader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pires.obd.reader.R;

public class Loginpage extends AppCompatActivity {

    EditText _txtUserName;
    EditText _txtPassword;

    TextView _txtRegister;
    CardView _cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);


        _txtUserName = findViewById(R.id.txtUrname);
        _txtPassword = findViewById(R.id.txtPassword);
        _txtRegister = findViewById(R.id.registerclick);
        _cardView = findViewById(R.id.btnlogin);

        _txtRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Loginpage.this, Registration.class));
            }
        });


        _cardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginpage.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
