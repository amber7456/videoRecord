function search() {
	var url = "/videoRecord/getVideoList/";
	var method = "POST";
	var data = {
		year : $("#year").val(),
		videoType : $("#videoType").val()
	};
	$("#yearHide").val($("#year").val());
	$("#videoTypeHide").val($("#videoType").val());
	sendRequest(url, method, data, loadVideoInfo);
}

window.callBackSearch = function() {
	console.log("回调查询");
	var url = "/videoRecord/getVideoList/";
	var method = "POST";
	var data = {
		year : $("#yearHide").val(),
		videoType : $("#videoTypeHide").val()
	};
	sendRequest(url, method, data, loadVideoInfo);
	// 回显查询条件
	console.log($("#yearHide").val());
	$("#year").val($("#yearHide").val());
	var videoTypeTab = $("#videoTypeHide").val();
	console.log(videoTypeTab);
	$("#" + videoTypeTab).siblings().removeClass("video-type-tab-this");
	$("#" + videoTypeTab).addClass("video-type-tab-this");
	$("#videoType").val(videoTypeTab);
	form.render('select');
};

function loadVideoInfo(resp) {
	$("#video_list_div").html("");
	for (i = 0, len = resp.data.yearData.length; i < len; i++) {
		var yearData = resp.data.yearData[i];

		$("#video_list_div").append("<div id='video_list_div_" + yearData.year + "' class='year-div'></div>");
		var yearId = "video_list_div_" + yearData.year;

		$("#" + yearId).append("<div class='year-title'>" + yearData.year + "年</div>");
		$("#" + yearId).append("<div class='countMsg-title'>" + yearData.countMsg + "</div>");

		for (j = 0, lenJ = yearData.season.length; j < lenJ; j++) {
			var season = yearData.season[j];
			$("#" + yearId).append("<div id=" + yearData.year + "-" + j + " class='season-div'><div class='season-title'>" + season.type + "</div></div>");
			var videoInfo = season.videoInfo;
			var typeId = yearData.year + "-" + j;
			/* 此处加载渲染数据 */
			for (k = 0, lenK = videoInfo.length; k < lenK; k++) {

				var video = videoInfo[k];
				var vm = $("#video-modile").html();
				vm = vm.replace(/{id}/g, video.video_id);

				if (video.video_broadcast_time != null) {
					vm = vm.replace(/{date}/g, getWeek(video.video_broadcast_time));
				} else {
					vm = vm.replace(/{date}/g, "");
				}
				if (video.video_name != null) {
					vm = vm.replace(/{name}/g, video.video_name);
				} else {
					vm = vm.replace(/{name}/g, "");
				}
				$("#" + typeId).append(vm);

				if (video.have_bd_resource === "1") {
					var blueObj = "<i class='layui-icon' style='color: #1E9FFF; position: absolute; top: 5px; left: 5px;'>&#xe643;</i>";
					$("#" + video.video_id).append(blueObj);
				}

				if (video.have_poster === "1") {
					var imgUrl = "/videoRecord/getPoster/" + video.video_id + "?t=t" + (new Date()).getTime().toString();

					var imgObj = "<img onload='setImgStyle(this)' id='img' onclick='enlargeImg(this)' style='display: none;' src='" + imgUrl + "'>"
					$("#video-poster-" + video.video_id).html(imgObj);

					var imgHide = "<img id='img' src='" + imgUrl + "'>";
					$("#video-poster-hide-" + video.video_id).html(imgHide);
				} else {
					$("#video-poster-" + video.video_id).html("暂无图片");
					$("#video-poster-hide-" + video.video_id).html("");
				}

			}
			if (j != lenJ - 1) {
				$("#" + typeId).append("<hr class='layui-bg-blue' />");
			}
		}
		if (i != len - 1) {
			$("#" + typeId).append("<hr class='layui-bg-green' />");
		}
	}

	$(".edit-div").click(function(event) {
		event.stopPropagation();// 取消事件冒泡
		$(this).parent().find(".edit-list").slideToggle(200); // 按钮的toggle,如果div是可见的,点击按钮切换为隐藏的;如果是隐藏的,切换为可见的。
		var thisId = $(this).parent().find(".edit-list").attr("id");
		$(".edit-list").each(function() {
			if ($(this).attr("id") != thisId) {
				$(this).slideUp(200);
			}
		});
		return false;
	});
}

function clickVideoTypeButton(vtt) {
	$(vtt).addClass('video-type-tab-this');
	$(vtt).siblings().removeClass('video-type-tab-this');
	$("#videoType").val($(vtt).attr("id"));
}

function detail(id) {
	var videoType = getVideoType();
	var url = videoType + "/" + videoType + "Detail.html?video_id=" + id + "&t=" + (new Date()).getTime().toString();
	// iframe层 parent.
	layer.open({
		type : 2,
		title : '资源详情',
		shadeClose : true,
		maxmin : true,
		shade : [ 0.3, '#333' ],
		offset : '10px',
		area : [ '1200px', '90%' ],
		anim : 5,
		isOutAnim : false,
		content : url
	});

}

function editVideo(div, id) {
	var videoType = getVideoType();
	var url = videoType + "/" + videoType + "Edit.html?video_id=" + id + "&t=" + (new Date()).getTime().toString();
	$(div).parent().slideUp(200);// 滑动消失
	// iframe层parent.
	layer.open({
		type : 2,
		title : '资源编辑',
		shadeClose : false,
		maxmin : true,
		shade : [ 0.3, '#333' ],
		area : [ '1200px', '90%' ],
		anim : 5,
		isOutAnim : false,
		content : url
	});
}

function deleteVideo(div, id, name) {
	$(div).parent().slideUp(200); // 滑动
	// 询问框parent.
	layer.confirm('确认删除记录：' + name, {
		offset : '200px',
		btn : [ '确定', '取消' ]
	}, function(confirmIndex) {
		var url = "/videoRecord/delVideo";
		var method = "POST";
		var data = {
			video_id : id
		};
		sendRequest(url, method, data, function(resp) {
			layer.close(confirmIndex);
			if (resp.data == 1) {
				layer.alert("删除成功！！！", {
					offset : '200px'
				}, function(index) {
					layer.close(index);
					// 刷新
					callBackSearch();
				});
			} else {
				layer.alert("删除失败！！！", {
					offset : '200px'
				});
			}
		});
	});
}

function getVideoType() {
	var videoType = $("#videoTypeHide").val();
	var x;
	switch (videoType) {
	case "动画":
		x = "animation";
		break;
	case "番剧":
		x = "drama";
		break;
	case "电影":
		x = "movie";
		break;
	case "记录片":
		x = "documentary";
		break;
	case "网络视频":
		x = "netvideo";
		break;
	}
	return x;
}