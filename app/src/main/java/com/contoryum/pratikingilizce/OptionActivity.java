package com.contoryum.pratikingilizce;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class OptionActivity extends AppCompatActivity {

    private static int iii = 0;
    String stcevap;

    private AdView adView;
    private InterstitialAd mInterstitialAd;
    private int bannerIndex = 0;

    TextView txtsoru, txtacevap, txtbcevap, txtccevap;
    int iskor = 0, i = 0, icevap = 0, ii = 0, gelen = 0, topla = 0;

    Button btnileri, btngeri;
    ArrayList<String> quotes;
    ArrayList<String> quotescvp;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        btnileri = findViewById(R.id.btnileri);
        btngeri = findViewById(R.id.btngeri);

       // reklamiYukle();
       // showFullPage();


        Intent in = getIntent();
        Bundle b = in.getExtras();
        gelen = b.getInt("a");


        if (gelen == 0) {
            iii = 0;
            getposition();
        } else if (gelen == 1) {
            iii = 1;
            getposition();

        } else if (gelen == 2) {
            iii = 2;
            getposition();
        } else if (gelen == 3) {
            iii = 3;
            getposition();
        } else if (gelen == 4) {
            iii = 4;
            getposition();
        } else if (gelen == 5) {
            iii = 5;
            getposition();
        } else if (gelen == 6) {
            iii = 6;
            getposition();
        } else if (gelen == 7) {
            iii = 7;
            getposition();
        } else if (gelen == 8) {
            iii = 8;
            getposition();
        } else if (gelen == 9) {
            iii = 9;
            getposition();
        }


        Mydatabase databaseAccess = Mydatabase.getInstance(this);

        databaseAccess.open();
        quotes = (ArrayList<String>) databaseAccess.getQuotes();
        quotescvp = (ArrayList<String>) databaseAccess.getcvp();
        databaseAccess.close();


        btngeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(i <= 0)) {
                    i = i - 4;
                    icevap--;
                    getideger(i);
                    txtacevap.setBackgroundColor(Color.WHITE);
                    txtbcevap.setBackgroundColor(Color.WHITE);
                    txtccevap.setBackgroundColor(Color.WHITE);
                }
                iskor = 0;

                if (ii == 0) {
                    Toast.makeText(getApplicationContext(), "Score sıfırlandı", Toast.LENGTH_SHORT).show();
                    ii = ii + 1;
                }


            }
        });

        btnileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(i >= 76/* 64 olcak*/)) {
                    i = i + 4;
                    icevap++;
                    getideger(i);
                    txtacevap.setBackgroundColor(Color.WHITE);
                    txtbcevap.setBackgroundColor(Color.WHITE);
                    txtccevap.setBackgroundColor(Color.WHITE);
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setIcon(R.drawable.tacc);
                    builder.setTitle("PUANINIZ:" + (iskor * 5));
                    builder.setMessage("20 sorudan " + iskor + " doğru  " + (20 - iskor) + " yanlış yaptınız.");
                    builder.setCancelable(true);


                    final AlertDialog dlg = builder.create();



                  dlg.show();


                    final  Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        public void run() {
                            dlg.dismiss(); // when the task active then close the dialog
                            t.cancel();

                            startActivity(new Intent(getApplicationContext(), GirisActivity.class));
                            // also just top the timer thread, otherwise, you may receive a crash report
                        }

                    }, 5000); // after 2 second (or 2000 miliseconds), the task will be active.


                }


            }
        });

        getideger(i);

    }

//    @Override
//    public void onBackPressed() {
//        if (mInterstitialAd.isLoaded()) mInterstitialAd.show();
//        super.onBackPressed();
//    }

//    private void showFullPage(){
//
//            mInterstitialAd.loadAd(new AdRequest.Builder().build());
//
//            mInterstitialAd.setAdListener(new AdListener() {
//                @Override
//                public void onAdLoaded() {
//                    super.onAdLoaded();
//
//
//
//                }
//
//
//            });
//
//
//
//    }


//    private void reklamiYukle() {
//            MobileAds.initialize(this,
//                    getResources().getString(R.string.apps_id));
//
//            adView = findViewById(R.id.reklam);
//            AdRequest adRequest = new AdRequest.Builder().build();
//            adView.loadAd(adRequest);
//
//        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId(getResources().getString(R.string.Page));
//
//    }


    public static int getposition() {
        int c = iii;
        return c;
    }


    private void getideger(int i) {


        final String stsoru = quotes.get(i);
        final String stasik = quotes.get(i + 1);
        final String stbsik = quotes.get(i + 2);
        final String stcsik = quotes.get(i + 3);


        txtsoru = findViewById(R.id.txtSoru);
        txtsoru.setMovementMethod(new ScrollingMovementMethod());
        txtacevap = findViewById(R.id.txtaCevap);
        txtbcevap = findViewById(R.id.txtbCevap);
        txtccevap = findViewById(R.id.txtcCevap);


        txtsoru.setText((icevap + 1) + "-)" + stsoru);

        txtacevap.setText("A-" + stasik);

        txtacevap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtacevap.setBackgroundColor(Color.GRAY);
                if (txtccevap.isClickable() || txtbcevap.isClickable()) {
                    txtccevap.setClickable(false);
                    txtbcevap.setClickable(false);
                }
                answer(icevap);
                scorehesapla();

            }
        });


        txtbcevap.setText("C-" + stbsik);
        txtbcevap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtbcevap.setBackgroundColor(Color.GRAY);
                if (txtacevap.isClickable() || txtccevap.isClickable()) {
                    txtacevap.setClickable(false);
                    txtccevap.setClickable(false);
                }
                answer(icevap);
                scorehesapla();
            }
        });
        txtccevap.setText("B-" + stcsik);
        txtccevap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtccevap.setBackgroundColor(Color.GRAY);
                if (txtacevap.isClickable() || txtbcevap.isClickable()) {
                    txtacevap.setClickable(false);
                    txtbcevap.setClickable(false);
                }
                answer(icevap);
                scorehesapla();
            }
        });
    }

    private void answer(final int icevap) {

        stcevap = quotescvp.get(icevap);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (stcevap.equals("a")) {

                    txtacevap.setBackgroundColor(Color.GREEN);

                } else if (stcevap.equals("b")) {

                    txtbcevap.setBackgroundColor(Color.GREEN);


                } else if (stcevap.equals("c")) {

                    txtccevap.setBackgroundColor(Color.GREEN);
                }


                // Actions to do after 10 seconds
            }
        }, 1000);


    }

    private int scorehesapla() {
        if (stcevap.equals("a") && txtacevap.isClickable()) {
            iskor = iskor + 1;

        } else if (stcevap.equals("b") && txtbcevap.isClickable()) {

            iskor = iskor + 1;

        } else if (stcevap.equals("c") && txtccevap.isClickable()) {
            iskor = iskor + 1;

        }
        return iskor;
    }
}
