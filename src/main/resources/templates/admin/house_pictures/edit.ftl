<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>${siteName!""}|房屋照片管理-编辑房屋照片</title>
<#include "../common/header.ftl"/>

</head>
  
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">
      
      <!-- logo -->
      <div id="logo" class="sidebar-header">
        <a href="index.html"><img src="/admin/images/logo-sidebar.png" title="${siteName!""}" alt="${siteName!""}" /></a>
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
              <div class="card-header"><h4>编辑房屋图片信息</h4></div>
              <div class="card-body">
                <form action="add" id="user-add-form" method="post" class="row">
                  <input type="hidden" name="id" value="${housePictures.id}">
                    <div class="input-group m-b-10">
                        <span class="input-group-addon">小区：</span>
                        <select name="housingEstate.id" class="form-control" onchange="changeHousingEstate()" id="housingEstate">
                            <option value="0">请选择</option>
                            <#if housingEstate??>
                                <#if housingEstate?size gt 0>
                                    <#list housingEstate as item>
                                         <option value="${item.id}" <#if item.id==housePictures.housingEstate.id>selected="selected"</#if> >
                                             ${item.name}
                                         </option>
                                    </#list>
                                </#if>
                            </#if>
                        </select>
                    </div>
                    <div class="input-group m-b-10">
                        <span class="input-group-addon">房间信息：</span>
                        <select name="houseInfo" class="form-control" id="houseInfo">
                            <#if houseInfo??>
                                <#if houseInfo?size gt 0>
                                    <#list houseInfo as item>
                                         <option value="${item.id}" <#if item.id==housePictures.houseInfo.id>selected="selected"</#if> >
                                             ${item.buildingNumber}栋${item.houseNumber}
                                         </option>
                                    </#list>
                                </#if>
                            </#if>
                        </select>
                    </div>
                    <div class="input-group m-b-10">
                        <span class="input-group-addon">照片名：</span>
                        <input type="text" class="form-control required" id="name" name="name" value="${housePictures.name}" placeholder="请输入照片名" tips="请填写照片名" />
                    </div>
                    <div class="form-group col-md-12">
                        <label>头像上传</label>
                        <div class="form-controls">
                            <ul class="list-inline clearfix lyear-uploads-pic">
                                <li class="col-xs-4 col-sm-3 col-md-2">
                                    <figure>
                                       <#if housePictures.picture?length gt 0>
                                           <img src="/photo/view?filename=${housePictures.picture}" id="show-picture-img">
                                       <#else>
                                           <img src="/admin/images/default-head.jpg" id="show-picture-img" alt="默认头像">
                                       </#if>
                                    </figure>
                                </li>
                                <input type="hidden" name="picture" id="picture"
                                       value="${housePictures.picture}">
                                <input type="file" id="select-file" style="display:none;"
                                       onchange="upload('show-picture-img','picture')">
                                <li class="col-xs-4 col-sm-3 col-md-2">
                                    <a class="pic-add" id="add-pic-btn" href="javascript:void(0)"
                                       title="点击上传"></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                  <div class="form-group col-md-12">
                    <button type="button" class="btn btn-primary ajax-post" id="add-form-submit-btn">确 定</button>
                    <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>
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
<script type="text/javascript" src="/admin/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/admin/js/main.min.js"></script>
<script type="text/javascript">
    // var M = {};
    // M.id = -1;
$(document).ready(function(){
    <#--M.id= ${house_division_info.houseInfo.id}-->
    <#--$("#houseInfo").val(M.id).attr("selected","selected");-->
	//提交按钮监听事件
	$("#add-form-submit-btn").click(function(){
		if(!checkForm("user-add-form")){
			return;
		}
		var data = $("#user-add-form").serialize();
		$.ajax({
			url:'edit',
			type:'POST',
			data:data,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					showSuccessMsg('编辑成功!',function(){
						window.location.href = 'list';
					})
				}else{
					showErrorMsg(data.msg);
				}
			},
			error:function(data){
				alert('网络错误!');
			}
		});
	});
	//监听上传图片按钮
	$("#add-pic-btn").click(function(){
		$("#select-file").click();
	});
});

//小区房屋二级联动
function changeHousingEstate() {
    $("#houseInfo").html('');
    var housingEstateId = $("#housingEstate").find("option:selected").val();
    $.ajax({
        url: "/admin/houseInspectionRecord/add/house",
        type: "post",
        dataType: "json",
        data: {
            id: housingEstateId,
        },
        success: function (data) {
            console.log(data);
            var html = '<option value=\'\'>--------请选择房间信息--------</option>';
            $("#houseInfo").empty();
            for (var i = 0, len = data.length; i < len; i++) {
                html += "<option value='" + data[i].id + "'>" + data[i].buildingNumber +"栋" +data[i].houseNumber  + "</option>";
            }
            $("#houseInfo").append(html);
        },
        error: function (data) {
            showErrorMsg('网络错误!');
        }
    });
}
</script>
</body>
</html>