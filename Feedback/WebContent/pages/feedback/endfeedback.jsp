<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>反馈管理</title>

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
<form name="frmAction" id="frmAction" method="post" action="courseAction_batchDelete">
    <div class="row">
        <div class="col-md-12">
            <div class="content-box-large">
                <div class="panel-heading">
                    <!-- 显示栏目标题 -->
                    <div class="panel-title">结束反馈批次</div>
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
                                       <th class="sorting" >教学反馈ID</th>
                                       <th class="sorting" >教学反馈名称</th>
                                       <th class="sorting" >反馈开始时间</th>
                                       <th class="sorting" >反馈结束时间</th>
                                       <th class="sorting" >反馈状态</th>
                                       <th class="sorting" >结束</th>
                                       <th class="sorting" >操作</th>
                                </tr>
                            </thead>
                            <tbody role="alert" aria-live="polite" aria-relevant="all">
                               <c:forEach var="list" items="${list}" varStatus="st">
                                <tr>
                                    <td class="sorting"><input type='checkbox' name='ids' value="${list[0]}" /></td>
                                    <td class="sorting"><c:out value="${st.index+1 }" /> </td>
                                    <c:forEach var="li" items="${st.current}" varStatus="st2">
                                        <td align="center"><c:out value="${li }" />
                                    </c:forEach>
                                    <td class="center" style="width: 9%;"><a
                                        href="feedback_endstatus?id=${list[0] }">一键结束</a>
                                    <td class="center" style="width: 9%;">
                                        <a href="feedback_update?id=${list[0]}&&name=${list[1]}&&stime=${list[2]}&&etime=${list[3]}&&status=${list[4]}">修改</a> 
                                        <a href="feedback_delete?id=${list[0]}" 
                                        onclick="return confirm('您确认删除反馈吗?删除操作不可撤销');"> 删除 </a></td>
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