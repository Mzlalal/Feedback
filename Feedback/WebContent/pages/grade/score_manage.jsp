<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>评分管理</title>
<script src="resource/js/jquery-3.2.1.js"></script>
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/styles.css" rel="stylesheet">
<link rel="resource/stylesheet" href="css/stats.css">
<script src="resource/vendors/datatables/js/jquery.dataTables.min.js"></script>
<script src="resource/vendors/datatables/dataTables.bootstrap.js"></script>
<script src="resource/bootstrap/js/bootstrap.min.js"></script>
<script src="resource/js/custom.js"></script>
<script src="resource/js/tables.js"></script>
<script src="resource/js/grade.js" type="text/javascript"></script>
</head>

<body>
	<form name="frmAction" id="frmAction" method="post" action="gradeAction_manage">
		<!-- 操作类型：1修改 -->
		<input name="operateType" type="hidden" id="operateType" value="0" />
		<input name="feedbackScore.fsId" type="hidden" id="feedbackScores.fsId" value="" />
		<input name="feedbackScore.score" type="hidden" id="feedbackScores.score" value="" />
		<input name="feedbackScore.feedbackItem.itemValue" type="hidden" id="feedbackScores.feedbackItem.itemValue" value="" />

		<div class="row">
			<div class="col-md-12">
				<div class="content-box-large">
					<div class="panel-heading">
						<!-- 显示栏目标题 -->
						<div class="panel-title">评分管理</div>
						<a class="btn btn-success btn-sm" href="javascript:;" onclick="save()" >保存</a>
					</div>
					<div class="panel-body">
						<div id="example_wrapper" class="dataTables_wrapper form-inline"
							role="grid">
							<table cellpadding="0" cellspacing="0" border="0"
								class="table table-striped table-bordered dataTable"
								id="example" aria-describedby="example_info">
								<thead>
									<tr role="row">
										<th  >#</th>
										<th  >评分编号</th>
										<th  >批次</th>
										<th  >学生</th>
										<th  >教师</th>
										<th  >课程</th>
										<th  >指标</th>
										<th  >分值</th>
										<th  >分数</th>
										<th  >操作</th>
									</tr>
								</thead>

								<tbody role="alert" aria-live="polite" aria-relevant="all" id="scoreListTable">
									<c:forEach var="feedbackScores" items="${feedbackScores}" varStatus="status">
										<tr class="gradeA odd">
											<td><c:out value="${status.index+1}" /></td>
											<td ><c:out value="${feedbackScores.fsId}" /></td>
											<td ><c:out value="${feedbackScores.feedback.feedbackName}" /></td>
											<td ><c:out value="${feedbackScores.student.name}" /></td>
											<td ><c:out value="${feedbackScores.teacher.name}" /></td>
											<td ><c:out value="${feedbackScores.course.courseName}" /></td>
											<td style="width:28%;"><c:out value="${feedbackScores.feedbackItem.fiName}" /></td>
											<td  id="feedbackScores.feedbackItem.itemValue_${feedbackScores.fsId}"><c:out value="${feedbackScores.feedbackItem.itemValue}" /></td>
											<td  style="width:5%;">
											<input name="score_${feedbackScores.fsId}" type="text"  style="width:90%;"
												id="score_${feedbackScores.fsId}" 
												value="<c:out value="${feedbackScores.score}"/>" disabled="true"/>
											</td>
											<td >
											<a class="btn btn-primary btn-xs" href="javascript:;" onclick="editSingle( ${feedbackScores.fsId} )">修改 </a> 
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