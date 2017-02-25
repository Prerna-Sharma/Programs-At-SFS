package com.example.student.androidprograms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.Services.MyIntentService;
import com.example.student.Services.MyService;


public class ImplicitIntentActivity extends AppCompatActivity implements View.OnClickListener {

    //Code of 3 buttons named "Facebook","Gallery","Call"
    private Button btnFacebookPage, btnGallery, btnCall, btnPrevious, btnStartService;
    private EditText edtxtMobileNumber;
    private Intent intent;
    private String data;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        //findViewById
        btnFacebookPage = (Button) findViewById(R.id.btn_web_page);
        btnGallery = (Button) findViewById(R.id.btn_gallery);
        btnPrevious = (Button) findViewById(R.id.btn_previous_implicit_intent);
        btnCall = (Button) findViewById(R.id.btn_call);
        btnStartService = (Button) findViewById(R.id.btn_start_service);
        edtxtMobileNumber = (EditText)findViewById(R.id.edtxt_mobile_number);

        //setOnClickListener
        btnPrevious.setOnClickListener(this);
        btnFacebookPage.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnStartService.setOnClickListener(this);
    }

    //Action to be performed on OnClick event
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_web_page:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
//                intent = new Intent(this, com.example.student.myapplication.MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_gallery:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/external/images/media"));
//                intent = new Intent(this, CustomizedListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_call:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + edtxtMobileNumber.getText().toString()));
                startActivity(intent);
                break;
            case R.id.btn_previous_implicit_intent:
                intent = new Intent();
                intent.putExtra("data", edtxtMobileNumber.getText().toString());
                setResult(ImplicitIntentActivity.RESULT_OK,intent);
                finish();
                break;
            case R.id.btn_start_service:
                intent = new Intent(ImplicitIntentActivity.this, MyIntentService.class);
                startService(intent);
        }
    }

}
