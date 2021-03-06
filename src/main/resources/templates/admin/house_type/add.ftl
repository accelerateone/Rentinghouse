<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>${siteName!""}|户型管理-添加户型</title>
<#include "../common/header.ftl"/>

</head>
  
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">
      
      <!-- logo -->
      <div id="logo" class="sidebar-header">
        <a href="/system/index"><img src="/admin/images/logo-sidebar.png" title="${siteName!""}" alt="${siteName!""}" /></a>
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
              <div class="card-header"><h4>添加户型</h4></div>
              <div class="card-body">
                <form id="house-type-add-form" class="row">
                  <div class="form-group col-md-12">
                    <label>户型图上传</label>
                    <div class="form-controls">
                      <ul class="list-inline clearfix lyear-uploads-pic">
                        <li class="col-xs-4 col-sm-3 col-md-2">
                          <figure>
                            <img src="/admin/images/default-head.jpg" id="show-picture-img" alt="默认户型图">
                          </figure>
                        </li>
                        <input type="hidden" name="floorPlan" id="floorPlan">
                        <input type="file" id="select-file" style="display:none;" onchange="upload('show-picture-img','floorPlan')">
                        <li class="col-xs-4 col-sm-3 col-md-2">
                          <a class="pic-add" id="add-pic-btn" href="javascript:void(0)" title="点击上传"></a>
                        </li>
                      </ul>
                    </div>
                  </div>
                  <div class="input-group m-b-10">
                    <span class="input-group-addon">户型名称</span>
                    <input type="text" class="form-control required" id="name" name="name" value="" placeholder="请输入户型名称如:3室2厅2卫" tips="请填写户型名称如:3室2厅2卫" />
                  </div>
                  <div class="input-group m-b-10">
                    <span class="input-group-addon">户型面积(㎡)：</span>
                    <input type="number" class="form-control required" id="doorArea"
                           onkeyup="inputDouble(this)"
                           name="doorArea" tips="请填写户型面积(㎡)" placeholder="请输入户型面积(㎡)"/>
                  </div>
                  <div class="input-group m-b-10">
                    <span class="input-group-addon">所属楼盘</span>
                    <select name="newHouseInfo.id" class="form-control" id="role">
                    	<#list newHouseInfos as newHouseInfo>
                    	<option value="${newHouseInfo.id}">${newHouseInfo.name}</option>
                    	</#list>
                    </select>
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
$(document).ready(function(){
	//提交按钮监听事件
	$("#add-form-submit-btn").click(function(){
		if(!checkForm("house-type-add-form")){
			return;
		}
		var data = $("#house-type-add-form").serialize();
		$.ajax({
			url:'add',
			type:'POST',
			data:data,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					showSuccessMsg('户型添加成功!',function(){
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

function inputDouble(obj) {
  obj.value = obj.value.replace(/[^\d.]/g, ""); //清除"数字"和"."以外的字符
  obj.value = obj.value.replace(/^\./g, ""); //验证第一个字符是数字
  obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个, 清除多余的
  obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
  obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'); //只能输入两个小数

  if (obj.value.length > 10) {
    obj.value = ""
  }
}

</script>
</body>
</html>