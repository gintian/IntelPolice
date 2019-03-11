$(function () {
    //获取开始时间
    start_time();
    end_time();
    //点击添加问题
    btn_click();
    //点击删除问题
    delete_btn_click();
    //选择内容
    // choose();
    var flag = true;
    //获得form表单里的值
    $('#save').live('click',function (flag) {
        var question = $('#editor_table tr[class=question]');
        var answer = $('#editor_table tr[class=answer]');
        var $text = $('#editor_table tr[class=answer] textarea');
        $text.each(function () {
            var content = $(this).val();
            if(content === ""){
                alert('请填写完回答！');
                flag = false
            }else{
                flag = true;
            }
            return flag;
        });

        if(flag === true){
            var question_content = [];
            question.each(function (i) {
                question_content[i] = $(this).text();
                return question_content;
            });
            var answer_content = [];
            answer.each(function (i) {
                answer_content[i] = $(this).text()+$(this).find('td textarea').val();
                return answer_content;
            });
            for (var i=0;i<question_content.length;i++){
                console.log(question_content[i]+'\n'+answer_content[i]);
            }
        }
    });
    loop();
});
    // 笔录
function loop() {
    // var tr_q = $('<tr class="question"><th>问：</th><td>内容</td></tr>');
    // var tr_a = $('<tr class="answer"><th>答：</th><td><textarea class="required" name="record" id="" style="border: none;max-width: 560px;min-width: 560px;min-height: 45px;" cols="60" rows="1"></textarea></td></tr>');
    var data = {
        a:[
           {'name':'问','content':'内容'},
            {'name':'问','content':'内容2'}
        ]
    };
    $.each(data.a,function (i,j) {
        var tr_q = $('<tr class="question"><th>'+j.name+'</th><td>'+j.content+'</td></tr>');
        var tr_a = $('<tr class="answer"><th>答：</th><td><textarea class="required" name="record" id="" style="border: none;max-width: 560px;min-width: 560px;min-height: 45px;" cols="60" rows="1"></textarea></td></tr>');
        $('#editor_table tbody').append(tr_q).append(tr_a);
    });
}




    // 添加按钮
        $('<input type="button" value="添加">').appendTo('#menu_right_info li')
            .attr('class','btn btn-info').css('float','right');
        var button = $('#menu_right_info li input:button');

        for(var i=0;i<5;i++){
            button.attr('id','add_'+i);
        }

    //添加提问
    function  btn_click(){
        button.live('click',function () {
            var li_content = $(this).parent();
            // var tr = $('<tr class="question"><th>问：</th><td>'+li_content.text()+'</td></tr><tr class="answer">');
            // var tr_btn = tr.append('<td><input class="btn btn-danger" type="button" value="删除"></td>');
            // console.log(tr_btn.html());
            //
            // $(tr_btn.html()+'<th>答：</th><td><textarea class="required" name="record" id="" style="border: none;max-width: 560px;min-width: 560px;min-height: 45px;" cols="60" rows="1"></textarea></td></tr>')
            //     .appendTo($('table[id=editor_table] tbody'));
            $('<tr class="question"><th>问：</th><td>'+li_content.text()+'</td><td><input class="btn btn-danger" type="button" value="删除"></td></tr><tr class="answer">' +
                '<th>答：</th><td><textarea class="required" name="record" id="" style="border: none;max-width: 560px;min-width: 560px;min-height: 45px;" cols="60" rows="1"></textarea></td></tr>')
                .appendTo($('table[id=editor_table] tbody'));
        });
    }

    //删除提问
    function delete_btn_click() {
        var delete_btn = $('tr[class=question] input:button');
        delete_btn.live('click',function () {
            $(this).parent().parent().addClass('delete');
            $(this).parent().parent().next().addClass('delete');
            $('tr[class$=delete]').remove();
        });
    }




//获取开始时间
    function start_time(){
        $('#start_time').live('click',function () {
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
        $('#end_time').live('click',function () {
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

    //点击添加问题与回答模板
    // function btn_click(){
    //     var conAdded = $("#editor_table tr");//已添加的内容
    //
    //     $('#btn_add_answer').click(function () {
    //         conAdded.remove();
    //         function  init() {
    //             var content_li = $('#menu_right_info ul li[class=cur]');
    //             var select_iClass_data = [];
    //             var select_conText_data = [];
    //             content_li.each(function (i) {
    //                 $('<tr class="question"><th>问：</th>' +
    //                     '<td></td></tr><tr class="answer">' +
    //                     '<th>答：</th><td><textarea class="required" name="record" id="" style="border: none;max-width: 560px;min-width: 560px;min-height: 45px;" cols="60" rows="1"></textarea></td></tr>')
    //                     .prependTo($('table[id=editor_table] tbody'));
    //
    //                 $('table[id=editor_table] tbody tr[class=question] td')
    //                     .append($(this).html()).addClass('action');
    //
    //                 select_iClass_data.push($('td[class=action]').attr("class"));
    //                 select_conText_data.push($(this).text());
                    // console.log(select_conText_data);
                // });
                // content_li.each(function () {
                //     $('table[id=editor_table] tbody tr[class=question] td:gt(0)')
                //         .append($(this).html()).addClass('action');
                //
                // });
                // var has_data = [];
                // $('tr[class=question] td').each(function () {
                //     has_data.push($(this).text());
                // });
                // var new_has_data = has_data.split('-');
                // var result = [];
                // for (var i in new_has_data){
                //     if($.inArray(new_has_data[i],result) === -1){
                //         result.push(new_has_data[i]);
                //     }
                // }
                // 去掉重复选择的数据
                // function test(a,b) {
                //     var c = [];
                //     var tmp = a.concat(b);
                //     var o = {};
                //     for (var i = 0; i < tmp.length; i ++) (tmp[i] in o) ? o[tmp[i]] ++ : o[tmp[i]] = 1;
                //     for (var x in o) if (o[x] == 1) c.push(x);
                //     return c;
                // }
                // console.log(test(result,select_conText_data));
                // var new_result = result.filter(s => $.trim(s).length > 0);
                // var new_class = $.unique(select_iClass_data);
                // var new_context = $.unique(select_conText_data);
                // console.log(new_context);
                //将遍历数组循环存入到选中的内容数组中
    //             var hasCon_html= '';
    //             var selected_data = [];
    //             var has_class = [];
    //             for(var i=0; i<test(has_class,select_iClass_data).length; i++){
    //                 // var select_i_class = new_result[i];
    //                 var new_class = test(has_class,select_iClass_data)[i];
    //                 var new_content = test(has_data,select_conText_data)[i];
    //                 var select_attr ={"iClass": new_class, "conText":new_content};
    //                 selected_data.push(select_attr);
    //             };
    //             console.log(test(result,has_data));
    //             for(var j =0; j<selected_data.length; j++){
    //                 var hasObj = selected_data[j];
    //                 hasCon_html += "<td>";
    //                 hasCon_html += hasObj.conText;
    //                 hasCon_html += "</td>";
    //             };
    //             return hasCon_html;
    //         }
    //
    //         $('#editor_table tr').remove();
    //         $('tr[class=question] th').after(init());
    //     });
    // }

    //选择内容
    // function choose(){
    //     var li = $('#menu_right_info ul li');
    //     li.click(function () {
    //         if($(this).hasClass("cur")){
    //             $(this).removeClass("cur");
    //         }else {
    //             $(this).addClass("cur");
    //         }
    //     });
    // }

// li.click(function () {
// question.each(function (index) {
// $('#editor_table tbody').append($(this).prop('outerHTML'));
// $('#editor_table tbody>li').wrap('<tr class="question">').wrap('<td>');
// $('#editor_table tbody li').css({'background-color':'#FFF','list-style':'none'});
// $('<th>问：</th>').prependTo($('tbody tr.question'));
// $('#editor_table tbody tr[class=question]')
//     .after($('<tr class="answer"><th>答：</th><td><textarea class="required" name="record" id="" style="border: none;max-width: 560px;min-width: 560px;min-height: 45px;" cols="60" rows="1"></textarea></td></tr>'));
// });
// $('#editor_table tbody tr[class=answer]').eq(0).remove();
// $('#editor_table tbody>tr.question th').siblings().remove();

// });