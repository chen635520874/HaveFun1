package com.example.chen.havefun.widget;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.chen.havefun.R;


//import android.widget.ImageButton;

/**
 * Created by Cl on 2016.9.17
 * . my first android
 */
public class CnToolbar extends Toolbar {

    private LayoutInflater mInflater;
    private View mView;
    private TextView mTextTitle;
    private EditText mSearchView;
    private Button mRightButton;


    public CnToolbar(Context context) {
        this(context, null);
    }

    public CnToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CnToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        setContentInsetsRelative(10, 5);

        if (attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.CnToolbar, defStyleAttr, 0);
            // 标题是否居中显示(默认居中)
            final Drawable rightIcon = a.getDrawable(R.styleable.CnToolbar_rightButtonIcon);
            // 设置右侧icon
            if (rightIcon != null) {
                //setNavigationIcon(navIcon);
                setRightButtonIcon(rightIcon);
            }
            boolean isShowSearchView = a.getBoolean(R.styleable.CnToolbar_isShowSearchView, false);
            // 判断是否需要SearchView
            if (isShowSearchView) {
                showSearchView();
                hideTitleView();
            }
            CharSequence rightButtonText = a.getText(R.styleable.CnToolbar_rightButtonText);
            if (rightButtonText != null) {
                setRightButtonText(rightButtonText);
            }
            a.recycle();
        }

    }

    private void initView() {
        if (mView == null) {
            mInflater = LayoutInflater.from(getContext());
            mView = mInflater.inflate(R.layout.toolbar, null);

            mTextTitle = (TextView) mView.findViewById(R.id.toolbar_title);
            mSearchView = (EditText) mView.findViewById(R.id.toolbar_searchview);
            mRightButton = (Button) mView.findViewById(R.id.toolbar_rightButton);

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView, lp);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setRightButtonIcon(Drawable icon) {
        if (mRightButton != null) {
            mRightButton.setBackground(icon);
            mRightButton.setVisibility(VISIBLE);
        }
    }

    public void setRightButtonIcon(int icon) {
        setRightButtonIcon(getResources().getDrawable(icon));
    }

    // 右侧按钮点击事件的监听
    public void setRightButtonOnClickListener(OnClickListener li) {

        mRightButton.setOnClickListener(li);
    }

    public void setRightButtonText(CharSequence text) {
        mRightButton.setText(text);
        mRightButton.setVisibility(VISIBLE);
    }

    public void setRightButtonText(int id) {
        setRightButtonText(getResources().getString(id));
    }


    public Button getRightButton() {
        return this.mRightButton;
    }


    @Override
    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if (mTextTitle != null) {
            mTextTitle.setText(title);
            showTitleView();
        }
    }

    public void showSearchView() {
        if (mSearchView != null)
            mSearchView.setVisibility(VISIBLE);
    }

    public void hideSearchView() {
        if (mSearchView != null)
            mSearchView.setVisibility(GONE);
    }

    public void showTitleView() {
        if (mTextTitle != null) {
            mTextTitle.setVisibility(VISIBLE);
        }
    }

    public void hideTitleView() {
        if (mTextTitle != null)
            mTextTitle.setVisibility(GONE);

    }
}
