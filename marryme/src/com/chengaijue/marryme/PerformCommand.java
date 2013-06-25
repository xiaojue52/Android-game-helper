package com.chengaijue.marryme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.webkit.WebView;

public class PerformCommand {
    private String controller = "";
	private Context context;
	public PerformCommand(Context context){
		this.context = context;
		controller = this.readJs();
	}
	public void doClick(WebView w, String url){
		String myData = url;
		//String controller = "";
		w.loadUrl("javascript:(function(){var myData ='"+myData+"';"+controller+"})();");	
	}
	private String readJs(){
		String js = "";
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(context.getAssets().open("controller.js")));
			String temp = "";
			while((temp = br.readLine())!=null){
				js += temp;
			}
		}catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close(); //stop reading
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }
		return js;
	}
}
