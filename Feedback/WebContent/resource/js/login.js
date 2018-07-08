$(function() {
	// 添加事件
	$(".signup").on('click',function(e){
		$("#login").submit();
	});
	
	// 表单监听事件  在表单内输入回车时 提交表单
	$("#login").on('keydown',function(e){
		if(e.keyCode==13) {
			$("#login").submit();
		}
	});
});
