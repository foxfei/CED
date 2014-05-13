	$.validator.addMethod('maxBytes', function (value,element,param) {
    	return this.optional(element) || getBytesCount(value, element) <= param;
    }, jQuery.format("字节数不能超过 {0} 字节."));

	$.validator.addMethod('yearmonthday', function (value) { 
	
		//alert(value);
	if(value.trim()==""){
		//alert("xxx");
		return true;
	}else{
		//alert("xxxy");
		//return /^((\d{2}(([02468][048])|([13579][26]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|([1-2][0-9])))))|(\d{2}(([02468][1235679])|([13579][01345789]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\s(((0?[0-9])|([1-2][0-3]))\:([0-5]?[0-9])((\s)|(\:([0-5]?[0-9])))))?$/.test(value);
		var xxx=  /^\d{4}-\d{2}-\d{2}$/.test(value);
		var yyy=CheckDate(value);
		if(xxx==true && !yyy){return true;}
		else return false;
	}
	
     }, '');
     
 
function CheckDate(INDate)
{ if (INDate=="")
    {return true;}
subYY=INDate.substr(0,4)

if(isNaN(subYY) || subYY<=0){
   return true;
}
//转换月份
if(INDate.indexOf('-',0)!=-1){ separate="-"}
else{
   if(INDate.indexOf('/',0)!=-1){separate="/"}
   else {return true;}
   }
   area=INDate.indexOf(separate,0)
   subMM=INDate.substr(area+1,INDate.indexOf(separate,area+1)-(area+1))
   if(isNaN(subMM) || subMM<=0){
   return true;
}
   if(subMM.length<2){subMM="0"+subMM}
//转换日
area=INDate.lastIndexOf(separate)
subDD=INDate.substr(area+1,INDate.length-area-1)
if(isNaN(subDD) || subDD<=0){
   return true;
}
if(eval(subDD)<10){subDD="0"+eval(subDD)}
NewDate=subYY+"-"+subMM+"-"+subDD
if(NewDate.length!=10){return true;}
    if(NewDate.substr(4,1)!="-"){return true;}
    if(NewDate.substr(7,1)!="-"){return true;}
var MM=NewDate.substr(5,2);
var DD=NewDate.substr(8,2);
if((subYY%4==0 && subYY%100!=0)||subYY%400==0){ //判断是否为闰年
   if(parseInt(MM)==2){
    if(DD>29){return true;}
   }
}else{
   if(parseInt(MM)==2){
    if(DD>28){return true;}
   } 
}
var mm=new Array(1,3,5,7,8,10,12); //判断每月中的最大天数


var mmInt = parseInt(MM);
var ddInt = parseInt(DD);

var wangliang =30;
for(i=0;i< mm.length;i++){
   if (mmInt == mm[i]){
   	wangliang =31;
    break;
   }else{
   	continue;
   }
}


if(ddInt>wangliang){
return true;
}

if(mmInt>12){return true;}
   return false;}    
         
    
    
	$(document).ready(function(){
			doValidate();
			if (navigator.appName == "Microsoft Internet Explorer"){
				if(top!=window){
					$('body').css("width","97%")
				}
			}
	});
	

    
/**
计算字符串的字节数
**/
function getBytesCount(str){
  var bytesCount = 0;
  if (str != null)
  {
    for (var i = 0; i < str.length; i++)
    {
      var c = str.charAt(i);
      if (/^[\u0000-\u00ff]$/.test(c))
      {
        bytesCount += 1;
      }
      else
      {
        bytesCount += 2;
      }
    }
  }
  return bytesCount;
}
	
	

	//验证表单的file元素,如果大于maxFileSize返回false,否则返回true ,只适用于IE
	function validateUploadField(elementObj,maxFileSize){
  		var filePath =elementObj.value;
   		var image=new Image();
   		image.dynsrc=filePath;
   		var file_size = image.fileSize;
   		if(file_size>maxFileSize){ return false;}return true;
	}
	
	
	function validateUpload(){
  		var __maxFileSzie = 2500000;
  		var __fileV = true;
  		$('input[@type=file]').each(function(){
  			__fileV = validateUploadField(this,__maxFileSzie);
    		if(!__fileV){return false;}
  		});
  		if(!__fileV){alert("单个附件上传大小不能超过2M");}
  		return __fileV;
 	}
	
function   String.prototype.trim()  
  {  
  return     this.replace(/(^\s*)|(\s*$)/g,   "");  
  }   	
	
	function doValidate(){
			$('input[class^=required]').each(function(){
					$(this).after("<font color=RED>**</font>");
			});
			
			$('select[class^=required]').each(function(){
					$(this).after("<font color=RED>**</font>");
			});
			
			$('textarea[class^=required]').each(function(){
					$(this).after("<font color=RED>**</font>");
			});
			$('form[class^=v]').each(function(){
			
					if($(this).find("div.error").length){
					$(this).validate(
						{
							errorLabelContainer: $(this).find("div.error"),
							wrapper: 'li',
							meta: "validate"
						}
					);
					}else{
						$(this).validate();
					}
					
			});
	}