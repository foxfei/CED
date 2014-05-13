// JavaScript Document

function ranub() { //随机验证码
		var nub=Math.floor(Math.random()*10000+1); //1-10000
		document.getElementById('nubs').innerHTML=nub;
		}

function bookmarkit(){ //加入收藏
window.external.addFavorite('http://www.csair.com','南方航空 www.csiar.com')
}

function SetBg(obj) { //#9ECC00
	obj.style.borderColor='#63A242';
}
function FetBg(obj) {
	obj.style.borderColor='';
}

//if (document.getElementById){ 
//document.write('<style type="text/css">\n')
//document.write('.submenu{display: none;}\n')
//document.write('</style>\n')
//}

//菜单

function SwitchMenu(sid){
	
var which = document.getElementById("sub" + sid);
var imgmenuElementId = "imgmenu" + sid;
//alert(imgmenuElementId);
var imgmenu = document.getElementById(imgmenuElementId);

	if (which.style.display == "none"){
		document.getElementById("sub" + sid).style.display="";
		imgmenu.className="menutitle2";
	}
	else{
		document.getElementById("sub" + sid).style.display="none";
		imgmenu.className="menutitle";
	}
}




		var hour = (new Date()).getHours();
		if (hour < 4) {
			hello = "夜深了，";
		}
		else if (hour < 7) {
			hello = "早安，";
		}
		else if (hour < 9) {
			hello = "早上好，"; 
		}
		else if (hour < 12) {
			hello = "上午好，";
		}
		else if (hour < 14) {
			hello = "中午好，";
		}
		else if (hour < 17) {
			hello = "下午好，";
		}
		else if (hour < 19) {
			hello = "您好，";
		}
		else if (hour < 22) {
			hello = "晚上好，";
		}
		else {
			hello = "夜深了，";
		}

var myweekday="";
mydate=new Date();
myweekday=mydate.getDay();

		if(myweekday == 0)
		weekday=" 星期日 ";
		else if(myweekday == 1)
		weekday=" 星期一 ";
		else if(myweekday == 2)
		weekday=" 星期二 ";
		else if(myweekday == 3)
		weekday=" 星期三 ";
		else if(myweekday == 4)
		weekday=" 星期四 ";
		else if(myweekday == 5)
		weekday=" 星期五 ";
		else if(myweekday == 6)
		weekday=" 星期六 ";