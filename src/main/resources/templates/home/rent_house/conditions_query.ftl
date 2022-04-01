<#if pageBean??>
    <#if pageBean.content?size gt 0>
      <input type="hidden" data-total="${pageBean.total}" id="total">
        <#list pageBean.content as rentHouse>
        <div class="content__list--item" data-el="listItem">
            <a class="content__list--item--aside" target="_blank" href="/home/rentHouse/details?id=${rentHouse.id}"
               title="${rentHouse.rentHouseWay.getName()}·${rentHouse.name} ">
                <img alt="" class="lazyload" src="/photo/view?filename=${rentHouse.coverPic}">
            </a>
            <div class="content__list--item--main">
                <p class="content__list--item--title">
                    <a class="twoline" target="_blank" href="/home/rentHouse/details?id=${rentHouse.id}">
                        ${rentHouse.rentHouseWay.getName()}·${rentHouse.name}&nbsp;
                        ${rentHouse.doorModel}&nbsp;${rentHouse.houseOrientation.getName()}
                    </a>
                </p>
                <p class="content__list--item--des">
                    <span>${rentHouse.district}</span>-
                    <span>${rentHouse.town}</span>-
                    <span>${rentHouse.housingEstate.name}</span>
                    <i>/</i>${rentHouse.area}㎡
                    <i>/</i>${rentHouse.houseOrientation.getName()}
                    <i>/</i>${rentHouse.doorModel}
                </p>
                <p class="content__list--item--bottom oneline">
                    <#if rentHouse.rentHouseFeaturesList??>
                        <#list rentHouse.rentHouseFeaturesList as rentHouseFeatures>
                            <i class="content__item__tag">${rentHouseFeatures.name}</i>
                        </#list>
                    </#if>
                </p>
                <span class="content__list--item-price"><em>${rentHouse.price}</em> 元/月</span>
            </div>
        </div>
        </#list>
        <#else>
            <div class="content__list--item" data-el="listItem">
                <div class="lz lz_box" style="border: 1px solid #eee; padding: 32px 40px;">
                    <div class="title" style="font-size: 24px; color: #222; font-weight: 700;">暂无符合条件的房源</div>
                </div>
            </div>
    </#if>

    <#else>
        <div class="content__list--item" data-el="listItem">
            <div class="lz lz_box" style="border: 1px solid #eee; padding: 32px 40px;">
                <div class="title" style="font-size: 24px; color: #222; font-weight: 700;">暂无符合条件的房源</div>
            </div>
        </div>
</#if>
<div id="demo">

</div>
<input type="text" style="display: none" id="rentHouseCount" value="${count}">
<script>
    //分页

    var curr = ${pageBean.currentPage};
    var count = ${pageBean.total};
    $(document).ready(function () {
        //判断是否有已选择的条件
        layui.use('laypage', function () {
            var laypage = layui.laypage;
            laypage.render({
                elem: 'demo'
                , count: count //数据总数，从服务端得到
                , limit:${pageBean.pageSize}
                , curr: curr
                , jump: function (obj, first) {
                    //首次不执行
                    if (!first) {
                        curr = obj.curr;
                        conditionsQuery(curr);
                    }
                }
            });
        });
    });
</script>