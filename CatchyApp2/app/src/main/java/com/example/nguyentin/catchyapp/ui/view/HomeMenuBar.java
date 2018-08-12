package com.example.nguyentin.catchyapp.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.R;

/**
 * Create by DavidSon Nguyen
 */

public class HomeMenuBar extends RelativeLayout implements View.OnClickListener {
    public static final int HOME = 0;
    public static final int USER = 1;

    // Drawable
    private int HOME_CHECKED = R.drawable.ic_home_color;
    private int HOME_NORMAL  = R.drawable.ic_home_dark;
    private int USER_CHECKED = R.drawable.ic_user_color;
    private int USER_NORMAL  = R.drawable.ic_user_dark;

    // Color
    private int COLOR_CHECKED = R.color.colorAccent;
    private int COLOR_NORMAL  = R.color.colorUncheck;

    // Constructor
    private Context context;

    // View
    private LinearLayout linearHome, linearUser;
    private ImageView imgHome, imgUser;
    private TextView txtHome, txtUser;

    // Var
    private int checkedId = -1;

    public HomeMenuBar(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public HomeMenuBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public HomeMenuBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView(){
        inflate(context, R.layout.view_home_menu_bar, this);

        linearHome = (LinearLayout) findViewById(R.id.linearHome);
        linearUser = (LinearLayout) findViewById(R.id.linearUser);

        imgHome = (ImageView) findViewById(R.id.imgHome);
        imgUser = (ImageView) findViewById(R.id.imgUser);

        txtHome = (TextView) findViewById(R.id.txtHome);
        txtUser = (TextView) findViewById(R.id.txtUser);

        initEvent();
    }

    private void initEvent(){
        linearHome.setOnClickListener(this);
        linearUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linearHome:
                setCheckEvent(HOME);
                break;
            case R.id.linearUser:
                setCheckEvent(USER);
                break;
        }
    }

    public void check(int checkedId){
        this.checkedId = checkedId;
        setCheckEvent(checkedId);
    }

    private void setCheckEvent(int id){
        switch (id){
            case HOME:
                imgHome.setImageDrawable(context.getDrawable(HOME_CHECKED));
                imgUser.setImageDrawable(context.getDrawable(USER_NORMAL));

                txtHome.setTextColor(context.getResources().getColor(COLOR_CHECKED));
                txtUser.setTextColor(context.getResources().getColor(COLOR_NORMAL));
                checkedId = R.id.linearHome;
                if (onCheckedChange != null){
                    onCheckedChange.onChanged(linearUser, HOME);
                }
                break;
            case USER:
                imgHome.setImageDrawable(context.getDrawable(HOME_NORMAL));
                imgUser.setImageDrawable(context.getDrawable(USER_CHECKED));

                txtHome.setTextColor(context.getResources().getColor(COLOR_NORMAL));
                txtUser.setTextColor(context.getResources().getColor(COLOR_CHECKED));
                checkedId = R.id.linearUser;
                if (onCheckedChange != null){
                    onCheckedChange.onChanged(linearUser, USER);
                }
                break;
        }
    }

    public interface OnCheckedChange {
        void onChanged(View view, int checkedId);
    }

    private OnCheckedChange onCheckedChange;

    public void setOnCheckedChangeListener(OnCheckedChange onCheckedChange){
        this.onCheckedChange = onCheckedChange;
    }
}
