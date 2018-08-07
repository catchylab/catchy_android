package com.example.nguyentin.catchyapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.activity.SignUpActivity;
import com.example.nguyentin.catchyapp.communication.OnYearPickerResult;
import com.example.nguyentin.catchyapp.dialog.YearPickerDialog;

public class SignUpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity activity;

    public SignUpAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sign_up_email_pass, null);
            return new EmailHolder(view);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sign_up_user_info, null);
            return new UserInfo(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    private void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public class EmailHolder extends RecyclerView.ViewHolder implements View.OnFocusChangeListener, View.OnClickListener {
        TextView txtHeaderEmail, txtHeaderPass, txtBottomEmail, txtBottomPass, txtNext;
        EditText edtEmail, edtPass;
        View viewBottomEmail, viewBottomPass;
        CheckBox cbShowPass;

        public EmailHolder(View itemView) {
            super(itemView);
            initView(itemView);

            edtEmail.setOnFocusChangeListener(this);
            edtPass.setOnFocusChangeListener(this);

            cbShowPass.setOnClickListener(this);
            txtNext.setOnClickListener(this);
        }

        private void initView(View view){
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hideSoftKeyboard(activity);
                }
            });
        }

        @Override
        public void onFocusChange(View view, boolean b) {
            switch (view.getId()){
                case R.id.edtEmail:
                    if (b){
                        txtHeaderEmail.setTextColor(activity.getResources().getColor(R.color.colorEditting));
                        viewBottomEmail.setBackgroundColor(activity.getResources().getColor(R.color.colorEditting));
                    }else {
                        txtHeaderEmail.setTextColor(activity.getResources().getColor(R.color.colorEditNormal));
                        viewBottomEmail.setBackgroundColor(activity.getResources().getColor(R.color.colorEditNormal));
                    }
                    break;
                case R.id.edtPass:
                    if (b){
                        txtHeaderPass.setTextColor(activity.getResources().getColor(R.color.colorEditting));
                        viewBottomPass.setBackgroundColor(activity.getResources().getColor(R.color.colorEditting));
                    }else {
                        txtHeaderPass.setTextColor(activity.getResources().getColor(R.color.colorEditNormal));
                        viewBottomPass.setBackgroundColor(activity.getResources().getColor(R.color.colorEditNormal));
                    }
                    break;
            }
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
                case R.id.txtNext:
                    ((SignUpActivity) activity).gotoNext();
                    break;
            }
        }
    }

    public class UserInfo extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnFocusChangeListener {
        TextView txtLastname, txtFirstname, txtYear, txtCreate;
        EditText edtLastname, edtFirstname;
        View viewBottomLastname, viewBottomFirstname;
        ImageView imgEdit;
        RadioGroup rdgGender;
        RadioButton rdbFemale, rdbMale;

        public UserInfo(View itemView) {
            super(itemView);
            txtLastname  = (TextView) itemView.findViewById(R.id.txtLastname);
            txtFirstname = (TextView) itemView.findViewById(R.id.txtFirstname);
            txtYear      = (TextView) itemView.findViewById(R.id.txtYear);
            txtCreate    = (TextView) itemView.findViewById(R.id.txtCreate);

            edtLastname  = (EditText) itemView.findViewById(R.id.edtLastname);
            edtFirstname = (EditText) itemView.findViewById(R.id.edtFirstname);

            viewBottomLastname  = (View) itemView.findViewById(R.id.viewBottomLastname);
            viewBottomFirstname = (View) itemView.findViewById(R.id.viewBottomFirstname);

            imgEdit = (ImageView) itemView.findViewById(R.id.imgEdit);

            rdgGender = (RadioGroup) itemView.findViewById(R.id.rdgGender);
            rdbFemale = (RadioButton) itemView.findViewById(R.id.rdbFemale);
            rdbMale   = (RadioButton) itemView.findViewById(R.id.rdbMale);

            edtLastname.setOnFocusChangeListener(this);
            edtFirstname.setOnFocusChangeListener(this);

            imgEdit.setOnClickListener(this);
            txtCreate.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hideSoftKeyboard(activity);
                }
            });
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.imgEdit:
                    YearPickerDialog dialog = new YearPickerDialog(activity, Integer.valueOf(txtYear.getText().toString()));
                    dialog.show();
                    dialog.addOnYearPickerListener(new OnYearPickerResult() {
                        @Override
                        public void onResult(Object o) {
                            txtYear.setText((String) o);
                        }
                    });
                    break;
                case R.id.txtCreate:
                    break;
            }
        }

        @Override
        public void onFocusChange(View view, boolean b) {
            switch (view.getId()){
                case R.id.edtLastname:
                    if (b){
                        txtLastname.setTextColor(activity.getResources().getColor(R.color.colorEditting));
                        viewBottomLastname.setBackgroundColor(activity.getResources().getColor(R.color.colorEditting));
                    }else {
                        txtLastname.setTextColor(activity.getResources().getColor(R.color.colorEditNormal));
                        viewBottomLastname.setBackgroundColor(activity.getResources().getColor(R.color.colorEditNormal));
                    }
                    break;
                case R.id.edtFirstname:
                    if (b){
                        txtFirstname.setTextColor(activity.getResources().getColor(R.color.colorEditting));
                        viewBottomFirstname.setBackgroundColor(activity.getResources().getColor(R.color.colorEditting));
                    }else {
                        txtFirstname.setTextColor(activity.getResources().getColor(R.color.colorEditNormal));
                        viewBottomFirstname.setBackgroundColor(activity.getResources().getColor(R.color.colorEditNormal));
                    }
                    break;
            }
        }
    }
}
