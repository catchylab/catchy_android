package com.example.nguyentin.catchyapp.fragment.SignUp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.R;

public class EmailPassFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {
    View view;
    TextView txtHeaderEmail, txtHeaderPass, txtBottomEmail, txtBottomPass, txtNext;
    EditText edtEmail, edtPass;
    View viewBottomEmail, viewBottomPass;
    CheckBox cbShowPass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_up_email_pass, container, false);
        initView();

        edtEmail.setOnFocusChangeListener(this);
        edtPass.setOnFocusChangeListener(this);

        cbShowPass.setOnClickListener(this);
        return view;
    }

    private void initView(){
        txtHeaderEmail = (TextView) view.findViewById(R.id.txtHeaderEmail);
        txtHeaderPass  = (TextView) view.findViewById(R.id.txtHeaderPass );
        txtBottomEmail = (TextView) view.findViewById(R.id.txtBottomEmail);
        txtBottomPass  = (TextView) view.findViewById(R.id.txtBottomPass );
        txtNext        = (TextView) view.findViewById(R.id.txtNext       );

        edtEmail = (EditText) view.findViewById(R.id.edtEmail);
        edtPass  = (EditText) view.findViewById(R.id.edtPass);

        viewBottomEmail = (View) view.findViewById(R.id.viewBottomEmail);
        viewBottomPass  = (View) view.findViewById(R.id.viewBottomPass);

        cbShowPass = (CheckBox) view.findViewById(R.id.cbShowPass);
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

    public void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cbShowPass:
                if (cbShowPass.isChecked()){
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
}
