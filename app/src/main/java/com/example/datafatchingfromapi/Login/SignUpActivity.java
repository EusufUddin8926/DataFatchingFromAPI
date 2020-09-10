package com.example.datafatchingfromapi.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datafatchingfromapi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText SignUpEmailEditText,SignUpPasswordEditText,SignUpphoneEditText,SignUpfnameEditText,SignUplnameEditText;
    private TextView SignInTextView;
    private Button SignUpButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.setTitle("Registration_Activity");


        mAuth = FirebaseAuth.getInstance();


        SignUpEmailEditText = findViewById(R.id.editEmail);
        SignUpPasswordEditText = findViewById(R.id.editPassword);
        SignUpphoneEditText = findViewById(R.id.editphone);
        SignUpfnameEditText = findViewById(R.id.editfName);
        SignUplnameEditText = findViewById(R.id.editlName);
       ;

        SignInTextView = findViewById(R.id.txtLogin);
        SignUpButton = findViewById(R.id.buttonRegister);

        SignInTextView.setOnClickListener(this);
       SignUpButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonRegister:
                UserRegister();

                break;
            case R.id.txtLogin:
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void UserRegister(){
        String fName = SignUpfnameEditText.getText().toString().trim();
        String lName = SignUplnameEditText.getText().toString().trim();
        String Email = SignUpEmailEditText.getText().toString().trim();
         String mphone = SignUpphoneEditText.getText().toString().trim();
        String Password = SignUpPasswordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(fName)){
            Toast.makeText(SignUpActivity.this, "Enter First Name", Toast.LENGTH_SHORT).show();
            return;

        }else if (TextUtils.isEmpty(lName)) {
            Toast.makeText(SignUpActivity.this, "Enter First Name", Toast.LENGTH_SHORT).show();
            return;

        }else if (TextUtils.isEmpty(lName)) {
            Toast.makeText(SignUpActivity.this, "Enter First Name", Toast.LENGTH_SHORT).show();
            return;

        }else if (TextUtils.isEmpty(lName)) {
            Toast.makeText(SignUpActivity.this, "Enter First Name", Toast.LENGTH_SHORT).show();
            return;

        }else if (TextUtils.isEmpty(lName)) {
            Toast.makeText(SignUpActivity.this, "Enter First Name", Toast.LENGTH_SHORT).show();
            return;

        }else if (TextUtils.isEmpty(lName)) {
            Toast.makeText(SignUpActivity.this, "Enter Last Name", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(Email)){
            Toast.makeText(SignUpActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(mphone)){
            Toast.makeText(SignUpActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(Password)){
            Toast.makeText(SignUpActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }else if (Password.length()<6){
            Toast.makeText(SignUpActivity.this,"Password must be greater then 6 digit",Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this,"Registation Successfull",Toast.LENGTH_SHORT).show();

                }else {
                   if(task.getException() instanceof FirebaseAuthUserCollisionException){
                       Toast.makeText(SignUpActivity.this,"User Already registered",Toast.LENGTH_SHORT).show();
                   }
                   else {
                       Toast.makeText(SignUpActivity.this,"Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                   }
                }


            }
        });
    }

}

