package com.itheima.okhttpdemo2;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.itheima.okhttpdemo2.base.BaseActivity;
import com.itheima.okhttpdemo2.bean.HomeBean;
import com.itheima.okhttpdemo2.callbacks.HomeBeanCallback;
import com.itheima.okhttpdemo2.events.ErrorEvent;
import com.itheima.okhttpdemo2.interfaces.IView;
import com.itheima.okhttpdemo2.protocol.HomeProtocol;
import com.itheima.okhttpdemo2.widgets.LoadingPage;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity implements View.OnClickListener, LoadingPage.OnLoadingPageClickListener, IView {

    private Button mBtn;
    private TextView mTv;
    private Button mBtn_start_topicactivity;
    LoadingPage mLoadingPage;
    private TextView mTv_show;
    private HomeProtocol mHomeProtocol;

    public void init() {
        setContentView(R.layout.activity_main);
        System.out.println(mHandler);
    }

    @Override
    public void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mTv = (TextView) findViewById(R.id.tv);
        mTv_show = (TextView) findViewById(R.id.tv_show);
        mBtn_start_topicactivity = (Button) findViewById(R.id.btn_start_topicactivity);
        mLoadingPage = (LoadingPage) findViewById(R.id.loading_page);
    }

    @Override
    public void initListener() {
        mBtn.setOnClickListener(this);
        mBtn_start_topicactivity.setOnClickListener(this);
        mLoadingPage.setOnClickListener(this);
        mLoadingPage.setOnLoadingPageClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                //访问网络的操作
                mLoadingPage.showLoading();
                loadNetData();
                break;
            case R.id.btn_start_topicactivity:
                Intent topicIntent = new Intent(this, TopicActivity.class);
                startActivity(topicIntent);
                break;
            default:
                break;
        }
    }

    private void loadNetData() {
        mHomeProtocol = new HomeProtocol();
        mHomeProtocol.get(this, new HomeBeanCallback(this));
    }

    @Subscribe
    public void onEvent(HomeBean bean) {
        mHandler.sendEmptyMessage(0);
    }

    @Subscribe
    public void onEvent(ErrorEvent errorEvent) {
        mTv_show.setVisibility(View.GONE);
        mLoadingPage.showEmpty();
    }

    /**
     * 子类activiy在该方法中处理消息
     *
     * @param msg
     */
    @Override
    public void processMsg(Message msg) {
        switch (msg.what) {
            case 0:
                System.out.println("我收到了homebean");
                mTv_show.setVisibility(View.VISIBLE);
                mLoadingPage.hide();
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoadingPageClick(View v) {
        switch (v.getId()) {
            case R.id.tv_empty:
                System.out.println("点击了empty");
                loadNetData();
                break;
        }
    }

    /**
     * 刷新页面的方法
     *
     * @param objs callback回调的参数,一般为实体bean对象
     */
    @Override
    public void refreshUI(Object... objs) {
        if (objs[0] instanceof HomeBean) {
            HomeBean bean = (HomeBean) objs[0];
            System.out.println(bean.weatherinfo.city);
            mLoadingPage.hide();
        }
    }

    @Override
    public void showEmpty() {
        mLoadingPage.showEmpty();
    }

    @Override
    public void showError() {
        mLoadingPage.showError();
    }

    @Override
    public void showLoading() {
        mLoadingPage.showLoading();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHomeProtocol.cancel(this);     //取消对应的网络请求
    }
}
