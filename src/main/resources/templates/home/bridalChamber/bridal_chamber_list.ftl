<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <title>楼盘列表</title>
    <link rel="stylesheet" href="/home/bridalChamber/css/listsite.css">
    <link rel="stylesheet" href="/home/bridalChamber/css/list.css">
    <link rel="stylesheet" href="/home/layui/layui/css/layui.css">
</head>
<body>
<header class="new-header">
    <#include "../common/header.ftl"/>
</header>
<!-- 主导航栏 -->
<div class="main-nav-container">
    <div class="main-nav">
        <div class="main-left-wrapper">

            <a class="s-city" data-xftrack="10124" title="选择城市">选择城市</a>

            <div class="city-change animated" id="cityDiv">
                <span class="city-close"></span>
                <div class="title">
                    选择城市
                    <span class="city-tab">
								<span class="code1">热门城市:</span>
								<a title="北京房产网">北京</a>
								<a title="上海房产网">上海</a>
								<a title="广州房产网">广州</a>
								<a title="深圳房产网">深圳</a>
							</span>
                </div>
                <div class="title-line"></div>
                <div class="fc-main clear">
                    <div class="fl citys-l">
                        <ul>
                            <li class="clear"><span class="code-title fl">B</span>
                                <div class="city-enum fl">
                                    <a title="保定">保定</a>
                                    <a title="北海">北海</a>
                                    <a title="保亭">保亭</a>
                                    <a title="北京">北京</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">C</span>
                                <div class="city-enum fl">
                                    <a title="长春">长春</a>
                                    <a title="滁州">滁州</a>
                                    <a title="长沙">长沙</a>
                                    <a title="澄迈">澄迈</a>
                                    <a title="重庆">重庆</a>
                                    <a title="成都">成都</a>
                                    <a title="赤峰"> 赤峰</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">D</span>
                                <div class="city-enum fl">
                                    <a title="">大连</a>
                                    <a title="东莞">东莞</a>
                                    <a title="儋州">儋州</a>
                                    <a title="东方">东方</a>
                                    <a title="德阳">德阳</a>
                                    <a title="大理">大理</a>
                                </div>
                            </li>
                            <li class="clear">
                                <span class="code-title fl">E</span>
                                <div class="city-enum fl">
                                    <a title="鄂州">鄂州</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">F</span>
                                <div class="city-enum fl">
                                    <a title="佛山">佛山</a>
                                    <a title="防城港">防城港</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">G</span>
                                <div class="city-enum fl">
                                    <a title="广州">广州</a>
                                    <a title="桂林">桂林</a>
                                    <a title="贵阳">贵阳</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">H</span>
                                <div class="city-enum fl">
                                    <a title="呼和浩特">呼和浩特</a>
                                    <a title="杭州">杭州</a>
                                    <a title="湖州">湖州</a>
                                    <a title="合肥">合肥</a>
                                    <a title="黄石">黄石</a>
                                    <a title="惠州">惠州</a>
                                    <a title="海口">海口</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">J</span>
                                <div class="city-enum fl"><a href="//jz.fang.lianjia.com" title="晋中房产网">晋中</a>
                                    <a title="嘉兴">嘉兴</a>
                                    <a title="济南">济南</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">K</span>
                                <div class="city-enum fl"><a title="昆明">昆明</a></div>
                            </li>
                        </ul>
                        x`
                    </div>
                    <div class="fl citys-r">
                        <ul>
                            <li class="clear"><span class="code-title fl">L</span>
                                <div class="city-enum fl">
                                    <a title="廊坊">廊坊</a>
                                    <a title="临高">临高</a>
                                    <a title="乐东">乐东</a>
                                    <a title="陵水">陵水</a>
                                    <a title="乐山">乐山</a></div>
                            </li>
                            <li class="clear"><span class="code-title fl">M</span>
                                <div class="city-enum fl"><a title="眉山">眉山</a></div>
                            </li>
                            <li class="clear"><span class="code-title fl">N</span>
                                <div class="city-enum fl">
                                    <a title="南京">南京</a>
                                    <a title="南通">南通</a>
                                    <a title="宁波">宁波</a>
                                    <a title="南昌">南昌</a>
                                    <a title="南宁">南宁</a></div>
                            </li>
                            <li class="clear"><span class="code-title fl">Q</span>
                                <div class="city-enum fl">
                                    <a title="秦皇岛">秦皇岛</a>
                                    <a title="泉州">泉州</a>
                                    <a title="青岛">青岛</a>
                                    <a title="清远">清远</a>
                                    <a title="琼海">琼海</a></div>
                            </li>
                            <li class="clear"><span class="code-title fl">S</span>
                                <div class="city-enum fl">
                                    <a title="石家庄">石家庄</a>
                                    <a title="沈阳">沈阳</a>
                                    <a title="上海">上海</a>
                                    <a title="苏州">苏州</a>
                                    <a title="绍兴">绍兴</a>
                                    <a title="三门峡">三门峡</a>
                                    <a title="深圳">深圳</a>
                                    <a title="三亚">三亚</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">T</span>
                                <div class="city-enum fl">
                                    <a title="天津">天津</a>
                                    <a title="太原">太原</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">W</span>
                                <div class="city-enum fl">
                                    <a title="无锡">无锡</a>
                                    <a title="威海">威海</a>
                                    <a title="武汉">武汉</a>
                                    <a title="五指山">五指山</a>
                                    <a title="文昌">文昌</a>
                                    <a title="万宁">万宁</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">X</span>
                                <div class="city-enum fl">
                                    <a title="徐州">徐州</a>
                                    <a title="厦门">厦门</a>
                                    <a title="襄阳">襄阳</a>
                                    <a title="西双版纳">西双版纳</a>
                                    <a title="西安">西安</a>
                                    <a title="咸阳">咸阳</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">Y</span>
                                <div class="city-enum fl">
                                    <a title="烟台">烟台</a>
                                    <a title="宜昌">宜昌</a>
                                </div>
                            </li>
                            <li class="clear"><span class="code-title fl">Z</span>
                                <div class="city-enum fl">
                                    <a title="张家口">张家口</a>
                                    <a title="镇江">镇江</a>
                                    <a title="漳州">漳州</a>
                                    <a title="郑州">郑州</a>
                                    <a title="珠海">珠海</a>
                                    <a title="中山">中山</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="overlayBg" style="display: none;"></div>

            <i class="vertical-split"></i>
            <div class="search-wrapper">
                <input type="text" class="search" id="search-input" placeholder="请输入楼盘名" autocomplete="off">
                <div class="search-button" onclick="selectNewHouseInfoListAjax()" id="search-button-select">
                    <i class="search-icon"></i>
                </div>
                <div class="search-result-wrapper"></div>

            </div>
        </div>
        <div class="main-right-wrapper post_ulog_exposure_scroll" data-ulog-exposure="xinfangpc_show=20091">
            <a href="/home/index/bridalChamberIndex" class="main-nav-item" title="首页" data-xftrack="20099"
               data-other-action="1">首页</a>
            <a href="/home/index/bridalChamberList" class="main-nav-item on" title="楼盘" data-xftrack="20099"
               data-other-action="2">楼盘</a>
        </div>
    </div>
</div>

<div class="price-area-container">
    <div class="price-wrapper">
        <div class="price-nav">
            <span class="total-price-nav">按均价<i>(元/平)</i></span>
        </div>
        <div class="drag-brush total-price">

            <div class="slid-container">
                <div id="slideTest9" class="demo-slider"></div>
            </div>

            <div class="number-reflect">
                <span class="desc">拖动按钮选择购房售价</span>
                <input type="text" class="min-value money" readonly="readonly" style="width: 60px;" value="1"
                       placeholder="">
                <span class="division">~</span>
                <input type="text" class="max-value money" readonly="readonly" style="width: 60px;" value="500000"
                       placeholder="">

            </div>
        </div>


    </div>


    <div class="area-wrapper">
        <div class="area-title">
            <span class="area-desc">面积</span>
            <span class="unit">(平)</span>
        </div>
        <div class="drag-brush area-drag-brush">

            <div class="slid-container">
                <div id="slideTest8" class="demo-slider"></div>
            </div>

            <div class="number-reflect">
                <span class="desc">拖动按钮选择建成面积</span>
                <input type="text" class="min-value builtUpArea" value="1" readonly="readonly" placeholder="">
                <span class="division">~</span>
                <input type="text" class="max-value builtUpArea" value="100000" readonly="readonly" placeholder="">
            </div>
        </div>
    </div>

</div>


<!-- 楼盘列表 -->
<div class="resblock-list-container clearfix">
    <div class="resblock-list-nav-wrapper">
        <ul class="nav-list">

            <!-- 开盘时间开始 -->
            <li class="nav-list-item open-time-nav">
                <div class="title-wrapper">
                    <span class="title">开盘时间</span>
                    <i class="icon"></i>
                </div>
                <div class="checkbox-wrapper openingTimes">
                    <ul class="check-box">
                        <#list openingTimes as openingTime>
                            <li class="check-item" data-value="${openingTime.getCode()}">
                                <i class="icon"></i>
                                <span class="desc">${openingTime.getName()}</span>
                                <span class="number"></span>
                            </li>
                        </#list>
                    </ul>
                    <div class="option">
                        <span class="clear-option">清空</span>
                        <span class="sure">确定</span>
                    </div>
                </div>
            </li>
            <!-- 开盘时间结束 -->

            <!-- 物业类型开始 -->
            <li class="nav-list-item type-nav">
                <div class="title-wrapper">
                    <span class="title">物业类型</span>
                    <i class="icon"></i>
                </div>
                <div class="checkbox-wrapper propertyTypes">
                    <ul class="check-box">
                        <#list propertyTypes as propertyType>
                            <li class="check-item" data-value="${propertyType.getCode()}">
                                <i class="icon"></i>
                                <span class="desc">${propertyType.getName()}</span>
                                <span class="number"></span>
                            </li>
                        </#list>
                    </ul>
                    <div class="option">
                        <span class="clear-option">清空</span>
                        <span class="sure">确定</span>
                    </div>
                </div>
            </li>
            <!-- 物业类型结束 -->

            <!-- 售卖状态开始 -->
            <li class="nav-list-item sell-nav">
                <div class="title-wrapper">
                    <span class="title">售卖状态</span>
                    <i class="icon"></i>
                </div>
                <div class="checkbox-wrapper sellingTheStates">
                    <ul class="check-box">
                        <#list sellingTheStates as sellingTheState>
                            <li class="check-item" data-value="${sellingTheState.getCode()}">
                                <i class="icon"></i>
                                <span class="desc">${sellingTheState.getName()}</span>
                                <span class="number"></span>
                            </li>
                        </#list>
                    </ul>
                    <div class="option">
                        <span class="clear-option">清空</span>
                        <span class="sure">确定</span>
                    </div>
                </div>
            </li>
            <!-- 售卖状态结束 -->

            <!-- 装修状况开始 -->
            <li class="nav-list-item decorate-nav">
                <div class="title-wrapper">
                    <span class="title">装修状况</span>
                    <i class="icon"></i>
                </div>
                <div class="checkbox-wrapper decorateStates">
                    <ul class="check-box">
                        <#list decorateStates as decorateState>
                            <li class="check-item" data-value="${decorateState.getCode()}">
                                <i class="icon"></i>
                                <span class="desc">${decorateState.getName()}</span>
                                <span class="number"></span>
                            </li>
                        </#list>
                    </ul>
                    <div class="option">
                        <span class="clear-option">清空</span>
                        <span class="sure">确定</span>
                    </div>
                </div>
            </li>
            <!-- 装修状况结束 -->

        </ul>

        <a href="/home/index/bridalChamberList" class="clear-all" data-xftrack="10135"
           data-search-position="search_result">
            <i></i>
            <span>清空条件</span>
        </a>

    </div>
    <div class="resblock-have-find">
        <span>为您找到</span>
        <span class="value" id="totalNewHouseInfo"></span>
        <span>个新房</span>
    </div>
    <ul class="sort-list-wrapper">
        <li class="sort-list-item on default-sort" data-xftrack="10137_1" data-search-position="search_result">默认排序</li>

        <li class="sort-list-item up average-sort" data-search-position="search_result">
            <span class="desc">均价</span>
            <i></i>
        </li>
        <li class="sort-list-item down open-title-sort" data-search-position="search_result">
            <span class="desc">开盘时间</span>
            <i></i>
        </li>
    </ul>
    <div class="no-result-wrapper hide">
        <div class="noresult">
            <p class="noresult-title">没有符合条件的结果</p>
            <div class="result-want">
            </div>
        </div>
        <div class="do-you-like">猜你喜欢</div>
    </div>

    <ul class="resblock-list-wrapper" id="resblock-list-wrapper-new-house-info">

    </ul>
    <div id="page"></div>


</div>

<!-- footer -->


<!-- bottom banner -->
<div class="list-bottom-banner-wrap">

    <div class="phone-banner-wrap">
        <div class="block-banner-bg-color">
            <div class="block-banner-wrap">
                <img src="" class="banner-bg-img"/>
                <div class="block-banner-content">
                    <input type="button" value="" class="banner-close-btn">
                    <div class="phone-collect-wrap">
                        <label class="label" for="banner-phone-input">想不想买到独家优惠的心仪好房？</label>
                        <div class="input-wrap">
                            <div class="input-and-clear">
                                <input type="tel" placeholder="请输入手机号" id="banner-phone-input"
                                       class="banner-phone-input" maxlength="11">
                                <input type="button" class="phone-clear-btn">
                            </div>
                            <input type="button" value="预约咨询" class="phone-confirm-btn post_ulog_exposure_scroll"
                                   data-ulog-exposure="xinfangpc_show=20095"
                                   data-xftrack="20109">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="page-padding-placeholder" style="opacity: 0">
            <img src="" class="banner-bg-img"/>
        </div>


        <div class="side-float-btn post_ulog_exposure_scroll" data-ulog-exposure="xinfangpc_show=20096"
             data-xftrack="20110"></div>
    </div>

    <div class="link-banner-wrap">
        <div class="block-banner-bg-color" target="_blank">
            <a class="block-banner-wrap">
                <img src="" alt="" class="banner-bg-img">
                <input type="button" value="" class="banner-close-btn">
            </a>
        </div>
        <div class="page-padding-placeholder" style="opacity: 0">
            <img src="" alt="" class="banner-bg-img">
        </div>
        <div class="side-float-btn post_ulog_exposure_scroll" data-ulog-exposure="xinfangpc_show=20098"
             data-xftrack="20112">
            <img src="" alt="" class="side-btn-bg">
        </div>
    </div>
</div>
<#include "../common/footer.ftl">
<script src="/home/layui/layui/layui.js"></script>
<script src="/home/bridalChamber/js/list/jquery.min.js"></script>
<script src="/home/bridalChamber/js/list/ejs.min.js"></script>
<script src="/home/bridalChamber/js/list/common.js"></script>
<script src="/home/bridalChamber/js/list/template-ejs.js"></script>
<script src="/home/bridalChamber/js/list/agent-sj-sdk.js"></script>
<script>
    $('.layui-slider-tips').css('color', "red")
    layui.use('slider', function () {
        var slider = layui.slider;
        slider.render({
            elem: '#slideTest9',
            value: 40,
            range: true,
            tips: true,
            value: [1, 500000],
            max: 500000
            , change: function (vals) {
                $('.min-value.money').val(vals[0]);
                $('.max-value.money').val(vals[1]);
                selectNewHouseInfoListAjax()
            }
        });

        slider.render({
            elem: '#slideTest8',
            value: 40,
            range: true,
            tips: true,
            value: [1, 100000],
            max: 100000
            , change: function (vals) {
                $('.min-value.builtUpArea').val(vals[0]);
                $('.max-value.builtUpArea').val(vals[1]);
                selectNewHouseInfoListAjax()
            }
        });


    })

</script>
<script type="text/javascript">
    var __city__id = '310000';
</script>
<script src="/home/bridalChamber/js/list/captcha.js"></script>
<script src="/home/bridalChamber/js/list/index.js"></script>
<div style="display:none">

</div><!-- lianjia ulog -->
<div style="display:none">
    <script type="text/javascript">
        window.__UDL_CONFIG = {
            'cid': '310000',
            'f': document.referrer,
            'ljweb_channel_key': 'loupan_index',
            'sample_mark': '',
            'ucid': ''
        };
    </script>
    <div style="display:none">
        <script src="/home/bridalChamber/js/list/ljulog.js"></script>
    </div>
</div>
<link property='stylesheet' rel="stylesheet" href="/home/bridalChamber/css/lianjiaim.css"/>
<script src="/home/bridalChamber/js/list/lianjiaim1.1.min.js"></script>


<script>

    $(function () {
        selectNewHouseInfoListAjax();
    });

    $('#cityDiv a').click(function () {
        $(".city-close").click()
        $('.s-city').text($(this).text());
        selectNewHouseInfoListAjax();
    });

    $(document.body).on("click", ".nav-list .sure", function (t) {
        var e = $(this), n = e.closest(".nav-list-item").find(".check-item");
        Array.prototype.forEach.call(n, function (t, e) {
            $(t).hasClass("on") && $(t).addClass("checked")
        }), m = "", e.closest(".checkbox-wrapper").addClass("hide"), setTimeout(function () {
            e.closest(".checkbox-wrapper").removeClass("hide")
        }, 300);
        selectNewHouseInfoListAjax();
    })
    $(document.body).on("click", ".nav-list .clear-option", function (t) {
        $(this).closest(".checkbox-wrapper").find(".check-item").removeClass("on").removeClass("checked")
        selectNewHouseInfoListAjax();
    })
    $(document.body).on("click", ".sort-list-item", function (t) {
        var e = $(this);
        e.hasClass("average-sort") || e.hasClass("open-title-sort") ? e.hasClass("on") ? e.hasClass("up") ? (e.removeClass("up").addClass("down"), e.hasClass("average-sort") ? window.$ULOG.send("10179", {action: {xinfangpc_click: "10137_2"}}) : window.$ULOG.send("10179", {action: {xinfangpc_click: "10137_4"}})) : (e.removeClass("down").addClass("up"), e.hasClass("average-sort") ? window.$ULOG.send("10179", {action: {xinfangpc_click: "10137_3"}}) : window.$ULOG.send("10179", {action: {xinfangpc_click: "10137_5"}})) : (e.addClass("on").siblings().removeClass("on"), e.hasClass("down") ? e.hasClass("average-sort") ? window.$ULOG.send("10179", {action: {xinfangpc_click: "10137_2"}}) : window.$ULOG.send("10179", {action: {xinfangpc_click: "10137_4"}}) : e.hasClass("average-sort") ? window.$ULOG.send("10179", {action: {xinfangpc_click: "10137_3"}}) : window.$ULOG.send("10179", {action: {xinfangpc_click: "10137_5"}})) : e.hasClass("on") || e.addClass("on").siblings().removeClass("on")
        selectNewHouseInfoListAjax();
    })


    function selectNewHouseInfoListAjax(currentPage) {

        if (currentPage == undefined) {
            currentPage = 1;
        }

        let average_price_sort;
        let latest_opening_hours_sort;
        let decorateStates_check_items_arr = [];
        let openingTimes_check_items_arr = [];
        let propertyTypes_check_items_arr = [];
        let sellingTheStates_check_items_arr = [];


        let decorateStates_check_items = $(".checkbox-wrapper.decorateStates").find(".checked");
        let openingTimes_check_items = $(".checkbox-wrapper.openingTimes").find(".checked");
        let propertyTypes_check_items = $(".checkbox-wrapper.propertyTypes").find(".checked");
        let sellingTheStates_check_items = $(".checkbox-wrapper.sellingTheStates").find(".checked");
        let name = $("#search-input").val();

        if ($(".sort-list-item.open-title-sort.on.up").length > 0) {
            latest_opening_hours_sort = 1;
        }

        if ($(".sort-list-item.open-title-sort.on.down").length > 0) {
            latest_opening_hours_sort = 0;
        }

        if ($(".sort-list-item.average-sort.on.up").length > 0) {
            average_price_sort = 1;
        }

        if ($(".sort-list-item.average-sort.on.down").length > 0) {
            average_price_sort = 0;
        }

        let s_city = $(".s-city").text();

        let builtUpArea_min_value = $(".min-value.builtUpArea").val();
        let builtUpArea_max_value = $(".max-value.builtUpArea").val();
        let money_max_value = $(".max-value.money").val();
        let money_min_value = $(".min-value.money").val();

        for (var i = 0; i < decorateStates_check_items.length; i++) {
            decorateStates_check_items_arr.push($(decorateStates_check_items[i]).attr("data-value"))
        }
        for (var i = 0; i < openingTimes_check_items.length; i++) {
            openingTimes_check_items_arr.push($(openingTimes_check_items[i]).attr("data-value"))
        }
        for (var i = 0; i < propertyTypes_check_items.length; i++) {
            propertyTypes_check_items_arr.push($(propertyTypes_check_items[i]).attr("data-value"))
        }
        for (var i = 0; i < sellingTheStates_check_items.length; i++) {
            sellingTheStates_check_items_arr.push($(sellingTheStates_check_items[i]).attr("data-value"))
        }

        var data = JSON.stringify({
            decorateStateCodeList: decorateStates_check_items_arr,
            openingTimeCodeList: openingTimes_check_items_arr,
            propertyTypeCodeList: propertyTypes_check_items_arr,
            sellingTheStateCodeList: sellingTheStates_check_items_arr,
            builtUpAreaMinValue: builtUpArea_min_value,
            builtUpAreaMaxValue: builtUpArea_max_value,
            moneyMaxValue: money_max_value,
            moneyMinValue: money_min_value,
            city: s_city,
            latestOpeningHoursSort: latest_opening_hours_sort,
            averagePriceSort: average_price_sort,
            name: name
        });

        $.ajax({
            type: 'POST',
            url: '/home/homeNewHouseInfo/list?currentPage=' + currentPage,
            contentType: 'application/json;charset=utf-8',
            data: data,
            dataType: 'html',
            async: false,
            success: function (data) {
                $("#resblock-list-wrapper-new-house-info").html(data);
                $("#totalNewHouseInfo").text($('#newHouseInfoCount').val());

            }
        });

    }


</script>
</body>
</html>
