package com.example.ux_project_axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

<<<<<<< HEAD
=======
    public static  String globalUser="name";

>>>>>>> 6c54b33 (kelar)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = findViewById(R.id.llogin);
        Button btn2 = findViewById(R.id.regisb);
        EditText ltfname = findViewById(R.id.ltfname);
        EditText ltfpw = findViewById(R.id.ltfpw);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ltfname.getText().toString().trim();
                String password = ltfpw.getText().toString().trim();

                if (username.isEmpty()) {
                    ltfname.setError("Username tidak boleh kosong");
                } else if (password.isEmpty()) {
                    ltfpw.setError("Password tidak boleh kosong");
                } else if (password.length() < 8) {
                    ltfpw.setError("Password minimal memiliki 8 karakter");
                } else {
                    globalUser = username;
                    Intent intent = new Intent(Login.this, Homepage.class);
<<<<<<< HEAD
                    intent.putExtra("Username", username);
=======

>>>>>>> 6c54b33 (kelar)
                    startActivity(intent);
                }
            }
        });
    }
    public static String getGlobalUser() {
        return globalUser;
    }
}