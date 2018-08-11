package com.example.nguyentin.catchyapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyentin.catchyapp.Constant.Constant;
import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.SignUpAdapter;
import com.example.nguyentin.catchyapp.layoutmanager.NonScrollLayoutManager;
import com.example.nguyentin.catchyapp.util.ActivityUtil;

/**
 * Create by DavidSon Nguyen
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack;
    RecyclerView recForm;
    TextView txtTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_sign_up);
        initView();

        imgBack.setOnClickListener(this);
    }

    private void initView(){
        imgBack = (ImageView) findViewById(R.id.imgBack);
        recForm = (RecyclerView) findViewById(R.id.recForm);
        txtTerms = (TextView) findViewById(R.id.txtTerms);

        SignUpAdapter adapter = new SignUpAdapter(this);
        NonScrollLayoutManager linearLayoutManager = new NonScrollLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recForm.setLayoutManager(linearLayoutManager);
        recForm.setAdapter(adapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recForm);

        setSpanClick();
    }

    private void setSpanClick(){
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getApplicationContext(), "Điều khoản", Toast.LENGTH_SHORT).show();
            }
        };

        String source = getString(R.string.su_terms);
        int[] strPos = getStringPosition(source, Constant.STRING_CLICK_TERMS);

        SpannableString spannableString = new SpannableString(source);
        spannableString.setSpan(clickableSpan, strPos[0], strPos[1], SpannableString.SPAN_MARK_POINT);

        txtTerms.setText(spannableString);
        txtTerms.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private int[] getStringPosition(String source, String pattern){
        int sta = source.indexOf(pattern);
        int end = source.length();
        return new int[]{sta, end};
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityUtil.launchActivity(this, PreLoginActivity.class);
    }

    public void gotoNext(){
        recForm.scrollToPosition(1);
    }

    public void gotoPrev(){
        recForm.scrollToPosition(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                ActivityUtil.launchActivity(this, PreLoginActivity.class);
                break;
        }
    }
}
