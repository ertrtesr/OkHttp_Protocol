package com.itheima.okhttpdemo2;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.itheima.okhttpdemo2.base.BaseActivity;
import com.itheima.okhttpdemo2.bean.TopicBean;
import com.itheima.okhttpdemo2.callbacks.TopicBeanCallback;
import com.itheima.okhttpdemo2.protocol.TopicProtocol;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class TopicActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtn_topic;
    private Button mBtn_start_categoryactivity;

    @Override
    public void init() {
        setContentView(R.layout.activity_topic);
        System.out.println(mHandler.toString());
    }

    @Override
    public void initView() {
        mBtn_topic = (Button) findViewById(R.id.btn_topic);
        mBtn_start_categoryactivity = (Button) findViewById(R.id.btn_start_categoryactivity);
    }

    @Override
    public void initListener() {
        mBtn_topic.setOnClickListener(this);
        mBtn_start_categoryactivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_topic:
                new TopicProtocol().get(this, new TopicBeanCallback());
                break;
            case R.id.btn_start_categoryactivity:
                Intent intent = new Intent(this, CategoryActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Subscribe
    public void onEvent(TopicBean topicBean) {
        mHandler.sendEmptyMessage(0);
    }

    @Override
    public void processMsg(Message msg) {
        switch (msg.what) {
            case 0:
                System.out.println("我收到了topic");
                break;
            default:
                break;
        }
    }

    //    @Override
    //    public void refreshUI(Object... objs) {
    //        super.refreshUI(objs);
    //
    //        System.out.println(((TopicBean) objs[0]).response);
    //        System.out.println(objs[1]);
    //        System.out.println(objs[2]);
    //    }
}
