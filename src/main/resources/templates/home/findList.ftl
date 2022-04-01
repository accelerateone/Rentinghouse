<div id="count" class="resultDes clear">
    <h2 class="total fl">共找到<span> ${pageBean.total}</span>套二手房</h2>
    <div class="button fr"></div>
</div>
<ul id="listAll" class="sellListContent" log-mod="list">
    <#if pageBean.content??>
        <#if pageBean.content?size gt 0>
            <#list pageBean.content as house>
                <li class="clear LOGVIEWDATA LOGCLICKDATA">
                    <input id="detail" type="hidden" value="${house.id}">
                    <a class="noresultRecommend img LOGCLICKDATA" href="/home/index/house_info_detail?id=${house.id}">
                        <img src="/photo/view?filename=${house.coverPic}">
                    </a>
                    <div class="info clear">
                        <div class="title">
                            <a class="" href="/home/index/house_info_detail?id=${house.id}" >${house.details}</a>
                        </div>
                        <div class="flood">
                            <div class="positionInfo">
                                <span class="positionIcon"></span>
                                <a href="" target="_blank">
                                    <#if house.housingEstate??>
                                        ${house.housingEstate.name}
                                    </#if>
                                </a>
                                <a href="" target="_blank">${house.district}</a>
                            </div>
                        </div>
                        <div class="address">
                            <div class="houseInfo">
                                <span class="houseIcon"></span>
                                ${house.houseTypeDescribe} | ${house.area}平米 | ${house.houseOrientation.getName()} | ${house.houseRenovation.getName()} | ${house.floor}楼 |<#if house.housingEstate??>${house.housingEstate.completedYear}</#if> 年建 | ${house.houseArchitectureType.getName()}
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
<script>
    var M = {};
    M.curr = ${pageBean.currentPage}
    M.count = ${pageBean.total}
    $(document).ready(function () {
        //判断是否有已选择的条件
        layui.use('laypage', function(){
            var laypage = layui.laypage;
            laypage.render({
                elem: 'page'
                ,count: M.count //数据总数，从服务端得到
                ,limit:${pageBean.pageSize}
                ,curr:M.curr
                ,jump: function(obj, first){
                    //首次不执行
                    if(!first){
                        M.curr = obj.curr;
                        findList(M.curr);
                    }
                }
            });
        });
    });
</script>