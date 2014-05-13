
var win= null;
function NewWindow(mypage,myname,w,h,scroll){
var winl = (screen.width-w)/2;
var wint = (screen.height-h)/2;
var settings ='height='+h+',';
settings +='width='+w+',';
settings +='top='+wint+',';
settings +='left='+winl+',';
settings +='scrollbars='+scroll+',';
settings +='resizable=yes';
win=parent.open(mypage,myname,settings);
if(parseInt(navigator.appVersion) >= 4){win.window.focus();}
} 


$(function(){	
		try{
			$('.ymPrompt').each(function (){
				$(this).click(function(){
					var _href = null;
					var _title= null;
					_href = $(this).attr("href1");
					_title = $(this).attr("title");
					//ymPrompt.win({message:_href,iframe:true,width:850,height:500,title:_title,showMask:false});
					
						
						var timestamp = Date.parse(new Date());
	
						NewWindow(_href,timestamp,700,400,'yes');
						return false;
					
					return false;
				});
				
			});
		
		}catch(e){
			alert(e);
		}
		

		

});
