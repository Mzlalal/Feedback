function save() {
	if (document.getElementById("operateType").value == 0) {
		alert('没有需要保存的修改！');
		return false;
	}
	if (isInputCorrectly()) {
		document.frmAction.submit();
	}
}

function add() {
	if (existsUnsavedModify()) return false;
	document.getElementById("operateType").value = 1;
	addNewRow();
	document.frmAction.action = "baseAction_save";
}

function editSingle(id) {
	if (existsUnsavedModify()) return false;
	document.getElementById("operateType").value = 2;
	document.getElementById("base.baseId").value = id;
	document.getElementById("base.baseName_" + id).disabled = false;
	document.frmAction.action = "baseAction_update";
}

function del() {
	if (existsUnsavedModify()) return false;
	
	var count = 0;
	var chk = document.getElementsByName("ids");
	if (chk == null) {
		alert("请勾选要删除的记录！");
		return false;
	}
	if (chk[0] == null) {
		if (chk.checked) {
			count++;
		}
	} else {
		for (i = 0; i < chk.length; i++) {
			if (chk[i].checked) {
				count++;
			}
		}
	}
	if (count == 0) {
		alert("请勾选要删除的记录！");
		return false;
	}
	if (confirm("操作不可恢复,您确定删除吗？")) {
		document.frmAction.action = "baseAction_dels";
		document.frmAction.submit();
	}

}

function selectAll(allSelect) {
	var chk = document.getElementsByName("ids");

	if (chk == null) {
		return false;
	}
	if (chk[0] == null) {
		chk.checked = allSelect.checked;
	} else {
		for (i = 0; i < chk.length; i++) {
			chk[i].checked = allSelect.checked;
		}
	}
}

// 检测是否存在未保存的修改
function existsUnsavedModify() {
	if (document.getElementById("operateType").value == 0) {
		return false;
	} else {
		alert('存在未保存的修改，请先进行保存！')
		return true;
	}
}

// 检测必须录入的数据项是否完整
function isInputCorrectly() {
	var type = document.getElementById("operateType").value;
	if (type == 1) {
		var roleName = document.getElementById("base.baseName_0").value.trim();
		if(roleName == "") {
			alert('必须输入教学基地名称！');
			return false;
		} else {
			document.getElementById("base.baseName").value = roleName;
		}
	} else if (type == 2) {
		var id = document.getElementById("base.baseId").value;
		var roleName = document.getElementById("base.baseName_" + id).value.trim();
		if(roleName == "") {
			alert('必须输入教学基地名称！');
			return false;
		} else {
			document.getElementById("base.baseName").value = roleName;
		}
	}
	return true;
}

// 给表格新增行
function addNewRow() {
	//获取table
	var tab = document.getElementById("baseTab");
	//  创建元素
	var tr = document.createElement("tr");
	var td1 = document.createElement("td");
	var td2 = document.createElement("td");
	var td3 = document.createElement("td");
	var td4 = document.createElement("td");
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tab.appendChild(tr);
	td1.innerHTML = '<input type="checkbox" name="ids" value="" />';
	td4.innerHTML = '<input name="base.baseName_0" type="text" id="base.baseName_0"	value="" />';
}