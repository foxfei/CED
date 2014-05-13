/*
@author huyanfei2351@gmail.com
@version 1.0
*/
 
 //分配按钮响应函数 【自动分配】【人工分配】
     function checkButtonSumbit(type) {
             if (type == 0) {//自动分配
            	var checked = checkSelectBox();
            	if (checked == false) {
             		alert("请选择要分配的服务单！");
             		return;
         		}
				$("#autoAllocateExecute").click();
             }
             if (type == 1) {//手工分配
                 var which = document.getElementById("sub");
                 if (which.style.display == "none") {
                     var b = getUserListTable();
                     if(b==true){//如果返回true代表有中台在线
                     	document.getElementById("sub2").style.display = "block";
                     }else{//没有中台在线
                     	document.getElementById("sub2").style.display = "none";
                     }
                 }
                 else {
                     document.getElementById("sub").style.display = "none";
                     document.getElementById("sub2").style.display = "none";
                 }
             }
     }
     //判断有没有checkbox被选中,若没有选中的则不允许提交
     function checkSelectBox() {
         var boxes = document.getElementsByTagName("input");
         for (var i = 0; i < boxes.length; i++) {
             if (boxes[i].type == "checkbox") {
                 if (boxes[i].name == "checkbox") {
                     if (boxes[i].checked == true) {
                         return true;
                     }
                 }
             }
         }
         return false;
     }
     
     //判断有没有radio被选中,若没有选中的则不允许提交
     function checkSelectRadio() {
         var boxes = document.getElementsByTagName("input");
         for (var i = 0; i < boxes.length; i++) {
             if (boxes[i].type == "radio") {
             	if (boxes[i].checked == true) {
             		document.getElementById("selectUser").value = boxes[i].value;
             		return true;
             	}
             }
         }
         return false;
     }

     //全选/取消全选
     function selectAll(check) {
         var toCheck = check;
         var boxes = document.getElementsByTagName("input");
         for (var i = 0; i < boxes.length; i++) {
             if (boxes[i].type == "checkbox") {
             	if(!(boxes[i].disabled)){
             		boxes[i].checked = toCheck;
             	}  
             }
         }
         checkButton();
     }

     //点击checkbox时检查【自动分配】【手工分配】按钮是否可用
     function checkButton() {
         var toCheck = false;
         var serviceStatus = document.getElementById("serviceStatus").value;
         if (serviceStatus == "0") {
             document.getElementById("handSubmit").disabled = false;
             var boxes = document.getElementsByTagName("input");
             for (var i = 0; i < boxes.length; i++) {
                 if (boxes[i].type == "checkbox") {
                     if (boxes[i].checked == true) {
                         if (boxes[i].id != null && boxes[i].id != "") {//如果被选中的记录操作人字段不为空，则将toCheck赋值为ture
                             toCheck = true;
                             break;
                         }
                     }
                 }
             }
             document.getElementById("autoSubmit").disabled = toCheck;
         }
         if (serviceStatus == "1") {
             document.getElementById("autoSubmit").disabled = true;
             document.getElementById("handSubmit").disabled = false;
         }
         if (serviceStatus == "2") {
             document.getElementById("autoSubmit").disabled = true;
             document.getElementById("handSubmit").disabled = true;
         }
     }


     //手工分配的【确定】按钮响应函数
     function checkSureSubmit() {
		 var checked = checkSelectBox();
         if (checked == false) {
            alert("请选择要分配的服务单！");
            return false;
         }
        var checkedRadio = checkSelectRadio();
         if (checkedRadio == false) {
             alert("请选择中台坐席");
             return false;
         } else {
         	 $("#handAllocateExecute").click();
         }
     }
     
     
     //按列排序

	 var asc = 1;
     function sortColumn(col){
     	var tbody = $("#resultTable")[0].tBodies[0];
     	var rows = tbody.rows;
     	var oFragment = document.createDocumentFragment();
     	var trsa = new Array();
		for(var i=0; i<rows.length; i++){
			trsa[i] = rows[i];
		}
		trsa.sort(sortCore(col));
		for(var i=0;i<trsa.length;i++){
			oFragment.appendChild(trsa[i]);
		}
		tbody.appendChild(oFragment);
		asc = (-1)*asc;
     }
     
     //排序方法
	function sortCore(col) {
    return function t(a, b) {
        var v1;
        var v2;
        if (a.cells[col].firstChild == null) {
            v1 = "xx";
        } else {
            var v1 = a.cells[col].firstChild.nodeValue;
        }
        if (b.cells[col].firstChild == null) {
            v2 = "xx";
        } else {
            var v2 = b.cells[col].firstChild.nodeValue;
        }
        var ret = 0;
        if (v1 != null && v2 != null) {
            if (v1 > v2) {
                ret = 1;
            }
            else if (v1 < v2) {
                ret = -1;
            }
            else {
                ret = 0;
            }
            return ret * asc;
        }

    }
}
     