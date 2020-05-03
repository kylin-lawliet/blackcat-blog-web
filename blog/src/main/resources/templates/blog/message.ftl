<#include "/layout/admin-header.ftl"/>

<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/admin">首页</a></li>
            <li class="active">消息通知表管理</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="">
                    <div class="btn-group hidden-xs" id="toolbar">
                        <#--<@shiro.hasPermission name="message:add">-->
                            <#--<button id="btn_add" type="button" class="btn btn-default" title="新增用户">-->
                                <#--<i class="fa fa-plus"></i> 新增消息通知表-->
                            <#--</button>-->
                        <#--</@shiro.hasPermission>-->
                        <@shiro.hasPermission name="message:batchDelete">
                            <button id="btn_delete_ids" type="button" class="btn btn-default" title="删除选中">
                                <i class="fa fa-trash-o"></i> 批量删除
                            </button>
                        </@shiro.hasPermission>
                    </div>
                    <table id="dataTable">
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/layout/admin-footer.ftl"/>

<!--添加消息通知表-->
<div class="modal fade" id="addOrUpdateModal" tabindex="-1" role="dialog" aria-labelledby="addroleLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="addroleLabel"></h4>
            </div>
            <div class="modal-body">
                <form id="addOrUpdateForm" class="form-horizontal form-label-left" novalidate>
                    <input type="hidden" name="id">
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="id">: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="id" id="id" required="required" placeholder="请输入"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="message">消息内容内容: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="message" id="message" required="required" placeholder="请输入消息内容内容"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="event">事件类型: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="event" id="event" required="required" placeholder="请输入事件类型"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="userId">创建用户id: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="userId" id="userId" required="required" placeholder="请输入创建用户id"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="toUserId">发送用户id: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="toUserId" id="toUserId" required="required" placeholder="请输入发送用户id"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="articleId">文章id: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="articleId" id="articleId" required="required" placeholder="请输入文章id"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="createTime">创建时间: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="createTime" id="createTime" required="required" placeholder="请输入创建时间"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="status">状态  0:未读 1:已读: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="status" id="status" required="required" placeholder="请输入状态  0:未读 1:已读"/>
                            </div>
                        </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary addOrUpdateBtn">保存</button>
            </div>
        </div>
    </div>
</div>
<!--/添加用户弹框-->
<script>
    $(function () {
        // 列表属性
        var options = {
            url: "/message/list",
            getInfoUrl: "/message/get/{id}",
            updateUrl: "/message/edit",
            removeUrl: "/message/remove",
            createUrl: "/message/add",
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'message',
                    title: '消息内容内容'
                }, {
                    field: 'userName',
                    title: '发送用户'
                }, {
                    field: 'articleTitle',
                    title: '文章'
                    ,formatter:function (code,row) {
                        return '<a href="/article/view/'+row.articleId+'" target="_blank">'+code+'</a>';
                    }
                }, {
                    field: 'createTime',
                    title: '创建时间'
                }, {
                    field: 'status',
                    title: '状态'
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }],
            modalName: "消息通知表"
        };
        //1.初始化Table
        $.tableUtil.init(options);
        //2.初始化Button的点击事件
        $.buttonUtil.init(options);

    });



    /**
     * 操作按钮
     */
    function operateFormatter(code, row, index) {
        var trUserId = row.id;
        var operateBtn = [
            <#--'<@shiro.hasPermission name="message:edit"><a class="btn btn-xs btn-primary btn-update" data-id="' + trUserId + '"><i class="fa fa-edit"></i>编辑</a></@shiro.hasPermission>',-->
            '<@shiro.hasPermission name="message:delete"><a class="btn btn-xs btn-danger btn-remove" data-id="' + trUserId + '"><i class="fa fa-trash-o"></i>删除</a></@shiro.hasPermission>'
        ];

        return operateBtn.join('');
    }

</script>


