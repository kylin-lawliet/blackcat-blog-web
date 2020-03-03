<!--********************************************************-->
<!--********************* 页头 **********************-->
<!--********************************************************-->
<#include "/layout/header.ftl"/>

<#assign basePath=request.contextPath />
<!--********************************************************-->
<!--********************* 页面内容 *********************-->
<!--********************************************************-->
<div class="site-content">
    <div class="main-wrapper ptb-40">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <!--~~~~~ 页面内容主体 ~~~~~-->
                    <main class="site-main">
                        <div class="row">
                            <div class="post-header single-post-header">
                                <div class="content-entry-wrap">
                                    <!--标题-->
                                    <h3 class="entry-title">${articleVo.article.title}</h3>
                                    <div class="entry-meta-content">
                                        <!--作者信息-->
                                        <div class="entry-meta-author">
                                            <div class="entry-author-thumb">
                                                <img class="avatar photo" alt="author" src="${basePath}/images/author.png">
                                            </div><div class="entry-author-name"><a href="#">Ahmed Arafa</a>
                                            </div>
                                        </div>
                                        <!--日期-->
                                        <div class="entry-date">
                                            <span>2020-03-03 16:23</span>
                                        </div>
                                        <!--阅读数量-->
                                        <div class="entry-views">
                                            <span><i class="fa fa-eye"></i>&nbsp;0</span>
                                        </div>
                                        <!--评论数量-->
                                        <div class="entry-comment">
                                            <span><i class="fa fa-comment-o"></i>&nbsp;0</span>
                                        </div>
                                        <!--标签-->
                                        <div class="entry-category">
                                            <#list articleVo.tags as tag>
                                                <a class="cat" href="#">${tag.name}</a>&nbsp;
                                            </#list>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="single-post-content">
                                <div class="entry-content">
                                    <div class="content-body entry-content panel-body ">
                                        <div class="markdown-body">
                                            ${articleVo.article.content}
                                        </div>
                                    </div>

                                </div>
                            </div>

                        </div>
                    </main>
                    <!--面内容主体结束~-->

                </div>

                <!--********************************************************-->
                <!--********************** 右边侧边 *********************-->
                <!--********************************************************-->
                <#include "/layout/sidebar.ftl"/>

            </div>
        </div>
    </div>
</div>

<div class="magala-close-all-window"></div>

<!--********************************************************-->
<!--********************** 页脚 *********************-->
<!--********************************************************-->
<#include "/layout/footer.ftl"/>