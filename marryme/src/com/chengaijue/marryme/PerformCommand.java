package com.chengaijue.marryme;

import android.webkit.WebView;

public class PerformCommand {

	public static void doClick(WebView w, String url){
		w.loadUrl("javascript:" +
				"alert('111');");	
	}
}
