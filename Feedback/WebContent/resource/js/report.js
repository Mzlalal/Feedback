$(function() {
	// 将 列  结果集重置到 行 结果集
	var cols = $(".col");
	// i % 指标项数 将结果集列排序
	for (var i = 0, max = cols.length; i < max; i++) {
		$("#row" + (i % 4)).append("<td class='score_"+parseInt(i/4)+"'>" + $(cols[i]).val() + "</td>");
	}

	// 添加列标题添加到列标题
	var thead = $(".thead");
	
	for (var i = 0, max = thead.length; i < max; i++) {
		$("#thead").append("<th>" + $(thead[i]).val() + "</th>");
	}

	// 删除 多余 thead 元素
	if ($("thead").length > 1) {
		for (var x = 1; x < $("thead").length; x++) {
			$("thead")[x].remove();
		}
	}
	// 删除 多余 tbody 元素
	// 第一个tbody 用来添加总分
	if ($("tbody").length > 2) {
		for (var x = 2; x < $("tbody").length + 1; x++) {
			$("tbody")[x].remove();
		}
	}

	// 添加总分行
	$(".full_socre").append("<tr class='all' style='color:red;font-weight: bold;'><td>总分</td><td class='full_itemValue'></td></tr>");
	
	// 指标项分数
	var itemValue = $(".itemValue");
	var sum = 0;
	for (var x = 0; x < itemValue.length; x++) {
		sum = sum + parseFloat($(itemValue[x]).html());
	}
	$(".full_itemValue").html(sum);
	
	// 根据课程标题个数来遍历添加总分
	for (var y=0; y<thead.length; y++) {
		sum = 0;
		var score = $(".score_"+y);
		for (var x = 0; x < score.length; x++) {
			sum = sum + parseFloat($(score[x]).html());
		}
		$(".all").append("<td>"+sum+"</td>")
	}
	
})