$(function() {
			// 变量定义在方法外
			var list = "";
			var temp_index = 0;
			var cache = [];
			$(".add").on('click', function() {
				var temp_name = $(this).attr("id");
				console.log("id:" + temp_name);

				console.log("cache.length:" + cache);
				var temp;
				if (cache.indexOf(temp_name) == -1) {
					console.log("进入else");
					list = "";
					cache[temp_index] = temp_name;
					temp_index++;
					for (temp in cache) {
						list = "<p class='load' id=" + cache[temp] + ">"
								+ cache[temp] + "</p>";
					}
					$("#list").append(list);
				}

			});
		});