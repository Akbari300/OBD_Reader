package com.github.pires.obd.reader.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pires.obd.reader.R;

import roboguice.activity.RoboActivity;

public class Registrationpage extends RoboActivity
        implements ConfirmDialog.Listener {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

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


        openHelper  = new DatabaseHelper(this);

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


        _btnregister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                db = openHelper.getWritableDatabase();
                String fName = _txtFname.getText().toString();
                String lName = _txtLname.getText().toString();
                String Pass = _txtUserName.getText().toString();
                String email = _txtPassword.getText().toString();

                insertData(fName, lName, Pass, email);

                Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_LONG).show();

            }
        });

    }


    public void insertData(String f_name, String l_name, String username, String password)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, f_name);
        contentValues.put(DatabaseHelper.COL_3, l_name);
        contentValues.put(DatabaseHelper.COL_4, username);
        contentValues.put(DatabaseHelper.COL_5, password);


        Long id = db.insert(DatabaseHelper.TABLE_NAME1, null, contentValues);

    }


    @Override
    public void onConfirmationDialogResponse(int id, boolean confirmed) {

    }
}
