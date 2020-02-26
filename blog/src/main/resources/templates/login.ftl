<!DOCTYPE html>
<html lang="en">
<head>
    <#assign basePath=request.contextPath />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理</title>
    <#--<link href="${basePath}/images/favicon.ico" rel="icon">-->
    <link href="${basePath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/bootstrap/css/font-awesome.css" rel="stylesheet">
    <link href="${basePath}/css/jquery-confirm.min.css" rel="stylesheet">
    <link href="${basePath}/css/nprogress.min.css" rel="stylesheet">
    <link href="${basePath}/css/blog.core.css" rel="stylesheet">
</head>

<body class="login">
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static"
     data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="login_wrapper">
                    <div class="animate form login_form" style="position: relative;">
                        <section class="login_content">
                            <form action="/login" method="POST" id="login-form">
                                <h1>登录管理系统</h1>
                                <div>
                                    <input type="text" class="form-control" placeholder="请输入用户名" name="username" required=""/>
                                </div>
                                <div>
                                    <input type="password" class="form-control" placeholder="请输入密码" name="password" required=""/>
                                </div>
                                <div class="form-group" style="text-align : left">
                                    <label><input type="checkbox" id="rememberMe" name="rememberMe" style="width: 12px; height: 12px;margin-right: 5px;">记住我</label>
                                </div>
                                <div>
                                    <button type="button" class="btn btn-success btn-login" style="width: 100%;">登录</button>
                                </div>

                                <div class="clearfix"></div>

                                <div class="separator">
                                    <div class="clearfix"></div>
                                    <div>
                                        <h1><i class="fa fa-coffee"></i> BlackCat 博客系统</h1>
                                        <p>Copyright © 2019 <a href="https://www.kylin-blackcat.com">blackcat</a>. All Rights Reserved. </p>
                                    </div>
                                </div>
                            </form>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script src="${basePath}/jquery/jquery-3.2.0.min.js" type="text/javascript"></script>
<script src="${basePath}/jquery/jquery-confirm.min.js" type="text/javascript"></script>
<script src="${basePath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${basePath}/js/blog-table-tool.js"></script>

<script>
    $("#modal").modal('show');
    $(".btn-login").click(function () {
        $.ajax({
            type: "POST",
            url: "/login",
            data: $("#login-form").serialize(),
            dataType: "json",
            success: function () {
                // if (json.status === 200) {
                    window.location.href = "/admin";
                /*}else{
                    $.tool.ajaxSuccess(json);
                    $("#img-kaptcha").attr("src", '/getKaptcha?time=' + new Date().getTime());
                }*/
            }
        });
    });
    // $("#img-kaptcha").click(function () {
    //     $(this).attr("src", '/getKaptcha?time=' + new Date().getTime());
    // });
    document.onkeydown = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode === 13) {
            $(".btn-login").click();
        }
    };
</script>
</html>
