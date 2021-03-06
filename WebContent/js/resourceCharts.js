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
	} else {
		console.log("已选中，无操作");
	}
}
function search() {
	var url = "/videoRecord/getEchartsData/";
	var method = "POST";
	var data = $('#searchVideo').serializeJSON();// objectifyForm(new
	// $("#charts").children().remove();
	sendRequest(url, method, data, createChart);
}

function createChart(resp) {
	console.log(resp);
	var myChart = echarts.init(document.getElementById('charts'));
	myChart.title = '堆叠柱状图';

	var series = new Array();
	var yearList;
	for (var i = 0; i < resp.data.dataList.length; i++) {

		if (resp.data.dataList[i].key == 'year') {
			yearList = resp.data.dataList[i].arr;
		} else {
			if (resp.data.dataList[i].key == "冬番"
					|| resp.data.dataList[i].key == "春番"
					|| resp.data.dataList[i].key == "夏番"
					|| resp.data.dataList[i].key == "秋番") {

				series[i] = {
					name : resp.data.dataList[i].key,
					type : 'bar',
					stack : 'season',
					data : resp.data.dataList[i].arr
				}
			} else if (resp.data.dataList[i].key == "OVA/OAD"
					|| resp.data.dataList[i].key == "映画"
					|| resp.data.dataList[i].key == "特别篇"
					|| resp.data.dataList[i].key == "其他") {
				series[i] = {
					name : resp.data.dataList[i].key,
					type : 'bar',
					stack : 'sp',
					data : resp.data.dataList[i].arr
				}

			}
		}
	}

	option = {
		color : [ '#01AAED', '#5FB878', '#FFB800', '#FF5722', '#749f83',
				'#ca8622', '#bda29a', '#6e7074', '#546570', '#2F4056',
				'#c4ccd3' ],
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		legend : {
			data : resp.data.season
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			data : yearList
		} ],
		yAxis : [ {
			type : 'value'
		} ],
	};
	option.series = series;
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option, true);
}