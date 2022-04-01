<!DOCTYPE html>
<html>
<head>

    <title>租房</title>
    <link rel="stylesheet" href="/home/layui/layui/css/layui.css">
    <link rel="stylesheet" href="/home/rent_house/css/index.css">
    <link rel="stylesheet" href="/home/bridalChamber/css/listsite.css">
    <link rel="stylesheet" href="/home/rent_house/css/common.css">
    <link rel="stylesheet" href="/home/rent_house/css/lianjia.css">
    <link rel="stylesheet" href="/home/rent_house/css/lianjiaim.css">
    <link rel="stylesheet" href="/home/bridalChamber/css/list.css">


</head>

<body>

<!-- 载入低版本浏览器样式 -->
<style>
    .browser__low .browser__low--inner p {
        font-size: 20px;
        padding-bottom: 40px
    }

    .browser__low .browser__low--inner a {
        display: inline-block;
        color: #fff;
        background: #2ab78e;
        padding: 10px 6px
    }

</style>

<header class="new-header">
    <#include "../common/header.ftl"/>
</header>
<div class="wrapper">

    <div class="search__area">
        <!-- 租房导航 -->
        <div class="beike__nav">
            <img src="/admin/images/ylrc-logo.png" >
            <ul class="beike__nav--tab rentHouseWay">
                <li data-query="-1" class="strong">
                    <a class="cur" href="javascript:;">不限</a>
                </li>
            <#list rentHouseWayEnums as rentHouseWay>
                <li data-query="${rentHouseWay.getCode()}" class="">
                    <a class="" href="javascript:;">${rentHouseWay.getName()}</a>
                </li>
            </#list>
            </ul>

            <a class="s-city" data-xftrack="10124" id="queryCity" title="选择城市" data-query="" style="position: relative">选择城市</a>
            <div class="city-change animated bounceIn" id="cityDiv" style="display: none;">
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
        </div>
        <div class="search w1150">
            <div class="search__wrap" style="position: relative;">
                <input class="search__input fl" type="text" placeholder="请输入镇名或者小区名开始找房" id="search">
                <span class="search__button fl" data-el="button" id="searchBtn"></span>
                <div class="sug-search" style="display: none;"></div>
            </div>
        </div>
    </div>

    <!-- 筛选项 -->
    <div class="filter">

        <div class="filter__wrapper w1150" id="filter">

            <ul class="filter__ul price" data-el="filterPrice">
                <li class="filter__item--level5 filter__item--aside">
                    <a href="javascript:;" data-query="-1">租金</a>
                </li>
            <#list priceEnums as price>
                <li class="filter__item--level5 check ">
                    <a href="javascript:;" data-query="${price.getCode()}">${price.getName()}</a>
                </li>
            </#list>
            </ul>

            <ul class="filter__ul houseType">
                <li class="filter__item--level5 filter__item--aside">
                    <a href="javascript:;" data-query="-1">户型</a>
                </li>
                <#list houseTypeEnums as houseType>
                    <li class="filter__item--level5 check ">
                        <a href="javascript:;" data-query="${houseType.getCode()}">${houseType.getName()}</a>
                    </li>
                </#list>
            </ul>

            <ul class="filter__ul houseOrientation">
                <li class="filter__item--level5 filter__item--aside">
                    <a href="javascript:;" data-query="-1">朝向</a>
                </li>
                    <#list houseOrientationEnums as houseOrientation>
                         <li class="filter__item--level5 check ">
                             <a rel="nofollow" href="javascript:;" data-query="${houseOrientation.getCode()}">
                                 ${houseOrientation.getName()}
                             </a>
                         </li>
                    </#list>
            </ul>

            <ul class="filter__ul rentHouseFeatures">
                <li class="filter__item--level5 filter__item--aside">
                    <a href="javascript:;" data-query="-1">特色</a>
                </li>
                    <#list rentHouseFeaturesList as rentHouseFeatures>
                        <li class="filter__item--level5 check ">
                            <a rel="nofollow" data-query="${rentHouseFeatures.id}"
                               href="javascript:;">${rentHouseFeatures.name}</a>
                        </li>
                    </#list>
            </ul>

            <!--租期-->
            <ul class="filter__ul leaseType">
                <li class="filter__item--level5 filter__item--aside">
                    <a href="javascript:;" data-query="-1">租期</a>
                </li>
                <#list leaseTypeEnums as leaseType>
                    <li class="filter__item--level5 check ">
                        <a rel="nofollow" data-query="${leaseType.getCode()}"
                           href="javascript:;">${leaseType.getName()}</a>
                    </li>
                </#list>
            </ul>

            <ul class="filter__ul floorType">
                <li class="filter__item--level5 filter__item--aside">
                    <a href="javascript:;" data-query="-1">楼层</a>
                </li>
                <#list floorTypeEnums as floorType>
                    <li class="filter__item--level5 check ">
                        <a rel="nofollow" data-query="${floorType.getCode()}"
                           href="javascript:;">${floorType.getName()}</a>
                    </li>
                </#list>
            </ul>

            <ul class="filter__ul elevator">
                <li class="filter__item--level5 filter__item--aside">
                    <a href="javascript:;" data-query="-1">电梯</a>
                </li>
                <#list elevatorEnums as elevator>
                    <li class="filter__item--level5 check ">
                        <a rel="nofollow" data-query="${elevator.getCode()}"
                           href="javascript:;">${elevator.getName()}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </div>

    <!-- 房源列表相关信息 -->
    <div class="content w1150" id="content">
        <div class="content__article">

            <!-- 搜索结果信息 -->
            <p class="content__title">
                已为您找到 <span class="content__title--hl" id="showTotal">${pageBean.total}</span> 套
                <span class="content__title--aside">
                    <a href="javascript:;" id="clearCondition">清空条件</a>
                </span>
            </p>

            <!-- 搜索结果排序模块 -->
            <ul class="content__filter" id="contentList">
                <li class='content__filter--selected'>
                    <a id="defaultSort" data-sort_code="0" href="javascript:;">综合排序</a>
                </li>
                <li>
                    <a id="newReleases" data-sort_code="-1" href="javascript:;">最新上架</a>
                </li>
                <li class="">
                    <a id="priceSort" data-sort_code="-1" href="javascript:;">价格</a>
                </li>
                <li class="">
                    <a id="areaSort" data-sort_code="-1" href="javascript:;">面积</a>
                </li>
            </ul>


            <!-- 房源列表模块 -->
            <div class="content__list" id="queries">
            </div>
            <div id="demo">

            </div>
        </div>

    </div>
<#include "../common/footer.ftl">

</body>

<script src="/home/rent_house/js/pclogin.js"></script>
<script src="/home/rent_house/js/captcha.js"></script>
<script src="/home/rent_house/js/common.js"></script>
<script src="/home/rent_house/js/index.js"></script>
<script src="/home/layui/layui/layui.all.js"></script>


<script>
    $(function () {
        conditionsQuery(1);
    });


    //选择城市
    $("#queryCity").click(function () {
        $("#cityDiv").css("display", "block");
    });
    $(".city-close").click(function () {
        $("#cityDiv").css("display", "none");
    });

    $('#cityDiv a').click(function () {
        $(".city-close").click();
        $('.s-city').text($(this).text());
        $('.s-city').attr("data-query", $(this).text());
        conditionsQuery(1);
    });

    //租房方式高亮
    $(".rentHouseWay").on('click', 'li a', function () {
        $(".rentHouseWay").find("li a").each(function () {
            $(this).removeClass("cur");
        });
        $(".rentHouseWay").find("li").each(function () {
            $(this).removeClass("strong");
        });
        $(this).addClass("cur");
        $(this).parent().addClass("strong");
        conditionsQuery(1);
    });

    //租金高亮
    $(".price").on('click', 'li a', function () {
        var t = $(this);
        if (t.parent().hasClass("checked")) {
            t.parent().removeClass("checked");
        } else {
            if (t.parent().hasClass("filter__item--aside")) {
                t.parent().siblings("li").removeClass("checked");
            } else {
                t.parent().addClass('checked');
            }
        }
        conditionsQuery(1);
    });

    //户型高亮
    $(".houseType").on('click', 'li a', function () {
        var t = $(this);
        if (t.parent().hasClass("checked")) {
            t.parent().removeClass("checked");
        } else {
            if (t.parent().hasClass("filter__item--aside")) {
                t.parent().siblings("li").removeClass("checked");
            } else {
                t.parent().addClass('checked');
            }
        }
        conditionsQuery(1);
    });

    //朝向高亮
    $(".houseOrientation").on('click', 'li a', function () {
        var t = $(this);
        if (t.parent().hasClass("checked")) {
            t.parent().removeClass("checked");
        } else {
            if (t.parent().hasClass("filter__item--aside")) {
                t.parent().siblings("li").removeClass("checked");
            } else {
                t.parent().addClass('checked');
            }
        }
        conditionsQuery(1);
    });

    //特色高亮
    $(".rentHouseFeatures").on('click', 'li a', function () {
        var t = $(this);
        if (t.parent().hasClass("checked")) {
            t.parent().removeClass("checked");
        } else {
            if (t.parent().hasClass("filter__item--aside")) {
                t.parent().siblings("li").removeClass("checked");
            } else {
                t.parent().addClass('checked');
            }
        }
        conditionsQuery(1);
    });

    //租期高亮
    $(".leaseType").on('click', 'li a', function () {
        var t = $(this);
        if (t.parent().hasClass("checked")) {
            t.parent().removeClass("checked");
        } else {
            if (t.parent().hasClass("filter__item--aside")) {
                t.parent().siblings("li").removeClass("checked");
            } else {
                t.parent().addClass('checked');
            }
        }
        conditionsQuery(1);
    });

    //楼层高亮
    $(".floorType").on('click', 'li a', function () {
        var t = $(this);
        if (t.parent().hasClass("checked")) {
            t.parent().removeClass("checked");
        } else {
            if (t.parent().hasClass("filter__item--aside")) {
                t.parent().siblings("li").removeClass("checked");
            } else {
                t.parent().addClass('checked');
            }
        }
        conditionsQuery(1);
    });

    //电梯高亮
    $(".elevator").on('click', 'li a', function () {
        var t = $(this);
        if (t.parent().hasClass("checked")) {
            t.parent().removeClass("checked");
        } else {
            if (t.parent().hasClass("filter__item--aside")) {
                t.parent().siblings("li").removeClass("checked");
            } else {
                t.parent().addClass('checked');
            }
        }
        conditionsQuery(1);
    });


    //价格排序
    $("#priceSort").click(function () {
        var t = $(this);
        t.parent().siblings("li").attr("class", "");
        t.parent().siblings("li").children().attr("data-sort_code", "-1");
        if (t.parent().hasClass("content__filter--selected content__filter-down")) {
            t.parent().attr("class", "content__filter--selected content__filter-up");
            t.attr("data-sort_code", "1");
        } else {
            t.parent().attr("class", "content__filter--selected content__filter-down");
            t.attr("data-sort_code", "0");
        }
        conditionsQuery(1);
    });

    //面积排序
    $("#areaSort").click(function () {
        var t = $(this);
        t.parent().siblings("li").attr("class", "");
        t.parent().siblings("li").children().attr("data-sort_code", "-1");
        if (t.parent().hasClass("content__filter--selected content__filter-down")) {
            t.parent().attr("class", "content__filter--selected content__filter-up");
            t.attr("data-sort_code", "1");
        } else {
            t.parent().attr("class", "content__filter--selected content__filter-down");
            t.attr("data-sort_code", "0");
        }
        conditionsQuery(1);
    });

    //最新上架排序
    $("#newReleases").click(function () {
        var t = $(this);
        t.parent().siblings("li").attr("class", "");
        t.parent().attr("class", "content__filter--selected");
        t.parent().siblings("li").children().attr("data-sort_code", "-1");
        t.attr("data-sort_code", "0");
        conditionsQuery(1);
    });

    //默认排序
    $("#defaultSort").click(function () {
        var t = $(this);
        t.parent().siblings("li").attr("class", "");
        t.parent().siblings("li").children().attr("data-sort_code", "-1");
        t.parent().attr("class", "content__filter--selected");
        t.attr("data-sort_code", "0");
        conditionsQuery(1);
    });

    //清空条件
    $("#clearCondition").click(function () {
        $("#filter").find("li.filter__item--aside").find("a").each(function () {
            this.click();
        });

    });

    $("#searchBtn").click(function () {
        conditionsQuery(1);
    });

    //多条件查询
    function conditionsQuery(page) {

        if (page == undefined) {
            page = 1;
        }

        var city = $("#queryCity").attr("data-query");
        var rentHouseWay = $(".rentHouseWay").find("li.strong").attr("data-query");//获取租房方式

        var priceList = new Array();        //租金
        $(".price").find("li.checked").find("a").each(function () {
            priceList.push($(this).attr("data-query"));//获取所有选中的租金信息
        });

        var houseTypeList = new Array();    //户型
        $(".houseType").find("li.checked").find("a").each(function () {
            houseTypeList.push($(this).attr("data-query"));//获取所有选中的户型信息
        });

        var houseOrientationList = new Array();    //朝向
        $(".houseOrientation").find("li.checked").find("a").each(function () {
            houseOrientationList.push($(this).attr("data-query"));//获取所有选中的朝向信息
        });

        var rentHouseFeaturesList = new Array();    //特色
        $(".rentHouseFeatures").find("li.checked").find("a").each(function () {
            rentHouseFeaturesList.push($(this).attr("data-query"));//获取所有选中的特色信息
        });

        var leaseTypeList = new Array();    //租期
        $(".leaseType").find("li.checked").find("a").each(function () {
            leaseTypeList.push($(this).attr("data-query"));//获取所有选中的租期信息
        });

        var floorTypeList = new Array();    //楼层
        $(".floorType").find("li.checked").find("a").each(function () {
            floorTypeList.push($(this).attr("data-query"));//获取所有选中的楼层信息
        });

        var elevatorList = new Array();    //电梯
        $(".elevator").find("li.checked").find("a").each(function () {
            elevatorList.push($(this).attr("data-query"));//获取所有选中的电梯信息
        });

        var search = $("#search").val(); //搜索内容

        //排序选择
        var defaultSort = $("#defaultSort").attr("data-sort_code");
        var newReleases = $("#newReleases").attr("data-sort_code");
        var priceSort = $("#priceSort").attr("data-sort_code");
        var areaSort = $("#areaSort").attr("data-sort_code");

        var data = JSON.stringify({
            rentHouseWay: rentHouseWay,
            priceList: priceList,
            houseTypeList: houseTypeList,
            houseOrientationList: houseOrientationList,
            rentHouseFeaturesList: rentHouseFeaturesList,
            leaseTypeList: leaseTypeList,
            floorTypeList: floorTypeList,
            elevatorList: elevatorList,
            defaultSort: defaultSort,
            newReleases: newReleases,
            priceSort: priceSort,
            areaSort: areaSort,
            city: city,
            search: search
        });
        $.ajax({
            type: 'POST',
            url: '/home/rentHouse/conditionsQuery?currentPage=' + page,
            contentType: 'application/json;charset=utf-8',
            data: data,
            dataType: 'html',
            async: false,
            success: function (data) {
                $("#queries").html(data);
                $("#showTotal").text($('#rentHouseCount').val());
               /* var total = $("#total").attr("data-total");
                $("#showTotal").text(total == undefined ? 0 : total);*/
            }
        });

    }


</script>

<script>

    BeikeLoginSDK.config({
        env: 'prod',
        loginCallback: function () {
            location.reload()
        },
        registerCallback: function () {
            location.reload()
        }
    })
</script>


</html>
