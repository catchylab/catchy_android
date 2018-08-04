package com.example.nguyentin.catchyapp;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.activity.PreLoginActivity;
import com.example.nguyentin.catchyapp.activity.WelcomeActivity;
import com.example.nguyentin.catchyapp.startup.HomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    TextView txtSignIn, txtHeaderEmail, txtHeaderPass;
    EditText edtEmail, edtPass;
    ImageView imgBack;
    CheckBox imgShowPass;

    View viewBottomEmail, viewBottomPass;

    ConstraintLayout constraintParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        imgShowPass.setOnClickListener(this);
        imgBack.setOnClickListener(this);
        txtSignIn.setOnClickListener(this);
        constraintParent.setOnClickListener(this);

        edtEmail.setOnFocusChangeListener(this);
        edtPass.setOnFocusChangeListener(this);
    }

    private void initView(){
        txtSignIn      = (TextView) findViewById(R.id.txtLogIn);
        txtHeaderEmail = (TextView) findViewById(R.id.txtHeaderEmail);
        txtHeaderPass  = (TextView) findViewById(R.id.txtHeaderPass);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPass  = (EditText) findViewById(R.id.edtPass);

        imgShowPass = (CheckBox) findViewById(R.id.imgShowPass);
        imgBack     = (ImageView) findViewById(R.id.imgBack);

        viewBottomEmail = (View) findViewById(R.id.viewBottomEmail);
        viewBottomPass  = (View) findViewById(R.id.viewBottomPass);

        constraintParent = (ConstraintLayout) findViewById(R.id.constraintParent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                goBack();
                break;
            case R.id.txtLogIn:
                // check login
//                gotoHome();
                gotoWelcome();
                break;
            case R.id.constraintParent:
                hideSoftKeyboard(this);
                break;
            case R.id.imgShowPass:
                if (imgShowPass.isChecked()){
                    // show
                    edtPass.setInputType(InputType.TYPE_CLASS_TEXT);
                    edtPass.setTransformationMethod(new SingleLineTransformationMethod());
                    edtPass.setSelection(edtPass.getText().length());
                }else {
                    // hide
                    edtPass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    edtPass.setTransformationMethod(new PasswordTransformationMethod());
                    edtPass.setSelection(edtPass.getText().length());
                }
                edtPass.setFocusable(true);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.edtEmail:
                if (b){
                    txtHeaderEmail.setTextColor(getResources().getColor(R.color.colorEditting));
                    viewBottomEmail.setBackgroundColor(getResources().getColor(R.color.colorEditting));
                }else {
                    txtHeaderEmail.setTextColor(getResources().getColor(R.color.colorEditNormal));
                    viewBottomEmail.setBackgroundColor(getResources().getColor(R.color.colorEditNormal));
                }
                break;
            case R.id.edtPass:
                if (b){
                    txtHeaderPass.setTextColor(getResources().getColor(R.color.colorEditting));
                    viewBottomPass.setBackgroundColor(getResources().getColor(R.color.colorEditting));
                }else {
                    txtHeaderPass.setTextColor(getResources().getColor(R.color.colorEditNormal));
                    viewBottomPass.setBackgroundColor(getResources().getColor(R.color.colorEditNormal));
                }
                break;
        }
    }

    private void gotoHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void goBack(){
        Intent intent = new Intent(this, PreLoginActivity.class);
        startActivity(intent);
    }

    private void gotoWelcome(){
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
