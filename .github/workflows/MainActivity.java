package com.zenapp.mobile;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.view.View;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    // Set this to the deployed HTTPS ZenApp address before building a live-connected APK.
    private static final String ZENAPP_SERVER_URL = "";

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(16,42,67));
        getWindow().setNavigationBarColor(Color.rgb(16,42,67));
        if (ZENAPP_SERVER_URL.startsWith("https://")) {
            WebView web = new WebView(this);
            WebSettings settings = web.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
            web.setWebViewClient(new WebViewClient());
            setContentView(web);
            web.loadUrl(ZENAPP_SERVER_URL);
        } else {
            LinearLayout box = new LinearLayout(this);
            box.setOrientation(LinearLayout.VERTICAL);
            box.setGravity(android.view.Gravity.CENTER);
            box.setPadding(40,40,40,40);
            box.setBackgroundColor(Color.rgb(248,250,252));
            TextView logo = new TextView(this);
            logo.setText("Z"); logo.setTextSize(44); logo.setTextColor(Color.WHITE);
            logo.setGravity(android.view.Gravity.CENTER);
            logo.setBackgroundColor(Color.rgb(22,199,183));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(120,120); lp.bottomMargin=28; box.addView(logo,lp);
            TextView title = new TextView(this); title.setText("ZenApp"); title.setTextSize(30); title.setTextColor(Color.rgb(16,42,67)); title.setGravity(android.view.Gravity.CENTER); box.addView(title);
            TextView message = new TextView(this); message.setText("Your Android app shell is ready. To enable real messaging, ZenApp must first be deployed to a secure HTTPS server and its address added to the build. This screen is not a working chat service yet."); message.setTextSize(16); message.setTextColor(Color.rgb(98,116,138)); message.setGravity(android.view.Gravity.CENTER); LinearLayout.LayoutParams mp=new LinearLayout.LayoutParams(-1,-2); mp.topMargin=18; box.addView(message,mp);
            setContentView(box);
        }
    }
}
