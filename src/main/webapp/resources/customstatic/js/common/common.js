    //获取表单数据为json对象
	    (function ($) {
	        $.fn.serializeJson = function () {
	            var serializeObj = {};
	            $(this.serializeArray()).each(function () {
	                serializeObj[this.name] = this.value;
	            });
	            return serializeObj;
	        };
	        console.log("自调用方法获取表单的对象");
	        //使用方法  
	        //	fromData = $('#表单id').serializeJson();// 调用serializeJson方法获取表单内容,自定义方法
	    })(jQuery)

	//添加查询时，添加当前页数为1的条件,,全局配置查询
	$(function () {
		$("#query_base_show").click(function () {
			console.log("=========动态添加pageCurrent=================");
			$("form").prepend("  <input type='hidden' name='pageCurrent' value='1'/>");
		})

		//点击清空表单内容，清空所有的内容
		$(".reset").click(function () {
			$(this).siblings("input").each(function(){
				this.value = "";//也可以清空数据this.value ="";
			});
		})
	});

	var onclickLongTime = 0;               //时间变量，不能删除

	/**
	 *  判断是否要发出 服务器请求
	 * @returns {boolean}       true 是，，false 否
	 *
	 * 使用案例：
	 * if (!validataOnclickIsOverTime()){
            return;
        }
	 */
	function validataOnclickIsOverTime() {
		var nowDate = new Date();
		if (onclickLongTime == 0){
			onclickLongTime = nowDate;
			return true;
		}else {
			if ((nowDate - onclickLongTime) < 1500){
				console.log("点击太频繁， 不做处理");
				onclickLongTime = nowDate;
				return false;
			}else{
				onclickLongTime = nowDate;
				return true;
			}
		}
	}