<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
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
<script src="resource/js/role.js" type="text/javascript"></script>
<script src="resource/js/entity.js" type="text/javascript"></script>
</head>
<body>
	<form name="frmAction" id="frmAction" method="post" action="roleAction_batchDelete">
		<!-- 操作类型：1新增 2修改 3删除 -->
		<input name="operateType" type="hidden" id="operateType" value="0" />
		<input name="role.roleId" type="hidden" id="role.roleId" value="" />
		<input name="role.roleName" type="hidden" id="role.roleName" value="" />

		<div class="row">
			<div class="col-md-12">
				<div class="content-box-large">
					<div class="panel-heading">
						<!-- 显示栏目标题 -->
						<div class="panel-title">角色管理</div>
                        <a class="btn btn-success btn-sm" href="javascript:;" onclick="add()" >新增角色</a>
						<a class="btn btn-success btn-sm" href="javascript:;" onclick="save()" >保存</a>
						<a class="btn btn-warning btn-sm" href="javascript:;" onclick="del()" >批量删除</a>
					</div>
					<div class="panel-body">
						<div id="example_wrapper" class="dataTables_wrapper form-inline"
							role="grid">
							<table cellpadding="0" cellspacing="0" border="0"
								class="table table-striped table-bordered dataTable"
								id="example" aria-describedby="example_info">
								<thead>
									<tr role="row">
										<th><input type="checkbox" name="selall" onclick="selectAll(this)" /></th>
										<th class="sorting" >#</th>
										<th class="sorting" >ID</th>
										<th class="sorting" >角色名称</th>
										<th class="sorting" >操作</th>
									</tr>
								</thead>

								<tbody role="alert" aria-live="polite" aria-relevant="all" id="roleListTable">
									<c:forEach var="role" items="${roles}" varStatus="status">
										<tr class="gradeA odd">
											<td class="sorting"><input type='checkbox' name='ids' value="${role.roleId}" /></td>
											<td class="sorting"><c:out value="${status.index+1}" /></td>
											<td class="sorting"><c:out value="${role.roleId}" /></td>
											<td class="sorting">
											<input name="role.roleName_${role.roleId}" type="text"
												id="role.roleName_${role.roleId}"
												value="<c:out value="${role.roleName}" />" disabled="true" /></td>
											<td class="sorting">
											<a class="btn btn-primary btn-xs" href="javascript:;" onclick="editSingle(${role.roleId})">修改 </a> 
											<a class="btn btn-primary btn-xs" href="javascript:;" onclick="delSingle(${role.roleId})">删除</a>
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