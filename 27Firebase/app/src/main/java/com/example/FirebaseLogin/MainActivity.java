package com.example.FirebaseLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText email, password;

    private FirebaseAuth mAuth;


    //Make sure to check email and password (empty and null).


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
//

    }

    public void mRegister(View view) {

        final String myEMail = email.getText().toString();
        final String myPass = password.getText().toString();


        mAuth.createUserWithEmailAndPassword(myEMail, myPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Authentication success.", Toast.LENGTH_SHORT).show();
                            email.setText(null);
                            password.setText(null);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

        public void mLogin(View view) {

            final String myEMail = email.getText().toString();
            final String myPass = password.getText().toString();

            mAuth.signInWithEmailAndPassword(myEMail, myPass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.i("tag", "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                String userID = user.getUid().toString();
                                Toast.makeText(MainActivity.this, "Authentication success.", Toast.LENGTH_SHORT).show();
                                Log.i("user", "USER" + user.toString());
                                Log.i("user", "USER" + userID);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.i("tag", "signInWithEmail:failure", task.getException());
                                Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });
        }

            public void mLogout(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logged out.", Toast.LENGTH_SHORT).show();

            }






}
