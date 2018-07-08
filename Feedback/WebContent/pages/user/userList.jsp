<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<script src="resource/js/jquery-3.2.1.js"></script>
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/styles.css" rel="stylesheet">
<link rel="resource/stylesheet" href="css/stats.css">
<script src="resource/vendors/datatables/js/jquery.dataTables.min.js"></script>
<script src="resource/vendors/datatables/dataTables.bootstrap.js"></script>
<script src="resource/bootstrap/js/bootstrap.min.js"></script>
<script src="resource/js/custom.js"></script>
<script src="resource/js/tables.js"></script>
<script src="resource/js/entity.js" type="text/javascript"></script>
</head>
<body>
<form name="frmAction" action="userAction_batchDelete" method="post">
	<div class="row">
		<div class="col-md-12">
			<div class="content-box-large">
				<div class="panel-heading">
					<!-- 显示栏目标题 -->
					<div class="panel-title">用户管理</div>
					<a class="btn btn-success btn-sm" href="userAction_add" >新增用户</a>
					<a class="btn btn-warning btn-sm" href="javascript:;" onclick="del()" >批量删除</a>
				</div>
				<div class="panel-body">
					<div id="example_wrapper" class="dataTables_wrapper form-inline"
						role="grid">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered dataTable" id="example"
							aria-describedby="example_info">
							<thead>
								<tr role="row">
								    <th><input type="checkbox" name="selall" onclick="selectAll(this)" /></th> 
									<th class="sorting" >#</th>
									<th class="sorting" >用户ID</th>
									<th class="sorting" >登录名</th>
									<th class="sorting" >性别</th>
									<th class="sorting" >姓名</th>
									<th class="sorting" >身份证号码</th>
									<th class="sorting" >用户角色</th>
									<th class="sorting" >用户类别</th>
									<th class="sorting" >操作</th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all">
							<s:iterator value="#session.users" id="user" status="status">
								<tr class="gradeA odd">
								    <td class="sorting"><input type='checkbox' name='ids' value="<s:property value="#user.userId"/>" /></td>
								    <td class="sorting"><s:property value="#status.index+1"/></td>
									<td class="sorting" id="<s:property value="#user.userId"/>" ><s:property value="#user.userId"/></td>
									<td class="sorting"><s:property value="#user.loginName"/></td>
									<td class="sorting"><s:property value="#user.sex"/></td>
									<td class="sorting"><s:property value="#user.name"/></td>
									<td class="sorting"><s:property value="#user.idcard"/></td>
									<td class="sorting"><s:property value="#user.role.roleName"/></td>
									<td class="sorting">
									   <s:if test="#user.userType==1">教师</s:if>
									   <s:if test="#user.userType==2">学生</s:if></td>
									<td class="center">
									<a href="userAction_edit?id=<s:property value="#user.userId"/>" class="btn btn-primary btn-xs">修改</a> 
									<a href="userAction_delete?id=<s:property value="#user.userId"/>" class="btn btn-primary btn-xs" onclick="return confirm('您确认删除该用户吗?删除操作不可撤销');">	删除</a></td>
								</tr>
						  </s:iterator>
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