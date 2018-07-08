<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>教学基地管理</title>

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
<form name="frmAction" id="frmAction" method="post" action="courseAction_batchDelete">
<!-- 操作类型：1新增 2修改 3删除 -->
		<input name="operateType" type="hidden" id="operateType" value="0" />
		<input name="base.baseId" type="hidden" id="base.baseId" value="" />
		<input name="base.baseName" type="hidden" id="base.baseName" value="" />
	<div class="row">
		<div class="col-md-12">
			<div class="content-box-large">
				<div class="panel-heading">
					<!-- 显示栏目标题 -->
					<div class="panel-title">教学基地管理</div>
					<a class="btn btn-success btn-sm" href="javascript:;" onclick="add()">新增基地</a>
					<a class="btn btn-success btn-sm" href="javascript:;" onclick="save()" >保存</a>
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
									   <!-- 遍历数据开始 -->
									   <th><input type="checkbox" name="selall" onclick="selectAll(this)" /></th> 
									   <th class="sorting" role="columnheader">#</th>
										<th class="sorting" role="columnheader">教学基地ID</th>
										<th class="sorting" role="columnheader">教学基地名称</th>
									<th class="sorting" role="columnheader">操作</th>
								</tr>
							</thead>
							<tbody role="alert" aria-live="polite" aria-relevant="all" id="baseTab">
								<c:forEach	var="base" items="${bases}" varStatus="status">
									<tr class="gradeA odd">
										 <td class="sorting"><input type='checkbox' name='ids' value="${base.baseId}" /></td>
										 <td class="center"><c:out value="${status.index+1}"/></td>
										 <td class="center"><c:out value="${base.baseId}" /></td>
										 <td class="sorting">
											<input name="base.baseName_${base.baseId}" type="text"
												id="base.baseName_${base.baseId}"
												value="<c:out value="${base.baseName}" />" disabled="true" /></td>
										  <td class="center"><a class="btn btn-primary btn-xs" href="javascript:;" 
										  onclick="editSingle(${base.baseId})">修改 </a>
										   <a class="btn btn-primary btn-xs" href="baseAction_delete?id=${base.baseId}"
										   		 onclick="return confirm('您确认删除该课程吗？')" >删除</a>
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
