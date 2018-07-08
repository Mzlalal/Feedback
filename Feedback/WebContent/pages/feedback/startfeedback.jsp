<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resource/js/jquery-3.2.1.js"></script>

<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/styles.css" rel="stylesheet">
<link
	href="resource/vendors/form-helpers/css/bootstrap-formhelpers.min.css"
	rel="stylesheet">
<link href="resource/vendors/select/bootstrap-select.min.css"
	rel="stylesheet">
<link href="resource/css/forms.css" rel="stylesheet">
<script src="resource/bootstrap/js/bootstrap.min.js"></script>
<script
	src="resource/vendors/form-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="resource/vendors/select/bootstrap-select.min.js"></script>
<script type="text/javascript">
	function checkForm(){
		var name = document.getElementById('name');
		var starttime = document.getElementById('starttime');
		var endtime = document.getElementById('endtime');
		var status = document.getElementById('status');
		if(name.value==''){
			confirm('请填写反馈名称！');
			return false;
		}else if(starttime.value==''){
			confirm('请填写反馈时间！');
			return false;
		}else if(endtime.value==''){
			confirm('请填写结束时间');
			return false;
		}else if(status.value==''){
			confirm('请填写反馈状态');
			return false;
		}else if(status.value !='1'&&status.value !='2'&&status.value !='3'){
			confirm('反馈状态只能是  1  或者  2  或者  3  哦！');
			return false;
		}else if(starttime.value>=endtime.value){
			confirm('亲，结束时间必须大于开始时间哦!');
			return false;
		}else{
			return true;
		}
	}
</script>
</head>
<body>
	<div class="col-md-6">
		<div class="content-box-large" style="width: 130%">
			<div class="panel-heading">
				<div class="panel-title">开启反馈批次</div>
				<div class="panel-options">
					<a href="#" data-rel="collapse"><i
						class="glyphicon glyphicon-refresh"></i></a>
				</div>
			</div>
			<div class="panel-body">
				<form method="post" action="feedback_save" onsubmit="return checkForm()" value=" 确认添加">
					<input name="id" type="hidden" id="id" value="0" />
					<table width="100%" border="0px;" cellpadding="10px;"
						cellspacing="2px;">
						<tr>
							<td height="25px" align="right">反馈名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2"><input name="feedback.feedbackName"
								type="text" class="form-control" placeholder="反馈名称" id="name" /></td>
						</tr>
						<tr>
							<td height="25px" align="right">开始时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2"><input name="feedback.beginTiime"
								type="date" class="form-control" placeholder="开始反馈时间" id="starttime" /></td>
						</tr>
						<tr>
							<td height="25px" align="right">结束时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2"><input name="feedback.endTime" type="date"
								class="form-control" placeholder="结束反馈时间" id="endtime"/></td>
						</tr>
						<tr>
							<td height="25px" align="right">反馈状态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2"><input name="feedback.status" type="text"
								class="form-control" placeholder="1表示开启   2表示进行   3表示结束"
								id="status" /></td>
						</tr>
						<tr>
							<td colspan="3">
								<p align="center" /> <br /> <input type="submit"
								class="btn btn-info" value="一键开启"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		</td>
		</tr>
		</tbody>
		</table>
		</form>
	</div>
	</div>
	</div>

</body>
</html>