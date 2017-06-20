package com.example.administrator.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mvp.R;

public class DengluActivity extends AppCompatActivity {
    private EditText mEt1,mEt2;
    private String name="15041193314";
    private String code="123456";
    private String s1,s2;
    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        initView();
    }

    private void initView() {
        mEt1= (EditText) findViewById(R.id.mEt1);
        mEt2= (EditText) findViewById(R.id.mEt2);
        mBtn= (Button) findViewById(R.id.mBtn);

//        mEt1.addTextChangedListener(watcher);
//        mEt2.addTextChangedListener(watcher);
//
//        s1=mEt1.getText().toString();
//        s2=mEt2.getText().toString();
//
//
//        if (s1.equals("")&&s2.equals("")){
//            Toast.makeText(DengluActivity.this,"账号密码不能为空",Toast.LENGTH_SHORT).show();
//        }else if (!s1.equals(name)&&!s2.equals(code)){
//            Toast.makeText(DengluActivity.this,"账号密码不正确",Toast.LENGTH_SHORT).show();
//        }else if (s1.equals(name)&&s2.equals(code)){
//            Toast.makeText(DengluActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
//            Intent intent=new Intent(DengluActivity.this,OneActivity.class);
//            startActivity(intent);
//        }

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=mEt1.getText().toString();
                s2=mEt2.getText().toString();


                if (s1.equals("")&&s2.equals("")){
                    Toast.makeText(DengluActivity.this,"账号密码不能为空",Toast.LENGTH_SHORT).show();
                }else if (!s1.equals(name)&&!s2.equals(code)){
                    Toast.makeText(DengluActivity.this,"账号密码不正确",Toast.LENGTH_SHORT).show();
                }else if (s1.equals(name)&&s2.equals(code)){
                    Toast.makeText(DengluActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(DengluActivity.this,OneActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        s1=mEt1.getText().toString();
//        s2=mEt2.getText().toString();
//
//        if (s1.equals("")&&s2.equals("")){
//            Toast.makeText(DengluActivity.this,"账号密码不能为空",Toast.LENGTH_SHORT).show();
//        }else if (!s1.equals(name)&&!s2.equals(code)){
//            Toast.makeText(DengluActivity.this,"账号密码不正确",Toast.LENGTH_SHORT).show();
//        }else if (s1.equals(name)&&s2.equals(code)){
//            Toast.makeText(DengluActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
//            Intent intent=new Intent(DengluActivity.this,OneActivity.class);
//            startActivity(intent);
//        }
//    }
//private TextWatcher watcher = new TextWatcher() {
//
//    @Override
//    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void beforeTextChanged(CharSequence s, int start, int count,
//                                  int after) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void afterTextChanged(Editable s) {
//        // TODO Auto-generated method stub
//
//    }
//};
}
