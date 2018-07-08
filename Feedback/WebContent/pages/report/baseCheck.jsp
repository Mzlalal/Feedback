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
		<div class="content-box-large">
			<div class="panel-heading">
				<div class="panel-title">按基地查询报表</div>
				<div class="panel-options">
					<a href="#" data-rel="collapse">
					<i class="glyphicon glyphicon-refresh"></i></a>
				</div>
			</div>
			<div class="panel-body">
				<form action="reportAction_baseReport" method="post">
					<fieldset>
						<div class="form-group">
							<label>反馈年份</label>
							<p>
								<select class="form-control" name="schoolYear">
									<c:forEach var="fd" items="${feedbacks }">
										<option value="${fd }">${fd }</option>
									</c:forEach>
								</select>
							</p>
						</div>
						
						<div class="form-group">
							<label>反馈次数</label>
							<p>
								<select class="form-control" name="time">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</select>
							</p>
						</div>
						
						<div class="form-group">
							<label>反馈类型</label>
							<p>
								<select class="form-control" name="type">
									<c:forEach var="type" items="${requestScope.type }">
										<option value="${type.fitId }">${type.fitName }</option>
									</c:forEach>
								</select>
							</p>
						</div>
						
						<div class="form-group">
							<label>基地名</label>
							<p>
								<select class="form-control" name="id">
									<c:forEach var="base" items="${requestScope.bases }">
										<option value="${base.baseId }">${base.baseName }</option>
									</c:forEach>
								</select>
							</p>
						</div>
					</fieldset>
					<div>
						<button class="btn btn-primary">
							<i class="glyphicon glyphicon-align-left"></i> 查看报表
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>