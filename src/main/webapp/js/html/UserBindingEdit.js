$(document).ready(function (){	
		if(_id != ""){
			$("#employeeNo").attr("readonly",true);
		}else{
			$("#employeeNo").attr("readonly",false);
		}
});