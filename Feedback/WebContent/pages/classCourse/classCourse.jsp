<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>班级课程</title>

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
</head>

<body>
<form name="frmAction" action="ccAction_batchDelete" method="post">
	<div class="row">
		<div class="col-md-12">
			<div class="content-box-large">
				<div class="panel-heading">
					<!-- 显示栏目标题 -->
					<div class="panel-title">班级课程</div>
					<a class="btn btn-success btn-sm" href="ccAction_insert">新增班级课程</a>
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
										<!-- 遍历数据开始-->
									    <th><input type="checkbox" name="selall" onclick="selectAll(this)" /></th>
										<th class="sorting" >#</th>
										<th class="sorting" > 班级</th>
										<th class="sorting" >辅导员</th>
										<th class="sorting" >课程名</th>
										<th class="sorting" >课程类型</th>
										<th class="sorting" >教师名</th>
								        <th class="sorting" >学年</th>
								        <th class="sorting" >学期</th>
									<th class="sorting" >操作</th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all">
								<s:iterator id="classCourses" status="status" value="#session.classCourses">
									<tr class="gradeA odd">
									    <td class="sorting"><input type='checkbox' name='ids' value="<s:property value="#classCourses.ccId"/>" /></td>
										<td class="center"><s:property value="#status.index+1" /></td>
										<td class="center"><s:property value="#classCourses.classes.className" /></td>
										<td class="center"><s:property value="#classCourses.classes.users.name" /></td>
                                        <td class="center"><s:property value="#classCourses.course.courseName" /></td>
                                        
                                        <td class="center">
                                        <s:if test="#classCourses.course.courseType==1"> 纯理论授课  </s:if>
                                        <s:if test="#classCourses.course.courseType==2"> 理论加上机  </s:if>
                                        <s:if test="#classCourses.course.courseType==3"> 纯上机实践  </s:if>
                                        </td>
                                        
                                        <td class="center"><s:property value="#classCourses.users.name" /></td>
                                        <td class="center"><s:property value="#classCourses.schoolYear" /></td>
                                        <td class="center"><s:property value="#classCourses.semester" /></td>
										<td class="center">
										<a class="btn btn-primary btn-xs" href="ccAction_insert?type=1
										&id=<s:property value="#classCourses.ccId"/>
										&courseType=<s:property value="#classCourses.course.courseType" />  ">修改 </a>
										<a  href="ccAction_delete?
										&id=<s:property value="#classCourses.ccId" />"class="btn btn-primary btn-xs"
										onclick="return confirm('您确认删除该课程吗？')">删除 </a>
										</td>
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