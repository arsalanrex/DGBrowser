package com.kilgharrah.dgbrowser_adisposablebrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    //banner ads
    private AdView mAdView;

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize app
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        //banner ads
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //show ad
        mAdView.loadAd(adRequest);

        wv=findViewById(R.id.webView1);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://google.com/");
        wv.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed(){
        if (wv.canGoBack()){
            wv.goBack();
        }
        else{
            super.onBackPressed();
        }
    }

}
