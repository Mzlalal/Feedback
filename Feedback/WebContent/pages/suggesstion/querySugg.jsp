<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人建议管理</title>

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
<form name="frmAction" id="frmAction" method="post" action="feedbackConAction_batchDelete">
    <div class="row">
        <div class="col-md-12">
            <div class="content-box-large">
                <div class="panel-heading">
                    <!-- 显示栏目标题 -->
                    <div class="panel-title">查询个人建议</div>
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
                                       <th class="sorting" >#</th>
                                       <th class="sorting" >个人建议ID</th>
                                       <th class="sorting" >反馈ID</th>
                                       <th class="sorting" >老师ID</th>
                                       <th class="sorting" >学生ID</th>
                                       <th class="sorting" >建议内容</th>
                                       <th class="sorting" >操作</th>
                                </tr>
                            </thead>
                            <tbody role="alert" aria-live="polite" aria-relevant="all">
                               <s:iterator id="suggestion" status="status" value="#session.suggestion">
		                        <tr>
		                        	<td class="sorting"><input type='checkbox' name='ids' value="<s:property value="#suggestion.sugId"/>" /></td>
		                        	<td class="center"><s:property value="#status.index+1" /></td>
		                            <td class="sorting"><s:property value="#suggestion.sugId" /></td>
                                    <td class="sorting"><s:property value="#suggestion.feedback.feedbackId" /></td>
                                    <td class="sorting"><s:property value="#suggestion.usersByTeacherId.userId" /></td>
                                    <td class="sorting"><s:property value="#suggestion.usersByStudentId.userId" /></td>
                                    <td class="sorting"><s:property value="#suggestion.sugContent" /></td>
		                            <td class="center" style="width: 9%;">
		                                <a href="feedbackConAction_toupdate?sId=${sugId}&&fId=${suggestion.feedback.feedbackId }&&tId=${suggestion.usersByTeacherId.userId }&&stId=${suggestion.usersByStudentId.userId }&&sug=${sugContent}">修改</a> 
		                                <a href="feedbackConAction_delete?id=${sugId}" 
		                                onclick="return confirm('您确认删除建议吗?删除操作不可撤销');"> 删除</a></td>
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