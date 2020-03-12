<!--********************************************************-->
<!--********************* 页头 **********************-->
<!--********************************************************-->
<#include "layout/header.ftl"/>
<#setting date_format="yyyy-MM-dd HH:mm:ss">
<#setting datetime_format="yyyy-MM-dd HH:mm:ss"/>
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
                            <div class="col-12">
                                <div class="section-header"><h2 class="section-title">所有文章</h2></div>
                            </div>

                            <!--~~~~~ 单篇文章内容 ~~~~~-->
                            <#list articles as article>
                                <div class="col-12 load-post">
                                    <article class="post hentry post-list">
                                        <div class="content-entry-wrap">
                                            <!-- 标题 -->
                                            <div class="entry-content">
                                                <h3 class="entry-title">
                                                    <a href="/article/view/${article.id}">
                                                        ${article.title}
                                                    </a>
                                                </h3>
                                            </div>

                                            <div class="entry-meta-content">
                                                <!--作者-->
                                                <div class="entry-meta-author">
                                                    <div class="entry-author-thumb">
                                                        <img class="avatar photo" src="${basePath}/images/author.png" alt="author">
                                                    </div>
                                                    <div class="entry-author-name">
                                                        <a href="#">Ahmed Arafa</a>
                                                    </div>
                                                </div>
                                                <!--日期-->
                                                <div class="entry-date">
                                                    <span>
                                                        <@formatTime unix="${article.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"> </@formatTime>
                                                    </span>
                                                </div>
                                                <!--阅读数量-->
                                                <div class="entry-views"><i class="fa fa-eye"></i>&nbsp;<span>${article.viewCount}</span></div>
                                                <!--评论数量-->
                                                <div class="entry-views"><i class="fa fa-comment-o"></i>&nbsp;<span>${article.commentCount}</span></div>
                                                <!--点赞数量-->
                                                <#--<div class="entry-views"><i class="fa fa-thumbs-o-up"></i>&nbsp;<span>${article.starCount}</span></div>-->
                                                <!--分类-->
                                                <div class="entry-category">
                                                    <#list articleVo.tags as tag>
                                                        <a class="cat" href="#">${tag.name}</a>&nbsp;
                                                    </#list>
                                                </div>
                                            </div>
                                            <!--描述-->
                                            <div class="entry-summary">
                                                <p>
                                                    ${article.introduction}
                                                </p>
                                            </div>
                                        </div>
                                    </article>
                                </div>
                            </#list>
                            <!-- 单篇文章内容结束 ~-->

                        </div>
                    </main>
                    <!--面内容主体结束~-->

                    <!--~~~~~ 加载更多 ~~~~~-->
                    <div class="load-more-area text-center mt-30">
                        <button class="btn btn-load-more loadmore"><i class="fa fa-spinner"></i>加载更多</button>
                        <span class="no-posts">到底了</span>
                    </div>

                </div>

                <!--********************************************************-->
                <!--********************** 右边侧边 *********************-->
                <!--********************************************************-->
                <#include "layout/sidebar.ftl"/>

            </div>
        </div>
    </div>
</div>

<div class="magala-close-all-window"></div>

<!--********************************************************-->
<!--********************** 页脚 *********************-->
<!--********************************************************-->
<#include "layout/footer.ftl"/>