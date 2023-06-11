package com.example.ux_project_axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

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
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ltfname.getText().toString().trim();
                String password = ltfpw.getText().toString().trim();

                if (username.isEmpty()) {
                    ltfname.setError("Username cannot be empty");
                } else if (password.isEmpty()) {
                    ltfpw.setError("Password cannot be empty");
                } else if (password.length() < 8) {
                    ltfpw.setError("Password must have at least 8 characters");
                } else {
<<<<<<< HEAD:app/src/main/java/com/example/ux_project_axforasset/Login.java
                    globalUser = username;
                    Intent intent = new Intent(Login.this, Homepage.class);
<<<<<<< HEAD
=======
                    Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
>>>>>>> 7ff2e25 (meki):app/src/main/java/com/example/ux_project_axforasset/LoginActivity.java
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