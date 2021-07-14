package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private WebView webView;
    private Random random = new Random();
    private ImageButton ib_back;
    private ImageButton ib_continue;

    private String[] 발라드 = {"https://www.youtube.com/embed/Hi0skksGeRk",
            "https://www.youtube.com/embed/kB5g7ceKejw",
            "https://www.youtube.com/embed/jy_UiIQn_d0",
            "https://www.youtube.com/embed/vtdR75lwy9s",
            "https://www.youtube.com/embed/VgbIDfPJIFs"};
    private String[] 댄스팝 = {"https://www.youtube.com/embed/CuklIb9d3fI",
            "https://www.youtube.com/embed/RmuL-BPFi2Q",
            "https://www.youtube.com/embed/GWNODbG9AIM",
            "https://www.youtube.com/embed/WMweEpGlu_U",
            "https://www.youtube.com/embed/4TWR90KJl84"};
    private String[] 트로트 = {"https://www.youtube.com/embed/5zONW_hyI5A",
            "https://www.youtube.com/embed/5MS-GpklkHs",
            "https://www.youtube.com/embed/GNcwNAT6fro",
            "https://www.youtube.com/embed/o71z6nDktEI",
            "https://www.youtube.com/embed/7Uu_K0R3yuY"};
    private String[] 힙합 = {"https://www.youtube.com/embed/0CS8qFgFHxU",
            "https://www.youtube.com/embed/MiYgR25ur8k",
            "https://www.youtube.com/embed/FKlr_LXnKmU",
            "https://www.youtube.com/embed/QPUjV7epJqE",
            "https://www.youtube.com/embed/N6ElB8ysTXM"};
    private String[] 락메탈 = {"https://www.youtube.com/embed/N2p-LRBNc",
            "https://www.youtube.com/embed/K6sH0r_NwUo",
            "https://www.youtube.com/embed/CKZvWhCqx1s",
            "https://www.youtube.com/embed/tqyrl2V1kTM",
            "https://www.youtube.com/embed/GVRUPRSFnQI&t=126s"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        if (Objects.equals(MainActivity.select, "발라드")) {
            webView.loadUrl(발라드[random.nextInt(발라드.length+1)]);
        } else if(Objects.equals(MainActivity.select, "댄스/팝")) {
            webView.loadUrl(댄스팝[random.nextInt(댄스팝.length+1)]);
        } else if(Objects.equals(MainActivity.select, "트로트")) {
            webView.loadUrl(트로트[random.nextInt(트로트.length+1)]);
        } else if(Objects.equals(MainActivity.select, "랩/힙합")) {
            webView.loadUrl(힙합[random.nextInt(힙합.length+1)]);
        } else if(Objects.equals(MainActivity.select, "락/메탈")) {
            webView.loadUrl(락메탈[random.nextInt(락메탈.length+1)]);
        }

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());

        ib_back = (ImageButton) findViewById(R.id.ib_back);
        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ib_continue = (ImageButton) findViewById(R.id.ib_continue);
        ib_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();

                if (Objects.equals(MainActivity.select, "발라드")) {
                    webView.loadUrl(발라드[random.nextInt(발라드.length+1)]);
                } else if(Objects.equals(MainActivity.select, "댄스/팝")) {
                    webView.loadUrl(댄스팝[random.nextInt(댄스팝.length+1)]);
                } else if(Objects.equals(MainActivity.select, "트로트")) {
                    webView.loadUrl(트로트[random.nextInt(트로트.length+1)]);
                } else if(Objects.equals(MainActivity.select, "랩/힙합")) {
                    webView.loadUrl(힙합[random.nextInt(힙합.length+1)]);
                } else if(Objects.equals(MainActivity.select, "락/메탈")) {
                    webView.loadUrl(락메탈[random.nextInt(락메탈.length+1)]);
                }
            }
        });

    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}