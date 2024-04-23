package com.example.turtlearmorsecurity;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneAuth {

    private FirebaseAuth mAuth;
    private Activity mActivity;

    public PhoneAuth(Activity activity) {
        mAuth = FirebaseAuth.getInstance();
        mActivity = activity;
    }

    public void sendOTP(String phoneNumber) {
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth).setPhoneNumber("+15551234567")
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(mActivity)
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        if (e instanceof FirebaseTooManyRequestsException) {

                        } else {

                        }
                    }
                })
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}