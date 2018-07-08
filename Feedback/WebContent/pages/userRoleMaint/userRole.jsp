<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户角色维护</title>

<script src="resource/js/jquery-3.2.1.js"></script>
<link href="resource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resource/css/styles.css" rel="stylesheet">
<link rel="resource/stylesheet" href="css/stats.css">
<script
	src="resource/vendors/datatables/js/jquery.dataTables.min.js"></script>
<script src="resource/vendors/datatables/dataTables.bootstrap.js"></script>
<script src="resource/bootstrap/js/bootstrap.min.js"></script>
<script src="resource/js/custom.js"></script>
<script src="resource/js/tables.js"></script>
<script src="resource/js/entity.js" type="text/javascript"></script>
<script src="resource/js/teaching_base.js" type="text/javascript"></script>
</head>
<body>
<form name="frmAction" id="frmAction">
	<div class="row">
		<div class="col-md-12">
			<div class="content-box-large">
				<div class="panel-heading">
					<!-- 显示栏目标题 -->
					<div class="panel-title">用户角色维护</div>
				</div>
				<div class="panel-body">
					<div id="example_wrapper" class="dataTables_wrapper form-inline"
						role="grid">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered dataTable" id="example"
							aria-describedby="example_info">
							<thead>
								<tr role="row">
									   <!-- 遍历数据开始 -->
									   <th class="sorting" role="columnheader">#</th>
										<th class="sorting" role="columnheader">用户ID</th>
										<th class="sorting" role="columnheader">登录名</th>
										<th class="sorting" role="columnheader">性名</th>
										<th class="sorting" role="columnheader">角色ID</th>
										<th class="sorting" role="columnheader">角色名</th>
									<th class="sorting" role="columnheader">操作</th>
								</tr>
							</thead>
							<tbody role="alert" aria-live="polite" aria-relevant="all" id="baseTab">
								<c:forEach	var="userRole" items="${userRole}" varStatus="status">
									<tr class="gradeA odd">
										 <td class="center"><c:out value="${status.index+1}"/></td>
										<td class="center"><c:out value="${userRole.user.userId}" /></td>
										  <td class="center"><c:out value="${userRole.user.loginName}" /></td>
										  <td class="center"><c:out value="${userRole.user.name}" /></td>
										  <td class="center"><c:out value="${userRole.roleId}" /></td>
										  <td class="center"><c:out value="${userRole.roleName}" /></td>
										  <td class="center"><a class="btn btn-primary btn-xs" 
										  href="userroleAction_updating?rId=<c:out value="${userRole.roleId}"/>&uId=<c:out value="${userRole.user.userId}" />" >修改 </a>
									  	</td> 
									</tr>
								</c:forEach>

							</tbody>
       
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>
