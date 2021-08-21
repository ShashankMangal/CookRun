package com.example.cookrun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    Button registerButton ;
    FirebaseAuth auth;
    TextView registerToLogin;
    EditText registerEmail;
    EditText registerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();


        registerButton = findViewById(R.id.registerButton);
        registerPassword = findViewById(R.id.registerPassword);
        registerEmail = findViewById(R.id.registerEmail);
        registerToLogin = findViewById(R.id.registerLoginHereText);
        auth = FirebaseAuth.getInstance();


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        registerToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }


        private void createUser(){
            String email = registerEmail.getText().toString();
            String password = registerPassword.getText().toString();

            if(TextUtils.isEmpty(email)){
                registerEmail.setError("Enter an email.");
                registerEmail.requestFocus();
            }else if(TextUtils.isEmpty(password)){
                registerPassword.setError("Enter a password.");
                registerPassword.requestFocus();
            }else{
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Registration Successful.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this, "Registration Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }


    }
}