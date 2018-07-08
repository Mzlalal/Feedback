function editSingle(id) {
	if (existsUnsavedModify()) return false;
	document.getElementById("operateType").value = 1;
	document.getElementById("feedbackScores.fsId").value = id;
	document.getElementById("score_" + id).disabled = false;
	document.frmAction.action = "gradeAction_update";
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
		var id = document.getElementById("feedbackScores.fsId").value;
		var maxval=document.getElementById("feedbackScores.feedbackItem.itemValue_"+id).innerHTML;
		var score = document.getElementById("score_" + id).value.trim();
		console.log("maxval"+maxval+"	score"+score);
		if(score == "") {
			alert('分数不能为空！');
			return false;
		}else if(parseInt(score) > parseInt(maxval)){
			alert('分数不能大于最大值'+maxval+'!')
			return false;
		}else if(score < 0){
			alert('分数不能少于0!')
			return false;
		}else {
			document.getElementById("feedbackScores.score").value = score;
		}
	}
	return true;
}

function save() {
	if (document.getElementById("operateType").value == 0) {
		alert('没有需要保存的修改！');
		return false;
	}
	if (isInputCorrectly()) {
		document.frmAction.submit();
	}
}

function start() {
		document.frmAction.action = "gradeAction_grade";
		document.frmAction.submit();
}
