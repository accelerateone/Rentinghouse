<!DOCTYPE html>
<html>
<title>二手房</title>
<link property='stylesheet' rel="stylesheet" href="/home/houseInfo/css/lianjiaim.css"/>
<link rel="stylesheet" href="/home/houseInfo/css/common.css">
<link rel="stylesheet" href="/home/houseInfo/css/index.css">
<link rel="stylesheet" href="/home/layui/layui/css/layui.css">
<link rel="stylesheet" href="/home/bridalChamber/css/listsite.css">
<link rel="stylesheet" href="/home/bridalChamber/css/list.css">
<style type="text/css">
    .item {
        margin-left: 6px;
    }

    .aui-col-xs-5 {
        display: inline-block;
    }

    .aui-col-xs-5 select {
        height: 35px;
    }

    #page .layui-laypage {
        font-size: 10px;
    }

    #page {
        margin-left: 500px;
    }

    .city {
        display: block;
    }
</style>
<body>
<header class="new-header">
    <#include "common/header.ftl"/>
</header>
<div class="city-change animated bounceIn hide" id="cityDiv">
    <span class="city-close" onclick="close()"></span>
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

<div class="header">
    <div class="menu">
        <div class="menuLeft">
            <img src="/admin/images/ylrc-logo.png">
            <ul class="typeList">
                    <#if sales??>
                        <#if sales?size gt 0>
                            <#list sales as item>
                                <li class="LOGVIEWDATA LOGCLICKDATA">
                                    <a href="javascript:;" data-value="${item.getCode()}">${item.getName()}</a>
                                </li>
                            </#list>
                        </#if>
                    </#if>
                <a class="s-city" id="queryCity" title="选择城市">选择城市</a>
            </ul>
        </div>
    </div>
    <div class="search">
        <div class="input" log-mod="search">
            <input type="text" id="searchInput" value="" autocomplete="off" placeholder="请输入小区名或区名开始找房">
            <div class="inputRightPart">
                <button type='submit' class="searchButton" data-bl="search" data-el="search" id="searchBtn">&nbsp;<i></i>&nbsp;
                </button>
            </div>
        </div>
    </div>
</div>
<div>
    <div class="m-filter">
        <div class="list-more">
        <#--售价-->
            <dl class="hasmore price">
                <h2>
                    <dt>售价</dt>
                </h2>
                <dd>
                        <#if price??>
                            <#if price?size gt 0>
                                <#list price as item>
                                    <a href="javascript:;" class="" rel="nofollow">
                                        <span class="checkbox" data-value="${item.getCode()}"></span>
                                        <span class="name">${item.getName()}</span>
                                    </a>
                                </#list>
                            </#if>
                        </#if>
                    <span class="customFilter mt hide" data-role="price">
                            <input type="text" role="minValue" value="">
                            <span>-</span>
                            <input type="text" role="maxValue" value="">&nbsp;
                            <span>万</span>
                            <button class="btn-range hide" data-url="/ershoufang/bp{min}ep{max}">确定</button>
                        </span>
                </dd>
            </dl>
        <#--房型-->
            <dl class="houseType">
                <h2>
                    <dt>房型</dt>
                </h2>
                <dd>
                        <#if houseType??>
                            <#if houseType?size gt 0>
                                <#list houseType as item>
                                    <a href="javascript:;" class="" rel="nofollow">
                                        <span class="checkbox " data-value="${item.getCode()}"></span>
                                        <span class="name">${item.getName()}</span>
                                    </a>
                                </#list>
                            </#if>
                        </#if>
                </dd>
            </dl>
        <#--面积-->
            <dl class="hasmore area">
                <h2>
                    <dt>面积</dt>
                </h2>
                <dd>

                <#if area??>
                    <#if area?size gt 0>
                        <#list area as item>
                            <a href="javascript:;" class="" rel="nofollow">
                                <span class="checkbox" data-value="${item.getCode()}"></span>
                                <span class="name">${item.getName()}</span>
                            </a>
                        </#list>
                    </#if>
                </#if>
                    <span class="customFilter mt hide" data-role="area">
                        <input type="text" role="minValue" value="">
                        <span>-</span>
                        <input type="text" role="maxValue" value="">&nbsp;
                        <span>平</span>
                        <button class="btn-range hide" data-url="/ershoufang/ba{min}ea{max}">确定</button>
                    </span>
                </dd>
            </dl>
        <#--标签-->
            <dl class="labels">
                <h2>
                    <dt>标签</dt>
                </h2>
                <dd>
                <#if labels??>
                    <#if labels?size gt 0>
                        <#list labels as item>
                            <a href="javascript:;" class="" rel="nofollow">
                                <span class="checkbox" data-value="${item.id}"></span>
                                <span class="name">${item.name}</span>
                            </a>
                        </#list>
                    </#if>
                </#if>
                </dd>
            </dl>
        <#--朝向-->
            <dl class="hide orientation" id="orientation" data-role="hide-row">
                <h2>
                    <dt>朝向</dt>
                </h2>
                <dd>
                <#if orientation??>
                    <#if orientation?size gt 0>
                        <#list orientation as item>
                            <a href="javascript:;" class="" rel="nofollow">
                                <span class="checkbox" data-value="${item.getCode()}"></span>
                                <span class="name">${item.getName()}</span>
                            </a>
                        </#list>
                    </#if>
                </#if>
                </dd>
            </dl>
        <#--楼层-->
            <dl class="hide floor" data-role="hide-row">
                <h2>
                    <dt>楼层</dt>
                </h2>
                <dd>
                <#if floor??>
                    <#if floor?size gt 0>
                        <#list floor as item>
                            <a href="javascript:;" class="" rel="nofollow">
                                <span class="checkbox" data-value="${item.getCode()}"></span>
                                <span class="name">${item.getName()}</span>
                            </a>
                        </#list>
                    </#if>
                </#if>
                </dd>
            </dl>
        <#--楼龄-->
            <dl class="hide age" data-role="hide-row">
                <h2>
                    <dt>楼龄</dt>
                </h2>
                <dd>
                       <#if age??>
                            <#if age?size gt 0>
                                <#list age as item>
                                    <a href="javascript:;" class="" rel="nofollow">
                                        <span class="checkbox" data-value="${item.getCode()}"></span>
                                        <span class="name">${item.getName()}</span>
                                    </a>
                                </#list>
                            </#if>
                       </#if>
                </dd>
            </dl>
        <#--装修-->
            <dl class="hide renovation" data-role="hide-row">
                <h2>
                    <dt>装修</dt>
                </h2>
                <dd>
                        <#if renovation??>
                            <#if renovation?size gt 0>
                                <#list renovation as item>
                                    <a href="javascript:;" class="" rel="nofollow">
                                        <span class="checkbox" data-value="${item.getCode()}"></span>
                                        <span class="name">${item.getName()}</span>
                                    </a>
                                </#list>
                            </#if>
                        </#if>
                </dd>
            </dl>
        <#--用途-->
            <dl class="hide purpose" data-role="hide-row">
                <h2>
                    <dt>用途</dt>
                </h2>
                <dd>
                        <#if purpose??>
                            <#if purpose?size gt 0>
                                <#list purpose as item>
                                    <a href="javascript:;" class="" rel="nofollow">
                                        <span class="checkbox" data-value="${item.getCode()}"></span>
                                        <span class="name">${item.getName()}</span>
                                    </a>
                                </#list>
                            </#if>
                        </#if>
                </dd>
            </dl>
        <#--电梯-->
            <dl class="hide elevator" data-role="hide-row">
                <h2>
                    <dt>电梯</dt>
                </h2>
                <dd>
                       <#if elevator??>
                            <#if elevator?size gt 0>
                                <#list elevator as item>
                                    <a href="javascript:;" class="" rel="nofollow">
                                        <span class="checkbox" data-value="${item.getCode()}"></span>
                                        <span class="name">${item.getName()}</span>
                                    </a>
                                </#list>
                            </#if>
                       </#if>
                </dd>
            </dl>
        <#--权属-->
            <dl class="hide ownership" data-role="hide-row">
                <h2>
                    <dt>权属</dt>
                </h2>
                <dd>
                       <#if ownership??>
                            <#if ownership?size gt 0>
                                <#list ownership as item>
                                    <a href="javascript:;" class="" rel="nofollow">
                                        <span class="checkbox" data-value="${item.getCode()}"></span>
                                        <span class="name">${item.getName()}</span>
                                    </a>
                                </#list>
                            </#if>
                       </#if>
                </dd>
            </dl>
        <#--类型-->
            <dl class="hide architectureType" data-role="hide-row">
                <h2>
                    <dt>类型</dt>
                </h2>
                <dd>
                        <#if architectureType??>
                            <#if architectureType?size gt 0>
                                <#list architectureType as item>
                                    <a href="javascript:;" class="" rel="nofollow">
                                        <span class="checkbox" data-value="${item.getCode()}"></span>
                                        <span class="name">${item.getName()}</span>
                                    </a>
                                </#list>
                            </#if>
                        </#if>
                </dd>
            </dl>
        </div>
        <div class="more btn-more" onclick="show()">
            <p style="display: inline-block">更多选项</p>
            <span class="arrow"></span>
        </div>
    </div>
</div>
<div class="content " id="content"><!-- 左侧内容 -->
    <div class="leftContent">
        <div class="orderFilter">
            <div class="orderTag">
                <ul>
                    <li class='selected default'>
                        <h3>
                            <a data-value="" href="javascript:;">默认排序<span></span></a>
                        </h3>
                    </li>
                    <li class="createTimeSort"><h3><a data-value="" href="javascript:;">最新发布<span></span></a></h3></li>
                    <li class="specificPriceSort"><h3><a data-value="" href="javascript:;">房屋总价<span></span></a></h3>
                    </li>
                    <li class="unitPriceSort"><h3><a data-value="" href="javascript:;">房屋单价<span></span></a></h3></li>
                    <li class="areaSort"><h3><a data-value="" href="javascript:;">房屋面积<span></span></a></h3></li>
                </ul>
            </div>
        </div>
    <#--<div id="count" class="resultDes clear">-->
    <#--<h2 class="total fl">共找到<span> ${pageBean.total}</span>套二手房</h2>-->
    <#--<div class="button fr"></div>-->
    <#--</div>-->
        <ul id="listAll" class="sellListContent" log-mod="list">
                 <#if pageBean.content??>
                     <#if pageBean.content?size gt 0>
                         <#list pageBean.content as house>
                             <li class="clear LOGVIEWDATA LOGCLICKDATA" onclick="detail(${house.id})">
                                 <input id="detail" type="hidden" value="${house.id}">
                                 <a class="noresultRecommend img LOGCLICKDATA"
                                    href="/home/index/house_info_detail?id=${house.id}">
                                     <img src="/photo/view?filename=${house.coverPic}">
                                 </a>
                                 <div class="info clear">
                                     <div class="title">
                                         <a class=""
                                            href="/home/index/house_info_detail?id=${house.id}">${house.details}</a>
                                     </div>
                                     <div class="flood">
                                         <div class="positionInfo">
                                             <span class="positionIcon"></span>
                                             <a href="javascript:;" target="_blank">
                                                 <#if house.housingEstate??>
                                                     ${house.housingEstate.name}
                                                 </#if>
                                             </a>
                                             -
                                             <a href="javascript:;" target="_blank">${house.district}</a>
                                         </div>
                                     </div>
                                     <div class="address">
                                         <div class="houseInfo">
                                             <span class="houseIcon"></span>
                                             ${house.houseTypeDescribe} | ${house.area}平米
                                             | ${house.houseOrientation.getName()} | ${house.houseRenovation.getName()}
                                             | ${house.floor}楼
                                             |<#if house.housingEstate??>${house.housingEstate.completedYear}</#if> 年建
                                             | ${house.houseArchitectureType.getName()}
                                         </div>
                                     </div>
                                     <div class="followInfo">
                                         <span class="starIcon"></span>
                                         发布时间：${house.createTime}
                                     </div>
                                     <div class="tag">
                                         <#if house.houseLabel??>
                                             <#if house.houseLabel?size gt 0>
                                                 <#list house.houseLabel as label>
                                                     <span class="vr">${label.name}</span>
                                                 </#list>
                                             </#if>
                                         </#if>
                                     </div>
                                     <div class="priceInfo">
                                         <div class="totalPrice">
                                             <span>${house.specificPrice}</span>万
                                         </div>
                                         <div class="unitPrice">
                                             <span>单价${house.unitPrice}元/平米</span>
                                         </div>
                                     </div>
                                 </div>
                             </li>
                         </#list>
                     <#else>
                      <div class="lz lz_box">
                          <div class="title">暂无符合条件的房源</div>
                      </div>
                     </#if>
                 <#else>
                     <div class="lz lz_box">
                         <div class="title">暂无符合条件的房源</div>
                     </div>
                 </#if>
        </ul>
        <div id="noResultPush" data-recommend_ext_info='[]'></div>
        <div class="contentBottom clear">
            <div id="page"></div>
        </div>
    </div>
    <div style="clear:both"></div>
</div>

<#include "common/footer.ftl">
</body>
<script type="text/javascript" src="/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="/home/houseInfo/js/distpicker.data.js"></script>
<script type="text/javascript" src="/home/houseInfo/js/distpicker.js"></script>
<script type="text/javascript" src="/home/layui/layui/layui.all.js"></script>
<#--hz-->
<script>
    var M = {};
    M.curr = ${pageBean.currentPage};
    M.count = ${pageBean.total};
    $(document).ready(function () {
        //判断是否有已选择的条件
        layui.use('laypage', function () {
            var laypage = layui.laypage;
            laypage.render({
                elem: 'page'
                , count: M.count //数据总数，从服务端得到
                , limit:${pageBean.pageSize}
                , curr: M.curr
                , jump: function (obj, first) {
                    //首次不执行
                    if (!first) {
                        M.curr = obj.curr;
                        findList(M.curr);
                    }
                }
            });
        });
    });

    function detail(id) {
        window.location.href = "/home/index/house_info_detail?id" + id;
    };
</script>
<script>
    $(document).ready(function () {
        var $this = $(".typeList a[data-value=0]");
        $this.parent("li").addClass("selected");
        $this.parent("li").siblings().removeClass("selected");
        findList(1);
    });

    function show() {
        if ($("#orientation").hasClass("hide")) {
            $("[data-role=hide-row]").removeClass("hide");
            $(".more p").text("收起选项");
            $(".more span").addClass("upArrow");
            $(".more span").removeClass("arrow");
        } else {
            $("[data-role=hide-row]").addClass("hide");
            $(".more p").text("更多选项");
            $(".more span").find("span").addClass("arrow");
            $(".more span").find("span").removeClass("upArrow");
        }
    }

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
        findList(1);
    });

    $("#searchBtn").click(function () {
        findList(1);
    });

    // 售价
    $(".price").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 房型
    $(".houseType").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 面积
    $(".area").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 标签
    $(".labels").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 朝向
    $(".orientation").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 楼层
    $(".floor").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 楼龄
    $(".age").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 装修
    $(".renovation").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 用途
    $(".purpose").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 电梯
    $(".elevator").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 权属
    $(".ownership").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    // 类型
    $(".architectureType").on("click", "dd a", function () {
        var $this = $(this);
        if (!$this.find("span.checkbox").hasClass("checked")) {
            $this.find("span.checkbox").addClass("checked");
        } else {
            $this.find("span.checkbox").removeClass("checked");
        }
        findList(1);
    });
    //出售情况
    $(".typeList li").on("click", function () {
        var $this = $(this);
        $this.addClass("selected")
        $this.siblings("li").removeClass("selected");
        findList(1);
    });
    //默认排序
    $(".default").on("click", function () {
        var $this = $(this);
        $this.addClass("selected");
        $this.siblings("li").removeClass("selected");
        $this.find("h3 a").attr("data-value", 0);
        $this.siblings("li").find("h3 a").attr("data-value", 0);
        findList(1);
    });
    //最新发布
    $(".createTimeSort").on("click", function () {
        var $this = $(this);
        $this.addClass("selected");
        $this.siblings("li").removeClass("selected");
        $this.find("h3 a").attr("data-value", 3);
        $this.siblings("li").find("h3 a").attr("data-value", 0);
        findList(1);
    });
    //房屋总价
    $(".specificPriceSort").on("click", function () {
        var $this = $(this);
        if ($this.hasClass("selected")) {
            if ($this.find("h3 a span").hasClass("upArrow")) {
                $this.siblings("li").removeClass("selected");
                $this.find("h3 a span").addClass("downArrow");
                $this.find("h3 a span").removeClass("upArrow");
                $this.find("h3 a").attr("data-value", 2);
                $this.siblings("li").find("h3 a").attr("data-value", 0);
                findList(1);
                return;
            } else if ($this.find("h3 a span").hasClass("downArrow")) {
                $this.siblings("li").removeClass("selected");
                $this.find("h3 a span").addClass("upArrow");
                $this.find("h3 a span").removeClass("downArrow");
                $this.find("h3 a").attr("data-value", 1);
                $this.siblings("li").find("h3 a").attr("data-value", 0);
                findList(1);
                return;
            }
        }
        $this.addClass("selected");
        $this.siblings("li").removeClass("selected");
        $this.find("h3 a span").addClass("upArrow");
        $this.find("h3 a").attr("data-value", 1);
        $this.siblings("li").find("h3 a").attr("data-value", 0);
        findList(1);
    });
    //房屋单价
    $(".unitPriceSort").on("click", function () {
        var $this = $(this);
        if ($this.hasClass("selected")) {
            if ($this.find("h3 a span").hasClass("upArrow")) {
                $this.siblings("li").removeClass("selected");
                $this.find("h3 a span").addClass("downArrow");
                $this.find("h3 a span").removeClass("upArrow");
                $this.find("h3 a").attr("data-value", 2);
                $this.siblings("li").find("h3 a").attr("data-value", 0);
                findList(1);
                return;
            } else if ($this.find("h3 a span").hasClass("downArrow")) {
                $this.siblings("li").removeClass("selected");
                $this.find("h3 a span").addClass("upArrow");
                $this.find("h3 a span").removeClass("downArrow");
                $this.find("h3 a").attr("data-value", 1);
                $this.siblings("li").find("h3 a").attr("data-value", 0);
                findList(1);
                return;
            }
        }
        $this.addClass("selected");
        $this.siblings("li").removeClass("selected");
        $this.find("h3 a span").addClass("upArrow");
        $this.find("h3 a").attr("data-value", 1);
        $this.siblings("li").find("h3 a").attr("data-value", 0);
        findList(1);
    });
    //房屋面积
    $(".areaSort").on("click", function () {
        var $this = $(this);
        if ($this.hasClass("selected")) {
            if ($this.find("h3 a span").hasClass("upArrow")) {
                $this.siblings("li").removeClass("selected");
                $this.find("h3 a span").addClass("downArrow");
                $this.find("h3 a span").removeClass("upArrow");
                $this.find("h3 a").attr("data-value", 2);
                $this.siblings("li").find("h3 a").attr("data-value", 0);
                findList(1);
                return;
            } else if ($this.find("h3 a span").hasClass("downArrow")) {
                $this.siblings("li").removeClass("selected");
                $this.find("h3 a span").addClass("upArrow");
                $this.find("h3 a span").removeClass("downArrow");
                $this.find("h3 a").attr("data-value", 1);
                $this.siblings("li").find("h3 a").attr("data-value", 0);
                findList(1);
                return;
            }
        }
        $this.addClass("selected");
        $this.siblings("li").removeClass("selected");
        $this.find("h3 a span").addClass("upArrow");
        $this.find("h3 a").attr("data-value", 1);
        $this.siblings("li").find("h3 a").attr("data-value", 0);
        findList(1);
    });

    function findList(page) {
        // var province = $("#province").val();//省
        // var district = $("#district").val();//区
        var city = $("#queryCity").text().trim();//市


        var priceList = new Array();//售价
        var priceListIds = $(".price dd a span.checked").each(function () {
            priceList.push($(this).attr("data-value"));
        });
        var houseTypeList = new Array();//房型
        var houseTypeListIds = $(".houseType dd a span.checked").each(function () {
            houseTypeList.push($(this).attr("data-value"));
        });
        var areaList = new Array();//面积
        var areaListIds = $(".area dd a span.checked").each(function () {
            areaList.push($(this).attr("data-value"));
        });
        var labelList = new Array();//标签
        var labelListIds = $(".labels dd a span.checked").each(function () {
            labelList.push($(this).attr("data-value"));
        });
        var orientationList = new Array();//朝向
        var orientationListIds = $(".orientation dd a span.checked").each(function () {
            orientationList.push($(this).attr("data-value"));
        });
        var floorList = new Array();//楼层
        var floorListIds = $(".floor dd a span.checked").each(function () {
            floorList.push($(this).attr("data-value"));
        });
        var ageList = new Array();//楼龄
        var ageListIds = $(".age dd a span.checked").each(function () {
            ageList.push($(this).attr("data-value"));
        });
        var renovationList = new Array();//装修
        var renovationListIds = $(".renovation dd a span.checked").each(function () {
            renovationList.push($(this).attr("data-value"));
        });
        var purposeList = new Array();//用途
        var purposeListIds = $(".purpose dd a span.checked").each(function () {
            purposeList.push($(this).attr("data-value"));
        });
        var elevatorList = new Array();//电梯
        var elevatorListIds = $(".elevator dd a span.checked").each(function () {
            elevatorList.push($(this).attr("data-value"));
        });
        var ownershipList = new Array();//权属
        var ownershipListIds = $(".ownership dd a span.checked").each(function () {
            ownershipList.push($(this).attr("data-value"));
        });
        var architectureTypeList = new Array();//建筑类型
        var architectureTypeListIds = $(".architectureType dd a span.checked").each(function () {
            architectureTypeList.push($(this).attr("data-value"));
        });
        var sales = $(".typeList").find("li.selected").find("a").attr("data-value");

        //最新发布
        var createTimeSort = $(".createTimeSort").find("h3 a").attr("data-value");
        //房屋总价排序
        var specificPriceSort = $(".specificPriceSort").find("h3 a").attr("data-value");
        //房屋单价排序
        var unitPriceSort = $(".unitPriceSort").find("h3 a").attr("data-value");
        //房屋面积排序
        var areaSort = $(".areaSort").find("h3 a").attr("data-value");

        var search = $("#searchInput").val(); //搜索内容
        var data = JSON.stringify({
            city: city,
            housePrice: priceList,
            houseType: houseTypeList,
            houseArea: areaList,
            houseLabel: labelList,
            houseOrientation: orientationList,
            houseFloor: floorList,
            houseAge: ageList,
            houseRenovation: renovationList,
            housePurpose: purposeList,
            houseElevator: elevatorList,
            houseOwnership: ownershipList,
            houseArchitectureType: architectureTypeList,
            houseSales: sales,
            createTimeSort: createTimeSort,
            specificPriceSort: specificPriceSort,
            unitPriceSort: unitPriceSort,
            areaSort: areaSort,
            search:search
        });
        $.ajax({
            type: 'POST',
            url: '/home/index/secondHouse/findList?currentPage=' + page,
            contentType: 'application/json;charset=utf-8',
            data: data,
            dataType: 'html',
            async: true,
            success: function (data) {
                $("#listAll").html(data);
            }
        });
    }
</script>
</html>
