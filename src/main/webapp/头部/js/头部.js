$(function(){
	$(".hul1 li a").hover(
		function(){
			$(this).addClass("hulchange");
			$(this).css("color","#1428A0");
		},
		function(){
			$(this).removeClass("hulchange");
			$(this).css("color","#363636");
		}
		);
	$(".hul2 li a").hover(
		function(){
			$(this).addClass("hulchange");
			$(this).css("color","#1428A0");
		},
		function(){
			$(this).removeClass("hulchange");
			$(this).css("color","#363636");
		}
		);
		
});
$(function(){
	$(".xialafunc").mouseover(function(){
		var index = $(".xialafunc").index(this);
		$(".xiala:eq("+index+")").show();
	});
	$(".xialafunc").mouseout(function(){
		var index = $(".xialafunc").index(this);
		$(".xiala:eq("+index+")").hide();
	});
	$(".xiala").mouseover(function(){
		var index = $(".xiala").index(this);
		$(".xiala:eq("+index+")").show();
		$(".xialafunc:eq("+index+") a").addClass("hulchange");
		$(".xialafunc:eq("+index+") a").css("color","#1428A0");
	});
	$(".xiala").mouseout(function(){
		var index = $(".xiala").index(this);
		$(".xiala:eq("+index+")").hide();
		$(".xialafunc:eq("+index+") a").removeClass("hulchange");
		$(".xialafunc:eq("+index+") a").css("color","#363636");
	});
});
$(function(){
	$(".xialaclose").click(function(){
		var index = $(".xialaclose").index(this);
		$(".xiala:eq("+index+")").hide();
	});
});