<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">

    <title>${siteName!""}|小区管理-添加小区</title>
<#include "../common/header.ftl"/>

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
                <a href="/system/login">
                    <img src="/admin/images/logo-sidebar.png" title="${siteName!""}"
                         alt="${siteName!""}"/></a>
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
                            <div class="card-header"><h4>添加小区</h4></div>
                            <div class="card-body">

                                <form action="add" id="housingEstate-add-form" method="post" class="row">


                                    <div class="input-group m-b-10">
                                        <input type="text" style="visibility:hidden" value="" class="form-control">
                                        <div id="distpicker">
                                            <span class="spanSheng">省</span>
                                            <select class="form-control" name="province" id="province" style="position: absolute;left: 49px;top: 0px;"></select>
                                            <span class="spanS">市</span>
                                            <select class="form-control" id="city" name="city" style="position: absolute;left: 278px;top: 0px;"></select>
                                            <span class="spanQ">区</span>
                                            <select class="form-control" id="district" name="district" style="position: absolute;left: 507px;top: 0px;"></select>
                                        </div>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">所在镇</span>
                                        <input type="text" class="form-control required" id="town" name="town"
                                               value="" placeholder="请填写所在镇" tips="请填写所在镇"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">所在街道</span>
                                        <input type="text" class="form-control required" id="street" name="street"
                                               value="" placeholder="请填写所在街道" tips="请填写所在街道"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">小区名</span>
                                        <input type="text" class="form-control required" id="name" name="name"
                                               value="" placeholder="请填写小区名" tips="请填写小区名"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">建成年代</span>
                                        <input type="number" class="form-control required" id="completedYear"
                                               name="completedYear"
                                               value="" placeholder="请填写建成年代（只需填年份即可）" tips="请填写建成年代"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">建筑类型</span>
                                        <input type="text" class="form-control required" id="buildingType"
                                               name="buildingType"
                                               value="" placeholder="请填写建筑类型" tips="请填写建筑类型"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">经纬度</span>
                                        <input type="text" class="form-control required" id="latitudeAndLongitude"
                                               name="latitudeAndLongitude"
                                               value="" placeholder="请填写经纬度（不清楚可以去下方链接自行拾取）" tips="请填写经纬度"/>
                                    </div>

                                    <div class="input-group m-b-10">
                                        <span class="input-group-addon">经纬度坐标链接：</span>
                                        <a href="http://api.map.baidu.com/lbsapi/getpoint/index.html"
                                           target="_blank">百度地图拾取坐标系统</a>
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
<script src="/admin/Distpicker/js/main.js"></script>
<script type="text/javascript" src="/admin/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/admin/js/main.min.js"></script>
<script type="text/javascript">

    $("#distpicker").distpicker({
        autoSelect: false
    });

    $(document).ready(function () {
        //提交按钮监听事件
        $("#add-form-submit-btn").click(function () {
            if (!checkForm("housingEstate-add-form")) {
                return;
            }
            var formdata = $("#housingEstate-add-form").serialize();
            $.ajax({
                url: 'add',
                type: 'POST',
                data: formdata,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 0) {
                        showSuccessMsg('小区添加成功!', function () {
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