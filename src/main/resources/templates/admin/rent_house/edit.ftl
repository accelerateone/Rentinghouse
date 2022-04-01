<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, rentHouse-scalable=no"/>
    <title>${siteName!""}|租房管理-编辑租房</title>
<#include "../common/header.ftl"/>
    <link href="/admin/bootstrap-fileinput/fileinput.css" rel="stylesheet">
    <link rel="stylesheet" href="/admin/bootstrap-select/dist/css/bootstrap-select.min.css">
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
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <aside class="lyear-layout-sidebar">

            <!-- logo -->
            <div id="logo" class="sidebar-header">
                <a href="index.html">
                    <img src="/admin/images/logo-sidebar.png" title="${siteName!""}" alt="${siteName!""}"/>
                </a>
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
                            <div class="card-header"><h4>编辑租房</h4></div>
                            <div class="card-body">

                                <form action="add" id="rentHouse-add-form" method="post" class="row">
                                    <input type="hidden" name="id" value="${rentHouse.id}">
                                    <div class="form-group col-md-12">
                                        <label>租房封面图</label>
                                        <div class="form-controls">
                                            <ul class="list-inline clearfix lyear-uploads-pic">
                                                <li class="col-xs-4 col-sm-3 col-md-2">
                                                    <figure>
                                                    <#if rentHouse.coverPic?length gt 0>
                                                        <img src="/photo/view?filename=${rentHouse.coverPic}"
                                                             id="show-picture-img">
                                                    <#else>
                                                        <img src="/admin/images/default-head.jpg" id="show-picture-img"
                                                             alt="默认头像">
                                                    </#if>
                                                    </figure>
                                                </li>
                                                <input type="hidden" name="coverPic" id="coverPic"
                                                       value="${rentHouse.coverPic}">
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
                                        <input type="text" style="visibility:hidden" value="1111"
                                               class="form-control">
                                        <div id="distpicker">
                                            <span class="spanSheng">省</span>
                                            <select class="form-control" name="province" id="province"
                                                    style="position: absolute;left: 49px;top: 0px;"></select>
                                            <span class="spanS">市</span>
                                            <select class="form-control" id="city" name="city"
                                                    style="position: absolute;left: 278px;top: 0px;"></select>
                                            <span class="spanQ">区</span>
                                            <select class="form-control" id="district" name="district"
                                                    style="position: absolute;left: 507px;top: 0px;" onchange="changeCate()"></select>
                                        </div>
                                    </div>


                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">所属小区</span>
                                        <select class="form-control" id="housingEstate" name="housingEstate" >
                                              <#list housingEstateList as housingEstate>
                                                  <option value="${housingEstate.id}" <#if housingEstate.id == rentHouse.housingEstate.id></#if>>
                                                      ${housingEstate.name}</option>
                                              </#list>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">所属顾问</span>
                                        <select name="roconsultant.id" class="form-control" id="roconsultant">
                                        <#list consultants as roconsultant>
                                            <option value="${roconsultant.id}" <#if roconsultant.id == rentHouse.roconsultant.id></#if>>
                                                ${roconsultant.username}</option>
                                        </#list>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">所在镇</span>
                                        <input type="text" class="form-control required" id="town" name="town"
                                               value="${rentHouse.town}" placeholder="请填写所在镇" tips="请填写所在镇"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">所在街道</span>
                                        <input type="text" class="form-control required" id="street" name="street"
                                               value="${rentHouse.street}" placeholder="请填写所在街道" tips="请填写所在街道"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">租房房名</span>
                                        <input type="text" class="form-control required" id="name" name="name"
                                               value="${rentHouse.name}" placeholder="请填写租房房名" tips="请填写租房房名"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">租价</span>
                                        <input type="number" class="form-control required" id="price" name="price"
                                               value="${rentHouse.price}" placeholder="请填写租房均价" tips="请填写租房均价"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房间面积</span>
                                        <input type="number" class="form-control required" id="area" name="area"
                                               value="${rentHouse.area}" placeholder="请填写房间面积/平" tips="请填写房间面积"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">楼层类型</span>
                                        <select name="floorType" class="form-control required" id="floorType">
                                        <#list houseFloorEnums as houseFloor>
                                            <option value="${houseFloor}"
                                                    <#if rentHouse.floorType.getCode() == houseFloor.getCode()
                                                    >selected</#if>>${houseFloor.getName()}</option>
                                        </#list>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">具体层</span>
                                        <input type="number" class="form-control required" id="floor" name="floor"
                                               value="${rentHouse.floor}" placeholder="请填写房间具体所在层" tips="请填写房间具体所在层"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">出租方式</span>
                                        <select name="rentHouseWay" class="form-control required" id="rentHouseWay">
                                        <#list houseWayEnums as houseWay>
                                            <option value="${houseWay}"
                                                    <#if rentHouse.rentHouseWay.getCode() == houseWay.getCode()
                                                    >selected</#if>>${houseWay.getName()}</option>
                                        </#list>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">租期类型</span>
                                        <select class="form-control required" id="leaseType" name="leaseType">
                                        <#list houseLeaseEnums as houseLease>
                                            <option value="${houseLease}"
                                                    <#if rentHouse.leaseType.getCode() == houseLease.getCode()
                                                    >selected</#if> >${houseLease.getName()}</option>
                                        </#list>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">具体租期</span>
                                        <input type="text" class="form-control required" id="lease" name="lease"
                                               value="${rentHouse.lease}" placeholder="请填写具体租期（例：三个月/一年/三年）"
                                               tips="请填写具体租期"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">户型类型</span>
                                        <select class="form-control required" id="houseType" name="houseType">
                                        <#list houseTypeEnums as houseType>
                                            <option value="${houseType}"
                                                    <#if rentHouse.houseType.getCode() == houseType.getCode()
                                                    >selected</#if> >${houseType.getName()}</option>
                                        </#list>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">户型信息</span>
                                        <input type="text" class="form-control required" id="doorModel"
                                               name="doorModel" value="${rentHouse.doorModel}"
                                               placeholder="请填写具体户型信息（例：两室一厅/三室两厅）" tips="请填写具体户型信息"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房屋朝向</span>
                                        <select class="form-control required" id="houseOrientation"
                                                name="houseOrientation">
                                        <#list HouseOrientationEnums as HouseOrientation >
                                            <option value="${HouseOrientation}"
                                                    <#if rentHouse.houseOrientation.getCode() == HouseOrientation.getCode()
                                                    >selected</#if> >${HouseOrientation.getName()}</option>
                                        </#list>
                                        </select>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">有无电梯</span>
                                        <select class="form-control required" id="elevator" name="elevator">
                                        <#list houseElevatorEnums as houseElevator>
                                            <option value="${houseElevator}"
                                                    <#if rentHouse.elevator.getCode() == houseElevator.getCode()
                                                    >selected</#if> >${houseElevator.getName()}</option>
                                        </#list>
                                        </select>
                                    </div>



                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房源特色</span>
                                        <select name="rentHouseFeaturesList" class="form-control selectpicker"
                                                multiple data-live-search="true" id="rentHouseFeaturesList">
                                            <#list rentHouseFeaturesList as rentHouseFeatures>
                                                <option <#list rentHouse.rentHouseFeaturesList as rentHouseFeaturess>
                                                        <#if rentHouseFeatures.id == rentHouseFeaturess.id>selected</#if>
                                                    </#list> value="${rentHouseFeatures.id}" >${rentHouseFeatures.name}
                                                </option>
                                            </#list>
                                        </select>
                                    </div>


                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">车位信息</span>
                                        <input type="text" class="form-control" id="parkingSpace" name="parkingSpace"
                                               value="${rentHouse.parkingSpace}" placeholder="请填写车位信息（选填）"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">用水信息</span>
                                        <input type="text" class="form-control" id="water" name="water"
                                               value="${rentHouse.water}" placeholder="请填写用水信息（选填）"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">用电信息</span>
                                        <input type="text" class="form-control" id="electricity" name="electricity"
                                               value="${rentHouse.electricity}" placeholder="请填写用电信息（选填）"/>
                                    </div>
                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">燃气信息</span>
                                        <input type="text" class="form-control" id="fuelGas" name="fuelGas"
                                               value="${rentHouse.fuelGas}" placeholder="请填写燃气信息（选填）"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">采暖信息</span>
                                        <input type="text" class="form-control" id="heating" name="heating"
                                               value="${rentHouse.heating}" placeholder="请填写采暖信息（选填）"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">房间介绍</span>
                                        <input type="text" class="form-control" id="introduction"
                                               value="${rentHouse.introduction}"
                                               name="introduction" placeholder="请填写房间介绍信息（选填）"/>
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
<script type="text/javascript" src="/admin/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/admin/js/main.min.js"></script>


<script>
    //省市区联动选择初始化
    $(function () {
        $('#distpicker').distpicker('destroy');
        $("#distpicker").distpicker({
            province: "${rentHouse.province}",
            city: '${rentHouse.city}',
            district: '${rentHouse.district}'
        });
    })
</script>

<script type="text/javascript">


    var resultData = new Array();
    var resultProviewIdData = new Array();
    var resultStr = "";

    var imgFileTypeArr = new Array();
    var array = new Array();
    <#if arrayList??>
        <#list arrayList as picPath>
        resultData.push("${picPath}");
        array.push("/photo/view?filename=${picPath}");
        imgFileTypeArr.push({
             caption: "${picPath}",
             key: ${picPath_index},
         },);
         resultProviewIdData.push(${picPath_index})
        </#list>
    </#if>

    //上传租房详情介绍图片
    $("#fileinput").fileinput({
        theme: 'explorer-fas',
        uploadUrl: '/upload/upload_file',
        overwriteInitial: false,
        initialPreviewAsData: true,
        showUpload: true,//是否显示上传按钮
        previewSettings: {
            image: {width: "200px", height: "150px"},
        },
        initialPreviewShowDelete: true,
        allowedFileExtensions: ['jpg', 'png', 'jpeg', 'gif', 'bmp'],
        allowedFileTypes: ['image'],
        maxFileSize: 500,
        maxFileCount: 3,//最大上传文件数限制
        initialPreview: array,
        initialPreviewConfig: imgFileTypeArr,
    }).on("fileuploaded", function (event, data, proviewId) {
        resultStr = resultStr + data.response.data + ",";
        resultData.push(data.response.data);
        resultProviewIdData.push(proviewId);
    }).on('filesuccessremove', function (event, previewId) {
        var proviewIdIndex = resultProviewIdData.indexOf(previewId);
        resultData.splice(proviewIdIndex, 1, "null");
    });

    //区，小区二级联动
    function changeCate() {
        $("#housingEstate").html('');
        var district = $("#district").find("option:selected").val();

        if (district == undefined || district == null || "" == district) {
            return ;
        }
        $.ajax({
            url: "add/housingEstate",
            type: "post",
            dataType: "json",
            data: {
                district: district,
            },
            success: function (data) {
                var html = '<option value=\'\'>--------请选择所属小区--------</option>';
                $("#housingEstate").empty();
                for (var i = 0, len = data.length; i < len; i++) {
                    html += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                }
                $("#housingEstate").append(html);

            },
            error: function (data) {
                errorMsg('网络错误!');
            }
        });
    }

    $(document).ready(function () {
        $('.kv-file-remove.btn.btn-sm.btn-kv.btn-default.btn-outline-secondary').on('click', function () {
            var dataKey = $(this).attr('data-key');
            if (dataKey != "undefined") {
                resultData.splice(dataKey, 1);
                $(this).parents()[3].remove();
            }
        })
    });

    $(document).ready(function () {

        //提交按钮监听事件
        $("#add-form-submit-btn").click(function () {
            if (!checkForm("rentHouse-add-form")) {
                return;
            }
            var str = "";
            for (var i = 0; i < resultData.length; i++) {
                if (resultData[i] != null && resultData[i] != "null") {
                    str += resultData[i] + ",";
                }
            }
            if (resultData.length>12){
                showErrorMsg("详情图最多上传12张");
                return;
            }
            var data = $("#rentHouse-add-form").serialize();
            data += "&detailsPics=" + str;
            $.ajax({
                url: 'edit',
                type: 'POST',
                data: data,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 0) {
                        showSuccessMsg('租房编辑成功!', function () {
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