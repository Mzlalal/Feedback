<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>评分</title>
<script src="resource/js/jquery-3.2.1.js"></script>
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/styles.css" rel="stylesheet">
<link rel="resource/stylesheet" href="css/stats.css">
<script src="resource/vendors/datatables/js/jquery.dataTables.min.js"></script>
<script src="resource/vendors/datatables/dataTables.bootstrap.js"></script>
<script src="resource/bootstrap/js/bootstrap.min.js"></script>
<script src="resource/js/custom.js"></script>
<script src="resource/js/tables.js"></script>
</head>
<body>
	<form name="frmAction" id="frmAction" method="post"
		action="departmentAction_batchDelete">
		<!-- 操作类型：1新增 2修改 3删除 -->
		<%-- <input name="operateType" type="hidden" id="operateType" value="0" />
		<input name="department.deptId" type="hidden" id="department.deptId" value="" />
		<input name="department.deptName" type="hidden" id="department.deptName" value="" />
		<input name="department.deptAddress" type="hidden" id="department.deptAddress" value="" /> --%>

		<div class="row">
			<div class="col-md-12">
				<div class="content-box-large">
					<div class="panel-heading">
						<!-- 显示栏目标题 -->
						<div class="panel-title">评分</div>
						<a class="btn btn-success btn-sm" href="javascript:;"
							onclick="submit()">提交</a>
					</div>
					<div class="panel-body">
						<div id="example_wrapper" class="dataTables_wrapper form-inline"
							role="grid">
							<c:forEach var="feedbackType" items="${feedbackType }"
							varStatus="status">
							<table cellpadding="0" cellspacing="0" border="0"
								class="table table-striped table-bordered dataTable"
								aria-describedby="example_info">
								<thead>
									<tr role="row">
										<th class="sorting">排序</th>
										<th style="width: 57%;" class="sorting"><c:out value="${feedbackType.fitName }" />（指标）</th>
										<th class="sorting">分值</th>
										<th class="sorting">评分</th>
									</tr>
								</thead>

								<tbody role="alert" aria-live="polite" aria-relevant="all"
									id="departmentListTable">
									<c:forEach var="feedbackItem" items="${feedbackItem }"
										varStatus="status">
										<c:if test="${feedbackItem.feedbackItemType.fitId ==feedbackType.fitId }">
										<tr class="gradeA odd">
											<td  style="width: 91px;" class="sorting" ><c:out value="${status.index+1}" /></td>
											<td class="sorting">
												<c:out value="${feedbackItem.fiName }" />
											</td>
											<td  class="sorting" style="color: red;">
												<c:out
												value="${feedbackItem.itemValue }">
												</c:out>
											</td>
											<td><input type="text"/></td>
										</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
							</c:forEach>

						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>