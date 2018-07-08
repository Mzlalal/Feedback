<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>班级课程</title>
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
<script src="resource/js/itemReport.js"></script>
</head>

<body>
	<div class="row">
		<div class="col-md-12">
			<div class="content-box-large">
				<div class="panel-heading">
					<!-- 显示栏目标题 -->
					<div class="panel-title">指标项报表</div>
				</div>

				<div class="panel-body">
					<div id="example_wrapper" class="dataTables_wrapper form-inline"
						role="grid">

						<c:forEach items="${requestScope.reports }" var="report"
							varStatus="status">
							<c:if
								test="${reports[status.index][1] != reports[status.index-1][1] }">
								<!-- 遍历数据开始-->
								<table class="table table-striped table-bordered dataTable"
									aria-describedby="example_info">

									<thead>
										<tr>
											<th>${reports[status.index][5] }</th>
											<th>分值</th>
											<th>平均分值</th>
										</tr>
									</thead>
									<tr>
										<td>${reports[status.index][3] }</td>
										<td>${reports[status.index][2] }</td>
										<td>${reports[status.index][4] }</td>
									</tr>
							</c:if>
							<c:if
								test="${reports[status.index][1] == reports[status.index-1][1] }">
								<tr>
									<td>${reports[status.index][3] }</td>
									<td class="itemValue">${reports[status.index][2] }</td>
									<td><fmt:formatNumber type="number"
											value="${reports[status.index][4]}" maxFractionDigits="2" /></td>
								</tr>
							</c:if>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>