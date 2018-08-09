function resourceDel(resourceId) {
	$("#" + resourceId).slideUp(200, function() {
		$("#" + resourceId).remove();
	});
}

function setEpisode(episode) {
	$("#video_episode").val(episode);
}

function clickVideoTypeButton(vtt) {
	var pitchId;
	$("#video_type_item").children().each(function() {
		if ($(this).hasClass("video-type-tab-this")) {
			pitchId = $(this).attr("id");
		}
	});
	if (pitchId !== $(vtt).attr("id")) {
		$(vtt).addClass('video-type-tab-this');
		$(vtt).siblings().removeClass('video-type-tab-this');
		$("#videoType").val($(vtt).attr("id"));
		setAddInfo(300);// 设置 添加数据
	} else {
		console.log("已选中，无操作");
	}
}

function changeEp(type) {
	var ep = $("#video_episode").val() * 1;
	if (isIntNum(ep)) {
		if (type == 'add') {
			$("#video_episode").val(ep + 1);
		} else if (type = 'minus') {
			if (ep - 1 > 0) {
				$("#video_episode").val(ep - 1);
			}
		}
	}
}

function isIntNum(val) {
	var regPos = /^[0-9]+.?[0-9]*$/;
	var regNeg = /^[1-9]+[0-9]*]*$/; // 正整数
	if (regPos.test(val) || regNeg.test(val)) {
		return true;
	} else {
		return false;
	}
}

function setAddInfo(second) {
	var videoType = $("#videoType").val();
	switch (videoType) {
	case "动画":
		$("#countryDiv").hide();
		$("#dramaSeasonDiv").hide();
		$("#countryBtnDiv").hide();

		$(".ep-btn").each(function() {
			if ($(this).hasClass("animEp")) {
				$(this).removeClass("display-none");
			} else {
				$(this).addClass("display-none");
			}
		});

		$("#animationSeasonDiv").css("display", "inline-block");
		$("#episodeDiv").css("display", "inline-block");
		$("#episodeOptionDiv").css("display", "inline-block");
		$("#sourceDiv").css("display", "inline-block");
		$("#video_episode").val(12);
		break;
	case "番剧":
		$("#country").val("日本");
		$("#animationSeasonDiv").hide();
		$("#sourceDiv").hide();
		$("#countryBtnDiv").hide();

		$("#countryDiv").css("display", "inline-block");
		$("#dramaSeasonDiv").css("display", "inline-block");
		$("#episodeDiv").css("display", "inline-block");
		$("#episodeOptionDiv").css("display", "inline-block");

		$(".ep-btn").each(function() {
			if ($(this).hasClass("dramaEp")) {
				$(this).removeClass("display-none");
			} else {
				$(this).addClass("display-none");
			}
		});
		$("#video_episode").val(8);
		break;
	case "电影":
		$("#country").val("日本");
		$("#dramaSeasonDiv").hide();
		$("#animationSeasonDiv").hide();
		$("#episodeDiv").hide();
		$("#sourceDiv").hide();
		$("#episodeOptionDiv").hide();

		$("#countryDiv").css("display", "inline-block");
		$("#countryBtnDiv").css("display", "inline-block");

		break;
	case "记录片":
		$("#country").val("日本");
		$("#dramaSeasonDiv").hide();
		$("#animationSeasonDiv").hide();
		$("#sourceDiv").hide();

		$("#episodeDiv").css("display", "inline-block");
		$("#episodeOptionDiv").css("display", "inline-block");
		$("#countryDiv").css("display", "inline-block");
		$("#countryBtnDiv").css("display", "inline-block");

		$(".ep-btn").each(function() {
			if ($(this).hasClass("docuEp")) {
				$(this).removeClass("display-none");
			} else {
				$(this).addClass("display-none");
			}
		});
		$("#video_episode").val(1);
		break;
	case "网络视频":
		$("#country").val("中国");
		$("#dramaSeasonDiv").hide();
		$("#animationSeasonDiv").hide();
		$("#sourceDiv").hide();

		$("#episodeOptionDiv").css("display", "inline-block");
		$("#episodeDiv").css("display", "inline-block");
		$("#countryDiv").css("display", "inline-block");
		$("#countryBtnDiv").css("display", "inline-block");

		$(".ep-btn").each(function() {
			if ($(this).hasClass("netEp")) {
				$(this).removeClass("display-none");
			} else {
				$(this).addClass("display-none");
			}
		});
		$("#video_episode").val(1);
		break;
	}
}
