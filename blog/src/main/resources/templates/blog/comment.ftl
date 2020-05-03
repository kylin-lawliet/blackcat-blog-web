
<#include "/layout/admin-header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/admin">首页</a></li>
            <li class="active">博客评论表管理</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="">
                    <div class="btn-group hidden-xs" id="toolbar">
                        <@shiro.hasPermission name="comment:batchDelete">
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
            url: "/comment/list",
            getInfoUrl: "/comment/get/{id}",
            updateUrl: "/comment/edit",
            removeUrl: "/comment/remove",
            createUrl: "/comment/add",
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'comment',
                    title: '评论内容'
                }, {
                    field: 'nickName',
                    title: '评论用户'
                }, {
                    field: 'articleTitle',
                    title: '评论文章',
                    formatter:function (code,row) {
                        return '<a href="/article/view/'+row.articleId+'" target="_blank">'+code+'</a>';
                    }
                }, {
                    field: 'createTime',
                    title: '评论时间'
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }],
            modalName: "博客评论"
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
            '<@shiro.hasPermission name="comment:delete"><a class="btn btn-xs btn-danger btn-remove" data-id="' + trUserId + '"><i class="fa fa-trash-o"></i>删除</a></@shiro.hasPermission>'
        ];

        return operateBtn.join('');
    }

</script>


