package at.sadra.apps.season4java;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class E23AndroidWebView extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    ImageView go;
    EditText url;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e23_android_web_view);
        setTitle(getString(R.string.E23AndroidWebView));

        init();
    }

    private void init() {
        webView = findViewById(R.id.webView);
        go = findViewById(R.id.go);
        url = findViewById(R.id.url);
        progressBar = findViewById(R.id.progressBar);

        webView.setWebViewClient(new Browser());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);

        go.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        webView.loadUrl(url.getText().toString());
    }


    public class Browser extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.VISIBLE);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.INVISIBLE);
            super.onPageFinished(view, url);
        }
    }


}
