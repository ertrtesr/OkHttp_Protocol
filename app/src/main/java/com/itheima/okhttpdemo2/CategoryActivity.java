package com.itheima.okhttpdemo2;

import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.itheima.okhttpdemo2.base.BaseActivity;
import com.itheima.okhttpdemo2.bean.CategoryBean;
import com.itheima.okhttpdemo2.bean.TopicBean;
import com.itheima.okhttpdemo2.callbacks.CategoryBeanCallback;
import com.itheima.okhttpdemo2.protocol.CategoryProtocol;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class CategoryActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtn_category;

    @Override
    public void init() {
        setContentView(R.layout.activity_category);
        System.out.println(mHandler);
    }

    @Override
    public void initView() {
        mBtn_category = (Button) findViewById(R.id.btn_category);
    }

    @Override
    public void initListener() {
        mBtn_category.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_category:
                new CategoryProtocol().post(this, new CategoryBeanCallback());
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
                System.out.println("我收到了category");
                break;
            default:
                break;
        }
    }

    @Override
    public void refreshUI(Object... objs) {
        super.refreshUI(objs);

        System.out.println(((CategoryBean) objs[0]).response);
        System.out.println(objs[1]);
        System.out.println(objs[2]);
    }
}
