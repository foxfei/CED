    	var _____flag=true;
  		function __justHidden(){
  		
  			if(_____flag==true){
   				document.getElementById("_____Ctrl").innerHTML="<img src=\"images/up.gif\"/>";
  				document.getElementById("_____footerContent").style.display="none";
  				$("#__main").attr("height","98%");
   				_____flag=false;
  			}else{
  		 	 	document.getElementById("_____Ctrl").innerHTML="<img src=\"images/down.gif\"/>";
  				document.getElementById("_____footerContent").style.display="";	
  				$("#__main").attr("height","60%");
  			  	_____flag=true;
   			}
  		}
  		

var status = 1;
function switchSysBar(){
     if (1 == window.status){
		  window.status = 0;
          document.getElementById("switchPoint").innerHTML = '<img src="images/left.gif" alt="展开左栏" />';
          document.getElementById("frmTitle").style.display="none";
     }
     else{
		  window.status = 1;
          document.getElementById("switchPoint").innerHTML = '<img src="images/right.gif" alt="隐藏左栏" />';
          document.getElementById("frmTitle").style.display="block";
     }
}  		
  		
 
$(function(){	
		try{
			$("#_____Ctrl").click(__justHidden);
		}catch(e){
			alert(e);
		}
		

		

});
  		