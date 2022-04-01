<!DOCTYPE html>
<html>
<head>
    <title>${houseInfo.details}</title>


    <link rel="stylesheet" href="/home/houseInfo/css/common.css">
    <link rel="stylesheet" href="/home/houseInfo/css/detailv3.css">
    <link property='stylesheet' rel="stylesheet" href="/home/houseInfo/css/lianjiaim.css"/>
    <link rel="stylesheet" href="/home/bridalChamber/css/list.css">
    <link rel="stylesheet" href="/home/rent_house_details/css/common.css">
    <link rel="stylesheet" href="/home/rent_house_details/css/index.css">
    <link rel="stylesheet" href="/home/bridalChamber/css/list.css">
    <link rel="stylesheet" href="/home/bridalChamber/css/listsite.css">
    <link rel="stylesheet" href="/home/layui/layui/css/layui.css">
    <style>
        .cur {
            color: #ffffff;
        }

        .component-agent-es-pc-6 {
            position: relative;
            display: block;
            font-size: 0;
            padding-top: 40px;
            padding-bottom: 35px;
            border-bottom: 1px solid #eeeeee;
        }

        .component-agent-es-pc-6:after {
            content: ".";
            clear: both;
            display: block;
            height: 0;
            visibility: hidden;
            font-size: 0;
            line-height: 0;
        }

        .component-agent-es-pc-6 a {
            text-decoration: none;
        }

        .component-agent-es-pc-6 .qrcode-wrapper {
            color: #999;
            font-size: 10px;
            text-align: center;
            line-height: 18px;
            margin-top: 5px;
        }

        .component-agent-es-pc-6 .img-wrapper {
            width: 110px;
            height: 110px;
            border: 1px solid #F5F5F5;
            background: #f5f5f6;
            vertical-align: top;
        }

        .component-agent-es-pc-6 .weapp-code {
            display: inline-block;
            position: absolute;
            right: 0px;
            top: 40px;
        }

        .component-agent-es-pc-6 .dy_tag {
            max-width: 52px;
            -o-text-overflow: ellipsis;
            text-overflow: ellipsis;
            overflow: hidden;
            height: 17px;
            line-height: 17px;
            text-align: center;
            border-radius: 2px;
            font-size: 11px;
            display: inline-block;
            margin-left: 4px;
            color: #9399a5;
            background-color: #eff0f2;
        }

        .component-agent-es-pc-6 .ke-agent-sj-profile-card {
            display: inline-block;
            position: relative;
            vertical-align: middle;
            border-radius: 2px;
            background-position: center;
            width: 24px;
            height: 18px;
            margin: 0 3px;
            cursor: pointer;
            background-size: 24px 18px;
        }

        .component-agent-es-pc-6 .agent-img {
            width: 108px;
            height: 108px;
        }

        .component-agent-es-pc-6 .brokerInfoText {
            float: right;
            line-height: 1;
            width: 299px;
            margin-right: -45px;
        }

        .component-agent-es-pc-6 .ke-agent-sj-name {
            font-size: 18px;
            font-weight: bold;
            color: #394043;
            vertical-align: top;
        }

        .component-agent-es-pc-6 .dy {
            vertical-align: middle;
            top: 0;
            position: relative;
            display: inline-block;
            margin-right: 2px;
        }

        .component-agent-es-pc-6 .phone {
            margin-top: 8px;
            font-size: 14px;
            line-height: 19px;
            color: #EB4D3A;
            font-family: Tahoma-Bold;
            letter-spacing: 0;
        }

        .component-agent-es-pc-6 .phone phone-text {
            padding: 0 6px;
            font-size: 14px;
        }

        .component-agent-es-pc-6 .evaluate {
            margin-top: 11px;
            font-size: 12px;
            vertical-align: middle;
            color: #333333;
            height: 12px;
        }

        .component-agent-es-pc-6 .ke-agent-sj-im {
            top: 2px;
            position: relative;
            margin-top: 6px;
            display: inline-block;
            padding: 7px 12px;
            background: #00AE66;
            border-radius: 2px;
            vertical-align: middle;
            cursor: pointer;
            height: 34px;
            line-height: 20px;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
        }

        .component-agent-es-pc-6 .ke-agent-sj-im .im-icon {
            width: 16px;
            height: 16px;
            margin-right: 5px;
            display: inline-block;
            vertical-align: middle;
            background-size: cover;
        }

        .component-agent-es-pc-6 .ke-agent-sj-im .im-text {
            font-family: PingFangSC-Medium;
            font-size: 14px;
            color: #FFFFFF;
            letter-spacing: 0;
            vertical-align: middle;
        }

        .ke-agent-sj-code {
            font-family: PingFangSC-Regular;
            font-size: 14px;
            color: #101D37;
            letter-spacing: 0;
            text-align: justify;
            margin-left: 4px;
            line-height: 14px;
            display: inline-block;
            height: 14px;
            margin-top: 4px;
        }

        #head1 {
            margin-top: -20px;
        }

        .m-content {
            position: relative;
            top: -102px;
        }

        #pictureName {
            margin-top: -20px;
        }

        #loader {
            position: absolute;
            left: 8%;
            top: -14%;
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
</head>
<body>
<header class="new-header">
    <#include "common/header.ftl"/>
</header>


<div class="overview" style="margin-top: 20px">
    <div class="img" id="topImg">
        <div class="imgContainer">
            <div class="new-default-icon maxWidth defaultImg">
                <div class="layui-carousel" id="test1" lay-filter="test1">
                    <div carousel-item="">
                        <div style="background-color: white;"  class="swiper-slide">
                            <img style="width: 710px;height: 400px" src="/photo/view?filename=${houseInfo.coverPic}" width="">
                        </div>
                    <#list houseInfo.detailsPics?split(",") as picture>
                        <#if picture?length gt 0>
                            <div style="background-color: white" class="swiper-slide">
                                <img style="width: 710px;height: 400px"  src="/photo/view?filename=${picture}">
                            </div>
                        </#if>
                    </#list>
                    </div>
                </div>
            </div>
            <div class="vr_animation_logo vr_gold_animation_logo"></div>
            <div class="vr_zhuangxiu VIEWDATA">
                <div class="vr_zhuangxiu_word">设计效果</div>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="title">
            <h1 class="main" title="">${houseInfo.details}·${houseInfo.sellingPoint}</h1>
        </div>
        <div class="price ">
            <span class="total">${houseInfo.specificPrice}</span>
            <span class="unit">
                <span>万</span>
            </span>
            <div class="text">
                <div class="unitPrice">
                    <span class="unitPriceValue">
                        ${houseInfo.unitPrice}
                        <i>元/平米</i>
                    </span>
                </div>
                <div class="tax im-talk LOGCLICKDATA">
                    <span class="taxtext">首付及贷款情况请咨询经纪人</span>
                    <i></i>
                </div>
            </div>
            <div class="removeIcon"></div>
        </div>
        <div class="houseInfo">
            <div class="room">
                <div class="mainInfo">${houseInfo.houseType.getName()}</div>
                <div class="subInfo">${houseInfo.floor}层</div>
            </div>
            <div class="type">
                <div class="mainInfo"
                     title="${houseInfo.houseOrientation.getName()}">${houseInfo.houseOrientation.getName()}</div>
                <div class="subInfo">${houseInfo.houseRenovation.getName()}</div>
            </div>
            <div class="area">
                <div class="mainInfo">${houseInfo.area}平米</div>
                <div class="subInfo noHidden">${houseInfo.housingEstate.completedYear}
                    年建/${houseInfo.houseArchitectureType.getName()}</div>
            </div>
        </div>
        <div class="aroundInfo">
            <div class="communityName">
                <i></i>
                <span class="label">小区名称</span>
                <a class="info" style="cursor: auto">${houseInfo.housingEstate.name}</a>
            </div>
            <div class="areaName">
                <i></i>
                <span class="label">所在区域</span>
                <span class="info">
                    <a target="_blank">${houseInfo.housingEstate.city}</a>&nbsp;
                    <a target="_blank">${houseInfo.housingEstate.town}</a>&nbsp;${houseInfo.housingEstate.street}
                </span>
            </div>
            <div class="visitTime">
                <i></i>
                <span class="label">看房时间</span>
                <span class="info">${houseInfo.openHome }</span>
            </div>
        </div>
        <div class="brokerInfo clear  ke-agent-sj-sdk component-agent-id-100001356" id="zuanzhan"
             style="position: relative">
            <div style="width: 0;height: 0;" class="ke-agent-data"></div>
            <div class="component-agent-es-pc-6">
                <a class="ke-agent-sj-avatar ke-agent-sj-avatar-100001356 ke-agent-sj-avatar-1000000026664826"
                   href="javascript:;">
                    <img class="agent-img" src="/photo/view?filename=${houseInfo.roconsultant.headPic}" alt=""
                         width="100" height="100"></a>
                <div class="brokerInfoText">
                    <div class="brokerName">
                        <a class="ke-agent-sj-name " href="javascript:;">
                        ${houseInfo.roconsultant.username}
                        </a>
                    </div>
                    <div class="phone">
                    ${houseInfo.roconsultant.mobile}
                        <div class="weapp-code">
                            <img class="img-wrapper" src="/home/bridalChamber/images/saoma.jpg">
                            <div class="qrcode-wrapper"> 微信联系我们</div>
                        </div>
                    </div>
                    <span class="ke-agent-sj-im ke-agent-sj-im-100001356 ke-agent-sj-im-1000000026664826"
                          style="position: relative;z-index: 1000;"
                          onclick="onlineChat(this)" data-username="${houseInfo.roconsultant.username}"
                          data-userId="${houseInfo.roconsultant.id}"><span>
                        <span class="im-text">在线咨询</span>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="m-content">
    <div class="box-l">
        <!-- 基本信息 -->
        <div class="newwrap baseinform" id="introduction">
            <div class="" style="width:700px;">
                <h2>
                    <div class="title">基本信息</div>
                </h2>
                <div class="introContent">
                    <div class="base">
                        <div class="name">基本属性</div>
                        <div class="content">
                            <ul>
                                <li><span class="label">房屋户型</span>${houseInfo.houseTypeDescribe}</li>
                                <li><span class="label">所在楼层</span>${houseInfo.floor}楼</li>
                                <li><span class="label">建筑面积</span>${houseInfo.area}㎡</li>
                                <li><span class="label">套内面积</span>${houseInfo.area}㎡</li>
                                <li><span class="label">建筑类型</span>${houseInfo.houseArchitectureType.getName()}</li>
                                <li><span class="label">房屋朝向</span>${houseInfo.houseOrientation.getName()}</li>
                                <li><span class="label">建筑结构</span>${houseInfo.housingEstate.buildingType}</li>
                                <li><span class="label">装修情况</span>${houseInfo.houseRenovation.getName()}</li>
                                <li><span class="label">梯户比例</span>${houseInfo.scale}</li>
                                <li><span class="label">配备电梯</span>${houseInfo.houseElevator.getName()}</li>
                            </ul>
                        </div>
                    </div>
                    <div class="transaction">
                        <div class="name">交易属性</div>
                        <div class="content">
                            <ul>
                                <li>
                                    <span class="label ">挂牌时间</span>
                                    <span>${houseInfo.createTime}</span>
                                </li>
                                <li>
                                    <span class="label ">交易权属</span>
                                    <span>${houseInfo.houseOwnership.getName()}</span>
                                </li>
                                <li>
                                    <span class="label ">房屋用途</span>
                                    <span>${houseInfo.housePurpose.getName()}</span>
                                </li>
                                <li>
                                    <span class="label ">房屋年限</span>
                                    <span>${houseInfo.housingYears}</span>
                                </li>
                                <li>
                                    <span class="label">抵押信息</span>
                                    <span>${houseInfo.mortgageInfo}</span>
                                    </span>
                                </li>
                                <li>
                                    <span class="label ">出售情况</span>
                                    <span>${houseInfo.houseSales.getName()}</span>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- 房源特色 -->
        <div class="newwrap baseinform">
            <h2>
                <div class="title" style="margin-top:50px;">房源特色</div>
            </h2>
            <div class="introContent showbasemore">
                <div class="tags clear">
                    <div class="name">房源标签</div>
                    <div class="content">
                        <#if houseInfo.houseLabel??>
                            <#if houseInfo.houseLabel?size gt 0>
                                <#list houseInfo.houseLabel as label>
                                    <a style="cursor:auto" class="tag is_near_subway ">${label.name}</a>
                                </#list>
                            </#if>
                        </#if>
                    </div>
                </div>
                <div class="baseattribute clear">
                    <div class="name">核心卖点</div>
                    <div class="content">${houseInfo.sellingPoint}</div>
                </div>
                <div class="baseattribute clear">
                    <div class="name">户型介绍</div>
                    <div class="content">
                    ${houseInfo.houseIntroduce}
                    </div>
                </div>
                <div class="baseattribute clear">
                    <div class="name">装修描述</div>
                    <div class="content">
                    ${houseInfo.decorationDescription}
                    </div>
                </div>
                <div class="disclaimer">
                    注：1.房源介绍中的周边配套、在建设施、规划设施、地铁信息、绿化率、得房率、容积率等信息为通过物业介绍、房产证、实勘、政府官网等渠道获取，因时间、政策会发生变化，与实际情况可能略有偏差，房源介绍仅供参考。
                    2.房源介绍中与距离相关的数据均来源于百度地图。 3.土地使用起止年限详见业主土地证明材料或查询相关政府部门的登记文件。
                </div>
            </div>
        </div>
        <!-- 户型分间 -->
        <div class="newwrap">
            <div class="layout-wrapper" id="layout">
                <div class="layout">
                    <h3>
                        <div class="title">户型分间</div>
                    </h3>
                    <div class="frame frameItem">
                        <div id="framesdk"
                             class="agent-tips ke-agent-sj-sdk component-agent-type-1 component-agent-id-100001360"></div>
                    </div>
                    <div class="content">
                        <div class="clear"></div>
                        <div class="imgdiv">
                            <img src="/photo/view?filename=${houseInfo.coverPic}">
                        </div>
                        <div class="des">
                            <div class="info">
                                <div class="list">
                                    <div id="infoList">
                                        <div class="row">
                                            <div class="col">房间名：</div>
                                            <div class="col">面积：</div>
                                            <div class="col">朝向：</div>
                                            <div class="col">窗户类型：</div>
                                        </div>
                                        <#if houseDivisionInfo??>
                                            <#if houseDivisionInfo?size gt 0>
                                                <#list houseDivisionInfo as division>
                                                    <div class="row">
                                                        <div class="col">${division.name}</div>
                                                        <div class="col">${division.divisionArea}平米</div>
                                                        <div class="col">${division.orientation}</div>
                                                        <div class="col">${division.houseDivisionWindowEnum.getName()}</div>
                                                    </div>
                                                </#list>
                                            <#else>
                                                <div class="row">
                                                    <h1 class="col">暂无分间信息</h1>
                                                </div>
                                            </#if>
                                        <#else>
                                            <div class="row">
                                                <h1 class="col">暂无分间信息</h1>
                                            </div>
                                        </#if>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <span class="justify_fix"></span>
                        <p class="disclaimer">注：户型图标注的面积不同于房本面积，存在测量误差，购房请以房本面积为准。</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- 房源照片 -->
        <div class="newwrap">
            <div class="content-wrapper housePic">
                <h3>
                    <div class="title">房源照片</div>
                </h3>
                <div class="container">
                    <div class="list">
                        <div>
                            <img src="/photo/view?filename=${houseInfo.coverPic}" alt="" width="710" height="400">
                        </div>
                    <#if houseInfo.detailsPics?length gt 0>
                        <#list houseInfo.detailsPics?split(",") as picture>
                            <#if picture?length gt 0>
                              <div >
                                  <img src="/photo/view?filename=${picture}" alt="" width="350" height="230">
                              </div>
                            </#if>
                        </#list>
                    <#else>
                        <div>
                            <h1>此房屋照片待上传
                        </div>
                    </#if>
                    </div>
                </div>
                <!-- 看房记录 -->
                <div class="newwrap">
                    <div class="record" id="record">
                        <div class="list">
                            <div class="title">看房记录
                                <span class="next disable"><i></i></span>
                                <span class="pre disable"><i></i></span>
                            </div>
                            <div class="content">
                                <div class="record-header">
                                    <div class="item mytime">带看时间</div>
                                    <div class="item myname">带看经纪人</div>
                                    <div class="item mytotal">本房总带看</div>
                                    <div class="phone" style="margin-left:12px;">咨询电话</div>
                                </div>
                            <#if houseInspectionRecord??>
                                <#if houseInspectionRecord?size gt 0>
                                    <#list houseInspectionRecord as record>
                                    <div class="row">
                                        <div class="item mytime">${record.createTime?string("yyyy-MM-dd")}</div>
                                        <div class="item agentName myname">
                                            <a class="agent-icon" target="_blank">
                                                <img src="/photo/view?filename=${record.user.headPic}" alt="">
                                                <span style="cursor: auto">${record.user.username}</span>
                                            </a>
                                        </div>
                                        <div class="item mytotal">${record.coun}</div>
                                        <div class="phone">${record.user.mobile}</div>
                                    </div>
                                    </#list>
                                <#else>
                                <div class="row"><span class="noData">暂无看房记录</span></div>
                                </#if>
                            <#else>
                            <div class="row"><span class="noData">暂无看房记录</span></div>
                            </#if>
                            </div>
                        </div>
                        <div class="panel">
                            <div class="panel-title">近7天带看次数</div>
                            <div class="count">${withinSevenDays}</div>
                            <div class="totalCount">- 30日带看<span>${withinThirtyDays}</span>次 -</div>
                        </div>
                    </div>
                </div>

                <div id="loader" style="display:none"></div>
                <!-- 价格变动 -->
                <div class="newwrap">
                    <div class="priceChange">
                        <div class="pchangeheader">
                            <span class="title">价格变动</span>
                            <span class="subTitle">当前房源共有过<span></span>条价格记录</span>
                            <span class="btn">
                        <span class="pre disable"><i></i></span>
                        <span class="next disable"><i></i></span>
                    </span>
                        </div>
                        <div class="container" id="priceChangeBar"></div>
                    </div>
                </div>
                <div id="resblockCardContainer"></div>
                <div id="resblockBannerContainer"></div>
            </div>
        </div>
    </div>
</div>
<!-- 周边配套 -->
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
<#--推荐房源-->
<div id="pushContainer" log-mod="ershoufang_detail_recommend-ershoufang" class="">
    <div class="push">
        <h3 class="pushheader">为您推荐优质房源</h3>
        <ul class="pushList">
            <#if findTop8By??>
                <#if findTop8By?size gt 0>
                    <#list findTop8By as findTop>
                     <li class="pushListItem">
                         <a target="_blank" href="/home/index/house_info_detail?id=${findTop.id}"
                            class="LOGCLICK LOGCLICKDATA xiangqingRecommendList">
                             <div class="pic">
                                 <img class="new-default-icon"
                                      src="/photo/view?filename=${findTop.coverPic}">
                             </div>
                             <div class="htitle">
                                 <p class="position">${findTop.district}</p>
                                 <p class="position">${findTop.housingEstate.name}</p>
                             </div>
                             <div class="info">
                                 <span>${findTop.houseType.getName()}·${findTop.area}平米</span>
                                 <span class="tips-price">${findTop.specificPrice}万</span>
                             </div>
                         </a>
                     </li>
                    </#list>
                </#if>
            </#if>

        </ul>
    </div>
</div>


<#--顶部导航栏-->
<div class="tab-wrap">
    <div class="wrap" style="display: none;" id="navigationBar">
        <div class="panel-tab">
            <ul class="clear">
                <li class="" id="introductionOn"><a href="#introduction">房源信息介绍</a></li>
                <li class="" id="layoutOn"><a href="#layout">户型分间</a></li>
                <li class="" id="recordOn"><a href="#record">看房记录</a></li>
                <li class="" id="aroundOn"><a href="#around">周边配套</a></li>
                <li class="" id="pushContainerOn"><a href="#pushContainer">优质房源</a></li>
            </ul>
        </div>
    </div>
</div>

<div id="customer-service-chat-div">

</div>

<#include "common/footer.ftl">
<script type="text/javascript" src="/admin/js/jquery.min.js"></script>
<script src="/home/houseInfo/js/lianjiaim1.1.min.js"></script>
<script type="text/javascript" src="/home/houseInfo/js/prism-flash-min.js"></script>
<script type="text/javascript" src="/home/houseInfo/js/captcha.js"></script>
<script type="text/javascript" src="/home/houseInfo/js/pclogin.js"></script>
<script type="text/javascript" src="/home/layui/layui/layui.all.js"></script>
<script src="//api.map.baidu.com/api?type=webgl&v=1.0&ak=Gepby3PliGhP0Qcf2XssaUKxkBMfboWH"></script>
<script>
    var dataDd = "${houseInfo.housingEstate.latitudeAndLongitude}";
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
    var label = new BMapGL.Label("${houseInfo.housingEstate.name},${houseInfo.housingEstate.street}", opts);
    // 自定义文本标注样式
    label.setStyle({
        color: 'blue',
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

    //导航栏添加高亮
    $(".panel-tab").on('click', 'li a', function () {
        $(".panel-tab").find("li a").each(function () {
            $(this).removeClass("on");
        });
        $(this).addClass("on");
    });

    //滚动条导航事件
    $(window).scroll(function () {//获得滚动条距离顶部的高度
        var scrollHeight = $(window).scrollTop();
        var introduction = $("#introduction").offset().top;
        var layout = $("#layout").offset().top;
        var record = $("#record").offset().top;
        var around = $("#around").offset().top;
        var pushContainer = $("#pushContainer").offset().top - 300;

        if (scrollHeight > introduction && scrollHeight < layout) {
            $("#navigationBar").css("display", "block");
            $(".panel-tab").find("li a").each(function () {
                $(this).removeClass("on");
            });
            $("#introductionOn").children().addClass("on");
        } else if (scrollHeight < introduction) {
            $(".panel-tab").find("li a").each(function () {
                $(this).removeClass("on");
            });
            $("#navigationBar").css("display", "none");
        } else if (scrollHeight > layout && scrollHeight < record) {
            $(".panel-tab").find("li a").each(function () {
                $(this).removeClass("on");
            });
            $("#layoutOn").children().addClass("on");
        } else if (scrollHeight > record && scrollHeight < around) {
            $(".panel-tab").find("li a").each(function () {
                $(this).removeClass("on");
            });
            $("#recordOn").children().addClass("on");
        } else if (scrollHeight > around && scrollHeight < pushContainer) {
            $(".panel-tab").find("li a").each(function () {
                $(this).removeClass("on");
            });
            $("#aroundOn").children().addClass("on");
        } else if (scrollHeight > pushContainer) {
            $(".panel-tab").find("li a").each(function () {
                $(this).removeClass("on");
            });
            $("#pushContainerOn").children().addClass("on");
        }
    });

    layui.use(['carousel', 'form'], function () {
        var carousel = layui.carousel
                , form = layui.form;
        //图片轮播
        carousel.render({
            elem: '#test1'
            , width: '710px'
            , height: '440px'
            , interval: 5000
            , indicator: 'none'
        });
    });
</script>


<script>
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

                    var dataUserName = $(t).attr("data-username");
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

</body>

</html>
