/*
@author huangqj
@version 1.0
*/

$(document).ready(function (){
	$("#tree").treeview({
		collapsed:true,
		animated:"medium",
		control:"#sidetreecontrol"
	});	
	
	if(__edit){		
		$("#DIV1").attr("style","display:none");
	}	
	if(__radio){		
		var radio = $('input[name='+__class+']');
		if(radio.size()>=1){
			radio[0].checked=true;
		}		
	}else{		
		$('input[class='+__class+']').each(function(){
			var obj = $(this);
			obj.attr("checked",true);
			obj.click(function(){
				var checked = obj.attr('checked');
				var val;
				if(checked){
					val = true;
				}else{
					val = false;
				}
				obj.parent().find('input[class='+__class+']').attr("checked",val);
			});
			
		});
	}
	
	$('#button1').click(function(){
		var parentWindow = window.dialogArguments;
		var parentWindowDocument = parentWindow.document;
		
		var el = parentWindowDocument.getElementById(__elementId);
		var elDisplay = parentWindowDocument.getElementById(__elementId + "Hidden");
		el.value = "";
		elDisplay.value = "";
	});
	
	$('#button').click(function(){
		var val = "";
		var valDisplay = "";			
		if(!__radio){			
			$('input[class='+__class+']').each(function(){
				var obj = $(this);
				var checked = obj.attr('checked');
				if(checked){
					var jsonString = obj.attr("value");
					var jsonObj  = $.parseJSON(jsonString);
					val = val+ jsonObj.id +",";
					valDisplay = valDisplay+ jsonObj.name +",";
				}
			});
		}else{				
			var item = $('input[name='+__class+'][checked]').val();				
			if(item == null){
				alert("请选择部门!");
				return false;
			}
			var jsonString = item;
			var jsonObj = $.parseJSON(jsonString);					
			if(__edit){					
				val = val + jsonObj.id;
			}else{					
				if($("#ContainChildren").attr('checked') == true){
					val = "Y," + jsonObj.id + "," + jsonObj.orderLevel + "," + jsonObj.name;
				}else{
					val = "N," + jsonObj.id + "," + jsonObj.orderLevel + "," + jsonObj.name;
				}
			}
			valDisplay = valDisplay + jsonObj.name;
		}
		
		var parentWindow = window.dialogArguments;	
		var parentWindowDocument = parentWindow.document;		
		var el = parentWindowDocument.getElementById(__elementId);
		var elDisplay = parentWindowDocument.getElementById(__elementId + "Hidden");
		el.value = val;
		elDisplay.value = valDisplay;
		window.close();		
	});
	
});