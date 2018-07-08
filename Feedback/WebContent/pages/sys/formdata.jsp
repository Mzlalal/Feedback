<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>${panel_title }</title>

<script src="../../resource/js/jquery-3.2.1.js"></script>
<link href="../../resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resource/css/styles.css" rel="stylesheet">
<link rel="../../resource/stylesheet" href="css/stats.css">
<script src="../../resource/vendors/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../resource/vendors/datatables/dataTables.bootstrap.js"></script>
<script src="../../resource/bootstrap/js/bootstrap.min.js"></script>
<script src="../../resource/js/custom.js"></script>
<script src="../../resource/js/tables.js"></script>
</head>
<body>

	<div class="row">
		<div class="col-md-9">
			<div class="content-box-large">
				<div class="panel-heading">
					<!-- 显示栏目标题 -->
					<div class="panel-title">${panel_title }</div>
				</div>
				<div class="panel-body">
					<div id="example_wrapper" class="dataTables_wrapper form-inline"
						role="grid">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered dataTable" id="example"
							aria-describedby="example_info">
							<thead>
								<tr role="row">
									<th class="sorting" role="columnheader">#</th>
									<!-- 遍历数据开始 -->
									<s:iterator id="col" status="status" value="cols">
										<th class="sorting" role="columnheader">
										<s:property value="col" /></th>
									</s:iterator>
									<th class="sorting" role="columnheader">操作</th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all">
								<tr class="gradeA odd">
									<td class="sorting">java</td>
									<td class="">Firefox 1.0</td>
									<td class="">Win 98+ / OSX.2+</td>
									<td class="center">1.7</td>
									<td class="center">A</td>
									<td class="center"><a href="#" class="btn btn-primary btn-xs">修改</a> <a href="#" class="btn btn-primary btn-xs">删除</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>