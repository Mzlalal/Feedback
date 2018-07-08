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
<form name="frmAction" action="menuAction_batchDelete" method="post">
	<div class="row">
		<div class="col-md-12">
			<div class="content-box-large">
				<div class="panel-heading">
					<!-- 显示栏目标题 -->
					<div class="panel-title">系统管理</div>
					<a class="btn btn-success btn-sm" href="menuAction_add" >添加系统</a>
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
									<th class="sorting" >菜单编号</th>
									<th class="sorting" >菜单名称</th>
									<th class="sorting" >菜单响应链接</th>
									<th class="sorting" >菜单图标</th>
									<th class="sorting" >上级菜单编号</th>
									<th class="sorting" >有效图标</th>
									<th class="sorting" >菜单描述信息</th>
									<th class="sorting" >操作</th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all">
							<s:iterator value="#session.menus" id="menus" status="status">
								<tr class="gradeA odd">
								    <td class="sorting"><input type='checkbox' name='ids' value="<s:property value="#menus.menuId"/>" /></td>
								    <td class="sorting"><s:property value="#status.index+1"/></td>
									<td class="sorting" id="<s:property value="#menus.menuId"/>" ><s:property value="#menus.menuId"/></td>
									<td class="sorting"><s:property value="#menus.menuName"/></td>
									<td class="sorting"><s:property value="#menus.url"/></td>
									<td class="sorting"><s:property value="#menus.menuIcon"/></td>
									<td class="sorting"><s:property value="#menus.parentMenuId"/></td>
									<td class="sorting"><s:property value="#menus.validFlag"/></td>
									<td class="sorting"><s:property value="#menus.menuDesc"/></td>
									<td class="center">
									<a href="menuAction_toupdate?id=${menus.menuId }&&name=${menus.menuName}&&url=${menus.url}
									&&icon=${menus.menuIcon}&&menuID=${menus.parentMenuId}&&flag=${menus.validFlag}&&desc=${menus.menuDesc}" 
									class="btn btn-primary btn-xs">修改</a> 
									<a href="menuAction_delete?id=${menus.menuId }" class="btn btn-primary btn-xs" onclick="return confirm('您确认删除该菜单吗?删除操作不可撤销');">	删除</a></td>
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