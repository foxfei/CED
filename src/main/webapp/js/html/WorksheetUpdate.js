$(function(){	
	
			$("#doSave").click(function(){
				var val ="";
				$('input[name=wl]').each(function(){
						if(this.checked == true){
							val = val+$(this).attr("value")+";";
						}
					});
				
				//alert(val);
				$("#yyy").val(val);
			});
	
		
		var options = {minWidth: 120, arrowSrc: 'images/arrow_right.gif'};  
			$('div[class^=menuthree]').each(function(){
				$(this).menu(options);
			});
		

});