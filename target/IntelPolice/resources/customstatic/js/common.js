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