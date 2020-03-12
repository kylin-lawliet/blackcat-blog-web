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
                        <div class="post single-post single-post-three">
                            <!--~~~~~ 文章内容 ~~~~~-->
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
                                            <span><@formatTime unix="${articleVo.article.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"> </@formatTime></span>
                                        </div>
                                        <!--阅读数量-->
                                        <div class="entry-views">
                                            <span><i class="fa fa-eye"></i>&nbsp;${articleVo.article.viewCount}</span>
                                        </div>
                                        <!--评论数量-->
                                        <div class="entry-comment">
                                            <span><i class="fa fa-comment-o"></i>&nbsp;${articleVo.article.commentCount}</span>
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
                            <!--~~~~~ 文章内容 结束 ~~~~~-->
                            <div class="post-share-area pt-40" >
                                <span style="background-color:#f4f5f3">注：本文归作者所有，未经作者允许，不得转载。</span>
                            </div>

                            <!--~~~~~ 评论模块 ~~~~~-->
                            <div class="entry-footer">
                                <h3 class="comment-reply-title"><span>全部评论：</span><span id="commentCount">${articleVo.comments?size}</span>&nbsp;条</h3>
                            </div>
                            <!--~~~~~ 评论内容加载 ~~~~~-->
                            <div class="pt-30">
                                <ul class="c_list" id="comment">

                                </ul>
                            </div>
                            <!--~~~~~ 加载更多 ~~~~~-->
                            <div class="load-more-area text-center mt-30">
                                <button class="btn btn-load-more loadmore"><i class="fa fa-spinner"></i>加载更多</button>
                                <span class="no-posts">到底了</span>
                            </div>
                            <!--~~~~~ 发表评论 ~~~~~-->
                            <div class="comments-area pt-40" id="comments">
                                <div class="comment-respond" id="respond">
                                    <h3 class="comment-reply-title headline">
                                        <span>发表评论 :</span><span id="comment_at"></span>
                                    </h3>
                                    <form name="contact_form" id="contact_form" method="post">
                                        <input name="articleId" id="articleId" type="hidden" value="${articleVo.article.id}"><#--文章id-->
                                        <input name="parentId" type="hidden" value="" id="parentId"><#--回复的评论id-->
                                        <input type="hidden" value="0" id="commentType"><#--评论类型 0：对文章进行评论 1：回复用户的评论-->
                                        <div class="row">
                                            <div class="col-12">
                                                <textarea name="comment" class="form-controllar" id="commentText"
                                                          aria-required="true" placeholder="请输入评论...."
                                                          rows="8" cols="45"></textarea>
                                            </div>
                                            <div class="col-md-12">
                                                <p class="form-submit">
                                                    <input id="comment_submit" type="button" value="发送">
                                                </p>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <!-- #respond -->

                                <!--~~~~~ 文章内容 ~~~~~-->
                            </div>
                            <!--~~~~~ 评论模块 结束 ~~~~~-->
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
<@shiro.guest>
    <input type="hidden" value="0" id="isLogin"><#--是否登陆-->
</@shiro.guest>
<input type="hidden" value="" id="commentParentId">
<input type="hidden" value="${userInfo.nickname}" id="userNick"><#--用户昵称-->
<input type="hidden" value="${userInfo.avatar}" id="userAvatar"><#--用户头像-->
<div class="magala-close-all-window"></div>

<!--********************************************************-->
<!--********************** 页脚 *********************-->
<!--********************************************************-->
<#include "/layout/footer.ftl"/>
<script src="${basePath}/js/blog-comment.js"></script>
