package com.chengaijue.marryme;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Boolean loading = false;
	Boolean starting = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText uText = (EditText)this.findViewById(R.id.uText);
        final Button uButton = (Button)this.findViewById(R.id.uButton);
        final WebView webview = (WebView)this.findViewById(R.id.webview);
        WebSettings wSettings = webview.getSettings();
        wSettings.setJavaScriptEnabled(true);
        
        
        webview.loadUrl("http://pt.3g.qq.com/s?aid=cpgamelogin&cpid=1&gameid=10&go_url=http%3A%2F%2Fmg.3g.qq.com%2Flogin.jsp%3Fcpid%3D1%26gameid%3D10%26from%3DmgameHome%26cid%3D0%26pcid%3D0");
        uButton.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (!loading){
					String url = uText.getText().toString();
					uButton.setText("stop");
					webview.loadUrl(url);
					loading = true;
				}
				if (loading){
					uButton.setText("(0!0)");
					webview.stopLoading();
					loading = false;
				}
			}        	
        });
        webview.setWebViewClient(new WebViewClient(){       
            public boolean shouldOverrideUrlLoading(WebView view, String url) {       
                view.loadUrl(url);       
                return true;       
            }     
            @Override
            public void onPageFinished(WebView view, String url) 
            {
            	if (starting){
            		PerformCommand.doClick(view, url);
            	}
            	loading = false;
            	uButton.setText("(0!0)");
                super.onPageFinished(view, url);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) 
            {
            	loading = true;
            	uButton.setText("stop");
            	uText.setText(url);
                super.onPageStarted(view, url, favicon);
            }
        }); 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
        	case R.id.action_settings: 
        		//Toast.makeText(this, "1", Toast.LENGTH_LONG).show();
        		break;
        	case R.id.action_controller:
        		if (starting){
        			Toast.makeText(this, "Stoping", Toast.LENGTH_LONG).show();
        			item.setTitle("start");
        			starting = false;
        			break;
        		}
        		if (!starting){
        			Toast.makeText(this, "Starting", Toast.LENGTH_LONG).show();
        			item.setTitle("stop");
        			starting = true;
        			break;
        		}
        		//break;
        }
        return true;
    }
    
}
