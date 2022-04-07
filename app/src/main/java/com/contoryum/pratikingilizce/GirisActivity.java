package com.contoryum.pratikingilizce;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class GirisActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btnkelime;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

       // showFullPage();

        btn1=(Button)findViewById(R.id.btn_test1);
        btn2=(Button)findViewById(R.id.btn_test2);
        btn3=(Button)findViewById(R.id.btn_test3);
        btn4=(Button)findViewById(R.id.btn_test4);
        btn5=(Button)findViewById(R.id.btn_test5);
        btn6=(Button)findViewById(R.id.btn_test6);
        btn7=(Button)findViewById(R.id.btn_test7);
        btn8=(Button)findViewById(R.id.btn_test8);
        btn9=(Button)findViewById(R.id.btn_test9);
        btn10=(Button)findViewById(R.id.btn_test10);
        btnkelime=(Button)findViewById(R.id.btn_kelime);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",0);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",1);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",2);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",3);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",4);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",5);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",6);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",7);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",8);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putInt("a",9);
                Intent i=new Intent(getApplicationContext(),OptionActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btnkelime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);


            }
        });






    }


//    @Override
//    public void onBackPressed() {
//        if (mInterstitialAd.isLoaded()) mInterstitialAd.show();
//        super.onBackPressed();
//    }

//    private void showFullPage(){
//        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId(getResources().getString(R.string.Page));
//
//
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
//
//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//
//
//
//            }
//
//
//        });
//
//    }
}
