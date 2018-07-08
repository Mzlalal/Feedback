<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>修改密码</title>
<meta charset="utf-8">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link href="css/forms.css" rel="stylesheet">

</head>
<body>
	<!-- 导入头部 -->
	<s:include value="navigation.jsp">
	</s:include>

	<div class="row">
		<!-- 导入左侧导航栏 -->
		<s:include value="leftNavigation.jsp">
			<s:param name="privilige"></s:param>
		</s:include>
		<div class="col-md-6">
			<div class="content-box-large">
				<div class="panel-heading">
					<div class="panel-title">教学反馈</div>
					<div class="panel-options" title="重置">
						<a href="#" data-rel="collapse"><i
							class="glyphicon glyphicon-refresh"></i></a>
					</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>理论授课</th>
								<th width="20%">分值</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>为人师表,关心学生,要求严格</td>
								<td>
									<div class="col-sm-12 pull-right">
										<input type="text" class="form-control" placeholder="8">
									</div>
								</td>
							</tr>
							<tr>
								<td>2</td>
								<td>讲授语言清晰、流畅、简洁；语调抑扬顿挫、语速适中</td>
								<td>
									<div class="col-sm-12 pull-right">
										<input type="text" class="form-control" placeholder="8">
									</div>
								</td>
							</tr>
							<tr>
								<td>3</td>
								<td colspan="2"><div class="col-sm-12">
										<textarea class="form-control" placeholder="个人建议" rows="3"></textarea>
									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>

</body>
</html>