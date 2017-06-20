package com.example.administrator.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mvp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager mVp;
    private TextView mTv,mNum;
    private boolean isFirstIn=false;
    private Intent in;

    private ImageView iv1, iv2, iv3;
    private View v1, v2, v3;
    private List<View> list;

    private int number=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initList();
    }

    private void initList() {
        list = new ArrayList<View>();
        list.add(v1);
        list.add(v2);
        list.add(v3);


        MyAdapter adapter = new MyAdapter(list);
        mVp.setAdapter(adapter);
        mVp.setOnPageChangeListener(MainActivity.this);


        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// handler.sendEmptyMessage(0);
                in=new Intent(MainActivity.this,DengluActivity.class);
                startActivity(in);
                finish();
            }
        });
    }
    private void initView() {

        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        mVp=(ViewPager)findViewById(R.id.mVp);

        v1 = View.inflate(this, R.layout.tiem1, null);
        v2 = View.inflate(this, R.layout.tiem2, null);
        v3 = View.inflate(this, R.layout.tiem3, null);
        mTv=(TextView) v3.findViewById(R.id.mTv);
        mNum= (TextView) v3.findViewById(R.id.mNum);
    }


    public class MyAdapter extends PagerAdapter {

        private List<View> list;

        public MyAdapter(List<View> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            // TODO Auto-generated method stub
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView(list.get(position));
        }

    }


    @Override
    public void onPageScrollStateChanged(int arg0) {//在状态改变的时候调用
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {//页面在滑动的时候会调用此方法
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int arg0) {//页面跳转完后得到调用
        // TODO Auto-generated method stub
        clear();
        switch (arg0) {
            case 0:
                iv1.setImageResource(R.mipmap.dian);
                break;

            case 1:
                iv2.setImageResource(R.mipmap.dian);
                break;
            case 2:
                iv3.setImageResource(R.mipmap.dian);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 3; i < 4; i--) {
                            Message msg = hd.obtainMessage();
                            msg.what = 1;
                            msg.obj = i;
                            hd.sendMessage(msg);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (i == 0) {
                                Intent in = new Intent(MainActivity.this, DengluActivity.class);
                                startActivity(in);
                                finish();

                            }
                        }
                    }
                }).start();
                break;
        }
    }
    public void clear(){
        iv1.setImageResource(R.mipmap.undian);
        iv2.setImageResource(R.mipmap.undian);
        iv3.setImageResource(R.mipmap.undian);
    }
    private Handler hd = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                int s = (int) msg.obj;
                mNum.setText(s + "");
            }
        }
    };
}
