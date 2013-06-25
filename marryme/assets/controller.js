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
		setTimeout(doSom,time);
		break;
	}
}
function doSom(){
	
	alert(windows.location);
}