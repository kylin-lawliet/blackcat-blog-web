<!-- 页头 -->
<#include "/layout/admin-header.ftl"/>
<#assign basePath=request.contextPath />
<div class="page-content d-flex align-items-stretch" xmlns="http://www.w3.org/1999/html">
    <!-- 左菜单 -->
    <div class="content-inner">
        <!-- 位置-->
        <header class="page-header">
            <div class="container-fluid">
                <h2 class="no-margin-bottom">bootstrap 示例</h2>
            </div>
        </header>

        <div class="container">
            <h2>按钮样式</h2>
            <button type="button" class="btn">基本按钮</button>
            <button type="button" class="btn btn-primary">主要按钮</button>
            <button type="button" class="btn btn-secondary">次要按钮</button>
            <button type="button" class="btn btn-success">成功</button>
            <button type="button" class="btn btn-info">信息</button>
            <button type="button" class="btn btn-warning">警告</button>
            <button type="button" class="btn btn-danger">危险</button>
            <button type="button" class="btn btn-dark">黑色</button>
            <button type="button" class="btn btn-light">浅色</button>
            <button type="button" class="btn btn-link">链接</button>
            </br>
            </br>
            <a href="#" class="btn btn-info" role="button">链接按钮</a>
            <button type="button" class="btn btn-info">按钮</button>
            <input type="button" class="btn btn-info" value="输入框按钮">
            <input type="submit" class="btn btn-info" value="提交按钮">
            </br>
            </br>
            <button type="button" class="btn btn-primary btn-lg">大号按钮</button>
            <button type="button" class="btn btn-primary">默认按钮</button>
            <button type="button" class="btn btn-primary btn-sm">小号按钮</button>
            </br>
            </br>
            <button type="button" class="btn btn-primary btn-block">按钮 1</button>
            </br>
            </br>
            <button type="button" class="btn btn-primary active">点击后的按钮</button>
            <button type="button" class="btn btn-primary" disabled>禁止点击的按钮</button>
            <a href="#" class="btn btn-primary disabled">禁止点击的链接</a>
        </div>

        <div class="container">
            <h2>文字背景</h2>
            <span class="badge badge-success">成功</span>
            <span class="badge badge-primary">主要</span>
            <span class="badge badge-secondary">次要</span>
            <span class="badge badge-success">成功</span>
            <span class="badge badge-info">信息</span>
            <span class="badge badge-warning">警告</span>
            <span class="badge badge-danger">危险</span>
            <span class="badge badge-dark">黑色</span>
            <span class="badge badge-light">浅色</span>
        </div>




<!-- 页脚 -->
<#include "/layout/admin-footer.ftl"/>