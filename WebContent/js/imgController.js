/**
 * 放大图片
 */
function enlargeImg(img) {
	var div = $(img).parent().next();
	var w = $(window).width();
	var h = $(window).height();

	// 获取浏览器可用高度*0.95，为遮罩层留出空间
	w = w * 0.95;
	h = h * 0.95;
	var image = new Image();
	image.src = img.src;
	var arr = clacImgZoomParam(w, h, image.width, image.height);// 计算弹出的图片的大小

	// 调整弹出的图片的大小
	div.children("img").css("width", arr.width);// img.width = rect.width;
	div.children("img").css("height", arr.height);// img.height = rect.height;

	layer.open({
		type : 1,
		title : false,
		closeBtn : 1,
		shade : [ 0.6, '#fff' ],
		area : [ arr.width + "px", arr.height + "px" ],
		skin : 'layui-layer-nobg', // 没有背景色
		shadeClose : true,
		content : div.html()
	});

}

// 图片上传插件
function inputClick(div) {
	$(div).parent().find('input').click();
}
// 图片上传插件
function previewImage(file) {
	var div = $(file).prev();// 当前元素前一个兄弟节点
	var MAXWIDTH = div.css('width').replace("px", "") * 1;
	var MAXHEIGHT = div.css('height').replace("px", "") * 1;
	var imgFlag = $("#previewImg").val();

	if (imgFlag == "" || imgFlag == null) {
		var imgId = $(file).parent().find('div').find('img').attr('id');
		$(file).parent().find('div').html("");
		$(file).parent().find('div').html("上传图片");
		$("#img_del").css("display", "none");
		// var img = document.getElementById(imgId);
		// var imgUrl = "../../img/photo_icon.png";
		// img.src = imgUrl;
		// img.width = MAXWIDTH;
		// img.height = MAXHEIGHT;
		// img.style.marginLeft = '0px';
		// img.style.marginTop = '0px';
	} else {
		if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG|BMP|bmp)$/.test(imgFlag)) {
			layer.alert("图片类型必须是jpeg,jpg,png,gif中的一种", {
				offset : '100px',
				title : '图片格式不正确'
			})
			return false;
		}

		var div = $(file).parent().find('div');// document.getElementById('preview');
		if (file.files && file.files[0]) {

			var myData = new Date();
			var times = myData.getTime();// 当前时间的毫秒数
			div.html('');
			div.html('<img id="' + times + '" width=0 height=0 >');// div.innerHTML

			// 设定img的长宽
			var img = document.getElementById(times);
			img.onload = function() {
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.naturalWidth, img.naturalHeight);// 图片原始大小
				img.width = rect.width;
				img.height = rect.height;
				img.style.marginLeft = rect.left + 'px';
				img.style.marginTop = rect.top + 'px';
				img.style.display = 'block';
				if (MAXWIDTH == rect.width && MAXHEIGHT == rect.height) {
					img.setAttribute("style", "border-radius:4px;vertical-align:middle;");
				}
				$("#img_del").css("display", "bolck");
			}
			var reader = new FileReader();
			if (window.FileReader) {
				reader.onload = function(evt) {
					img.src = evt.target.result;
				}
				reader.readAsDataURL(file.files[0]);
			} else {
				var msg = "不支持您当前使用的浏览器的图片预览!请用最新版本的Firefox，chrome或其他主流浏览器（IE除外！）";
				layer.alert(msg, {
					offset : '100px',
					title : '提示'
				});
			}
		}
	}

	// 存在元素，则重置图片状态为有改动
	if (document.getElementById("posterUpdateFlag")) {
		$("#posterUpdateFlag").val("1");// 图片有变动
	}
}

function deleteImg(i) {
	$(i).next().find('img').remove();
	$(i).next().html("上传图片");
	$(i).css("display", "none")
	var obj = document.getElementById('previewImg');
	obj.outerHTML = obj.outerHTML;
	// 存在元素，则重置图片状态为有改动
	if (document.getElementById("posterUpdateFlag")) {
		$("#posterUpdateFlag").val("1");// 图片有变动
	}
}

// 图片上传插件
function clacImgZoomParam(maxWidth, maxHeight, width, height) {
	var param = {
		top : 0,
		left : 0,
		width : width,
		height : height
	};
	if (width > maxWidth || height > maxHeight) {
		rateWidth = width / maxWidth;
		rateHeight = height / maxHeight;

		if (rateWidth > rateHeight) {
			param.width = maxWidth;
			param.height = Math.round(height / rateWidth);
		} else {
			param.width = Math.round(width / rateHeight);
			param.height = maxHeight;
		}
	}
	param.left = Math.round((maxWidth - param.width) / 2);
	param.top = Math.round((maxHeight - param.height) / 2);
	return param;
}

/**
 * 重置图片大小
 */
function setImgStyle(img) {
	var image = new Image();
	image.src = $(img).attr("src");
	if (img.width > 0 && img.height > 0) {
		var div = $(img).parent();// document.getElementById('preview');
		var MAXWIDTH = $(img).parent().css('width').replace("px", "") * 1;
		var MAXHEIGHT = $(img).parent().css('height').replace("px", "") * 1;
		var img = $(img);// document.getElementById('imghead');
		var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, image.width, image.height);

		if (rect.width == MAXWIDTH && rect.height == MAXHEIGHT) {
			img.css("border-radius", "4px");// 若图片撑满div则设为圆角
		}
		img.css("width", rect.width);// img.width = rect.width;
		img.css("height", rect.height);// img.height = rect.height;
		img.css("marginLeft", rect.left + 'px');// img.style.marginLeft=rect.left+'px';
		img.css("marginTop", rect.top + 'px');// img.style.marginTop=rect.top+'px';
		img.css("display", "block");// img.style.display = "block";
	}
}