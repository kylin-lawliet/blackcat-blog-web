<#include "/layout/admin-header.ftl"/>
<div class="clearfix"></div>
    <div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
    <ol class="breadcrumb">
        <li><a href="${basePath}/admin">首页</a></li>
        <li class="active">系统参数</li>
    </ol>

<section class="content container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#sites" data-toggle="tab" aria-expanded="true">站点信息</a></li>
                    <#--<li class=""><a href="#mail" data-toggle="tab" aria-expanded="false">邮件服务</a></li>-->
                    <#--<li class=""><a href="#oauth" data-toggle="tab" aria-expanded="false">第三方登录</a></li>-->
                    <#--<li class=""><a href="#storage" data-toggle="tab" aria-expanded="false">图片存储</a></li>-->
                    <li class="pull-right header"><i class="fa fa-cogs"></i></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="sites">
                        <#include "/options/sites.ftl">
                    </div>
                   <#-- <div class="tab-pane" id="mail">
                        <#include "/options/mail.ftl">
                    </div>
                    <div class="tab-pane" id="oauth">
                        <#include "/options/oauths.ftl">
                    </div>
                    <div class="tab-pane" id="storage">
                        <#include "/options/storages.ftl">
                    </div>-->
                </div>
                <!-- /.tab-content -->
            </div>
        </div>
    </div>
</section>
<#include "/layout/admin-footer.ftl"/>
    <script>
        $(function () {
            // 下拉框选中
            $('select[data-select]').each(function () {
                var id = $(this).attr('data-select');
                if (typeof(id) != 'undefined' && id.length > 0) {
                    $(this).val(id);
                }
            });

            // 站点信息修改
            $('#siteButton').click(function () {
                $.ajax({
                    type: "post",
                    url: "/admin/options/update",
                    data: $("#siteForm").serialize(),
                    success: function (json) {
                        $.tool.ajaxSuccess(json.msg);
                    },
                    error: $.tool.ajaxError
                });
            });
        });
    </script>
