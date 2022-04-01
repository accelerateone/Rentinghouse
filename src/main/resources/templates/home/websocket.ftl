<html lang="zh">
<head>
    <title>websocket</title>
    <link href="/websocket/chat/css/timeCcss.css" rel="stylesheet">
    <link rel="stylesheet" href="/websocket/css/bootstrap.min.css">
    <link rel="stylesheet" href="/websocket/css/font-awesome.min.css">
    <link rel="stylesheet" href="/websocket/css/custom/index.css">
    <link rel="stylesheet" href="/websocket/css/custom/talk.css">
    <script type="text/javascript" src="/websocket/sockjs.min.js"></script>
    <script type="text/javascript" src="/websocket/stomp.min.js"></script>
    <script type="text/javascript" src="/admin/js/jquery.min.js"></script>
    <script src="/websocket/js/popper.min.js"></script>
    <script src="/websocket/js/bootstrap.min.js"></script>
    <script src="/websocket/js/custom/index.js"></script>
    <script src="/websocket/js/custom/talk.js"></script>
</head>

<body>

<#if homeUser??>
    <input type="text" value="home${homeUser.id}"  id="username" style="display: none"/>
    <#else>
    <input type="text" value="admin${adminUser.id}" id="username" style="display: none"/>
</#if>


<canvas id="lines" ></canvas>

<script  src="/websocket/js/script.js"></script>


<div class="rfixed navbar navbar-expand-lg p-0" style="z-index: 9999">
    <div class="talk">
        <div class="talk-head">
            <span class="talk-link ml-2">客服聊天</span>
            <i class="slide fa fa-caret-up mx-1 my-1" aria-hidden="true"></i>
        </div>

        <div class="talk-body">
            <div class="talk-person">

            </div>

            <div class="talk-panel-one">

            </div>

            <div class="talk-input">
                <div style="height: 10px;">
                </div>

                <div class="talk-content w-100" style="color: black" contenteditable="true">

                </div>

                <div class="talk-tools w-100 pl-2">
                    <#--                    <div class="talk-emo mx-1">-->
                    <#--&lt;#&ndash;                        <div class="row">&ndash;&gt;-->
                    <#--&lt;#&ndash;                            <!--放表情&ndash;&gt;&ndash;&gt;-->
                    <#--&lt;#&ndash;                        </div>&ndash;&gt;-->
                    <#--                    </div>-->
                    <#--                    <a class="click-emo" href="JavaScript:void(0);">-->
                    <i class="fa fa-smile-o fa-lg mr-1 text-dark" aria-hidden="true"></i>
                    </a>
                    <button class="btn btn-primary mt-1  btn-sm float-right mr-3">提交</button>
                </div>
            </div>

        </div>
    </div>
</div>

</body>

<script type="text/javascript">
$(function () {

    var webSocket;
    var commWebSocket;

    if ("WebSocket" in window) {
        webSocket = new WebSocket("ws://localhost:8081/websocket/" + document.getElementById('username').value);

        //连通之后的回调事件
        webSocket.onopen = function (event) {
        };



        var onlineUsers = new Array();

        //接收后台服务端的消息
        webSocket.onmessage = function (evt) {
            var received_msg = evt.data;
            var obj = JSON.parse(received_msg);
            //1代表上线 2代表下线  4代表普通消息
            if (obj.messageType == 1) {
                onlineUsers = obj.onlineUsers;
            } else if (obj.messageType == 2) {
               var index = onlineUsers.indexOf(obj.userId);
                onlineUsers.splice(index,1)
            } else {
                getToMessageInnerHTML(obj.textMessage, obj.fromusername, obj.fromusername);
            }
        };

        //连接关闭的回调事件
        webSocket.onclose = function () {
        };
    } else {
        // 浏览器不支持 WebSocket
        alert("您的浏览器不支持 WebSocket!");
    }

    $('.btn.btn-primary.mt-1.btn-sm.float-right.mr-3').click(function () {
        if ($(".talk-content.w-100").text() == "") {
            return;
        }


        send();
    })


    var setFlag = true;


    function setToMessageInnerHTML(message,userId) {
        var p = "  <p class=\"card-text\" style='text-align:right;' >" + message + "</p>"
        $("[data-message-sessionUUID =" + userId + "]").append(p);
        $("[data-message-sessionUUID =" + userId + "]").scrollTop($(".talk-panel").scrollTop() + 11111)
    }




    var getFlag = true;

    function getToMessageInnerHTML(message, fromusername, sessionUUID) {
        let talkPerson = $(".talk-person > div");
        for (let i = 0; i < talkPerson.length; i++) {
            if ($(talkPerson[i]).attr("data-person-sessionuuid") == sessionUUID) {
                getFlag = false;
            }
        }

        if (getFlag) {
            var divPerson = "<div class=\"card-text\" data-person-sessionUUID = " + sessionUUID + ">" + fromusername + "</div>"
            $(".talk-person").append(divPerson);

            var divMessage = "<div class='talk-panel talk-panel-hide' data-message-sessionUUID = " + sessionUUID + "></div>"
            $(".talk-panel-one").after(divMessage);
        }

        var p = "<p class=\"card-text\">" + message + "</p>";

        $("[data-message-sessionUUID =" + sessionUUID + "]").append(p);

        var remindDiv = "<div data-remind-div = "+ sessionUUID +" style=\"width: 10px; height: 10px; border-radius: 10px; background-color: red;" +
            "position: relative; left: 25px; top: -16px;\"></div>";

        if ($("[data-remind-div =" + sessionUUID + "]").length == 0 && $("[data-message-sessionuuid =" + sessionUUID + "]").hasClass("talk-panel-hide") ){
            $("[data-person-sessionuuid =" + sessionUUID + "]").append(remindDiv);
        }

        talkPersonOnClick();
        //
        // $('.talk-panel');
    }


    function talkPersonOnClick() {
        $(".talk-person > div").click(function () {
            let $talk = $(".talk-person > div");
            for (let i = 0; i < $talk.length; i++) {
                $talk.css("color","black")
            }

            $(this).css("color","red");
            let sessionUUID = $(this).attr("data-person-sessionuuid");
            $(".talk-panel").addClass("talk-panel-hide");
            $(".talk-panel-one").hide();
            $("[data-remind-div =" + sessionUUID + "]").remove();
            $("[data-message-sessionuuid =" + sessionUUID + "]").removeClass("talk-panel-hide");
            $(".btn.btn-primary.mt-1.btn-sm.float-right.mr-3").attr("data-uuid",sessionUUID);

        })
    }


    talkPersonOnClick();



    function closeWebSocket() {
        //直接关闭websocket的连接
        webSocket.close();
    }

    $(window).on('beforeunload unload', function () {
        closeWebSocket();
    });


    function send() {

        let to = $(".btn.btn-primary.mt-1.btn-sm.float-right.mr-3").attr("data-uuid");

        if($(".talk-panel").length<=0){
            alert("请选择用户");
            return;
        }

        if (onlineUsers.indexOf(to) == -1 ){
            alert("当前用户不在线无法聊天");
            return;
        }

        var message = {
            "message": $(".talk-content.w-100").text(),
            "userId": document.getElementById('username').value,
            "to": to
        };
        webSocket.send(JSON.stringify(message));
        setToMessageInnerHTML($(".talk-content.w-100").text(),to);
        console.log(document.getElementById('username').value)
        $(".talk-content.w-100").text("")

    }
})


</script>

</html>