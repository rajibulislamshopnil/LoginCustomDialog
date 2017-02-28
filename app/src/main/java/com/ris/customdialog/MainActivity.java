package com.ris.customdialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Button customDialog,login;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customDialog = (Button)findViewById(R.id.button_CustomDialog);

        customDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.layout_login,null);
                email = (EditText)view.findViewById(R.id.editText_email);
                password = (EditText)view.findViewById(R.id.editText_password);
                login = (Button)view.findViewById(R.id.button_login);
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this, R.string.succes_login_msg, Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this,
                                    R.string.err_login_msg, Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setView(view);
                 AlertDialog dialog = builder.create();
                dialog.show();


            }

        });

    }
}
