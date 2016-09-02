package com.itheima.okhttpdemo2.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.itheima.okhttpdemo2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/13 0013.
 */
public class LoadingPage extends FrameLayout implements View.OnClickListener {
    private View mEmptyPage;
    private View mErrorPage;
    private View mLoadingPage;
    private List<View> loadingPages = new ArrayList<>();

    private OnLoadingPageClickListener mListener;

    public LoadingPage(Context context) {
        this(context, null);
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);

        initLoadingPage(context);
    }

    private void initLoadingPage(Context context) {
        mEmptyPage = LayoutInflater.from(context).inflate(R.layout.framelayout_empty, null);
        mErrorPage = LayoutInflater.from(context).inflate(R.layout.framelayout_error, null);
        mLoadingPage = LayoutInflater.from(context).inflate(R.layout.framelayout_loading, null);

        mEmptyPage.findViewById(R.id.tv_empty).setOnClickListener(this);
        mErrorPage.findViewById(R.id.tv_error).setOnClickListener(this);
        mLoadingPage.findViewById(R.id.tv_loading).setOnClickListener(this);

        loadingPages.add(mEmptyPage);
        loadingPages.add(mErrorPage);
        loadingPages.add(mLoadingPage);

        for (int i = 0; i < loadingPages.size(); i++) {
            addView(loadingPages.get(i));
            loadingPages.get(i).setVisibility(View.GONE);
        }
    }

    public void showEmpty() {
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                loadingPages.get(i).setVisibility(View.VISIBLE);
            } else {
                loadingPages.get(i).setVisibility(View.GONE);
            }
        }
    }

    public void showError() {
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                loadingPages.get(i).setVisibility(View.VISIBLE);
            } else {
                loadingPages.get(i).setVisibility(View.GONE);
            }
        }
    }

    public void showLoading() {
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                loadingPages.get(i).setVisibility(View.VISIBLE);
            } else {
                loadingPages.get(i).setVisibility(View.GONE);
            }
        }
    }

    public void hide() {
        for (int i = 0; i < loadingPages.size(); i++) {
            loadingPages.get(i).setVisibility(View.GONE);
        }
    }

    public void setOnLoadingPageClickListener(OnLoadingPageClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_empty:
            case R.id.tv_error:
            case R.id.tv_loading:
                mListener.onLoadingPageClick(v);
                break;
            default:
                break;
        }
    }

    public interface OnLoadingPageClickListener {
        void onLoadingPageClick(View v);
    }
}
