function addContactRow(tableId) {
	var rowStr = "<TR class='tr2'><TD><select name='leixing'><OPTION value='手机' selected>手机</OPTION><OPTION value='传真'>传真</OPTION><OPTION value='家庭电话'>家庭电话</OPTION><OPTION value='工作电话'>工作电话</OPTION><OPTION value='电话'>电话</OPTION><OPTION value='EMAIL'>EMAIL</OPTION></select></TD><TD><input name='guojiaquhao' size='5'></TD><TD><input name='quhao' size='5' class='txt'></TD><TD><input name='haoma' size='20' class='txt'></TD><TD><input name='fenji' size='5' class='txt'><input type='hidden' name='youxianji' /></TD><TD><input name='infodel' type='button' value='删除' onclick='deleteRow(\""
			+ tableId + "\",this);' class='button'></TD></TR>";
	$("#" + tableId).append(rowStr);
}

function addContactRow2(tableId) {
	//modify on 09-12-29
	var rowStr = "<TR class='tr2'><TD><select disabled='disabled' name='leixing'><OPTION value='手机' selected>手机</OPTION><OPTION value='传真'>传真</OPTION><OPTION value='家庭电话'>家庭电话</OPTION><OPTION value='工作电话'>工作电话</OPTION><OPTION value='电话'>电话</OPTION><OPTION value='EMAIL'>EMAIL</OPTION></select></TD><TD><input name='guojiaquhao' size='5'></TD><TD><input name='quhao' size='5' class='txt'></TD><TD><input name='haoma' size='20' class='txt' readonly='readonly'></TD><TD><input name='fenji' size='5' class='txt'></TD><TD>&nbsp;<input type='hidden' name='youxianji' /></TD></TR>";
	$("#" + tableId).append(rowStr);
}

function addSecretaryRow(tableId) {
	var rowStr = "<tr class='tr2'><td><input name='mishuxingming' size='6'></td><td><input name='mishudianhua' size='15'></td><td><input name='mishushouji' size='18'></td><td><input name='email' size='20'></td><td><select name='zhengjian'><option value='NI'>身份证</option><option value='PP'>护照</option><option value='ID'>其它证件</option></SELECT></td><td><input name='zhengjianhaoma' size='22'></td></tr>";
	$("#" + tableId).append(rowStr);
}

function addWebcallRow(tableId) {
	var rowStr = "<tr class='tr2'><td><select name='leixing'><option value='skypeID'>skypeID</option></SELECT></td><td><input name='zhanghu' size='10'></td><td><input name='zhanghaoid' size='15'></td><td><input name='infodel3' type='button' value='删除' onclick='deleteRow(\""
			+ tableId + "\",this);' class='button'></td></tr>";
	$("#" + tableId).append(rowStr);
}

function addWebcallRow2(tableId) {
	var rowStr = "<tr class='tr2'><td><select disabled='disabled' name='leixing'><option value='skypeID'>skypeID</option></SELECT></td><td><input name='zhanghu' size='10'></td><td><input name='zhanghaoid' size='15' readonly='readonly'></td><td>&nbsp;</td></tr>";
	$("#" + tableId).append(rowStr);
}

function addInsuranceRow(tableId) {
	var len = $("#" + tableId + " tr").length;
	var rowStr = "<tr class='tr2'><td><select name='leixing'><option value='美亚年保'>美亚年保</option><option value='其它'>其它</option></select></td><td><input name='danhao' size='10'></td><td><input name='youxiaoriqi1' readonly='readonly' id='yxrq_ins_begin"
			+ len
			+ "' size='15'/><a href='#' onclick='setCurrentInsuranceDateInputValue(\"yxrq_ins_begin"
			+ len
			+ "\");calendarInsurance.toggle(document.getElementById(\"yxrq_ins_begin"
			+ len
			+ "\"));'><img src='images/datepicker_icon.png' border='0'></img></a>-<input name='youxiaoriqi2' readonly='readonly' id='yxrq_ins_end"
			+ len
			+ "' size='15'/><a href='#' onclick='setCurrentInsuranceDateInputValue(\"yxrq_ins_end"
			+ len
			+ "\");calendarInsurance.toggle(document.getElementById(\"yxrq_ins_end"
			+ len
			+ "\"));'><img src='images/datepicker_icon.png' border='0'></img></a></td><td><input name='infodel4' type='button' value='删除' onclick='deleteRow(\""
			+ tableId + "\",this);' class='button'></td></tr>";
	$("#" + tableId).append(rowStr);
}

function addInsuranceRow2(tableId) {
	var len = $("#" + tableId + " tr").length;
	var rowStr = "<tr class='tr2'><td><select disabled='disabled' name='leixing'><option value='美亚年保'>美亚年保</option><option value='其它'>其它</option></select></td><td><input name='danhao' size='10' readonly='readonly'></td><td><input name='youxiaoriqi1' readonly='readonly' id='yxrq_ins_begin"
			+ len
			+ "' size='15'/><a href='#' onclick='setCurrentInsuranceDateInputValue(\"yxrq_ins_begin"
			+ len
			+ "\");calendarInsurance.toggle(document.getElementById(\"yxrq_ins_begin"
			+ len
			+ "\"));'><img src='images/datepicker_icon.png' border='0'></img></a>-<input name='youxiaoriqi2' readonly='readonly' id='yxrq_ins_end"
			+ len
			+ "' size='15'/><a href='#' onclick='setCurrentInsuranceDateInputValue(\"yxrq_ins_end"
			+ len
			+ "\");calendarInsurance.toggle(document.getElementById(\"yxrq_ins_end"
			+ len
			+ "\"));'><img src='images/datepicker_icon.png' border='0'></img></a></td><td>&nbsp;</td></tr>";
	$("#" + tableId).append(rowStr);
}

function setCurrentInsuranceDateInputValue(value) {
	currentInsuranceDateInput = value;
}

// 联动需独立此方法
// function deleteContactRow(tableId, obj){
// if(!confirm("确认要删除此记录吗?")) return;
// var typeSel = $(obj.parentNode.parentNode).find("select")[0];
// var type = typeSel.options[typeSel.selectedIndex].value;
// if(type == "手机"){
// var inputs = $(obj.parentNode.parentNode).find("input");
// if(inputs[3].value == $("input[name='info.mobile']")[0].value)
// $("input[name='info.mobile']")[0].value = "";
// }
// else if(type == "电话" || type == "家庭电话" || type == "工作电话"){
// var inputs = $(obj.parentNode.parentNode).find("input");
// if(inputs[1].value == $("input[name='info.telCountryCode']")[0].value
// && inputs[2].value == $("input[name='info.telArea']")[0].value
// && inputs[3].value == $("input[name='info.telNum']")[0].value
// && inputs[4].value == $("input[name='info.telNumExt']")[0].value){
//			
// $("input[name='info.telCountryCode']")[0].value = "";
// $("input[name='info.telArea']")[0].value = "";
// $("input[name='info.telNum']")[0].value = "";
// $("input[name='info.telNumExt']")[0].value = "";
// }
// }
// else if(type == "传真"){
// var inputs = $(obj.parentNode.parentNode).find("input");
// if(inputs[1].value == $("input[name='info.faxCountryCode']")[0].value
// && inputs[2].value == $("input[name='info.faxArea']")[0].value
// && inputs[3].value == $("input[name='info.faxNum']")[0].value
// && inputs[4].value == $("input[name='info.faxNumExt']")[0].value){
//			
// $("input[name='info.faxCountryCode']")[0].value = "";
// $("input[name='info.faxArea']")[0].value = "";
// $("input[name='info.faxNum']")[0].value = "";
// $("input[name='info.faxNumExt']")[0].value = "";
// }
// }
// else{
// //email
// var inputs = $(obj.parentNode.parentNode).find("input");
// if(inputs[3].value == $("input[name='info.email']")[0].value)
// $("input[name='info.email']")[0].value = "";
// }
// var rowIndex = obj.parentNode.parentNode.rowIndex;
// $("#"+tableId+" tr:eq("+rowIndex+")").remove();
// }

function deleteRow(tableId, obj) {
	if (!confirm("确认要删除此记录吗?"))
		return;
	var row = obj.parentNode.parentNode.rowIndex;
	$("#" + tableId + " tr:eq(" + row + ")").remove();
}

function getContactJSON(tableId) {
	var rows = $("#" + tableId + " tr.tr2");
	var len = rows.length;
	var contacts = new Array();
	for (var i = 0; i < len; i++) {
		var inputs = $(rows[i]).find("input");
		if (inputs[2].value == null || inputs[2].value == "")
			return false;
		var contact = new Contact();
		var sel = $(rows[i]).find("select")[0];
		contact.contactType = sel.options[sel.selectedIndex].value;
		// contact.order = inputs[0].value;
		contact.countryCode = inputs[0].value;
		contact.telArea = inputs[1].value;
		contact.contactDetail = inputs[2].value;
		contact.telNumExt = inputs[3].value;
		//add on 09-12-29
		contact.order = inputs[4].value;
		contacts.push(contact);
	}
	$("input[name='contactJSON']")[0].value = JSON.stringify(contacts);
	return true;
}

function getSecretaryJSON(tableId) {
	var rows = $("#" + tableId + " tr.tr2");
	var len = rows.length;
	var secretaries = new Array();
	for (var i = 0; i < len; i++) {
		var inputs = $(rows[i]).find("input");
		var allEmpty = true;
		for (var j = 0; j < inputs.length; j++) {
			if (inputs[j].value != null && inputs[j].value != "") {
				allEmpty = false;
			}
		}
		if (allEmpty)
			continue;
		var secretary = new Secretary();
		secretary.nameOfSecretary = inputs[0].value;
		secretary.phoneOfOffice = inputs[1].value;
		secretary.cellphone = inputs[2].value;
		secretary.email = inputs[3].value;
		secretary.certificateNo = inputs[4].value;
		var select = $(rows[i]).find("select")[0];
		secretary.certificateType = select.options[select.selectedIndex].value;
		secretaries.push(secretary);
	}
	$("input[name='secretaryContactJSON']")[0].value = JSON
			.stringify(secretaries);
}

function getWebcallJSON(tableId) {
	var rows = $("#" + tableId + " tr.tr2");
	var len = rows.length;
	var webcalls = new Array();
	for (var i = 0; i < len; i++) {
		var webcall = new Webcall();
		var inputs = $(rows[i]).find("input");
		webcall.account = inputs[0].value;
		webcall.accountId = inputs[1].value;
		var sel = $(rows[i]).find("select")[0];
		webcall.webcallType = sel.options[sel.selectedIndex].value;
		webcalls.push(webcall);
	}
	$("input[name='webcallInfoJSON']")[0].value = JSON.stringify(webcalls);
}

function getInsuranceJSON(tableId) {
	var rows = $("#" + tableId + " tr.tr2");
	var len = rows.length;
	var insurances = new Array();
	for (var i = 0; i < len; i++) {
		var insurance = new Insurance();
		var inputs = $(rows[i]).find("input");
		insurance.insuranceNo = inputs[0].value;
		insurance.beginDate = inputs[1].value;
		insurance.endDate = inputs[2].value;
		var sel = $(rows[i]).find("select")[0];
		insurance.insuranceType = sel.options[sel.selectedIndex].value;
		insurances.push(insurance);
	}
	$("input[name='insuranceInfoJSON']")[0].value = JSON.stringify(insurances);
}

// function getOtherInfoJSON(){
// var otherInfo = new OtherInfo();
// var homeCountrySel = $("#homeCountrySel")[0];
// otherInfo.homeCountry =
// homeCountrySel.options[homeCountrySel.selectedIndex].value;
// var homeProvinceSel = $("#provinceSel")[0];
// otherInfo.homeProvince =
// homeProvinceSel.options[homeProvinceSel.selectedIndex].value;
// var homeCitySel = $("#citySel")[0];
// otherInfo.homeCity = homeCitySel.options[homeCitySel.selectedIndex].value;
// var workCountrySel = $("#countrySel2")[0];
// otherInfo.workCountry =
// workCountrySel.options[workCountrySel.selectedIndex].value;
// var workProvinceSel = $("#provinceSel2")[0];
// otherInfo.workProvince =
// workProvinceSel.options[workProvinceSel.selectedIndex].value;
// var workCitySel = $("#citySel2")[0];
// otherInfo.workCity = workCitySel.options[workCitySel.selectedIndex].value;
// $("input[name='info.otherInfoJSON']")[0].value = JSON.stringify(otherInfo);
// }

// 以下是根据后台回来的json数据初始化页面。。。
function initTablesFromJSON() {
	// 联系信息
	var contactJSON = $("input[name='contactJSON']")[0].value;
	if (contactJSON != null && contactJSON != "" && contactJSON != "[]") {
		var contacts = JSON.parse(contactJSON);
		if (contacts != null) {
			var table = $("#contactTable");
			table.find("tr.tr2").remove();
			var len = contacts.length;
			for (var i = 0; i < len; i++) {
				addContactRow2("contactTable");
				var currentRow = table.find("tr.tr2:eq(" + i + ")");
				currentRow.find("select")[0].value = contacts[i].contactType;
				var inputs = currentRow.find("input");
				inputs[0].value = contacts[i].countryCode;
				inputs[1].value = contacts[i].telArea;
				inputs[2].value = contacts[i].contactDetail;
				inputs[3].value = contacts[i].telNumExt;
				// inputs[4].value = contacts[i].telNumExt;
				//add on 09-12-29
				inputs[4].value = contacts[i].order;
			}
		}
	}
	// 秘书联系信息
	var secretaryJSON = $("input[name='secretaryContactJSON']")[0].value;
	if (secretaryJSON != null && secretaryJSON != "" && secretaryJSON != "[]") {
		var secretaries = JSON.parse(secretaryJSON);
		if (secretaries != null) {
			var table = $("#secretaryTable");
			table.find("tr.tr2").remove();
			var len = secretaries.length;
			for (var i = 0; i < len; i++) {
				addSecretaryRow("secretaryTable");
				var currentRow = table.find("tr.tr2:eq(" + i + ")");
				currentRow.find("select")[0].value = secretaries[i].certificateType;
				var inputs = currentRow.find("input");
				inputs[0].value = secretaries[i].nameOfSecretary;
				inputs[1].value = secretaries[i].phoneOfOffice;
				inputs[2].value = secretaries[i].cellphone;
				inputs[3].value = secretaries[i].email;
				inputs[4].value = secretaries[i].certificateNo;
			}
		} else {
			addSecretaryRow("secretaryTable");
		}
	}
	// webcall信息
	var webcallJSON = $("input[name='webcallInfoJSON']")[0].value;
	if (webcallJSON != null && webcallJSON != "" && webcallJSON != "[]") {
		var webcalls = JSON.parse(webcallJSON);
		if (webcalls != null) {
			var table = $("#webcallTable");
			table.find("tr.tr2").remove();
			var len = webcalls.length;
			for (var i = 0; i < len; i++) {
				addWebcallRow2("webcallTable");
				var currentRow = table.find("tr.tr2:eq(" + i + ")");
				currentRow.find("select")[0].value = webcalls[i].webcallType;
				var inputs = currentRow.find("input");
				inputs[0].value = webcalls[i].account;
				inputs[1].value = webcalls[i].accountId;
			}
		}
	}
	// 保险信息
	var insuranceJSON = $("input[name='insuranceInfoJSON']")[0].value;
	if (insuranceJSON != null && insuranceJSON != "" && insuranceJSON != "[]") {
		var insurances = JSON.parse(insuranceJSON);
		if (insurances != null) {
			var table = $("#insuranceTable");
			table.find("tr.tr2").remove();
			var len = insurances.length;
			for (var i = 0; i < len; i++) {
				addInsuranceRow2("insuranceTable");
				var currentRow = table.find("tr.tr2:eq(" + i + ")");
				currentRow.find("select")[0].value = insurances[i].insuranceType;
				var inputs = currentRow.find("input");
				inputs[0].value = insurances[i].insuranceNo;
				inputs[1].value = insurances[i].beginDate;
				inputs[2].value = insurances[i].endDate;
			}
		}
	}
	// 旅客其它信息
	// var otherInfo = new OtherInfo();
	// var homeCountrySel = $("#homeCountrySel")[0];
	// otherInfo.homeCountry =
	// homeCountrySel.options[homeCountrySel.selectedIndex].value;
	// var homeProvinceSel = $("#provinceSel")[0];
	// otherInfo.homeProvince =
	// homeProvinceSel.options[homeProvinceSel.selectedIndex].value;
	// var homeCitySel = $("#citySel")[0];
	// otherInfo.homeCity =
	// homeCitySel.options[homeCitySel.selectedIndex].value;
	// var workCountrySel = $("#countrySel2")[0];
	// otherInfo.workCountry =
	// workCountrySel.options[workCountrySel.selectedIndex].value;
	// var workProvinceSel = $("#provinceSel2")[0];
	// otherInfo.workProvince =
	// workProvinceSel.options[workProvinceSel.selectedIndex].value;
	// var workCitySel = $("#citySel2")[0];
	// otherInfo.workCity =
	// workCitySel.options[workCitySel.selectedIndex].value;
	// $("input[name='info.otherInfoJSON']")[0].value =
	// JSON.stringify(otherInfo);
	// var otherInfoJSON = $("input[name='info.otherInfoJSON']")[0].value;
	// if(otherInfoJSON != null && typeof(otherInfoJSON) != "undefined" &&
	// otherInfoJSON != ""){
	// var otherInfo = JSON.parse(otherInfoJSON);
	// var homeCountrySel = $("#homeCountrySel")[0];
	// var len = homeCountrySel.options.length;
	// for(var i=0; i<len; i++){
	// if(homeCountrySel.options[i].value == otherInfo.homeCountry){
	// homeCountrySel.selectedIndex = i;
	// break;
	// }
	// }
	// if(homeCountrySel.options[homeCountrySel.selectedIndex].value == "CN"){
	// //加载省份
	// showProvinces("provinceSel", "homeCitySel", "homeCountrySel");
	// }
	// var homeProvinceSel = $("#provinceSel")[0];
	// len = homeProvinceSel.options.length;
	// for(var i=0; i<len; i++){
	// if(homeProvinceSel.options[i].value == otherInfo.homeProvince){
	// homeProvinceSel.selectedIndex = i;
	// break;
	// }
	// }
	// if(homeProvinceSel.selectedIndex > 0){
	// //加载市
	// showCities("citySel", homeProvinceSel.selectedIndex);
	// }
	// var homeCitySel = $("#citySel")[0];
	// len = homeCitySel.options.length;
	// for(var i=0; i<len; i++){
	// if(homeCitySel.options[i].value == otherInfo.homeCity){
	// homeCitySel.selectedIndex = i;
	// break;
	// }
	// }
	// //some bugs....
	// }
}

// 以下是自定义对象
function Contact() {
	this.contactType = "";
	this.order = "";
	this.countryCode = "";
	this.telArea = "";
	this.contactDetail = "";
	this.telNumExt = "";
}

function Secretary() {
	this.nameOfSecretary = "";
	this.phoneOfOffice = "";
	this.cellphone = "";
	this.email = "";
	this.certificateType = "";
	this.certificateNo = "";
}

function Webcall() {
	this.webcallType = "";
	this.account = "";
	this.accountId = "";
}

function Insurance() {
	this.insuranceType = "";
	this.insuranceNo = "";
	this.beginDate = "";
	this.endDate = "";
}

function OtherInfo() {
	this.homeCountry = "";
	this.homeProvince = "";
	this.homeCity = "";
	this.workCountry = "";
	this.workProvince = "";
	this.workCity = "";
}

function KeyInfos() {
	this.firstNameCN = "";
	this.lastNameCN = "";
	this.firstNameEN = "";
	this.lastNameEN = "";
	this.identifyCard = "";
	this.passport = "";
	this.otherCredential = "";
	this.birthday = "";
}

// 校验信息
// 输入字符串是否为空判断
function isEmpty(textFieldName) {
	var field = $("input[name='" + textFieldName + "']")[0];
	var pattern = /^\s*$/;
	if (pattern.exec(field.value)) {
		return true;
	} else {
		return false;
	}
}

// 单选按钮或复选框是否已选上
function isChecked(buttonName) {
	var buttons = $("input[name='" + textFieldName + "']");
	if (buttons[0].type == "radio" || buttons[0].type == "checkbox") {
		for (var i = 0; i < buttons.length; i++) {
			if (buttons[i].checked == true) {
				return true;
			}
		}
		return false;
	} else {
		return false;
	}
}

function isSelected(selectName) {
	var sel = $("select[name='" + selectName + "']")[0];
	if (sel.options[sel.selectedIndex].value == "") {
		return false;
	}
	return true;
}

// var prevMobileValue = ""; //onfucus设置
// function setPrevMobileValueOnFucus(){
// prevMobileValue = $("input[name='info.mobile']")[0].value;
// }
//
// //联动手机到联系信息
// function setMobileToContacts(tableId){
// var table = $("#"+tableId)[0];
// var rows = table.rows;
// //如果手机在基本信息中删除，则应删除相应行
// var found = false;
// for(var i=1; i<rows.length; i++){
// //查找手机相同的行，联动过去
// var sel = $(rows[i]).find("select")[0];
// var input = $(rows[i]).find("input")[3];
// if(sel.options[sel.selectedIndex].value == "手机" && input.value ==
// prevMobileValue){
// found = true;
// if($("input[name='info.mobile']")[0].value == ""){
// //删除一行
// $("#"+tableId+" tr:eq("+i+")").remove();
// }
// else{
// input.value = $("input[name='info.mobile']")[0].value;
// prevMobileValue = $("input[name='info.mobile']")[0].value;
// }
// break;
// }
// }
// if(!found){
// //没有找到相同的，新增一行，如果手机为空，则不新增
// if($("input[name='info.mobile']")[0].value == ""){
// setPrevMobileValueOnFucus();
// return;
// }
// addContactRow(tableId);
// var lastTr = $(table).find("tr:last");
// var typeSel = lastTr.find("select")[0];
// var options = typeSel.options;
// for(var i=0; i<options.length; i++){
// if(options[i].value == "手机"){
// typeSel.selectedIndex = i;
// break;
// }
// }
// var mobileInput = lastTr.find("input")[3];
// mobileInput.value = $("input[name='info.mobile']")[0].value;
// setPrevMobileValueOnFucus();
// }
// }
//
// var prevTelCountryCode = "" //onfucus设置
// var prevTelArea = "";
// var prevTelNum = "";
// var prevTelNumExt = "";
// function setPrevTelInfosOnFucus(){
// prevTelCountryCode = $("input[name='info.telCountryCode']")[0].value;
// prevTelArea = $("input[name='info.telArea']")[0].value;
// prevTelNum = $("input[name='info.telNum']")[0].value;
// prevTelNumExt = $("input[name='info.telNumExt']")[0].value;
// }
//
// //联动常用电话到联系信息
// function setTelToContacts(tableId){
// var table = $("#"+tableId)[0];
// var rows = table.rows;
// var found = false;
// for(var i=1; i<rows.length; i++){
// //查找电话相同的行，联动过去
// var sel = $(rows[i]).find("select")[0];
// var inputs = $(rows[i]).find("input");
// var type = sel.options[sel.selectedIndex].value;
// if((type == "电话"||type == "家庭电话" || type == "工作电话") &&
// inputs[1].value == prevTelCountryCode &&
// inputs[2].value == prevTelArea &&
// inputs[3].value == prevTelNum &&
// inputs[4].value == prevTelNumExt){
// found = true;
// if($("input[name='info.telCountryCode']")[0].value == ""
// && $("input[name='info.telArea']")[0].value == ""
// && $("input[name='info.telNum']")[0].value == ""
// && $("input[name='info.telNumExt']")[0].value == ""
// ){
// //删除一行
// $("#"+tableId+" tr:eq("+i+")").remove();
// }
// else{
// var currentInput = inputs[1];
// currentInput.value = $("input[name='info.telCountryCode']")[0].value;
// currentInput = inputs[2];
// currentInput.value = $("input[name='info.telArea']")[0].value;
// currentInput = inputs[3];
// currentInput.value = $("input[name='info.telNum']")[0].value;
// currentInput = inputs[4];
// currentInput.value = $("input[name='info.telNumExt']")[0].value;
//				
// prevTelCountryCode = $("input[name='info.telCountryCode']")[0].value;
// prevTelArea = $("input[name='info.telArea']")[0].value;
// prevTelNum = $("input[name='info.telNum']")[0].value;
// prevTelNumExt = $("input[name='info.telNumExt']")[0].value;
// }
// break;
// }
// }
// if(!found){
// //没有找到相同的，新增一行，如果电话为空，则不新增
// if($("input[name='info.telCountryCode']")[0].value == ""
// && $("input[name='info.telArea']")[0].value == ""
// && $("input[name='info.telNum']")[0].value == ""
// && $("input[name='info.telNumExt']")[0].value == ""
// ){
// setPrevTelInfosOnFucus();
// return;
// }
// addContactRow(tableId);
// var lastTr = $(table).find("tr:last");
// var typeSel = lastTr.find("select")[0];
// var options = typeSel.options;
// for(var i=0; i<options.length; i++){
// if(options[i].value == "电话"){
// typeSel.selectedIndex = i;
// break;
// }
// }
// var inputs = lastTr.find("input");
// var currentInput = inputs[1];
// currentInput.value = $("input[name='info.telCountryCode']")[0].value;
// currentInput = inputs[2];
// currentInput.value = $("input[name='info.telArea']")[0].value;
// currentInput = inputs[3];
// currentInput.value = $("input[name='info.telNum']")[0].value;
// currentInput = inputs[4];
// currentInput.value = $("input[name='info.telNumExt']")[0].value;
// setPrevTelInfosOnFucus();
// }
// }
//
// var prevFaxCountryCode = "" //onfucus设置
// var prevFaxArea = "";
// var prevFaxNum = "";
// var prevFaxNumExt = "";
// function setPrevFaxInfosOnFucus(){
// prevFaxCountryCode = $("input[name='info.faxCountryCode']")[0].value;
// prevFaxArea = $("input[name='info.faxArea']")[0].value;
// prevFaxNum = $("input[name='info.faxNum']")[0].value;
// prevFaxNumExt = $("input[name='info.faxNumExt']")[0].value;
// }
//
// //联动fax到联系信息
// function setFaxToContacts(tableId){
// var table = $("#"+tableId)[0];
// var rows = table.rows;
// var found = false;
// for(var i=1; i<rows.length; i++){
// //查找fax相同的行，联动过去
// var sel = $(rows[i]).find("select")[0];
// var inputs = $(rows[i]).find("input");
// var type = sel.options[sel.selectedIndex].value;
// if((type == "传真") &&
// inputs[1].value == prevFaxCountryCode &&
// inputs[2].value == prevFaxArea &&
// inputs[3].value == prevFaxNum &&
// inputs[4].value == prevFaxNumExt){
// found = true;
// if($("input[name='info.faxCountryCode']")[0].value == ""
// && $("input[name='info.faxArea']")[0].value == ""
// && $("input[name='info.faxNum']")[0].value == ""
// && $("input[name='info.faxNumExt']")[0].value == ""
// ){
// //删除一行
// $("#"+tableId+" tr:eq("+i+")").remove();
// }
// else{
// var currentInput = inputs[1];
// currentInput.value = $("input[name='info.faxCountryCode']")[0].value;
// currentInput = inputs[2];
// currentInput.value = $("input[name='info.faxArea']")[0].value;
// currentInput = inputs[3];
// currentInput.value = $("input[name='info.faxNum']")[0].value;
// currentInput = inputs[4];
// currentInput.value = $("input[name='info.faxNumExt']")[0].value;
//				
// prevFaxCountryCode = $("input[name='info.faxCountryCode']")[0].value;
// prevFaxArea = $("input[name='info.faxArea']")[0].value;
// prevFaxNum = $("input[name='info.faxNum']")[0].value;
// prevFaxNumExt = $("input[name='info.faxNumExt']")[0].value;
// }
// break;
// }
// }
// if(!found){
// //没有找到相同的，新增一行，如果fax为空，则不新增
// if($("input[name='info.faxCountryCode']")[0].value == ""
// && $("input[name='info.faxArea']")[0].value == ""
// && $("input[name='info.faxNum']")[0].value == ""
// && $("input[name='info.faxNumExt']")[0].value == ""
// ){
// setPrevFaxInfosOnFucus();
// return;
// }
// addContactRow(tableId);
// var lastTr = $(table).find("tr:last");
// var typeSel = lastTr.find("select")[0];
// var options = typeSel.options;
// for(var i=0; i<options.length; i++){
// if(options[i].value == "传真"){
// typeSel.selectedIndex = i;
// break;
// }
// }
// var inputs = lastTr.find("input");
// var currentInput = inputs[1];
// currentInput.value = $("input[name='info.faxCountryCode']")[0].value;
// currentInput = inputs[2];
// currentInput.value = $("input[name='info.faxArea']")[0].value;
// currentInput = inputs[3];
// currentInput.value = $("input[name='info.faxNum']")[0].value;
// currentInput = inputs[4];
// currentInput.value = $("input[name='info.faxNumExt']")[0].value;
// setPrevFaxInfosOnFucus();
// }
// }
//
// var prevEmail = ""; //onfocus设置
// function setPrevEmailOnFocus(){
// prevEmail = $("input[name='info.email']")[0].value;
// }
// //联动email到联系信息
// function setEmailToContacts(tableId){
// var table = $("#"+tableId)[0];
// var rows = table.rows;
// var found = false;
// for(var i=1; i<rows.length; i++){
// //查找email相同的行，联动过去
// var sel = $(rows[i]).find("select")[0];
// var input = $(rows[i]).find("input")[3];
// if(sel.options[sel.selectedIndex].value == "EMAIL" && input.value ==
// prevEmail){
// found = true;
// if($("input[name='info.email']")[0].value == ""){
// //删除一行
// $("#"+tableId+" tr:eq("+i+")").remove();
// }
// else{
// input.value = $("input[name='info.email']")[0].value;
// prevEmail = input.value;
// }
// break;
// }
// }
// if(!found){
// //没有找到相同的，新增一行，如果为空，则不新增
// if($("input[name='info.email']")[0].value == ""){
// setPrevEmailOnFocus();
// return;
// }
// addContactRow(tableId);
// var lastTr = $(table).find("tr:last");
// var typeSel = lastTr.find("select")[0];
// var options = typeSel.options;
// for(var i=0; i<options.length; i++){
// if(options[i].value == "EMAIL"){
// typeSel.selectedIndex = i;
// break;
// }
// }
// var mobileInput = lastTr.find("input")[3];
// mobileInput.value = $("input[name='info.email']")[0].value;
// setPrevEmailOnFocus();
// }
// }

function ifKeyInfosModified() {
	// check if key infos modified
	var isModified = false;
	if ((oldKeyInfos.firstNameCN != $("input[name='info.firstNameCN']")[0].value)
			|| (oldKeyInfos.lastNameCN != $("input[name='info.lastNameCN']")[0].value)
			|| (oldKeyInfos.firstNameEN != $("input[name='info.firstNameEN']")[0].value)
			|| (oldKeyInfos.lastNameEN != $("input[name='info.lastNameEN']")[0].value)
			|| (oldKeyInfos.identifyCard != $("input[name='info.identifyCard']")[0].value)
			|| (oldKeyInfos.passport != $("input[name='info.passport']")[0].value)
			|| (oldKeyInfos.otherCredential != $("input[name='info.otherCredential']")[0].value)
			|| (oldKeyInfos.birthday != $("input[name='info.birthday']")[0].value)) {

		isModified = true;
	}
	return isModified;
}

$.validator.addMethod("regex", function(value, element, params) {
			// params[0] 正则表达式 params[1] 是否忽略空串
			if (params[1] != null && params[1] == true && value == "") {
				return true;
			}
			if (params[0].exec(value)) {
				return true;
			} else {
				return false;
			}
		}, "正则表达式校验出错<br/>");

$.validator.addMethod("ageValid", function(value, element, param) {
			if (value == "") {
				return true;
			}
			var date = new Date();
			date.setFullYear(date.getFullYear() - param);
			var arr = value.split("-");
			var targetDate = new Date();
			targetDate.setFullYear(arr[0], arr[1] - 1, arr[2]);
			if (targetDate <= date) {
				return true;
			} else
				return false;
		}, "年龄非法<br/>");

$.validator.addMethod("mobileValid", function(value, element, param) {
			// param 是否为中国境内手机的checkbox的id
			if ($("#" + param).attr("checked") == true) {
				var pattern = /^1[358][0-9]{9}$/;
				if (pattern.exec(value)) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}, "手机前缀应该为13/15/18的11位有效数字，请重新输入<br/>");

$.validator.addMethod("birthdayValid", function(value, element, param) {
			var year = value.substr(0, 4);
			var month = value.substr(5, 2);
			var day = value.substr(8, 2);
			var currentDate = new Date();
			var birth = new Date();
			birth.setFullYear(year);
			birth.setMonth(month - 1);
			birth.setDate(day);
			if (birth > currentDate)
				return false;
			else
				return true;
		}, "出生日期不能大于今天<br/>");
