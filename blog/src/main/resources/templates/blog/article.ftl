<#assign basePath=request.contextPath />
<#include "/layout/admin-header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="${basePath}/admin">首页</a></li>
            <li class="active">博客文章管理</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="">
                    <div class="btn-group hidden-xs" id="toolbar">
                        <@shiro.hasPermission name="article:add">
                        <button type="button" class="btn btn-default" title="新增用户" onclick="location.href = '/article/detail/0'">
                            <i class="fa fa-plus"></i> 新增博客文章
                        </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="article:batchDelete">
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

<script>
    $(function () {
        // 列表属性
        var options = {
            url: "/article/list",
            getInfoUrl: "/article/detail/{id}",
            updateUrl: "/article/edit",
            removeUrl: "/article/remove",
            createUrl: "/article/add",
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'title',
                    title: '文章标题'
                }, {
                    field: 'categoryId',
                    title: '分类编号',
                    formatter:function (code) {
                        return code;
                    }
                }, {
                    field: 'starCount',
                    title: '博客点赞'
                }, {
                    field: 'viewCount',
                    title: '浏览总量'
                }, {
                    field: 'top',
                    title: '是否置顶'
                }, {
                    field: 'commentCount',
                    title: '评论数量'
                }, {
                    field: 'userId',
                    title: '用户编号'
                }, {
                    field: 'createTime',
                    title: '添加时间'
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }],
            modalName: "博客文章"
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
        var trId = row.id;
        var operateBtn = [
            '<@shiro.hasPermission name="article:edit"><a class="btn btn-xs btn-primary" href="/article/detail/' + trId + '"><i class="fa fa-edit"></i>编辑</a></@shiro.hasPermission>',
            '<@shiro.hasPermission name="article:delete"><a class="btn btn-xs btn-danger btn-remove" data-id="' + trId + '"><i class="fa fa-trash-o"></i>删除</a></@shiro.hasPermission>'
        ];
        return operateBtn.join('');
    }

</script>


