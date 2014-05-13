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