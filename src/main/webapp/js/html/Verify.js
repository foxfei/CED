


function MingZhu(){
            

        var fnen=document.getElementsByName("info.firstNameEN")[0].value;
        var lnen=document.getElementsByName("info.lastNameEN")[0].value;
        
        
        var sel=  document.getElementById("countrySel");
        var country = sel.options[sel.selectedIndex].text;
        var countryValue=sel.options[sel.selectedIndex].value;
        
        var birth = document.getElementsByName("calendar_DatePicker0")[0].value;
        
        var PassPort = document.getElementsByName("info.passport")[0].value;
        var otherCredential = document.getElementsByName("info.otherCredential")[0].value;        
        var CardId = document.getElementsByName("info.identifyCard")[0].value;
        
        var MobilePhone = document.getElementsByName("info.mobile")[0].value;
        var UsualPhone1 = document.getElementsByName("info.telArea")[0].value;
        var UsualPhone2 = document.getElementsByName("info.telNum")[0].value;
        
        var address = document.getElementsByName("info.address")[0].value;
        
        var fncn=document.getElementsByName("info.firstNameCN")[0].value;
        var lncn=document.getElementsByName("info.lastNameCN")[0].value;
        
        
    
        if(fncn!=""&&fncn!=null){
        	var pattern =/^[\u4e00-\u9fa5]+$/;
     
        	var fn = pattern.test(fncn);
        	if(!fn){
        		alert("请输入简体中文名");return false;
        	}
        }else if(lncn!=""&&lncn!=null){
        	var pattern =/^[\u4e00-\u9fa5]+$/;
     
        	var ln = pattern.test(lncn);
        	if(!ln){
        		alert("请输入简体中文名");return false;
        	}
        	
        }
        
        
        
        if(fnen==""||lnen=="")
        {alert("请填写英文姓名");return false;}
        else if((!document.getElementsByName("info.sex")[0].checked)&&(!document.getElementsByName("info.sex")[1].checked))
        {alert("请填写性别");return false;}
                
        else if(country=="请选择")
        {alert("请填写国籍或所在地区");return false;}        
        else if(birth==""||birth==null)
        {alert("请填写出生日期！");return false;} 
        else if(CardId == ""|| CardId==null)
        {
        	if(PassPort == ""|| PassPort == null)
        	 if(otherCredential == ""|| otherCredential == null)
        	 {alert("身份证，护照，其它证件必须输入其中一项 ！");
        	 return false;
        	 }
        
        }
        else if((MobilePhone==""||MobilePhone==null)&&(UsualPhone2==""||UsualPhone2==null)){
        	{alert("手机和常用电话必须输入其中一项。");
        	return false;
        	}
        }
        else if(address == ""||address == null)
        {alert("请填写联系地址");
        return false;
        }
     //   debugger;
        

      

        
        
        
        var EnNameLength = fnen.length + lnen.length;

        var i=0;
        if(EnNameLength>1){
        for(i=0;i<fnen.length;i++){
        	

        	var ch=fnen.charCodeAt(i);
        	
        	if((!(64<ch&&ch<91))&&(!(96<ch&&ch<123)))
        	{alert("英文名无效，请检查是否大于两个字符及不包含无效字符。");i=1111;return false;}
        }
        if(i!=1111)
         { for(i=0;i<lnen.length;i++){
        	

        	var ch=lnen.charCodeAt(i);
        	
        	if((!(64<ch&&ch<91))&&(!(96<ch&&ch<123)))
        	{alert("英文名无效，请检查是否大于两个字符及不包含无效字符。");return false;}
        }
        }
        }
        else if(EnNameLength!=0){
        	{alert("英文名无效，请检查是否大于两个字符及不包含无效字符。");return false;}
        }
        
        
        
        
        
        if(CardId != ""&&CardId!=null){//CardId!=null||
        	var ii;
        	//CardId.toString().length
        	if(CardId.length==15||CardId.length==18){
        	for(var i=0;i<CardId.length-1;i++){
        		
        	ii=CardId.charCodeAt(i);

        	if(!(ii>=48&&ii<=57)){
        		alert("身份证应由数字或者大写字母X组成！");return false;
        	}

        	}
        	
        	ii=CardId.charCodeAt(CardId.length-1);
        	//alert("CardId.toString().length-1是："+(CardId.length-1));//+CardId.toString().length-1
        	if(!(ii>=48&&ii<=57)&&ii!=88){
        		alert("身份证最后一位必须由数字或者大写字母X组成！");return false;
        	}
        	
        	}
        	else{
        		alert("身份证的长度应该是15位或者18位！");return false;
        	}
        	
        }
        
     
        
        
        
        if((PassPort!=null&&PassPort!="")){
        	
        	var ii;
        	if(PassPort.length!=6)
        	{
        		alert("护照长度应为6位！");return false;
        	}
        	for(var i=0;i<PassPort.length;i++){//.toString()
        		
        	ii=PassPort.charCodeAt(i);

            
        	if(!(ii>=48&&ii<=57)){
        		if((!(64<ii&&ii<91))&&(!(96<ii&&ii<123))){
        		alert("护照应由字母、数字组成！"+ii);//break;
        		return false;
        		
        		}
        		
        	}
           	
        	
        	}
        	        	
        }
        
        
        
        
        if(otherCredential!=null&&otherCredential!=""){
        var pattern = /^[a-zA-Z0-9]+$/;
        var trfls=pattern.test(otherCredential);
        if(!trfls){
        	alert("其他证件类型必须是由字母数字组成！");return false;
        }
        }
        
        
        
        var workplace = document.getElementsByName("info.workplace")[0].value;
        if(workplace!=null&&workplace!=""){
        	
        	 var pattern =/^([\u4e00-\u9fa5]|[a-zA-Z])+$/;
        	 
        	 var wp = pattern.test(workplace);
        	 if(!wp){
        	 	alert("单位名称必须为汉字或英文！");return false;
        	 }
        }
        
        
       

         if(countryValue=="CN"){
         	var pattern =/[\u4e00-\u9fa5]{4,}/;
     
        	 var wp = pattern.test(address);
        	  if(!wp){
        	 	alert("国籍是中国，详细地址必须含4个以上汉字！");return false;
        	 }
         }
         else if(country!="请选择"){
         	var pattern =/[a-zA-Z]{10,}/;
         	var adr = pattern.test(address);
         	if(!adr){
         		alert("国籍非中国，详细地址必须含10个以上英文字母！");return false;
         	} 
         }
         
         var postCode = document.getElementsByName("info.postCode")[0].value;
         if(postCode!=null&&postCode!=""){
         	var pattern = /^[0-9]+$/;
         	var pc = pattern.test(postCode);
         	if(!pc){
         		alert("邮编号码应为数字");return false;
         	}
         }
        
        

       if(MobilePhone!=""&&MobilePhone!=null){
         	var pattern = /^[0-9]+$/;
         	var mp = pattern.test(MobilePhone);
         	if(!mp){
         		alert("手机应为数字");return false;
         	}
       }
       
       
       
       
       
        if(UsualPhone2!=""&&UsualPhone2!=null){
       	
       	    var pattern = /^[0-9]+$/;       	   
         	var up2 = pattern.test(UsualPhone2);
         	if(UsualPhone1!=""&&UsualPhone1!=null){
         		 var up1 = pattern.test(UsualPhone1);
         		 if(!up2||!up1){
         		alert("电话应为数字");return false;
         	}
         		  
         	}
         	else if(!up2){
         		alert("电话应为数字"); return false;
         	}
       }
       
       
       var email = document.getElementsByName("info.email")[0].value;
       if(email!=null&&email!=""){
       	　var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.){1,1}([a-zA-Z0-9_-])+$/;
       	  var em = pattern.test(email);
         	if(!em){
         		alert("e-mail地址有误");return false;
         	}
   
       	
       }
       
            
            return false;
          
     }
     
     
     function checkButtonSumbit(){
     	
        var sel=  document.getElementById("countrySel");
        var country = sel.options[sel.selectedIndex].text;
        var countryValue=sel.options[sel.selectedIndex].value;
        
        var birth = document.getElementsByName("calendar_DatePicker0").value;
        
        var PassPort = document.getElementsByName("info.passport")[0].value;
        var otherCredential = document.getElementsByName("info.otherCredential")[0].value;        
        var CardId = document.getElementsByName("info.identifyCard")[0].value;
        
        var MobilePhone = document.getElementsByName("info.mobile")[0].value;
        var UsualPhone1 = document.getElementsByName("info.telArea")[0].value;
        var UsualPhone2 = document.getElementsByName("info.telNum")[0].value;
        
        var address = document.getElementsByName("info.address")[0].value;
        
        var fncn=document.getElementsByName("info.firstNameCN")[0].value;
        var lncn=document.getElementsByName("info.lastNameCN")[0].value;
        
        
        if(fncn!=""&&fncn!=null){
        	var pattern =/^[\u4e00-\u9fa5]+$/;
     
        	var fn = pattern.test(fncn);
        	if(!fn){
        		alert("请输入简体中文名");return false;
        	}
        }else if(lncn!=""&&lncn!=null){
        	var pattern =/^[\u4e00-\u9fa5]+$/;
     
        	var ln = pattern.test(lncn);
        	if(!ln){
        		alert("请输入简体中文名");return false;
        	}
        	
        }
        
        
        

        if((!document.getElementsByName("info.sex")[0].checked)&&(!document.getElementsByName("info.sex")[1].checked))
        {alert("请填写性别");return false;}
                
        else if(country=="请选择")
        {alert("请填写国籍或所在地区");return false;}       
        else if(CardId == ""|| CardId==null)
        {
        	if(PassPort == ""|| PassPort == null)
        	 if(otherCredential == ""|| otherCredential == null)
        	 {alert("身份证，护照，其它证件必须输入其中一项 ！");
        	 return false;
        	 }
        
        }
        else if((MobilePhone==""||MobilePhone==null)&&(UsualPhone2==""||UsualPhone2==null)){
        	{alert("手机和常用电话必须输入其中一项。");
        	return false;
        	}
        }
        else if(address == ""||address == null)
        {alert("请填写联系地址");
        return false;
        }
        
        
        var workplace = document.getElementsByName("info.workplace")[0].value;
        if(workplace!=null&&workplace!=""){
        	
        	 var pattern =/^([\u4e00-\u9fa5]|[a-zA-Z])+$/;
        	 
        	 var wp = pattern.test(workplace);
        	 if(!wp){
        	 	alert("单位名称必须为汉字或英文！");return false;
        	 }
        }
        
        
        
         if(countryValue=="CN"){
         	var pattern =/[\u4e00-\u9fa5]{4,}/;
     
        	 var wp = pattern.test(address);
        	  if(!wp){
        	 	alert("国籍是中国，详细地址必须含4个以上汉字！");return false;
        	 }
         }
         else if(country!="请选择"){
         	var pattern =/[a-zA-Z]{10,}/;
         	var adr = pattern.test(address);
         	if(!adr){
         		alert("国籍非中国，详细地址必须含10个以上英文字母！");return false;
         	} 
         }
         
         
         var postCode = document.getElementsByName("info.postCode")[0].value;
         if(postCode!=null&&postCode!=""){
         	var pattern = /^[0-9]+$/;
         	var pc = pattern.test(postCode);
         	if(!pc){
         		alert("邮编号码应为数字");return false;
         	}
         }
         
         
          if(MobilePhone!=""&&MobilePhone!=null){
         	var pattern = /^[0-9]+$/;
         	var mp = pattern.test(MobilePhone);
         	if(!mp){
         		alert("手机应为数字");return false;
         	}
       }
       
       
         if(UsualPhone2!=""&&UsualPhone2!=null){
       	
       	    var pattern = /^[0-9]+$/;       	   
         	var up2 = pattern.test(UsualPhone2);
         	if(UsualPhone1!=""&&UsualPhone1!=null){
         		 var up1 = pattern.test(UsualPhone1);
         		 if(!up2||!up1){
         		alert("电话应为数字");return false;
         	}
         		  
         	}
         	else if(!up2){
         		alert("电话应为数字"); return false;
         	}
       }
        
        
       var email = document.getElementsByName("info.email")[0].value;
       if(email!=null&&email!=""){
       	　var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
       	  var em = pattern.test(email);
         	if(!em){
         		alert("e-mail地址有误");return false;
         	}
   
       	
       }
       return false;
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     