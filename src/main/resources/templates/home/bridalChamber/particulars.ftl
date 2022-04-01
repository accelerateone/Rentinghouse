<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>详情页面</title>
    <link rel="stylesheet" href="/home/layui/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/home/rent_house_details/css/common.css">
    <link rel="stylesheet" href="/home/rent_house_details/css/index.css">
    <link rel="stylesheet" href="/home/bridalChamber/particulars/css/site.css">
    <link rel="stylesheet" href="/home/bridalChamber/particulars/css/index.css">


</head>
<style>

    #loader {
        position: absolute;
        left: 23%;
        top: 8%;
        z-index: 9999;
        background-image: url("/static/home/bridalChamber/images/dog.jpg");
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

<div class="mod-global">
    <div class="pc-xcxdaoliu">
        <div id="matchBar"></div>
    </div>
    <!-- BANNER -->
    <div class="mod-wrap mod-resblock-name-bar clearfix" data-mark="name-bar" data-proname="xnlygcwlyblikf"
         data-is_floupan="">
        <div class="title-wrap">
            <div>
                <h2 class="DATA-PROJECT-NAME">${newHouseInfo.name}</h2>
                <div class="tags-wrap">
                    <span class="tag-item house-type-tag">${newHouseInfo.propertyType.getName()}</span>
                </div>
            </div>
        </div>
    </div>


    <div class="mod-wrap mod-banner">
        <div class="album" style="position: relative;z-index: 3000">
            <div class="carousel" style="height: 396px">
                <div class="layui-carousel" id="test10">
                    <div carousel-item="">
                        <#if newHouseInfo.firstFigurePath??>
                            <#if newHouseInfo.firstFigurePath?length gt 0>
                                <div><img src="/photo/view?filename=${newHouseInfo.firstFigurePath}"
                                          class="animation" style="width: 500px; height: 396px;"></div>
                            <#else>
                                <div><img src="/admin/images/default-head.jpg" class="animation"
                                          style="width: 500px; height: 396px;"></div>
                            </#if>
                        </#if>
                        <#if newHouseInfo.effectPictureItems?size gt 0>
                            <#list newHouseInfo.effectPictureItems as effectPictureItems>
                                <#if effectPictureItems.effectPicturePath??>
                                    <#if effectPictureItems.effectPicturePath?length gt 0>
                                        <div><img src="/photo/view?filename=${effectPictureItems.effectPicturePath}"
                                                  class="animation" style="width: 500px; height: 396px;"></div>
                                    <#else>
                                        <div><img src="/admin/images/default-head.jpg" class="animation"
                                                  style="width: 500px; height: 396px;"></div>
                                    </#if>
                                </#if>
                            </#list>
                        </#if>
                    </div>
                </div>
            </div>
        </div>

        <div class="resblock-info animation qr-fixed">
            <div class="info-wrap">
                <div class="name-info animation">
                    <h2 class="animation">${newHouseInfo.name}</h2>
                    <div class="tags-wrap">
                        <span class="tag-item house-type-tag">${newHouseInfo.propertyType.getName()}</span>
                    </div>
                </div>
                <div class="top-info ">
                    <div class="price">
                        <span class="title">参考均价</span>
                        <span class="price-number">${newHouseInfo.averagePrice}</span>
                        <span class="price-unit">元/平(单价) </span>
                    </div>
                    <ul class="resblock-tag col-nav">
                        <li class="item">
                            <span class="status-special-tag">${newHouseInfo.propertyType.getName()}</span>
                        </li>
                        <#if newHouseInfo.housingCharacteristicsList ??>
                            <#list newHouseInfo.housingCharacteristicsList as housingCharacteristics>
                                <li class="item"><span class="status-special-tag">${housingCharacteristics.name}</span>
                                </li>
                            </#list>
                        </#if>

                    </ul>
                </div>
                <div class="middle-info animation">
                    <ul class="info-list">
                        <li class="info-item">
                            <span class="title">项目地址</span>
                            <span class="content">
                                ${newHouseInfo.province}${newHouseInfo.city}${newHouseInfo.district}${newHouseInfo.detailedAddress}
                            </span>
                            <span class="map">
                                <a href="#around" data-xftrack="10155">地图</a>
                            </span>
                        </li>
                        <li class="info-item open-date-wrap">
                            <div class="open-date" data-more="0">
                                <span class="title">最新开盘</span>
                                <span class="content">${newHouseInfo.latestOpeningHours}</span>
                            </div>
                        </li>
                        <li class="info-item"><span class="title">楼盘户型</span>
                            <span class="content">
                                  <#if houseTypeThree ??>
                                      <#if houseTypeThree?size gt 0>
                                          <#list houseTypeThree as houseTypeThree>
                                              <span style="cursor: auto" class="house-type-item">${houseTypeThree.name}</span>&nbsp;
                                          </#list>
                                      </#if>
                                  </#if>
                            </span>
                            <a><span class="all-house-type" onclick="showCommonFrameModalWrap()">全部户型</span></a>
                        </li>
                        <hr class="middle-info-hr"/>
                    </ul>
                </div>

                <div class="consultant" style="height: 110px;">
                    <ul class="one-out animation">
                        <div class="ke-agent-sj-sdk component-agent-id-100001313 daoliu-100001313"
                             style="margin-top: 25px;">
                            <style>.ke-agent-sj-sdk {
                                    width: 100%
                                }

                                .ke-agent-sj-sdk-f-0 {
                                    font-size: 0
                                }

                                .ke-agent-sj-clear {
                                    clear: both
                                }

                                .component-agent-xf-pc-1 {
                                    position: relative;
                                    font-size: 0;
                                    height: 170px
                                }

                                .component-agent-xf-pc-1 .ke-agent-sj-container {
                                    position: absolute;
                                    top: 50%;
                                    -webkit-transform: translateY(-50%);
                                    -ms-transform: translateY(-50%);
                                    transform: translateY(-50%);
                                    white-space: nowrap
                                }

                                .component-agent-xf-pc-1 .ke-agent-sj-container .ke-agent-sj-phone {
                                    width: 240px;
                                    background: #00AE66;
                                    display: inline-block;
                                    text-align: center;
                                    -webkit-border-radius: 2px;
                                    border-radius: 2px;
                                    padding: 15px 0;
                                    vertical-align: middle;
                                    font-size: 20px;
                                    min-width: 205px;
                                    color: #fff;
                                    margin-right: 15px
                                }

                                .component-agent-xf-pc-1 .ke-agent-sj-container .ke-agent-sj-qr-code {
                                    width: 110px;
                                    height: 110px;
                                    vertical-align: middle
                                }

                                .component-agent-xf-pc-2 {
                                    position: relative;
                                    font-size: 0
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-avatar {
                                    display: inline-block;
                                    width: 60px;
                                    height: 80px;
                                    vertical-align: top;
                                    margin-right: 15px
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-info {
                                    display: inline-block;
                                    vertical-align: top;
                                    position: relative
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-qr-code {
                                    position: absolute;
                                    right: -107px;
                                    top: 0;
                                    width: 90px;
                                    height: 90px
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-name {
                                    font-weight: 600;
                                    font-size: 20px;
                                    color: #333;
                                    vertical-align: middle;
                                    margin-right: 6px
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-tag {
                                    display: inline-block;
                                    margin-right: 8px;
                                    height: 18px;
                                    line-height: 18px;
                                    font-family: HiraginoSansGB-W3;
                                    font-size: 12px;
                                    color: #b0b4b4;
                                    font-weight: 300;
                                    padding: 0 2px;
                                    -webkit-border-radius: 2px;
                                    border-radius: 2px;
                                    background-color: #eff0f2;
                                    vertical-align: middle
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-desc {
                                    margin-bottom: 5px;
                                    margin-top: 5px;
                                    height: 17px;
                                    line-height: 17px;
                                    font-size: 12px;
                                    color: #101d37
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-phone {
                                    margin-bottom: 8px;
                                    height: 23px;
                                    line-height: 23px;
                                    font-size: 14px;
                                    font-weight: 600;
                                    color: #fe615a
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-im {
                                    background-color: #f4f8fe;
                                    border: 1px solid #00AE66;
                                    -webkit-border-radius: 2px;
                                    border-radius: 2px;
                                    color: #00AE66;
                                    cursor: pointer;
                                    display: inline-block;
                                    font-size: 14px;
                                    height: 40px;
                                    line-height: 40px;
                                    text-align: center;
                                    text-decoration: none;
                                    width: 110px
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-im span {
                                    vertical-align: middle
                                }

                                .component-agent-xf-pc-2 .ke-agent-sj-container .ke-agent-sj-im .messing-icon {
                                    height: 16px;
                                    vertical-align: middle;
                                    width: 16px;
                                    margin-right: 2px
                                }</style>
                            <div class="component-agent-xf-pc-2">
                                <div class="ke-agent-sj-container">
                                    <#if newHouseInfo.user.headPic??>
                                        <#if newHouseInfo.user.headPic?length gt 0>
                                            <img src="/photo/view?filename=${newHouseInfo.user.headPic}"
                                                 class="ke-agent-sj-avatar">
                                        <#else>
                                            <img src="/admin/images/default-head.jpg" class="ke-agent-sj-avatar">
                                        </#if>
                                    </#if>
                                    <div class="ke-agent-sj-info">
                                        <div>
                                            <span class="ke-agent-sj-name">  ${newHouseInfo.user.username} </span>
                                            <span class="ke-agent-sj-tag"> 新房顾问 </span>
                                        </div>

                                        <a class="ke-agent-sj-im ke-agent-sj-im-100001313 ke-agent-sj-im-1000000026677294"
                                           onclick="onlineChat(this)" data-username="${newHouseInfo.user.username}"
                                           data-userId="${newHouseInfo.user.id}">
                                            <img src="/home/bridalChamber/images/聊天.png" class="messing-icon"
                                                 alt="在线咨询">
                                            <span> 在线咨询 </span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </ul>

                </div>
            </div>
        </div>
    </div>

    <!-- REMINDING -->

    <div class="reminding-box">


    </div>
    <!-- TAB -->
    <div class="mod-wrap mod-tab">
        <div id="modTab" style="z-index: 1000; position: relative; width: 1150px; margin-top: 0px;">
            <div class="panel-tab clickTargetBox" data-proname="xnlygcwlyblikf" style="width: 1175px">
                <ul class="panel-tab-ul clear">
                    <li class="on" id="house-online-id"><a data-href="#house-online">户型介绍</a></li>
                    <li class="" id="around-id"><a data-href="#around">位置周边</a></li>
                    <li class="" id="house-push-id"><a data-href="#house-push">楼盘推荐</a></li>
                </ul>

                <span class="ke-agent-sj-sdk component-agent-id-100010999 phone" id="ke_agent_2"></span>

            </div>
        </div>
    </div>

    <!-- INFO -->

    <!-- 户型介绍 -->
    <div class="content__article__info4 w1150" data-banner="1" id="house-online">
        <div class='clear mod-panel-houseonline mod-house-online post_ulog_exposure_scroll'
             data-ulog-exposure="xinfangpc_show=20022">
            <div class="h2-flow clear" style="height: 10px">
                <h3 class="title-wrap">
                    <a class="title-link">户型介绍</a>
                </h3>
            </div>
            <ul class="clear type-tab frame-type-list" data-mark="frame-type-list">
                <#if houseTypeThree ??>
                    <#if houseTypeThree?size gt 0>
                        <#list houseTypeThree as houseTypeThree>
                            <li class="item" style="cursor: auto " data-index="${houseTypeThree.id}"><span>${houseTypeThree.name}</span></li>
                        </#list>
                    </#if>
                </#if>
            </ul>
            <span class="jump-to-frame-all open-frame-modal" style="    position: relative;
    left: 360px;
    top: 31px;" onclick="showCommonFrameModalWrap()">全部户型</span>
            <div class="">
                <div class="houselist frame-container carousel"
                     data-mark="frame-container">
                    <ul class="carousel-body col-nav animation" data-mark="frame-body">
                        <li class="item top-item" data-index="0">
                            <#if houseTypeThree?size gt 0>
                                <#list houseTypeThree as houseType>
                                    <ul class="clear house-det">
                                        <div class="card-img">
                                            <#if houseType.floorPlan??>
                                                <#if houseType.floorPlan?length gt 0>
                                                    <img style="width: 230px;height: 170px"
                                                         src="/photo/view?filename=${houseType.floorPlan}"
                                                         class="img">
                                                <#else>
                                                    <img style="width: 230px;height: 170px"
                                                         src="/admin/images/default-head.jpg">
                                                </#if>
                                            </#if>
                                        </div>
                                        <div class="card-content">
                                            <div class="content-title">
                                                ${houseType.name}
                                            </div>
                                            <div class="content-area">建面${houseType.doorArea}m²</div>
                                        </div>
                                    </ul>
                                </#list>
                            <#else>
                                <ul class="clear house-det">
                                    <div class="card-img">
                                        <img src="/admin/images/default-head.jpg"
                                             style="width: 230px;height: 170px">
                                    </div>
                                    <div class="card-content">
                                        <div class="content-title">
                                            暂无户型
                                        </div>
                                        <div class="content-area" style="position: relative">暂无户型</div>
                                    </div>
                                </ul>
                            </#if>

                        </li>


                    </ul>
                </div>
            </div>

        </div>
    </div>

    <#--周边配套-->
    <div class="content__article__info4 w1150" id="around">
        <h3>周边配套</h3>
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
    <!-- 推荐楼盘 -->
    <div class="content__article__info4 w1150" id="house-push" data-mark='full-width'>
        <h3>好房为你推荐</h3>
        <div class='clear mod-panel'>

            <div class="img-list">
                <div class="show-content">
                    <ul>
                        <#if firstSix?size gt 0>
                            <#list firstSix as firstSix>
                                <li class=""
                                    data-ulog-exposure="xinfangpc_show=20009&location=1&project_name=ysqabqbr&recommend_log_info=&quot;&quot;">
                                    <a class="pic " href="/home/index/particulars/${firstSix.id}">
                                        <span class="coverpic-type coverpic-pos-rt">效果图</span>
                                        <#if firstSix.firstFigurePath??>
                                            <#if firstSix.firstFigurePath?length gt 0>
                                                <img src="/photo/view?filename=${firstSix.firstFigurePath}">
                                            <#else>
                                                <img src="/admin/images/default-head.jpg">
                                            </#if>
                                        </#if>
                                        <span class="tip">
												均价 ${firstSix.averagePrice} 元/平
											</span>
                                    </a>
                                    <a class="house-name " data-xftrack="10123">
                                        <strong style="font-weight: bold;">
                                            ${firstSix.district}||${firstSix.name} </strong>
                                    </a>
                                    <span class="zhuzhai">${firstSix.propertyType.getName()}</span>
                                    <P>
                                        建面 ${firstSix.builtUpArea}㎡
                                    </P>
                                </li>
                            </#list>
                        <#else>
                            <li class=""
                                data-ulog-exposure="xinfangpc_show=20009&location=1&project_name=ysqabqbr&recommend_log_info=&quot;&quot;">
                                <a class="pic ">
                                    <span class="coverpic-type coverpic-pos-rt">效果图</span>
                                    <img src="/admin/images/default-head.jpg">
                                    <span class="tip">
												暂无推荐
											</span>
                                </a>
                                <a class="house-name " data-xftrack="10123">
                                    <strong style="font-weight: bold;">
                                        暂无推荐 </strong>
                                </a>
                                <span class="zhuzhai">暂无推荐</span>

                            </li>
                        </#if>
                    </ul>
                </div>
            </div>

        </div>
    </div>


    <!-- 户型图弹层 -->
    <div class="common-frame-modal-wrap" style="display: none">
        <div class="mask"></div>
        <div class="modal-content" style="    height: 453px;
    width: 790px;
">
            <input type="button" class="close-btn">
            <div class='mod-panel-houseonline mod-house-online'>
                <div class="h2-flow clear" >
                    <h2 class="title-wrap"><a class="title-link">户型介绍</a></h2>
                </div>
                <ul class="clear type-tab frame-type-list" style="height: 10px;" data-mark="frame-modal-type-list">
                    <li class="onli item active" data-index="0"><span>全部户型</span></li>
                </ul>

                <div class="houselist frame-container carousel" data-mark="frame-modal-container">

                    <div class="layui-carousel" id="test11">
                        <div carousel-item="">
                            <#if houseType?size gt 0>
                                <#list houseType as houseType>
                                    <#if houseType.floorPlan??>
                                        <#if houseType.floorPlan?length gt 0>
                                            <div><img src="/photo/view?filename=${houseType.floorPlan}"
                                                      style="width: 500px; height: 260px;">
                                                <div class="card-content"
                                                     style="position: relative; left: 536px; top:-162px">
                                                    <div class="content-title">
                                                        ${houseType.name} <span class="p1-state p1-orange"></span>
                                                    </div>
                                                    <div class="content-area">建面 ${houseType.doorArea}m²</div>
                                                </div>
                                            </div>
                                        <#else>
                                            <div><img src="/admin/images/default-head.jpg"
                                                      style="width: 500px; height: 260px;">
                                                <div class="card-content">
                                                    <div style="position: relative; left: 348px; top: -261px"
                                                         class="content-title">
                                                        暂无户型
                                                    </div>
                                                </div>
                                            </div>
                                        </#if>
                                    </#if>
                                </#list>
                            <#else>
                                <div><img src="/admin/images/default-head.jpg"
                                          style="width: 500px; height: 260px;">
                                    <div class="card-content">
                                        <div style="position: relative; left: 348px; top: -261px"
                                             class="content-title">
                                            暂无户型
                                        </div>
                                    </div>
                                </div>
                            </#if>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>

</div>
<#include "../common/footer.ftl">

<div id="customer-service-chat-div">

</div>

<!-- 导流浮层 -->

<div class="follow-bar-wrap">
    <div class="follow-bar">
        <div class="follow-bar-qrcode">
            <img src="/home/bridalChamber/images/saoma.jpg" width="140" height="140"/>
        </div>
        <div class="follow-bar-content">
        </div>
        <div class="follow-bar-close"></div>
    </div>
</div>
<div class="follow-bar-pickup-wrap">
    <div class="follow-bar-pickup">
        <div class="follow-bar-pickup-qrcode">
            <img src="/home/bridalChamber/images/saoma.jpg" width="80" height="80"/>
        </div>
    </div>
</div>

<span class="close"></span>
<div class="overlayBgl"></div>
<!-- footer -->


<div id="loader" style="display:none"></div>
<script src="/home/bridalChamber/jquery-3.5.1.js"></script>
<script src="/home/bridalChamber/particulars/js/ejs.min.js"></script>
<script src="/home/bridalChamber/particulars/js/common.js"></script>
<script src="/home/bridalChamber/particulars/js/template-ejs.js"></script>
<script src="/home/bridalChamber/particulars/js/agent-sj-sdk.js"></script>
<script src="/home/layui/layui/layui.js"></script>
<script src="/home/bridalChamber/particulars/js/captcha.js"></script>
<script src="/home/bridalChamber/particulars/js/index.js"></script>
<script src="//api.map.baidu.com/api?type=webgl&v=1.0&ak=Gepby3PliGhP0Qcf2XssaUKxkBMfboWH"></script>
<script>
    //地图控件
    var dataDd = "${newHouseInfo.longitudeAndIatitude}";
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
    var label = new BMapGL.Label("${newHouseInfo.name}", opts);
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
<div style="display:none">
    <script>

        //顶部导航栏点击切换定位
        $("#modTab").on('click', 'li a', function () {
            $(this).addClass("on").siblings().removeClass("on");
            sessionStorage.setItem('scroll', 'scroll');
            $('html,body').animate({scrollTop: $($.attr(this, 'data-href')).offset().top - $("#modTab").height() - 50}, 800);
            setTimeout(function () {
                sessionStorage.removeItem('scroll');
            }, 800)
        });
        //滚动条导航事件
        $(window).scroll(function () {//获得滚动条距离顶部的高度
            var scrollHeight = $(window).scrollTop();
            var houseOnline = $("#house-online").offset().top - 180;
            var around = $("#around").offset().top - 180;
            var housePush = $("#house-push").offset().top - 300;
            if (scrollHeight > houseOnline && scrollHeight < around) {
                $("#modTab").css("position", "fixed");
                $("#modTab").css("width", "100%");
                $("#house-online-id").addClass("on").siblings().removeClass("on");
            } else if (scrollHeight < houseOnline) {
                $("#modTab").css("position", "relative");
                $("#modTab").css("width", "1150");
                $("#house-online-id").addClass("on").siblings().removeClass("on");
            } else if (scrollHeight > around && scrollHeight < housePush) {
                $("#around-id").addClass("on").siblings().removeClass("on");
            } else if (scrollHeight > housePush) {
                $("#house-push-id").addClass("on").siblings().removeClass("on");
            }
        });


        layui.use(['carousel', 'form'], function () {
            var carousel = layui.carousel, form = layui.form;
            var carousel = layui.carousel;
            //图片轮播
            carousel.render({
                elem: '#test10'
                , width: '500px'
                , height: '396px'
                , interval: 5000
            });


            carousel.render({
                elem: '#test11'
                , width: '700px'
                , height: '260px'
                , interval: 5000
            });
        });


        function showCommonFrameModalWrap() {
            $(".common-frame-modal-wrap").show();
        }

        $('.close-btn').click(function () {
            $(".common-frame-modal-wrap").hide();
        })

        //加载动画效果
        function showLoad() {
            $('#loader').show();
        }

        //隐藏动画效果
        function hiddenLoad() {
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
                    beforeSend: function () {
                        showLoad();
                    },
                    async: false,
                    success: function (data) {
                        $('#customer-service-chat-div').append(data)
                        $("#lines").hide();
                        var adminUserId = "admin" + $(t).attr("data-userid");
                        $(".btn.btn-primary.mt-1.btn-sm.float-right.mr-3").attr("data-uuid", adminUserId)
                        count++;
                        var dataUserName = $(t).attr("data-username");
                        var divPerson = "<div class=\"card-text\" style='color: red' data-person-sessionUUID = " + adminUserId + ">" + dataUserName + "</div>"
                        $(".talk-person").append(divPerson);
                        var divMessage = "<div class='talk-panel' data-message-sessionUUID = " + adminUserId + "></div>"
                        $(".talk-panel-one").hide()
                        $(".talk-panel-one").after(divMessage);
                    },

                    error: function (data) {
                        alert('网络错误!');
                    },
                    complete: function () {
                        setTimeout(function () {
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
</div>
<div style="display:none">
    <script src="/home/bridalChamber/particulars/js/ljulog.js"></script>
    <script type="text/javascript">
        $.listener.on('userInfo', function (data) {
            window.loginData = data;
        });

        window.login(); // 初始化登录

        $(window).on('load', function () {
            // SEO 百度自动推送URL
            (function () {
                var bp = document.createElement('script');
                var curProtocol = window.location.protocol.split(':')[0];
                if (curProtocol === 'https') {
                    bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
                } else {
                    bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
                }
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(bp, s);
            })();
        });
    </script>
</div>
</body>
</html>
