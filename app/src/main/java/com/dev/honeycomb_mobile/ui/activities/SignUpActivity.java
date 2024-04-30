package com.dev.honeycomb_mobile.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.dev.honeycomb_mobile.R;
import com.google.firebase.auth.FirebaseAuth;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {
    public static  final  String TAG = SignUpActivity.class.getSimpleName();
    private FirebaseAuth mAuth;
    @BindView(R.id.log)
    TextView loginTxt;
    @BindView(R.id.actvSignupEmail)
    EditText emailAddress;
    @BindView(R.id.etFirstName)
    EditText firstName;
    @BindView(R.id.etLastName)
    EditText lastName;
    @BindView(R.id.etSigninPassword)
    EditText password;
    @BindView(R.id.btnCreateAccount)
    Button signUp;
    @BindView(R.id.btnImageGoogle)
    ImageButton googleSignIn;
    @BindView(R.id.btnImageFacebook)
    ImageButton facebookSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);

        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewUser();
            }
        });
        //getInstance of firebaseAuth object
        mAuth = FirebaseAuth.getInstance();

    }
    private void createNewUser(){
        final String name = firstName.getText().toString().trim();
        final String name2 = lastName.getText().toString().trim();
        String email = emailAddress.getText().toString().trim();
        String passCode = password.getText().toString().trim();

        boolean validName = isValidFirstName(name);
        boolean validName2 = isValidSecondName(name2);
        boolean validEmail = isValidEmail(email);
        boolean validPassword = isValidPassword(passCode);
        if (!validEmail || !validName || !validPassword) return;

        mAuth.createUserWithEmailAndPassword(email, passCode)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this, "Authentication is a success!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignUpActivity.this, "ooops! Authentication Failed", Toast.LENGTH_LONG).show();
                    }
                });
    }

    //validate first name is entered
    private boolean isValidFirstName(String name){
        if(name.equals("")){
            firstName.setError("Please enter your name");
            return false;
        }
        return true;
    }
    //validate last name is entered
    private boolean isValidSecondName(String name2){
        if(name2.equals("")){
            lastName.setError("Please enter your name");
            return false;
        }
        return true;
    }

    //check the email address if it is valid
    private boolean isValidEmail(String email) {
        boolean isGoodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if(!isGoodEmail){
            emailAddress.setError("Please enter a valid email address");
            return false;
        }
        return true;
    }

    //check the password
    private boolean isValidPassword(String passCode){
        if(passCode.equals("") || passCode.length() < 6){
            password.setError("field required, Please create a strong password");
            return false;
        }
        return true;
    }
    }
