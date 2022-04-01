<#if  pageBean.content??>
<#if pageBean.content?size gt 0>
    <#list  pageBean.content as newHouseInfo>
        <ul class="resblock-list-wrapper">
            <li class="resblock-list post_ulog_exposure_scroll has-results">
                <a href="/home/index/particulars/${newHouseInfo.id}" class="resblock-img-wrapper" title="${newHouseInfo.name}" target="_blank">
                    <img class="lj-lazy" src="/photo/view?filename=${newHouseInfo.firstFigurePath}">
                    <ul class="icon-wrapper">
                    </ul>
                    <div class="watermark">效果图</div>
                </a>
                <div class="resblock-desc-wrapper">
                    <div class="resblock-name">
                        <a href="/home/index/particulars/${newHouseInfo.id}" class="name" target="_blank">${newHouseInfo.name}</a>
                        <span class="resblock-type"
                              style="background: #FB9252;">${newHouseInfo.propertyType.getName()}</span>
                    </div>
                    <div class="resblock-location">
                        <span>${newHouseInfo.district}</span>
                        <i class="split">/</i>
                            ${newHouseInfo.province}${newHouseInfo.city}${newHouseInfo.district}${newHouseInfo.detailedAddress}
                        </a>
                    </div>
                    <div class="resblock-area">
                        <span>建面 ${newHouseInfo.builtUpArea}㎡</span>
                    </div>
                    <div class="resblock-agent">
                        <div id="ke_agent_xnlygcwlyblikf" class="ke-agent-sj-sdk"></div>
                    </div>
                    <div class="resblock-price">
                        <div class="main-price">
                            <span class="number">${newHouseInfo.averagePrice}</span>
                            <span class="desc">&nbsp;元/㎡(均价)</span>
                        </div>
                    </div>
                    <div class="resblock-tag">
                        <#if newHouseInfo.housingCharacteristicsList?size gt 0>
                            <#list newHouseInfo.housingCharacteristicsList as housingCharacteristics>
                                <span>${housingCharacteristics.name}</span>
                            </#list>
                        </#if>
                    </div>
                </div>
            </li>
        </ul>
    </#list>
<#else>

    <div class="content__list--item" data-el="listItem">
        <div class="lz lz_box" style="    border: 1px solid #eee; padding: 32px 40px;">
            <div class="title" style="font-size: 24px; color: #222; font-weight: 700;">暂无符合条件的房源</div>
        </div>
    </div>

</#if>
    <#else>

        <div class="content__list--item" data-el="listItem">
            <div class="lz lz_box" style="    border: 1px solid #eee; padding: 32px 40px;">
                <div class="title" style="font-size: 24px; color: #222; font-weight: 700;">暂无符合条件的房源</div>
            </div>
        </div>
</#if>
<input type="text" style="display: none" id="newHouseInfoCount" value="${count}">

<script>
    var curr =
    ${pageBean.currentPage}
    var count = ${pageBean.total}
        $(document).ready(function () {
            layui.use('laypage', function () {
                var laypage = layui.laypage;
                laypage.render({
                    elem: 'page'
                    , count: count //数据总数，从服务端得到
                    , limit:${pageBean.pageSize}
                    , curr: curr
                    , jump: function (obj, first) {
                        //首次不执行
                        if (!first) {
                            curr = obj.curr;
                            selectNewHouseInfoListAjax(curr);
                        }
                    }
                });
            });
        });
</script>