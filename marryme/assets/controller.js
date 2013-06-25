var myString = myData;
/*alert(myString);*/
var body = document.body;
var aElements = body.getElementsByTagName("a");

var doText = "刷新";
var time = 1000;

for (var i=0;i<aElements.length;i++){
	/*if (aElements[i].innerText)*/
	var text = aElements[i].innerText;
	/*alert(text.indexOf(doText));*/

	if(text.indexOf(doText)!=-1){
		/*alert(aElements[i].innerText);*/
		setTimeout(function(){doSom(aElements[i]);},time);
		break;
	}
}
function doSom(ele){
	window.location = ele.href;
	/*alert(window.location);*/
}