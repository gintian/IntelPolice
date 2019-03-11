$(function () {
    start_time();
    end_time();
    save();
});
//获取辨认信息
function save() {
    var flag = false;

    if(flag){
        $('#save').addClass('disabled');
    }else{
        $('#save').removeClass('disabled');
    }
}
//获取开始时间
function start_time(){
    $('#start_time').click(function () {
        var time = new Date();
        var year = time.getFullYear()+'年';
        var month = time.getMonth()+1+'月';
        var date = time.getDate()+'日';
        // var day = '星期'+time.getDay();
        var hour = time.getHours(); //获取当前小时数(0-23)
        var minute = time.getMinutes(); //获取当前分钟数(0-59)
        var second = time.getSeconds(); //获取当前秒数(0-59)
        var start = year+month+date+'  '+hour+':'+minute+':'+second;
        $('#record_start_time').val(start);
        $(this).attr('disabled','disabled');
    });
}

//获取结束时间
function end_time(){
    $('#end_time').click(function () {
        var time = new Date();
        var year = time.getFullYear()+'年';
        var month = time.getMonth()+1+'月';
        var date = time.getDate()+'日';
        // var day = '星期'+time.getDay();
        var hour = time.getHours(); //获取当前小时数(0-23)
        var minute = time.getMinutes(); //获取当前分钟数(0-59)
        var second = time.getSeconds(); //获取当前秒数(0-59)
        var end = year+month+date+'  '+hour+':'+minute+':'+second;
        $('#record_end_time').val(end);
        $(this).attr('disabled','disabled');
    });
}