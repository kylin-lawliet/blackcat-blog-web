<#include "/layout/admin-header.ftl"/>
<link href="${basePath}/css/tagsinput.css" rel="stylesheet">
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="${basePath}/admin">首页</a></li>
            <li><a href="${basePath}/article/index">博客管理</a></li>
            <li class="active">博客文章编辑</li>
        </ol>

        <form class="form-horizontal" id="articleForm" role="form">
            <div class="form-group">
                <label for="title" class="col-sm-1 control-label">标题</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="title" value="${articleVo.article.title}" id="title" placeholder="标题">
                    <input type="hidden" name="id" value="${articleVo.article.id}">
                </div>
            </div>
            <div class="form-group">
                <label for="introduction" class="col-sm-1 control-label">简介</label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="3" name="introduction">${articleVo.article.introduction}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="categoryId" class="col-sm-1 control-label">分类</label>
                <div class="col-sm-5">
                    <select class="form-control" id="categoryId" name="categoryId" data-select="${articleVo.article.categoryId}">
                        <option value="0">请选择</option>
                        <@blog method="articleTypes">
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
                        </@blog>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label">标签</label>
                <div class="col-sm-10">
                    <div class="label-selected">
                        <a href="javascript:;" class="layui-btn layui-btn-sm show-labelitem" style="float: right; margin: 4px; display: block;line-height: 30px;">展开标签库 </a>
                        <a href="javascript:;" class="layui-btn layui-btn-sm hide-labelitem" style="float: right; margin: 4px; display: none;line-height: 30px;">收起标签库 </a>
                        <input type="hidden" name="tags" id="tags" value="${articleVo.article.tags}">
                        <#list articleVo.tags as tag>
                            <li data='${tag.id}'>x ${tag.name}</li>
                        </#list>
                    </div>
                    <div class="layui-col-md12" id="labelItem">
                        <!--标签库-->
                        <div class="label-item" id="tag-items"></div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <#include "/editor/${articleVo.article.contentType}.ftl"/>
                </div>
            </div>
            <div class="btn-group-crop"  style="float:right;">
                <button type="button" class="btn btn-primary" onclick="location.href='${basePath}/article/index'">返回</button>
                <button type="button" class="btn btn-primary" id="articleButton">保存</button>
            </div>
        </form>
        <input type="hidden" id="tagId" value="${options['articleTagCodeId']}">
    </div>
</div>
<#include "/layout/admin-footer.ftl"/>
<script src="${basePath}/js/blog-tagsinput.js"></script>
<script>
    MdEditor.initEditor();
    $(function () {
        // 提交表单
        $('#articleButton').click(function () {
            $.ajax({
                type: "post",
                url: "/article/add",
                data: $("#articleForm").serialize(),
                success: function (json) {
                    $.tool.ajaxSuccess(json.msg);
                    location.href='/article/index';
                },
                error: $.tool.ajaxError
            });
        });
    });
</script>