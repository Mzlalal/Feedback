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

</script>
</head>
<body>

	<div class="col-md-10">
		<div class="content-box-large">
			<div class="panel-heading">
				<div class="panel-title">查询班级</div>
				<form action="classAction_queryByCond">
					<div class="col-md-3">
						<select class="form-control" name="className" id="className">
							<option value="classId" selected>班级ID</option>
						</select>
					</div>
					<div class="col-md-3">
						<input class="form-control" placeholder="查询条件" type="text"
							name="classValue">
					</div>
					<div class="col-md-2">
						<button class="btn btn-primary" onclick="submit();">
							<i class="glyphicon glyphicon-zoom-in"></i> 查询
						</button>
					</div>

					<c:if test="${classValue != null && classValue != '' }">
						<div class="col-md-2">
							<a class="btn btn-success"
								href="classAction_insert?type=2&id=${requestScope.classes.classId }"> <i
								class="glyphicon glyphicon-zoom-out"></i> 修改
							</a>
						</div>
					</c:if>
				</form>
			</div>
			<div class="panel-body">
				<fieldset>
					<div class="form-group">
						<label>班级ID <span style="color: red;">${msg }</span></label> <input
							class="form-control" placeholder="班级ID" type="text"
							value="${requestScope.classes.classId }" readonly="readonly">
					</div>
					<div class="form-group">
						<label>班级名</label> <input class="form-control" placeholder="班级名"
							type="text" value="${requestScope.classes.className }"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>开班日期</label> <input class="form-control" placeholder="开班日期"
							type="date" name="classes.createDate"
							value='<fmt:formatDate value="${requestScope.classes.createDate }" pattern="yyyy-MM-dd" />' readonly="readonly">
					</div>

				</fieldset>
			</div>
		</div>
	</div>

</body>
</html>