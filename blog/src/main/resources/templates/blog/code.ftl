<#assign basePath=request.contextPath />
<#include "/layout/admin-header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/admin">首页</a></li>
            <li><a href="/code/listIndex">码表管理</a></li>
            <li class="active">${codeParent.name}</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="<#--table-responsive-->">
                    <div class="btn-group hidden-xs" id="toolbar">
                        <@shiro.hasPermission name="code:add">
                        <button id="btn_add" type="button" class="btn btn-default" title="新增用户">
                            <i class="fa fa-plus"></i> 新增码表
                        </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="code:batchDelete">
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
                <h4 class="modal-title" id="addroleLabel">添加</h4>
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="type">父级节点: </label>
                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <input type="hidden" id="codeType" value="2">
                            <input type="hidden" id="codeId" value="${codeParent.id}">
                            <select id="parentId" name="parentId" class="form-control col-md-5 col-xs-5">
                                <option value="">请选择</option>
                                <#--<@blog method="codes" codeId="${codeParent.id}">
                                    <#if codes?? && codes?size gt 0>
                                        <#list codes as item>
                                            <option value="${item.id?c}">${item.name}</option>
                                            <#if item.nodes?? && item.nodes?size gt 0>
                                                <#list item.nodes as node>
                                                    <option value="${node.id?c}">&nbsp;&nbsp;|-${node.name}</option>
                                                </#list>
                                            </#if>
                                        </#list>
                                    <#else>
                                        <option value="">无</option>
                                    </#if>
                                </@blog>-->
                            </select>
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
        url: "/code/list/${codeParent.id}",
        getInfoUrl: "/code/get/{id}",
        updateUrl: "/code/edit",
        removeUrl: "/code/remove",
        createUrl: "/code/add/${codeParent.id}",
        columns: [
            {
                checkbox: true
            }, {
                field: 'name',
                title: '名称'
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
            modalName: '码表'
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
            '<@shiro.hasPermission name="code:edit"><a class="btn btn-xs btn-primary btn-update" data-id="' + trUserId + '"><i class="fa fa-edit"></i>编辑</a></@shiro.hasPermission>',
            '<@shiro.hasPermission name="code:delete"><a class="btn btn-xs btn-danger btn-remove" data-id="' + trUserId + '"><i class="fa fa-trash-o"></i>删除</a></@shiro.hasPermission>'
        ];

        return operateBtn.join('');
    }

</script>