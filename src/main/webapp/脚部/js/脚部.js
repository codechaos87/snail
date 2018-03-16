$(function(){
	$(".footerone a").hover(
		function(){
			$(this).css("color","#1428A0")
		},
		function(){
			$(this).css("color","#363636")
		}
	);
});
$(function(){
	$(".one_3 li a").hover(
		function(){
			var index = $(".one_3 li a").index(this);
			switch (index){
				case 0:
					$(".one_3 li:eq("+index+")").css("backgroundImage","url(../img/weixin2.jpg)");
					break;
				case 1:
					$(".one_3 li:eq("+index+")").css("backgroundImage","url(../img/weibo2.jpg)");
					break;
				case 2:
					$(".one_3 li:eq("+index+")").css("backgroundImage","url(../img/tenxun2.jpg)");
					break;
				default:
					break;
			}
		},
		function(){
			var index = $(".one_3 li a").index(this);
			switch (index){
				case 0:
					$(".one_3 li:eq("+index+")").css("backgroundImage","url(../img/weixin.jpg)");
					break;
				case 1:
					$(".one_3 li:eq("+index+")").css("backgroundImage","url(../img/weibo.jpg)");
					break;
				case 2:
					$(".one_3 li:eq("+index+")").css("backgroundImage","url(../img/tenxun.jpg)");
					break;
				default:
					break;
			}
		}
	);
});