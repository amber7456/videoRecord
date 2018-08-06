function sendRequest(url, method, data, callback) {
	var index = layer.load(1, {
		shade : [ 0.3, '#ddd' ]
	});
	console.log("开启遮罩层" + index);
	$.ajax({
		url : url,
		method : method,
		data : data,
		dataType : "json",
		success : function(resp) {
			if (resp.code == 0) {
				console.log("公共方法返回");
				console.log(resp);
				if (callback != null) {
					console.log("执行参数函数");
					callback(resp);
				} else {
					return resp;
				}
				layer.close(index);
				console.log("关闭遮罩层" + index);
			} else {
				layer.close(index);
				console.log("关闭遮罩层" + index);
				layer.alert(resp.msg, {
					offset : "200px",
					title : '程序异常：'
				})
			}
		},
		error : function(xhr) {
			layer.close(index);
			console.log("关闭遮罩层" + index);
			layer.alert(xhr.status + " " + xhr.statusText, {
				offset : "200px",
				title : '系统异常：'
			})
		}
	});
}

function getData(url, data) {
	var r;
	$.ajax({
		url : url,
		method : "POST",
		data : data,
		dataType : "json",
		async : false,
		success : function(resp) {
			if (resp.code == 0) {
				r = resp;
			} else {
				layer.alert(resp.msg, {
					offset : "200px",
					title : '程序异常'
				});
			}
		},
		error : function(xhr) {
			layer.alert(xhr.status + " " + xhr.statusText, {
				offset : "200px",
				title : '系统异常'
			});
		}
	});
	return r;
}

function getWeek(date) {
	var s = date.replace(/-/g, "/");
	var d = new Date(s);
	var weekday = new Array(7);
	weekday[0] = "星期日";
	weekday[1] = "星期一";
	weekday[2] = "星期二";
	weekday[3] = "星期三";
	weekday[4] = "星期四";
	weekday[5] = "星期五";
	weekday[6] = "星期六";
	return date + " " + weekday[d.getDay()];
}

// 使用正则表达式获取url中的参数
function getUrlParam(name) {
	// 构造一个含有目标参数的正则表达式对象
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	// 匹配目标参数
	var r = window.location.search.substr(1).match(reg);
	// 返回参数值
	if (r != null)
		return unescape(r[2]);
	return null;
}