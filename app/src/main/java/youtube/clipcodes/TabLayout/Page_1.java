package youtube.clipcodes.TabLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import youtube.clipcodes.R;
import youtube.clipcodes.firebase_desain.desainlist;

/**
 * Created by haade on 13/09/2017.
 */


public class Page_1 extends Fragment {
    public WebView mWebView;
    View view;
    private Button buttonteknisi;
    //Constructor default
    public Page_1(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.page1, container, false);

        mWebView = (WebView) v.findViewById(R.id.weV);
        mWebView.loadUrl("https://www.designcontest.com/");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view=view;
        buttonteknisi();
    }

    public void buttonteknisi() {

        buttonteknisi = (Button)view.findViewById(R.id.buttonteknisi);
        buttonteknisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),desainlist.class);
                startActivity(intent);
            }
        });

    }


}