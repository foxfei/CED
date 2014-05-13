/**
 * identify_base.js
 * @author Jiahao.Shao
 * 
 * 此js文件提供较简单的异步请求并发控制的方案
 * 
 */

//请求缓存队列
var requestQueue = new Array();
//当前已发出的请求数
var sessionCount = 0;
//允许发出的最大请求数
var maxSessionCount = 2;
//以下对象用于判定一个同名请求是否已经发生过，避免多次点击多次发出请求
var callRecord = new Object();

/**
 * 自定义的request对象，用于以对象形式缓存在队列中，从队列
 * 取出来使用较为方便
 * @param functionName string	请求函数名，如dwr中是AnObject.anMethod
 * @param params array	请求函数所需参数的数组
 * @param callback string	请求函数的回调函数
 */
function AjaxRequest(functionName, params, callback){
	this.functionName = functionName;
	this.params = params;
	this.callback = callback;
}

/**
 * 真正发起ajax请求
 */
function processRequest(ajaxRequest){
//	alert(typeof(ajaxRequest));
//	if(typeof(ajaxRequest) != "AjaxRequest"){
//		alert("不正确的请求!");
//		return;
//	}
	if(ajaxRequest.callback == null){
		alert("没有设定回调函数!");
		return;
	}
	var process = ajaxRequest.functionName + "([";
	if(ajaxRequest.params != null && ajaxRequest.params.length > 0){
		var params = ajaxRequest.params;
		var len = params.length;
		for(var i=0; i<len; i++){
			process = process + "'" + params[i] + "' ";
			if(i < len-1){
				process += ",";
			}
		}
	}
	process = process + "], " + ajaxRequest.callback + ");";
	increaseSession();
	eval(process);
}

/**
 * 判定是否已经达到最大请求数
 */
function isMaxSessions(){
	if(sessionCount < maxSessionCount){
		return false;
	}
	else{
		return true;
	}
}

/**
 * 将ajaxRequest压入队列中等待
 */
function pushToQueue(ajaxRequest){
	requestQueue.push(ajaxRequest);
}

/**
 * 将queue头部的ajaxRequest删除并返回
 */
function shiftFromQueue(){
	return requestQueue.shift();
}

/**
 * 判定queue是否为空
 */
function isQueueEmpty(){
	return requestQueue.length > 0 ? false : true;
}

function increaseSession(){
	sessionCount ++;
}

function decreaseSession(){
	sessionCount --;
}

/**
 * 以下是对外api
 * 		1.createNewRequest是新建一个请求，切忌用AjaxRequest的构造函数，因为api
 * 带有一些新建限制，也就是不一定需要新建对象的。
 * 		2.doInNewRequest是在调用某个ajax请求时调用的，最终ajax进程是由此函数创建
 * 需要建立一个ajaxRequest对象，详细请见demo
 * 		3.doInCallback是某个ajax请求的回调函数调用的，回调函数业务逻辑处理之前就
 * 应当先调用此函数，以立即启动下一个ajax进程
 */
function createNewRequest(functionName, params, callback){
	if(callRecord[params[0]] == null || typeof(callRecord[params[0]]) == "undefined"){
		//没有发起过此种请求，记录下来，下次如点击之类事件发生都不再加入到缓存队列或重新发起请求
		callRecord[params[0]] = true;
		return new AjaxRequest(functionName, params, callback);
	}
	else{
		return null;
	}
}
 
function doInNewRequest(ajaxRequest){
	if(ajaxRequest == null || typeof(ajaxRequest) == "undefined"){
		return;
	}
	if(isMaxSessions()){
	//缓存请求
		pushToQueue(ajaxRequest);
	}
	else{
		processRequest(ajaxRequest);
	}
}

function doInCallback(){
	decreaseSession();
	if(!isQueueEmpty()){
		var ajaxRequest = shiftFromQueue();
		processRequest(ajaxRequest);
	}
}


function setTab(name,cursel,n,t){
	for(var i=1;i<=n;i++){	
		var menu=document.getElementById(name+i);
		if(!menu){
			if (t==0)cursel++;
			continue;
		}
		var con=document.getElementById("con_"+name+"_"+i);
		menu.className=(i==cursel?"hover":"");
		con.style.display=(i==cursel?"block":"none");
	}
}
function fSetBg(obj){
        obj.style.backgroundColor = '#F2F9C6';
}
function fReBg(obj){
        obj.style.backgroundColor = '';
}
function init(){
	//DO NOTHING
}