<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<input id="code_reddit" type="text"  autocomplete="off">
<button  onclick="g_gout()">Ŭ��</button>

<script>
var voices = [];
function setVoiceList() {
voices = window.speechSynthesis.getVoices();
}
setVoiceList();
if (window.speechSynthesis.onvoiceschanged !== undefined) {
window.speechSynthesis.onvoiceschanged = setVoiceList;
}
function speech(txt) {
if(!window.speechSynthesis) {
alert("���� ����� �������� �ʴ� �������Դϴ�. ũ��, ���̾����� ���� �ֽ� �������� �̿��ϼ���");
return;
}
var lang = 'ko-KR';
var utterThis = new SpeechSynthesisUtterance(txt);
utterThis.onend = function (event) {
console.log('end');
};
utterThis.onerror = function(event) {
console.log('error', event);
};
var voiceFound = false;
for(var i = 0; i < voices.length ; i++) {
if(voices[i].lang.indexOf(lang) >= 0 || voices[i].lang.indexOf(lang.replace('-', '_')) >= 0) {
utterThis.voice = voices[i];
voiceFound = true;
}
}
if(!voiceFound) {
alert('voice not found');
return;
}
utterThis.lang = lang;
utterThis.pitch = 1;
utterThis.rate = 1; //�ӵ�
window.speechSynthesis.speak(utterThis);
}
function g_gout(){
    var t = document.getElementById("code_reddit");
    speech(t.value);
}
</script>
</body>
</html>