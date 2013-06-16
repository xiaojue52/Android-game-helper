package com.chengaijue.marryme;

import android.content.Context;
import android.webkit.WebView;

public class PerformCommand {

	private Context context;
	public PerformCommand(Context context){
		this.context = context;
	}
	public void doClick(WebView w, String url){
		w.loadUrl("javascript:");	
	}
}
