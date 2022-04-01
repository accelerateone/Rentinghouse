<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <link rel="canonical" href="https://sh.lianjia.com/"/>
    <link rel="stylesheet" href="/home/bridalChamber/css/common.css">
    <link rel="stylesheet" type="text/css" href="/home/bridalChamber/css/main.css">
    <style type="text/css">
    </style>
</head>
<div class="header" data-stellar-background-ratio="0.07">
    <div class="wrapper">
        <div class="fr">
            <div class="nav typeUserInfo">
                <div class="ti-hover">

                </div>
                <ul>
                    <li class="CLICKDATA"><a class="" href="/home/index/bridalChamberList">新房</a></li>
                    <li class="CLICKDATA"><a class="" href="/home/index/secondHouse">二手房</a></li>
                    <li class="CLICKDATA"><a lass="" href="/home/rentHouse/list">租房</a></li>
                </ul>
            </div>
        </div>
        <div class="clear"></div>
        <div class="header-wrap">
            <div class="wrap-ico"></div>
            <div class="house-num">

            </div>

        </div>
    </div>

</div>
</div>

<div class="new-house">
    <div class="wrapper">
        <div class="fl">
            <div class="name"></div>
            <p>真实信息准确同步，楼盘动态一手掌握<a href="/home/index/bridalChamberList" target="_blank">更多新房</a></p>
        </div>
        <div class="newhose-list">
            <ul>
                <#if topThree?size gt 0>
                <#list topThree as newHouseInfo>
                <li>
                    <a href="/home/index/particulars/${newHouseInfo.id}">

                        <img src="/photo/view?filename=${newHouseInfo.firstFigurePath}" alt="${newHouseInfo.name}">
                        <div class="bg"></div>
                        <div class="title">
                            ${newHouseInfo.name}
                            <span>
										<label>${newHouseInfo.averagePrice}</label>元/平
									</span>
                        </div>
                        <div class="title01"><span
                                title="${newHouseInfo.detailedAddress}">${newHouseInfo.detailedAddress}</span>
                        </div>
                    </a>
                </li>
                </#list>
                </#if>
            </ul>
        </div>
    </div>
</div>

<div class="new-house">
    <div class="wrapper">
        <div class="fl">
            <div class="name2"><h1 style="font-weight: 900;font-size: 30px">二手房 </h1></div>
            <p>纵览二手房，恋上这座城<a href="/home/index/secondHouse" target="_blank">更多二手房</a></p>
        </div>
        <div class="newhose-list">
            <ul>
                <#if houseInfoTopThree?size gt 0>
                <#list houseInfoTopThree as houseInfo>
                <li>
                    <a href="/home/index/house_info_detail?id=${houseInfo.id}">
                        <img src="/photo/view?filename=${houseInfo.coverPic}" alt="${houseInfo.details}">
                        <div class="bg"></div>
                    </a>
                </li>
                </#list>

                </#if>

            </ul>
        </div>
    </div>
</div>
<div class="new-house">
    <div class="wrapper">
        <div class="fl">
            <div class="name2"><h1 style="font-weight: 900;font-size: 30px">租房</h1></div>
            <p>海量租房好房，畅享美好生活<a href="/home/rentHouse/list" target="_blank">更多租房</a></p>
        </div>
        <div class="newhose-list">
            <ul>
                <#if rentHouseTopThree?size gt 0>
                    <#list rentHouseTopThree as rentHouse>
                        <li>
                            <a href="/home/rentHouse/details?id=${rentHouse.id}">
                                <img src="/photo/view?filename=${rentHouse.coverPic}" alt="${rentHouse.name}">
                                <div class="bg"></div>
                            </a>
                        </li>
                    </#list>

                </#if>
            </ul>
        </div>
    </div>
</div>


<#include "../common/footer.ftl">

<link property='stylesheet' rel="stylesheet" href="/home/bridalChamber/css/lianjiaim.css"/>

</body>
</html>
