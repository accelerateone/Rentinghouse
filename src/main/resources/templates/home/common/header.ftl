<link rel="stylesheet" href="/home/layui/layui/css/layui.css">
<script type="text/javascript" src="/home/layui/layui/layui.all.js"></script>
<script type="text/javascript" src="/home/layui/layui/layui.js"></script>
<script type="text/javascript" src="/home/bridalChamber/js/jquery.min.js"></script>

<div class="float-wrapper">
    <ul class="link-list-wrapper">
        <li class="new-link-list">
            <a class="" href="/home/index/bridalChamberIndex">首页</a>
        </li>
        <li class="new-link-list">
            <a class="<#if index == 1>on</#if>" href="/home/index/secondHouse">二手房</a>
        </li>
        <li class="new-link-list">
            <a class="<#if index == 2>on</#if>" href="/home/index/bridalChamberList">新房</a>
        </li>
        <li class="new-link-list">
            <a class="<#if index == 3>on</#if>" href="/home/rentHouse/list">租房</a>
        </li>
    </ul>

<#if ylrc_auth != 1>
    <div class="top-nav" id="show-copyright">
        <div class="container fn-clear" align="center">
            <p style="color:red;font-size:16px;">
            </p>
        </div>
    </div>
</#if>
    <div class="fr user-wrapper typeUserInfo">
        <div class="typeShowUser">
            <ul class="link-list-wrapper">
                <li class="new-link-list">
                   <#if Session["ylrc_home_user"]?exists>
                       <a class="" href="/home/homeUser/logout">退出</a>
                    <#else>
                        <a class="" id="home-login" onclick="homeLogin()">登录</a>
                    </#if>
                </li>
            </ul>
        </div>
    </div>
</div>

<#--忘记密码开始-->
<div class='simple_dlg_define' id="forget-the-password" style='display:none'>
    <div class='pane' style='padding:16px'>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号:</label>
            <div class="layui-input-block">
                <input class='layui-input retrievepasswordmobile' type='text' placeholder="请输入手机号">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱:</label>
            <div class="layui-input-block">
                <input class='layui-input retrievepasswordemail' type='text' placeholder="请输入邮箱">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码:</label>
            <div class="layui-input-block">
                <input class='layui-input retrievepassword' type='password' placeholder="请输入密码">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认新密码:</label>
            <div class="layui-input-block">
                <input class='layui-input retrievepassword2' type='password' placeholder="请输入密码">
            </div>
        </div>
    </div>
</div>
<#--忘记密码结束-->

<#--登录开始-->
<div class='simple_dlg_define' id="login" style='display:none'>
    <div class='pane' style='padding:16px'>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号:</label>
            <div class="layui-input-block">
                <input class='layui-input loginmobile' type='text' placeholder="请输入手机号">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-block">
                <input class='layui-input loginpassword' type='password' placeholder="请输入密码">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验证码:</label>
            <div class="layui-input-block">
                <input class='layui-input logincode' type='text' placeholder="请输入验证码">
                <img src="/cpacha/generate_cpacha?vl=4&fs=25&w=128&h=40&method=home_user_login_code" class="pull-right"
                     id="captcha" style="cursor: pointer;" onclick="this.src=this.src+'&d='+Math.random();" title="点击刷新"
                     alt="captcha">
            </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" onclick="signIn()">注册</button>
                <button class="layui-btn layui-btn-danger" onclick="forgetThePassword()">找回密码</button>
            </div>
        </div>
    </div>
</div>
<#--登录结束-->

<#--注册开始-->
<div class='simple_dlg_define' id="signIn" style='display:none'>
    <div class='pane' style='padding:16px'>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号:</label>
            <div class="layui-input-block">
                <input class='layui-input signInmobile' type='text' placeholder="请输入手机号">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱:</label>
            <div class="layui-input-block">
                <input class='layui-input signInemail' type='text' placeholder="请输入邮箱">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-block">
                <input class='layui-input signInpassword' type='password' placeholder="请输入密码">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码:</label>
            <div class="layui-input-block">
                <input class='layui-input signInpassword2' type='password' placeholder="请确认密码">
            </div>
        </div>
    </div>
</div>
<#--注册结束-->
<script type="text/javascript" src="/home/bridalChamber/msg.js"></script>
<script>

    function forgetThePassword() {
        var forget_the_password_html = $('#forget-the-password').html()
        layer.open({
            type: 1,
            title: '忘记密码',
            area: ['420px', 'auto'],
            content: forget_the_password_html,
            btn: ['确认', '取消'],
            btn1: function (index, layero) {
                var mobile = $('.retrievepasswordmobile', layero).val();
                var email = $(".retrievepasswordemail", layero).val();
                var retrievepassword = $(".retrievepassword", layero).val();
                var retrievepassword2 = $(".retrievepassword2", layero).val();
                retrieveAjax(mobile, retrievepassword, retrievepassword2, email, index)
            },
            btn2: function (index, layero) {
                layer.close(index)
            }
        });
    }

    function homeLogin() {
        var login = $('#login').html()
        layer.open({
            type: 1,
            title: '登录',
            area: ['420px', 'auto'],
            content: login,
            btn: ['确认', '取消'],
            btn1: function (index, layero) {
                var mobile = $('.loginmobile', layero).val();
                var password = $('.loginpassword', layero).val();
                var code = $(".logincode", layero).val();
                homeLoginAjax(mobile, password, code, index)
            },
            btn2: function (index, layero) {
                layer.close(index)
            }
        });
    }

    function signIn() {
        var signIn = $('#signIn').html()
        layer.open({
            type: 1,
            title: '注册',
            area: ['420px', 'auto'],
            content: signIn,
            btn: ['确认', '取消'],
            btn1: function (index, layero) {
                var mobile = $('.signInmobile', layero).val();
                var password = $('.signInpassword', layero).val();
                var password2 = $('.signInpassword2', layero).val();
                var email = $(".signInemail", layero).val();
                signInAjax(mobile, password, password2, email, index);
            },
            btn2: function (index, layero) {
                layer.close(index)
            }
        });
    }

    function homeLoginAjax(mobile, password, code, index2) {
        if (!msg.isPhone(mobile) || msg.isEmpty(mobile)) {
            errorMsg("手机号格式错误或者为空")
            return;
        }
        if (password.length < 4 || password.length >= 32 || msg.isEmpty(password)) {
            errorMsg("密码格式错误或为空,应当大于4位数不超过32位数")
            return;
        }
        if (msg.isEmpty(code)) {
            errorMsg("验证不能为空")
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/home/homeUser/login',
            data: {
                code: code,
                userMobile: mobile,
                password: password
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {
                    layer.open({
                        title: "提示信息"
                        , btn: ['确定']
                        , content: "登录成功"
                        , yes: function (index, layero) {
                            layer.closeAll();
                        },
                    })
                    window.location.reload()
                } else {
                    layer.open({
                        title: "提示信息",
                        content: data.msg
                    })
                }
            },
            error: function (data) {
                alert('网络错误!');
            }
        })

    }


    function signInAjax(mobile, password, password2, email, index) {

        if (!msg.isPhone(mobile) || msg.isEmpty(mobile)) {
            errorMsg("手机号格式错误或者为空")
            return;
        }
        if (password.length < 4 || password.length >= 32 || msg.isEmpty(password)) {
            errorMsg("密码格式错误或为空,应当大于4位数不超过32位数")
            return;
        }

        if (password2.length < 4 || password2.length >= 32 || msg.isEmpty(password2)) {
            errorMsg("密码格式错误或为空,应当大于4位数不超过32位数")
            return;
        }

        if (!(password === password2)) {
            errorMsg("密码输入不一致")
            return;
        }

        if (msg.isEmpty(email) || !msg.isEmail(email)) {
            errorMsg("邮箱格式不正确或为空")
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/home/homeUser/regsiter',
            data: {
                email: email,
                userMobile: mobile,
                password: password
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {
                    layer.open({
                        title: "提示信息",
                        content: "注册成功,请登录",
                    })
                    layer.close(index)
                    $("#captcha").click();
                } else {
                    layer.open({
                        title: "提示信息",
                        content: data.msg
                    })
                }
            },
            error: function (data) {
                alert('网络错误!');
            }
        })
    }

    function retrieveAjax(mobile, password, password2, email, index) {
        if (!msg.isPhone(mobile) || msg.isEmpty(mobile)) {
            errorMsg("手机号格式错误或者为空")
            return;
        }
        if (password.length < 4 || password.length >= 32 || msg.isEmpty(password)) {
            errorMsg("密码格式错误或为空,应当大于4位数不超过32位数")
            return;
        }

        if (password2.length < 4 || password2.length >= 32 || msg.isEmpty(password2)) {
            errorMsg("密码格式错误或为空,应当大于4位数不超过32位数")
            return;
        }

        if (!(password === password2)) {
            errorMsg("密码输入不一致")
            return;
        }

        if (msg.isEmpty(email) || !msg.isEmail(email)) {
            errorMsg("邮箱格式不正确或为空")
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/home/homeUser/retrievePassword',
            data: {
                email: email,
                userMobile: mobile,
                password: password
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {
                    layer.open({
                        title: "提示信息",
                        content: "找回密码成功,请登录",
                    })
                    layer.close(index)
                    $("#captcha").click();
                } else {
                    layer.open({
                        title: "提示信息",
                        content: data.msg
                    })
                }
            },
            error: function (data) {
                alert('网络错误!');
            }
        })

    }



</script>