package com.example.administrator.mvp.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.ui.fragment.OneFragment;
import com.example.administrator.mvp.ui.fragment.ThreeFragment;
import com.example.administrator.mvp.ui.fragment.TwoFragment;
import com.example.administrator.mvp.view.SwitchMainViewI;

public class OneActivity extends BaseActivity  implements SwitchMainViewI{
    private String[] tags={"one","two","three"};
    private FragmentManager fm;
    private OneFragment f1;
    private TwoFragment f2;
    private ThreeFragment f3;
    private RadioGroup rg;
    private RadioButton r1,r2,r3;

    @Override
    public void initView() {
        setContentView(R.layout.activity_one);
        rg= (RadioGroup) findViewById(R.id.rg);
        r1= (RadioButton) findViewById(R.id.r1);
        r2= (RadioButton) findViewById(R.id.r2);
        r3= (RadioButton) findViewById(R.id.r3);
        swichPages();
        showFragment(fm,f1,"one");
    }

    @Override
    public void swichPages() {
        fm=getSupportFragmentManager();
        f1=new OneFragment();
        f2=new TwoFragment();
        f3=new ThreeFragment();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                clean();
                switch (checkedId){
                    case R.id.r1:
                        showFragment(fm,f1,"one");
                        r1.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case R.id.r2:
                        showFragment(fm,f2,"two");
                        r2.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case R.id.r3:
                        showFragment(fm,f3,"three");
                        r3.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                }
            }
        });

    }

    @Override
    public void showFragment(FragmentManager fm, Fragment fragment, String str) {
        FragmentTransaction ft;
        ft = fm.beginTransaction();
        for (String tag:tags){
            if (!tag.equals(str)){
                Fragment fragmentTemp = fm.findFragmentByTag(tag);
                if (fragmentTemp!=null){
                    ft.hide(fragmentTemp);
                }
            }
        }
        if (fm.findFragmentByTag(str)==null){
            ft.add(R.id.mFl, fragment, str);
        }
        ft.show(fragment);
        ft.commit();
    }
    public void clean(){
        r1.setTextColor(getResources().getColor(R.color.colorPrimary));
        r2.setTextColor(getResources().getColor(R.color.colorPrimary));
        r3.setTextColor(getResources().getColor(R.color.colorPrimary));
    }
}
