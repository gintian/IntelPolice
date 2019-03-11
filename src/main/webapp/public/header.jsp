<%@ page language="java" pageEncoding="UTF-8" %>
<style>
    /* MP3 start */
    #mp3{height: 50px;
        overflow: hidden;
        font-size: 26px;
        line-height: 62px;
        background-image: -moz-linear-gradient(top, #f05e6f, #c9394a);
        background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #ccd0d8), color-stop(1, #6a6972));
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#8fa1ff', endColorstr='#f05e6f', GradientType=0);
        -moz-border-radius: 8px 8px 0 0;
        -webkit-border-radius: 8px 8px 0 0;
        border-radius: 8px 8px 0 0;
        color: #fff;
        position: relative;}
    #mp3 p {font-size: 18px;line-height: 25px;margin-left: auto;margin-right: auto;}
    /* MP3 end */
</style>
<div class="row-fluid" id="mp3">
    <div class="col-md-12">
        <audio controls="controls" style="float: right;height: 50px">
            <source type="audio/mp3" src=""/>
            <source type="audio/ogg" src=""/>
            <embed style="float: right;height: 50px" src="" />
        </audio>
        <p>现依法向你询问，你应当如实回答，对与案件无关的问题，你有拒绝回答的权利。
            你有要求办案人员或者公安机关负责人回避的权利，有陈述和申辩的权利。</p>
    </div>
</div>
