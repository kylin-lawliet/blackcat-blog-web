<#assign basePath=request.contextPath />
<#include "/layout/admin-header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="${basePath}/admin">首页</a></li>
            <li class="active">码表管理</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="<#--table-responsive-->">
                    <div class="btn-group hidden-xs" id="toolbar">
                        <@shiro.hasPermission name="code-list:add">
                        <button id="btn_add" type="button" class="btn btn-default" title="新增用户">
                            <i class="fa fa-plus"></i> 新增码表
                        </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="code-list:batchDelete">
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

<!--添加码表-->
<div class="modal fade" id="addOrUpdateModal" tabindex="-1" role="dialog" aria-labelledby="addroleLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="addroleLabel">添加码表</h4>
            </div>
            <div class="modal-body">
                <form id="addOrUpdateForm" class="form-horizontal form-label-left" novalidate>
                    <input type="hidden" name="id">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">名称: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="name" id="name" required="required" placeholder="请输入名称"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="sort">排序: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="sort" name="sort" required="required" placeholder="请输入排序"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="remarks">备注:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="remarks" id="remarks" placeholder="请输入备注"/>
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
        url: "/code-list/list",
        getInfoUrl: "/code-list/get/{id}",
        updateUrl: "/code-list/edit",
        removeUrl: "/code-list/remove",
        createUrl: "/code-list/add",
        columns: [
            {
                checkbox: true
            }, {
                field: 'name',
                title: '名称',
                formatter: function (code,row) {
                    return '<a href="${basePath}/code/index/'+row.id+'">'+code+'</a>';
                }
            }, {
                field: 'remarks',
                title: '备注'
            }, {
                field: 'sort',
                title: '排序'
            }, {
                field: 'updateTime',
                title: '更新时间'
            }, {
                field: 'createTime',
                title: '添加时间'
            }, {
                field: 'operate',
                title: '操作',
                formatter: operateFormatter //自定义方法，添加操作按钮
            }],
            modalName: "码表"
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
            '<@shiro.hasPermission name="code-list:edit"><a class="btn btn-xs btn-primary btn-update" data-id="' + trUserId + '"><i class="fa fa-edit"></i>编辑</a></@shiro.hasPermission>',
            '<@shiro.hasPermission name="code-list:delete"><a class="btn btn-xs btn-danger btn-remove" data-id="' + trUserId + '"><i class="fa fa-trash-o"></i>删除</a></@shiro.hasPermission>'
        ];

        return operateBtn.join('');
    }

</script>