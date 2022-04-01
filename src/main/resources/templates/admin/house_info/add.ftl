<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>${siteName!""}|二手房管理-添加二手房</title>
<#include "../common/header.ftl"/>
    <link rel="stylesheet" href="/admin/bootstrap-select/dist/css/bootstrap-select.min.css">
    <link href="/admin/bootstrap-fileinput/fileinput.css" rel="stylesheet">
</head>
<style>

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
                <a href="index.html">
                    <img src="/admin/images/logo-sidebar.png" title="${siteName!""}" alt="${siteName!""}"/></a>
            </div>
            <div class="lyear-layout-sidebar-scroll">
        <#include "../common/left-menu.ftl"/>
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
                            <div class="card-header"><h4>添加二手房</h4></div>
                            <div class="card-body">
                                <form action="add" id="user-add-form" method="post" class="row">
                                    <div class="form-group col-md-12">
                                        <label>房间封面图上传</label>
                                        <div class="form-controls">
                                            <ul class="list-inline clearfix lyear-uploads-pic">
                                                <li class="col-xs-4 col-sm-3 col-md-2">
                                                    <figure>
                                                        <img name="coverPic" src="/admin/images/default-head.jpg"
                                                             id="show-picture-img"
                                                             alt="默认头像">
                                                    </figure>
                                                </li>
                                                <input type="hidden" name="coverPic" id="coverPic">
                                                <input type="file" id="select-file" style="display:none;"
                                                       onchange="upload('show-picture-img','coverPic')">
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
                                            <input id="fileinput" type="file" multiple>
                                        </div>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">小区:</span>
                                        <select name="housingEstate" class="form-control" id="housingEstate">
                                            <option value="0">请选择</option>
                                            <#if housingEstate??>
                                                <#if housingEstate?size gt 0>
                                                    <#list housingEstate as item>
                                                        <option value="${item.id}">${item.name}</option>
                                                    </#list>
                                                </#if>
                                            </#if>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">所属顾问</span>
                                        <select name="roconsultant.id" class="form-control" id="roconsultant">
                                        <#list consultants as roconsultant>
                                            <option value="${roconsultant.id}">${roconsultant.username}</option>
                                        </#list>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房型描述:</span>
                                        <input type="text" class="form-control required" id="houseTypeDescribe" name="houseTypeDescribe"
                                               value="" placeholder="请输入房型描述" tips="请填写房型描述"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">户型介绍:</span>
                                        <textarea class="form-control" rows="5" id="houseIntroduce" name="houseIntroduce" placeholder="请输入户型介绍" tips="请填写户型介绍"></textarea>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房间面积:</span>
                                        <input type="number" class="form-control required" id="area" name="area"
                                               value="" placeholder="请输入房间面积" tips="请填写房间面积"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">所在楼层:</span>
                                        <input type="number" class="form-control required" id="floor" name="floor"
                                               value="" placeholder="请输入所在楼层" tips="请填写所在楼层"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">梯户比例描述:</span>
                                        <input type="text" class="form-control required" id="scale" name="scale"
                                               value="" placeholder="请输入梯户比例描述" tips="请填写梯户比例描述"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">卖点:</span>
                                        <input type="text" class="form-control required" id="sellingPoint" name="sellingPoint"
                                               value="" placeholder="请输入卖点" tips="请填写卖点"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋详情介绍:</span>
                                        <textarea class="form-control" rows="5" id="details" name="details" placeholder="请输入房屋详情介绍" tips="请填写房屋详情介绍"></textarea>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">楼龄:</span>
                                        <input type="number" class="form-control required" id="buildingAge" name="buildingAge"
                                               value="" placeholder="请输入楼龄" tips="请填写楼龄"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">楼栋号:</span>
                                        <input type="number" class="form-control required" id="buildingNumber" name="buildingNumber"
                                               value="" placeholder="请输入楼栋号" tips="请填写楼栋号"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋号:</span>
                                        <input type="number" class="form-control required" id="houseNumber" name="houseNumber"
                                               value="" placeholder="请输入房屋号" tips="请填写房屋号"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">具体售价(总价):</span>
                                        <input type="number" class="form-control required" id="specificPrice" name="specificPrice"
                                               value="" placeholder="请输入具体售价(总价,单位:万)" tips="请填写具体售价(总价,单位:万)"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">抵押信息:</span>
                                        <input type="text" class="form-control required" id="mortgageInfo" name="mortgageInfo"
                                               value="" placeholder="请输入抵押信息" tips="请填写抵押信息"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋年限描述:</span>
                                        <input type="text" class="form-control required" id="housingYears" name="housingYears"
                                               value="" placeholder="请输入房屋年限描述" tips="请填写房屋年限描述"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">看房时间:</span>
                                        <input type="text" class="form-control required" id="openHome" name="openHome"
                                               value="" placeholder="请输入看房时间" tips="请填写看房时间"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">装修描述:</span>
                                        <input type="text" class="form-control required" id="decorationDescription" name="decorationDescription"
                                               value="" placeholder="请输入装修描述" tips="请填写装修描述"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋标签:</span>
                                        <select name="houseLabel" class="form-control selectpicker" multiple data-live-search="true" id="houseLabel">
                                            <#list houseLabels as houseLabel>
                                                <option value="${houseLabel.id}">
                                                    ${houseLabel
                                                    .name}
                                                </option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房型：</span>
                                        <select name="houseType" class="form-control" id="houseType">
                                            <#list houseType as item>
                                                <option value="${item}">${item.getName()}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋朝向：</span>
                                        <select name="houseOrientation" class="form-control" id="houseOrientation">
                                            <#list houseOrientation as item>
                                                <option value="${item}">${item.getName()}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋装修：</span>
                                        <select name="houseRenovation" class="form-control" id="houseRenovation">
                                            <#list houseRenovation as item>
                                                <option value="${item}">${item.getName()}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋用途：</span>
                                        <select name="housePurpose" class="form-control" id="housePurpose">
                                            <#list housePurpose as item>
                                                <option value="${item}">${item.getName()}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">有无电梯：</span>
                                        <select name="houseElevator" class="form-control" id="houseElevator">
                                            <#list houseElevator as item>
                                                <option value="${item}">${item.getName()}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋权属：</span>
                                        <select name="houseOwnership" class="form-control" id="houseOwnership">
                                            <#list houseOwnership as item>
                                                <option value="${item}">${item.getName()}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">建筑类型：</span>
                                        <select name="houseArchitectureType" class="form-control" id="houseArchitectureType">
                                            <#list houseArchitectureType as item>
                                                <option value="${item}">${item.getName()}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋出售情况：</span>
                                        <select name="houseSales" class="form-control" id="houseSales">
                                            <#list houseSales as item>
                                                <option value="${item}">${item.getName()}</option>
                                            </#list>
                                        </select>
                                    </div>
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
<#--
        &lt;#&ndash;文件名字弹出层&ndash;&gt;
        <div class='simple_dlg_define' style='display:none'>
            <div class='pane' style='padding:16px'>
                <div class="layui-form-item">
                    <label class="layui-form-label">图片名:</label>
                    <div class="layui-input-block">
                        <input class='layui-input pic' type='text' placeholder="请输入图片名">
                    </div>
                </div>
            </div>
        </div>-->
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
<script type="text/javascript">



    $("#distpicker").distpicker({
        autoSelect: false
    });

    var resultData = new Array();
    var resultProviewIdData = new Array();

    //上传租房详情介绍图片
    $("#fileinput").fileinput({
        theme: 'explorer-fas',
        uploadUrl: '/upload/upload_file',
        overwriteInitial: false,
        initialPreviewAsData: true,
        showUpload: true,//是否显示上传按钮
        initialPreviewShowDelete: false,
        previewSettings: {
            image: {width: "200px", height: "150px"},
        },
        allowedFileExtensions: ['jpg', 'png', 'jpeg', 'gif', 'bmp'],
        allowedFileTypes: ['image'],
        maxFileSize: 500,
        maxFileCount: 3,//最大上传文件数限制
    }).on("fileuploaded", function (event, data, proviewId) {

        resultData.push(data.response.data);
        resultProviewIdData.push(proviewId);

    }).on('filesuccessremove', function (event, previewId) {
        var proviewIdIndex = resultProviewIdData.indexOf(previewId);
        resultData.splice(proviewIdIndex, 1, "null");

    });




    $(document).ready(function () {
        //提交按钮监听事件
        $("#add-form-submit-btn").click(function () {
            if (!checkForm("user-add-form")) {
                return;
            }
            var str = "";
            for (var i = 0; i < resultData.length; i++) {
                if (resultData[i] != null && resultData[i] != "null") {
                    str += resultData[i] + ",";
                }
            }
            var data = $("#user-add-form").serialize();
            data += "&detailsPics=" + str;
            $.ajax({
                url: 'add',
                type: 'POST',
                data: data,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 0) {
                        showSuccessMsg('添加成功!', function () {
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
        });
        //监听上传图片按钮
        $("#add-pic-btn").click(function () {
            $("#select-file").click();
        });
    });
</script>
</body>
</html>