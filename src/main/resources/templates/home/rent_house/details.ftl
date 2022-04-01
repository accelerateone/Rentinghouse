<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>

    <title>租房详情</title>
    <link rel="stylesheet" href="/home/layui/layui/css/layui.css">
    <link rel="stylesheet" href="/home/rent_house_details/css/index.css">
    <link rel="stylesheet" href="/home/rent_house_details/css/common.css">
    <link rel="stylesheet" href="/home/rent_house_details/css/lianjia.css">
    <link rel="stylesheet" href="/home/rent_house_details/css/lianjiaim.css">
    <link rel="stylesheet" href="/home/bridalChamber/css/list.css">
    <link rel="stylesheet" href="/home/bridalChamber/css/listsite.css">

</head>
<style>

    #loader {
        position: absolute;
        left: 23%;
        top: 2%;
        z-index: 9999;
        background-image:url("/static/home/bridalChamber/images/dog.jpg");
        /*width: 20px;*/
        /*height: 20px;*/
        margin: -25px 0 0 -25px;
        border: 6px solid #f3f3f3;
        border-radius: 50%;
        border-top: 6px solid #00A76F;
        border-bottom: 6px solid #00A76F;
        width: 900px;
        height: 900px;
        -webkit-animation: spin 2s linear infinite;
        animation: spin 2s linear infinite;
    }

    @-webkit-keyframes spin {
        0% {
            -webkit-transform: rotate(0deg);
        }
        100% {
            -webkit-transform: rotate(360deg);
        }
    }

    @keyframes spin {
        0% {
            transform: rotate(0deg);
        }
        100% {
            transform: rotate(360deg);
        }
    }
</style>
<body>

<header class="new-header">
    <#include "../common/header.ftl"/>
</header>
<div class="wrapper">

    <!-- 房源有效时 -->
    <div class="content clear w1150" style="margin-top: 20px;top: 40px">
        <p class="content__title">${rentHouse.getName()}&nbsp;${rentHouse.street}&nbsp;</p>
        <div class="content__core">
            <!-- 房源图片轮播图 -->
            <div class="content__article__slide" id="mySwipe">
                <!-- 房源主图 -->
                <ul class="content__article__slide__wrapper">
                    <div class="content__article__slide__item" data-index="-1">
                        <img alt="" id="mainPic" src="/photo/view?filename=${rentHouse.coverPic}"/>
                    </div>
                </ul>

                <!-- 房源缩略图 -->
                <div class="content__thumb--box">
                    <ul class="content__article__slide--small content__article__slide_dot" data-el="prefix"
                        id="jsSwitchList" style="left:0px">
                        <li class="active" style="position:relative" data-index="-1">
                            <img src="/photo/view?filename=${rentHouse.coverPic}"/>
                            <i class="vr-animation" style="width:20px;height:20px;"></i>
                        </li>
                   <#list rentHouse.detailsPics?split(",") as detailsPic>
                       <#if detailsPic?length gt 0>
                           <li class="" data-index="${detailsPic_index}">
                               <img src="/photo/view?filename=${detailsPic}">
                           </li>
                       </#if>
                   </#list>
                    </ul>
                </div>
                <!-- 图片切换按钮-->
                <span class="content__article__slide--prev" data-el="prev" id="jsSwitchL"></span>
                <span class="content__article__slide--next" data-el="next" id="jsSwitchR"></span>
            </div>

            <!-- 右侧黄金展位 -->
            <div class="content__aside fr" id="aside">

                <!-- 租金及支付方式 -->
                <div class="content__aside--title">
                    <span>${rentHouse.price}</span>元/月 (季付价)
                </div>

                <!-- 房源标签列表 -->
                <p class="content__aside--tags">
                    <#if rentHouse.rentHouseFeaturesList??>
                        <#list rentHouse.rentHouseFeaturesList as rentHouseFeatures>
                             <i class="content__item__tag">${rentHouseFeatures.name}</i>
                        </#list>
                    </#if>
                </p>

                <!-- 房源户型、朝向、面积、租赁方式 -->
                <ul class="content__aside__list">
                    <li><span class="label">租赁方式：</span>${rentHouse.rentHouseWay.getName()}</li>
                    <li><span class="label">房屋类型：</span>${rentHouse.doorModel} ${rentHouse.area}㎡</li>
                    <li class="floor"><span class="label">朝向楼层：</span><span class="">${rentHouse.houseOrientation.getName()}
                    ${rentHouse.floorType.getName()}/${rentHouse.floor}层</span>
                    </li>
                </ul>

                <!-- 经纪人信息 -->

                <div>
                    <style></style>
                    <div style="width: 0;height: 0;" class="ke-agent-data"></div>
                    <div class="content__aside__list house-detail">
                            <span class="content__aside__list--icon">
                                <img src="/photo/view?filename=${rentHouse.roconsultant.headPic}" width="100%"
                                     height="100%">
                            </span>
                        <div class="content__aside__list--title oneline">
                            <span class="contact_name" title="">${rentHouse.roconsultant.username}</span>
                        </div>
                        <div class="content__aside__list--subtitle">新房顾问</div>
                        <div class="phone__hover--wrapper">
                            <div class="content__aside__list--bottom oneline phone num " id="phone1"
                                 style="cursor: pointer;">电话联系
                            </div>
                            <span class="contact__im im__online ke-agent-sj-im ke-agent-sj-im-10000078" onclick="onlineChat(this)"
                                  data-username="${rentHouse.roconsultant.username}" data-userId="${rentHouse.roconsultant.id}"> 在线咨询 </span>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="content__detail">
            <div id="baseInfo" style="height: 1px;margin: 0; padding:0; background: transparent"></div>
            <ul class="w1150 nav__tab fixednav " id="fixed">
                <li class="cur" data-el="fixedNavItem" data-event_id="26125" data-event_action="pcdetailtoptab=0"
                    data-event_position="pcdetailtoptab" data-href="#info" style="cursor: pointer" id="houseInfo">房屋信息
                </li>
                <li data-el="fixedNavItem" data-event_id="26125" data-event_action="pcdetailtoptab=1"
                    data-event_position="pcdetailtoptab" data-href="#desc" style="cursor: pointer" class="" id="intro">房源描述
                </li>
                <li data-el="fixedNavItem" data-event_id="26125" data-event_action="pcdetailtoptab=2"
                    data-event_position="pcdetailtoptab" data-href="#cost" style="cursor: pointer" class="" id="detailPrice">费用详情
                </li>
                <li data-el="fixedNavItem" data-event_id="26125" data-event_action="pcdetailtoptab=4"
                    data-event_position="pcdetailtoptab" data-href="#around" style="cursor: pointer" class="" id="near">位置周边
                </li>
                <li data-el="fixedNavItem" data-event_id="26125" data-event_action="pcdetailtoptab=5"
                    data-event_position="pcdetailtoptab" data-href="#nearbyList" style="cursor: pointer" class="" id="nearHouse">附近房源
                </li>
                <li class="fixed-contact">

                </li>
            </ul>
            <!-- 房源左侧内容 -->
            <div class="content__article fl">
                <!-- 房源基本信息 -->
                <div class="content__article__info" id="info">
                    <h3 id="info">房屋信息</h3>
                    <ul>
                        <li class="fl oneline">基本信息</li>
                        <li class="fl oneline">面积：${rentHouse.area}㎡</li>
                        <li class="fl oneline">朝向：${rentHouse.houseOrientation.getName()}</li>
                        <li class="fl oneline">&nbsp;</li>
                        <li class="fl oneline">楼层：${rentHouse.floorType.getName()}/${rentHouse.floor}层</li>
                        <li class="fl oneline">电梯：${rentHouse.elevator.getName()}</li>
                        <li class="fl oneline">&nbsp;</li>
                        <li class="fl oneline">
                            车位：<#if rentHouse.parkingSpace?length gt 0>${rentHouse.parkingSpace}
                        <#else>暂无数据</#if>
                        </li>
                        <li class="fl oneline">用水：<#if rentHouse.water?length gt 0>${rentHouse.water}
                        <#else>暂无数据</#if>
                        </li>
                        <li class="fl oneline">&nbsp;</li>
                        <li class="fl oneline">
                            用电：<#if rentHouse.electricity?length gt 0>${rentHouse.electricity}
                        <#else>暂无数据</#if></li>
                        <li class="fl oneline">燃气：<#if rentHouse.fuelGas?length gt 0>${rentHouse.fuelGas}
                        <#else>暂无数据</#if></li>
                        <li class="fl oneline">&nbsp;</li>
                        <li class="fl oneline">采暖：<#if rentHouse.heating?length gt 0>${rentHouse.heating}
                        <#else>暂无数据</#if></li>
                        <li class="fl oneline">租期：${rentHouse.lease}</li>
                    </ul>
                </div>

                <div class="content__article__info3" id="desc">
                    <h3>房源描述</h3>
                    <div id="" class="ke-agent-sj-sdk component-agent-id-100000453"><style></style>
                        <div class="desc-agent">
                        <i data-el="updateAvatar" class="info3__icon">
                            <img src="/photo/view?filename=${rentHouse.user.headPic}" width="100%"
                                 height="100%">
                        </i>
                        <div class="userinfo-detail">
                            <span data-el="updateName">${rentHouse.user.username}</span>
                        </div>
                        <div class="userinfo-num">
                            经纪人
                            <div class="ke-agent-sj-phone ke-agent-sj-phone-100000453 num" id="phone2" style="cursor: pointer;">电话联系</div>
                        </div>
                    </div>
                    </div>
                    <!-- 房源描述 -->
                    <p data-el="houseComment">
                    <#if rentHouse.introduction??>
                        <#if rentHouse.introduction?length gt 0>
                            ${rentHouse.introduction}
                        </#if>
                    </#if>
                    </p>
                    <!-- 房源图片 -->
                    <ul class="piclist" data-el="detail-pic">
                        <li data-index="0">
                            <img src="/photo/view?filename=${rentHouse.coverPic}" alt=""/>
                        </li>
                        <#list rentHouse.detailsPics?split(",") as detailsPic>
                            <#if detailsPic?length gt 0>
                               <li data-index="${detailsPic_index+1}">
                                   <img src="/photo/view?filename=${detailsPic}" alt=""/>
                               </li>
                            </#if>
                        </#list>
                    </ul>

                    <!-- 合租信息 -->
                </div>

                <!-- 费用详情 -->
                <div class="content__article__info3 cost_box" id="cost">
                    <h3>费用详情 </h3>
                    <div class="cost_content" data-el="costEl">
                        <div class="price_title">
                            <p class="title_info">年租价 当租期不足1年时租金可能会上浮</p>
                        </div>
                        <div class="table_wrapper " data-el="foldEl">
                            <ul class="table_title">
                                <li class="table_col">付款方式 <span class="sub_title"></span></li>
                                <li class="table_col">租金 <span class="sub_title">(元/月)</span></li>
                                <li class="table_col">押金 <span class="sub_title">(元)</span></li>
                                <li class="table_col">服务费 <span class="sub_title">(元)</span></li>
                                <li class="table_col">中介费 <span class="sub_title">(元)</span></li>

                            </ul>
                            <div class="table_content">
                                <ul class="table_row">
                                    <li class="table_col font_gray">季付</li>
                                    <li class="table_col font_orange">${rentHouse.price}</li>
                                    <li class="table_col">${rentHouse.price}</li>
                                    <li class="table_col">0</li>
                                    <li class="table_col">需咨询</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

            <div class="content__extend fr">
                <!-- 必看好房 -->
                <div class="list-recommend" exposure-event_id="26151">
                    <p>必看好房</p>
                    <#if findTop4By??>
                        <#if findTop4By?size gt 0>
                            <#list findTop4By as findBy>
                                <div class="recommend-item">
                                    <a href="/home/rentHouse/details?id=${findBy.id}">
                                        <img src="/photo/view?filename=${findBy.coverPic}" alt="">
                                        <p class="title">${findBy.rentHouseWay.getName()}·${findBy.street}
                                            ${findBy.doorModel}</p>
                                        <p class="desc">${findBy.town}/ ${findBy.houseOrientation.getName()}
                                            /${findBy.area}㎡</p>
                                        <p class="price">${findBy.price}元/月</p>
                                        <p class="tips">该小区低价抢手房</p>
                                    </a>
                                </div>
                            </#list>
                        </#if>
                    </#if>
                </div>
            </div>

        </div>
    </div>

    <!-- 房源地址与交通 -->
    <!-- 地址信息 -->
    <div class="content__article__info4 w1150" id="around">
        <h3>地址和交通</h3>
        <ul class="nav_list" data-el="nav_list">
            <li data-el="navItem" data-key="默认" data-classname="default" class="nav_item cur">默认</li>
            <li data-el="navItem" data-key="地铁" data-classname="station" class="nav_item">地铁</li>
            <li data-el="navItem" data-key="公交" data-classname="bus" class="nav_item ">公交</li>
            <li data-el="navItem" data-key="学校" data-classname="school" class="nav_item ">学校</li>
            <li data-el="navItem" data-key="医院" data-classname="hospital" class="nav_item ">医院</li>
            <li data-el="navItem" data-key="银行" data-classname="bank" class="nav_item ">银行</li>
            <li data-el="navItem" data-key="餐厅" data-classname="rest" class="nav_item ">餐饮</li>
            <li data-el="navItem" data-key="购物" data-classname="shop" class="nav_item ">购物</li>
            <li data-el="navItem" data-key="娱乐" data-classname="shop" class="nav_item ">娱乐</li>
            <li data-el="navItem" data-key="公园" data-classname="shop" class="nav_item ">公园</li>
        </ul>
        <!-- 地图插件显示 -->
        <div class="content__map">
            <div id="map" class="content__map--container">

            </div>
            <div class="content__map--overlay">
                <ul class="content__map--overlay__list" data-el="list" id="r-result">

                </ul>
            </div>
        </div>
    </div>


    <div class="content--recommend w1150">
        <div class="bottom w1150" id="nearbyList">
            <div class="bottom__list">
                <p class="bottom__list--title">附近房源</p>
                <div class="bottom__list--wrapper">
                <#if findTop8ByTownLike??>
                    <#if findTop8ByTownLike?size gt 0>
                        <#list findTop8ByTownLike as findTop8>
                            <div class="bottom__list--item">
                                <a href="/home/rentHouse/details?id=${findTop8.id}" target="_blank">
                                    <img src="/photo/view?filename=${findTop8.coverPic}">
                                </a>
                                <p class="bottom__list--item__des">
                                    <span>
                                        <a href="/home/rentHouse/details?id=${findTop8.id}" target="_blank">
                                            ${findTop8.rentHouseWay.getName()}·${findTop8.street}${findTop8.doorModel}
                                        </a>
                                    </span>
                                    <span class="bottom__list--item--hl fr">
                                        ${findTop8.price}元/月
                                    </span>
                                </p>
                                <p class="bottom__list--item__btm">
                                    <span>
                                       ${findTop8.town}/ ${findTop8.houseOrientation.getName()}/${findTop8.area}㎡
                                    </span>
                                </p>
                                <p class="bottom__list--item__btm">
                                    <span>
                                    </span>
                                </p>
                            </div>
                        </#list>
                    </#if>
                </#if>

                </div>
            </div>
        </div>


    </div>

</div>

<#include "../common/footer.ftl">

<div id="customer-service-chat-div">

</div>
<div id="loader"  style="display:none"></div>
</body>
<script src="/home/rent_house_details/js/pclogin.js"></script>
<script src="/home/rent_house_details/js/captcha.js"></script>
<script src="/home/rent_house_details/js/common.js"></script>
<script src="/home/rent_house_details/js/index.js"></script>
<script src="/home/layui/layui/layui.all.js"></script>
<script src="//api.map.baidu.com/api?type=webgl&v=1.0&ak=Gepby3PliGhP0Qcf2XssaUKxkBMfboWH"></script>
<script>
    //地图控件
    var dataDd = "${rentHouse.housingEstate.latitudeAndLongitude}";
    var dataDdArr = dataDd.split(",");
    var dd_1 = Number(dataDdArr[0]);
    var dd_2 = Number(dataDdArr[1]);
    var map = new BMapGL.Map('map'); // 创建Map实例
    var mPoint = new BMapGL.Point(dd_1, dd_2); //通过地图中心点坐标
    map.centerAndZoom(new BMapGL.Point(dd_1, dd_2), 16); // 初始化地图,设置中心点坐标和地图级别

    var myIcon = new BMapGL.Icon("/home/rent_house_details/icon/当前位置.png", new BMapGL.Size(30, 30));
    var marker = new BMapGL.Marker(mPoint, {icon: myIcon});
    map.addOverlay(marker);

    // 创建文本标注对象
    var opts = {
        position: mPoint, // 指定文本标注所在的地理位置
        offset: new BMapGL.Size(30, -30) // 设置文本偏移量
    };
    var label = new BMapGL.Label("${rentHouse.name},${rentHouse.housingEstate.street}", opts);
    // 自定义文本标注样式
    label.setStyle({
        borderRadius: '5px',
        borderColor: '#ccc',
        padding: '10px',
        fontSize: '16px',
        height: '30px',
        lineHeight: '30px',
        fontFamily: '微软雅黑'
    });
    map.addOverlay(label);

    //缩放和比例尺
    map.enableScrollWheelZoom(true);
    var scaleCtrl = new BMapGL.ScaleControl();
    map.addControl(scaleCtrl);

    //范围检索
    var local = new BMapGL.LocalSearch(map, {
        renderOptions: {map: map, panel: "r-result"}
    });

    //根据条件检索
    $(".nav_list").on('click', 'li', function () {
        var t = $(this);
        var searchKey = t.attr("data-key");
        t.siblings("li").removeClass("cur");
        t.addClass('cur');
        if (searchKey == "默认") {
            local.search("");
        } else {
            local.searchNearby(searchKey, mPoint, 1000);
        }
    });


</script>

<script>

    //加载动画效果
    function showLoad(){
        $('#loader').show();
    }
    //隐藏动画效果
    function hiddenLoad(){
        $('#loader').hide();
    }


    var count = 0;
    function onlineChat(t) {
        <#if Session["ylrc_home_user"]?exists>

        if (count == 0) {
            $.ajax({
                url: '/websocket/home/websocket',
                type: 'POST',
                dataType: 'html',
                beforeSend:function(){
                    showLoad();
                },
                async: false,
                success: function (data) {
                    $('#customer-service-chat-div').append(data)
                    $("#lines").hide();
                    var adminUserId = "admin" + $(t).attr("data-userid");
                    var dataUserName = $(t).attr("data-username");

                    $(".btn.btn-primary.mt-1.btn-sm.float-right.mr-3").attr("data-uuid",adminUserId)
                    count++;
                    var divPerson = "<div class=\"card-text\" data-person-sessionUUID = " + adminUserId + ">" + dataUserName + "</div>"
                    $(".talk-person").append(divPerson);
                    var divMessage = "<div class='talk-panel' data-message-sessionUUID = " + adminUserId + "></div>"
                    $(".talk-panel-one").hide()
                    $(".talk-panel-one").after(divMessage);
                },

                error: function (data) {
                    alert('网络错误!');
                },
                complete: function() {
                    setTimeout(function (){
                        hiddenLoad();
                    }, 1000);

                }
            });
        }
        <#else >
        $("#home-login").click();
        </#if>

    }
</script>

<script>

    //点击电话联系显示电话,再次点击隐藏
    var flag = 0;
    var flag1 = 0;
    $("#phone1").click(function () {
        var mobile = "";
        <#if rentHouse.roconsultant.mobile??>
            mobile = "${rentHouse.roconsultant.mobile}";
        </#if>
        if (flag1 == 0){
            $(this).text(mobile);
            flag1 = 1;
        } else if (flag1 == 1) {
            $(this).text("电话联系");
            flag1 = 0;
        }
    });
    $("#phone2").click(function () {
        var mobile = "";
        <#if rentHouse.user.mobile??>
            mobile = "${rentHouse.user.mobile}"
        </#if>
        if (flag == 0){
            $(this).text(mobile);
            flag = 1;
        } else if (flag == 1) {
            $(this).text("电话联系");
            flag = 0;
        }
    });

    //顶部导航栏点击切换定位
    $("#fixed").on('click', 'li', function () {
        $(this).addClass("cur").siblings().removeClass("cur");
        sessionStorage.setItem('scroll', 'scroll');
        $('html,body').animate({scrollTop: $($.attr(this, 'data-href')).offset().top - $("#fixed").height() - 50}, 800);
        setTimeout(function () {
            sessionStorage.removeItem('scroll');
        }, 800)
    });
    //滚动条导航事件
    $(window).scroll(function () {//获得滚动条距离顶部的高度
        var scrollHeight = $(window).scrollTop();
        var info = $("#info").offset().top -180;
        var desc = $("#desc").offset().top -180;
        var cost = $("#cost").offset().top -180;
        var around = $("#around").offset().top -180;
        var nearbyList = $("#nearbyList").offset().top -300;
        if (scrollHeight > info && scrollHeight < desc) {
            $("#fixed").addClass("fixed");
            $("#houseInfo").addClass("cur").siblings().removeClass("cur");
        } else if (scrollHeight < info) {
            $("#fixed").removeClass("fixed");
        } else if (scrollHeight > desc && scrollHeight < cost) {
            $("#intro").addClass("cur").siblings().removeClass("cur");
        } else if (scrollHeight > cost && scrollHeight < around) {
            $("#detailPrice").addClass("cur").siblings().removeClass("cur");
        } else if (scrollHeight > around && scrollHeight < nearbyList) {
            $("#near").addClass("cur").siblings().removeClass("cur");
        } else if (scrollHeight > nearbyList) {
            $("#nearHouse").addClass("cur").siblings().removeClass("cur");
        }
    });


    //轮播图开始
    var array = [];
    <#if rentHouse.detailsPics??>
     array.push("${rentHouse.coverPic}");
        <#list rentHouse.detailsPics?split(",") as detailsPic>
            <#if detailsPic?length gt 0>
            array.push("${detailsPic}");
            </#if>
        </#list>
    </#if>
    var num = 0;
    var li = document.getElementById('jsSwitchList').children;
    var left = document.getElementById('jsSwitchL');
    var right = document.getElementById('jsSwitchR');
    var leftPx = -105;
    //左右按钮
    left.onclick = function () {
        num--;
        if (num == -1) {
            num = array.length - 1;
        }
        if (num < 2) {
            $("#jsSwitchList").css("left", "0px");
            leftPx = -105;
        } else if (num >= 2) {
            leftPx = parseInt(leftPx) + 100;
            $("#jsSwitchList").css("left", leftPx + "px");
        }
        changeImg();
    };
    right.onclick = function () {
        num++;
        if (num == array.length) {
            num = 0;
        }
        if (num == 0) {
            $("#jsSwitchList").css("left", "0px");
            leftPx = -105;
        } else if (num >= 2) {
            leftPx = parseInt(leftPx) - 100;
            $("#jsSwitchList").css("left", leftPx + "px");
        }
        changeImg();
    };
    //点击小图片 换大图片
    for (var i = 0; i < li.length; i++) {
        li[i].index = i;
        li[i].onclick = function () {
            num = this.index;
            changeImg();
        }
    }
    //图片切换
    function changeImg() {
        for (var i = 0; i < li.length; i++) {
            //判断当前li是否包含active类
            if (li[i].classList.contains('active')) {
                li[i].classList.remove('active');
            }
        }
        //修改小图背景
        li[num].classList.add('active');
        //修改大图
        var currentImg = array[num];
        $("#mainPic").attr("src", "/photo/view?filename=" + currentImg);
    }
    //轮播图结束
</script>
</html>
