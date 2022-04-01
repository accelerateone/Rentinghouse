<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>${siteName!""}|楼盘管理-添加楼盘信息</title>
    <#include "../common/header.ftl"/>
    <link href="/admin/bootstrap-fileinput/fileinput.css" rel="stylesheet">
    <link rel="stylesheet" href="/admin/bootstrap-select/dist/css/bootstrap-select.min.css">
    <!--日期选择插件-->
    <link rel="stylesheet" href="/admin/bootstrap-datepicker/bootstrap-datepicker3.min.css">
</head>
<style>
    .bootstrap-datetimepicker-widget {
        text-align: center;
    }

    .spanSheng {
        border-color: #ebebeb;
        background-color: #f9fafb;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        border-top-right-radius: 0;
        border-bottom-right-radius: 0;
        border-right: 0;
        padding: 13px 19px 9px;
        font-size: 14px;
        font-weight: 400;
        line-height: 1;
        color: #555;
        text-align: center;
        background-color: #f9fafb;
        border: 1px solid #ebebeb;
        border-radius: 4px;
        width: 50px;
        white-space: nowrap;
        vertical-align: middle;
        position: absolute;
        left: 0px;
        top: 0px;
    }

    .spanS {
        border-color: #ebebeb;
        background-color: #f9fafb;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        border-top-right-radius: 0;
        border-bottom-right-radius: 0;
        border-right: 0;
        padding: 13px 19px 9px;
        font-size: 14px;
        font-weight: 400;
        line-height: 1;
        color: #555;
        text-align: center;
        background-color: #f9fafb;
        border: 1px solid #ebebeb;
        border-radius: 4px;
        width: 50px;
        white-space: nowrap;
        vertical-align: middle;
        position: absolute;
        left: 229px;
        top: 0px;
    }

    .spanQ {
        border-color: #ebebeb;
        background-color: #f9fafb;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        border-top-right-radius: 0;
        border-bottom-right-radius: 0;
        border-right: 0;
        padding: 13px 19px 9px;
        font-size: 14px;
        font-weight: 400;
        line-height: 1;
        color: #555;
        text-align: center;
        background-color: #f9fafb;
        border: 1px solid #ebebeb;
        border-radius: 4px;
        width: 50px;
        white-space: nowrap;
        vertical-align: middle;
        position: absolute;
        left: 458px;
        top: 0px;
    }
</style>
<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <aside class="lyear-layout-sidebar">

            <!-- logo -->
            <div id="logo" class="sidebar-header">
                <a href="/system/index"><img src="/admin/images/logo-sidebar.png" title="${siteName!""}"
                                             alt="${siteName!""}"/></a>
            </div>
            <div class="lyear-layout-sidebar-scroll">
                <#include "../common/left-menu.ftl"/>
                <link href="/admin/css/style.min.css" rel="stylesheet">
            </div>

        </aside>
        <!--End 左侧导航-->
        <#include "../common/header-menu.ftl"/>

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header"><h4>添加楼盘信息</h4></div>
                            <div class="card-body">
                                <form id="new-house-info-add-form" class="row">
                                    <div class="form-group col-md-12">
                                        <label>效果图上传</label>
                                        <div class="form-controls">
                                            <ul class="list-inline clearfix lyear-uploads-pic">
                                                <li class="col-xs-4 col-sm-3 col-md-2">
                                                    <figure>
                                                        <img src="/admin/images/default-head.jpg" id="show-picture-img"
                                                             alt="默认效果图">
                                                    </figure>
                                                </li>
                                                <input type="hidden" name="firstFigurePath" id="headPic">
                                                <input type="file" id="select-file" style="display:none;"
                                                       onchange="upload('show-picture-img','headPic')">
                                                <li class="col-xs-4 col-sm-3 col-md-2">
                                                    <a class="pic-add" id="add-pic-btn" href="javascript:void(0)"
                                                       title="点击上传"></a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">详情图上传</span>
                                        <div class="file-loading" style="height: 1200px">
                                            <input id="fileInput" type="file" multiple>
                                        </div>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <input type="text" style="visibility:hidden" value="1111"
                                               class="form-control required">
                                        <div id="distpicker">
                                            <span class="spanSheng">省</span>
                                            <select class="form-control" name="province" id="province"
                                                    style="position: absolute;left: 49px;top: 0px;"></select>
                                            <span class="spanS">市</span>
                                            <select class="form-control" id="city" name="city"
                                                    style="position: absolute;left: 278px;top: 0px;"></select>
                                            <span class="spanQ">区</span>
                                            <select class="form-control" id="district" name="district"
                                                    style="position: absolute;left: 507px;top: 0px;"></select>
                                        </div>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">详细地址</span>
                                        <input placeholder="请输入详细地址(无需省市区)" tips="请填写详细地址(无需省市区)"
                                               class="form-control" id="detailedAddress" name="detailedAddress"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">楼盘名称</span>
                                        <input type="text" class="form-control required" id="name" name="name" value=""
                                               placeholder="请输入楼盘名称" tips="请填写楼盘名称"/>
                                    </div>



                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">楼盘特色</span>
                                        <select name="housingCharacteristicsList" class="form-control selectpicker"
                                                multiple data-live-search="true" data-max-options="3" id="housingCharacteristicsList">
                                            <#list housingCharacteristicss as housingCharacteristics>
                                                <option value="${housingCharacteristics.id}">
                                                    ${housingCharacteristics.name}
                                                </option>
                                            </#list>
                                        </select>
                                    </div>


                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">装修状态:</span>
                                        <select name="decorateState" class="form-control" id="automobileType">
                                            <#if decorateStates??>
                                                <#list decorateStates as decorateState>
                                                    <option value="${decorateState}"
                                                            style="font-weight:bold;">${decorateState.getName()}</option>
                                                </#list>
                                            </#if>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">物业类型:</span>
                                        <select name="propertyType" class="form-control" id="automobileType">
                                            <#if propertyTypes??>
                                                <#list propertyTypes as propertyType>
                                                    <option value="${propertyType}"
                                                            style="font-weight:bold;">${propertyType.getName()}</option>
                                                </#list>
                                            </#if>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">售卖状态:</span>
                                        <select name="sellingTheState" class="form-control" id="automobileType">
                                            <#if sellingTheStates??>
                                                <#list sellingTheStates as sellingTheState>
                                                    <option value="${sellingTheState}"
                                                            style="font-weight:bold;">${sellingTheState.getName()}</option>
                                                </#list>
                                            </#if>
                                        </select>
                                    </div>


                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">建成面积(㎡)：</span>
                                        <input type="number" class="form-control required" id="builtUpArea"
                                               onkeyup="inputDouble(this)"
                                               name="builtUpArea" tips="请填写建成面积(㎡)" placeholder="请输入建成面积(㎡)"/>
                                    </div>


                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">楼盘所属顾问</span>
                                        <select name="user" class="form-control "
                                                data-live-search="true" id="user">
                                            <#list consultants as consultant>
                                                <option value="${consultant.id}">
                                                    ${consultant.username}
                                                </option>
                                            </#list>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">楼盘所属经纪人</span>
                                        <select name="users" class="form-control selectpicker"
                                                multiple data-live-search="true" id="users">
                                            <#list agents as agent>
                                                <option value="${agent.id}">
                                                    ${agent.username}
                                                </option>
                                            </#list>
                                        </select>
                                    </div>


                                    <div class="input-group m-b-10" >
                                        <span class="input-group-addon">最新开盘时间</span>
                                        <input class="form-control js-datepicker" type="text" id="LatestOpeningHours" name="LatestOpeningHours"  placeholder="yyyy-mm-dd" value="" data-date-format="yyyy-mm-dd">
                                    </div>


                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">预计完全开盘时间:</span>
                                        <select name="openingTime" class="form-control" id="automobileType">
                                            <#if openingTimes??>
                                                <#list openingTimes as openingTime>
                                                    <option value="${openingTime}"
                                                            style="font-weight:bold;">${openingTime.getName()}</option>
                                                </#list>
                                            </#if>
                                        </select>
                                    </div>



                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">均价(单价)(每平米/元)：</span>
                                        <input type="number" class="form-control required" id="averagePrice"
                                               onkeyup="inputDouble(this)" maxlength="15"
                                               name="averagePrice" tips="请填写均价(单价)(单位元)"
                                               placeholder="请输入均价(单价)(单位元)"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">地址经纬度:</span>
                                        <input type="text" class="form-control required" id="longitudeAndIatitude" name="longitudeAndIatitude"
                                               value="" placeholder="请填写经纬度（不清楚可以去下方链接自行拾取）" tips="请填写经纬度"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon" >经纬度坐标链接</span>
                                        <a style="margin-left: 10px;vertical-align: middle"  href="http://api.map.baidu.com/lbsapi/getpoint/index.html"
                                           target="_blank">百度地图拾取坐标系统</a>
                                    </div>


                                    <div style="display: none" id="divInput"></div>

                                    <div class="form-group col-md-12">
                                        <button type="button" class="btn btn-primary ajax-post"
                                                id="add-form-submit-btn">确 定
                                        </button>
                                        <button type="button" class="btn btn-default"
                                                onclick="javascript:history.back(-1);return false;">返 回
                                        </button>
                                    </div>

                                </form>

                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>
<#include "../common/footer.ftl"/>
<script src="/admin/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="/admin/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<script type="text/javascript" src="/admin/bootstrap-fileinput/fileinput.min.js"></script>
<script type="text/javascript" src="/admin/bootstrap-select/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/admin/bootstrap-select/js/i18n/defaults-zh_CN.js"></script>
<script src="/admin/Distpicker/js/distpicker.data.js"></script>
<script src="/admin/Distpicker/js/distpicker.js"></script>
<script src="/admin/Distpicker/js/main.js"></script>
<script type="text/javascript" src="/admin/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/admin/js/main.min.js"></script>
<script>


    $("#distpicker").distpicker({
        autoSelect: false
    });

    var resultPathData = new Array();
    var resultProviewIdData = new Array();

    //上传介绍图片
    $("#fileInput").fileinput({
        theme: 'explorer-fas',
        uploadUrl: '/upload/upload_file',
        overwriteInitial: false,
        initialPreviewAsData: true,
        showClose: false,
        showRemove: true,
        showUpload: true,//是否显示上传按钮
        initialPreviewShowDelete: false,
        previewSettings: {
            image: {width: "200px", height: "150px"},
        },
        allowedFileExtensions: ['jpg', 'png', 'jpeg', 'gif', 'bmp'],
        allowedFileTypes: ['image'],
        maxFileSize: 500,
        maxFileCount: 30,//最大上传文件数限制
        initialPreview: [
            "/admin/images/default-head.jpg"
        ]
    }).on("fileuploaded", function (event, data, proviewId) {
        resultPathData.push(data.response.data)
        resultProviewIdData.push(proviewId)
    }).on('filesuccessremove', function (event, previewId) {
        var proviewIdIndex = resultProviewIdData.indexOf(previewId);
        resultPathData.splice(proviewIdIndex, 1, "null");
    });


</script>
<script type="text/javascript">
    function inputDouble(obj) {
        obj.value = obj.value.replace(/[^\d.]/g, ""); //清除"数字"和"."以外的字符
        obj.value = obj.value.replace(/^\./g, ""); //验证第一个字符是数字
        obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个, 清除多余的
        obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
        obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'); //只能输入两个小数
    }

    function resultPathDataToJson(arr){
        if(!arr.length) return null;
        var i = 0;
        len = arr.length,
            array = [];
        for(;i<len;i++){
            array.push({"effectPicturePath":arr[i]});
        }
        return JSON.stringify(array);
    }

    $(document).ready(function () {
        //提交按钮监听事件
        $("#add-form-submit-btn").click(function () {

            if (!checkForm("new-house-add-form")) {
                return;
            }

            let filePaths = resultPathDataToJson(resultPathData);
            var data = $("#new-house-info-add-form").serialize();
            $.ajax({
                url: '/admin/effectPicture/saveAll',
                type: 'GET',
                async: false,
                data: data +"&filePaths="+filePaths,
                contentType: 'application/json;charset=utf-8', //设置请求头信息,防止乱码
                dataType: 'json',
                success: function (data) {
                    if(data.code == 0){
                        for (let i = 0; i < data.data.length; i++) {
                            var IcountHtml = "<input type=\"hidden\" name=\"effectPictureItems\" value=" + data.data[i].id + " >"
                            $("#divInput").append(IcountHtml);
                        }
                        var data1 = $("#new-house-info-add-form").serialize();
                        $.ajax({
                            url: 'add',
                            type: 'POST',
                            data: data1,
                            dataType: 'json',
                            success: function (data) {
                                if (data.code == 0) {
                                    showSuccessMsg('楼盘信息添加成功!', function () {
                                        window.location.href = 'list';
                                    })
                                } else {
                                    showErrorMsg(data.msg);
                                }
                            },
                            error: function (data) {
                                alert('网络错误!');
                            }
                        });
                    }else {
                        showErrorMsg(data.msg);
                    }
                },
                error: function (data) {
                    alert('网络错误!');
                }
            });


        });


        //监听上传图片按钮
        $("#add-pic-btn").click(function () {
            $("#select-file").click();
        });

    });


</script>
</body>
</html>