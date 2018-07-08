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
</head>
<body>
	<div class="col-md-6">
		<div class="content-box-large" style="width: 130%">
			<div class="panel-heading">
				<div class="panel-title">修改反馈批次</div>
				<div class="panel-options">
					<a href="#" data-rel="collapse"><i
						class="glyphicon glyphicon-refresh"></i></a>
				</div>
			</div>
			<div class="panel-body">
				<form method="post" action="feedback_updatefd">
					<input name="id" type="hidden" id="id" value="0" />
					<table width="100%" border="0px;" cellpadding="10px;"
						cellspacing="2px;">

						<tr>

							<td height="25px" align="right">反馈ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2"><input name="feedback.feedbackId"
								type="text" class="form-control" value="${param.id}"
								readonly="readonly" /></td>
						</tr>
						<tr>
							<td height="25px" align="right">反馈名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2"><input name="feedback.feedbackName"
								type="text" class="form-control" placeholder="反馈名称"
								value="${param.name}" /></td>
						</tr>
						<tr>
							<td height="25px" align="right">开始时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2"><input name="feedback.beginTiime"
								type="text" class="form-control" placeholder="开始反馈时间"
								value="${param.stime}" /></td>
						</tr>
						<tr>
							<td height="25px" align="right">结束时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2"><input name="feedback.endTime" type="text"
								class="form-control" placeholder="结束反馈时间" value="${param.etime}" /></td>
						</tr>
						<tr>
							<td height="25px" align="right">反馈状态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2"><input name="feedback.status" type="text"
								class="form-control" placeholder="1表示开启   2表示进行   3表示结束"
								value="${param.status }" readonly="readonly" /></td>
						</tr>
						<tr>
							<td colspan="3">
								<p align="center" /> <br /> <input type="submit"
								class="btn btn-info" onclick="return confirm('您确认修改反馈批次吗？')"
								value="确认修改" />
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