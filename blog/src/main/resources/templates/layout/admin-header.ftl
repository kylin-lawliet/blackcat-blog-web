<!DOCTYPE html>
<html lang="en">
<head>
    <#assign basePath=request.contextPath />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--自动适应移动屏幕-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理系统</title>
    <link href="${basePath}/images/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link href="${basePath}/ztree/css/metroStyle/metroStyle.css" rel="stylesheet">
    <link href="${basePath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${basePath}/bootstrap/css/daterangepicker.css" rel="stylesheet">
    <link href="${basePath}/bootstrap/css/datetimepicker.css" rel="stylesheet">
    <#--图标字体库-->
    <link href="${basePath}/bootstrap/css/font-awesome.css" rel="stylesheet">
    <link href="${basePath}/bootstrap/css/bootstrap-table.min.css" rel="stylesheet">
    <link href="${basePath}/css/blog.core.css" rel="stylesheet">
    <link href="${basePath}/css/toastr.min.css" rel="stylesheet">
    <#--iCheck 插件样式-->
    <link href="${basePath}/css/green.css" rel="stylesheet">
    <#--左侧菜单图标-->
    <link href="${basePath}/css/nprogress.min.css" rel="stylesheet">
    <#--弹窗插件-->
    <link href="${basePath}/css/jquery-confirm.min.css" rel="stylesheet">

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/" class="site_title"><i class="fa fa-coffee"></i> <span>后台管理</span></a>
                </div>
                <div class="clearfix"></div>
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="${basePath}/images/author.png" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>早上好,</span>
                        <h2>尊敬的管理员</h2>
                    </div>
                </div>
                <br />
                <#include "/layout/admin-sidebar.ftl"/>
            </div>
        </div>
        <#include "/layout/admin-setting.ftl"/>
        <div class="right_col" role="main">