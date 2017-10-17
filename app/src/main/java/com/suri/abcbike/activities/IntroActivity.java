package com.suri.abcbike.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.suri.abcbike.R;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    public static Activity mThisActivity;

    private Button mSignIn;
    private Button mSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mSignIn = (Button) findViewById(R.id.sign_in);
        mSignIn.setOnClickListener(this);

        mSignUp = (Button) findViewById(R.id.sign_up);
        mSignUp.setOnClickListener(this);

        mThisActivity = IntroActivity.this;

        try {
            Glide.with(this).load(R.drawable.choco).into((ImageView) findViewById(R.id.intro_image));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.sign_in:

                Intent goLogin = new Intent(IntroActivity.this, LoginActivity.class);
                startActivityForResult(goLogin,1);
                break;
            case R.id.sign_up:
                Intent goSignUp = new Intent(IntroActivity.this, SignUpActivity.class);
                startActivity(goSignUp);
                break;
            default:
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
                Intent i = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            } else {
            }
        } catch (Exception e) {
            Log.d("onActivityResult", e.getMessage());
        }

    }

}
