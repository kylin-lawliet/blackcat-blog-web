<div class="col-lg-3">
    <div class="sidebar">
        <div class="sidebar-inner">
            <aside class="widget widget-categories">
                <h4 class="widget-title"><span>分类</span> </h4>
                <div class="widget-content">
                    <ul id="category"></ul>
                </div>
            </aside>
            <aside class="widget popular-posts-widget">
                <h4 class="widget-title"> <span>标签</span></h4>
                <div class="widget-content">
                    <aside class="widget bt-widget-categories">
                        <div class="entry-footer mt-10">
                            <div class="entry-tag">
                                <@blog method="codes" codeId="${options['articleTagCodeId']}">
                                    <#list codes as code>
                                        <a href="#" rel="tag">${code.name}</a>
                                    </#list>
                                </@blog>
                            </div>
                        </div>
                    </aside>
                </div>
            </aside>

            <!--~~~~~ Start Popular Posts Widget~~~~~-->
            <aside class="widget popular-posts-widget">
                <h4 class="widget-title"> <span>热门文章</span></h4>
                <div class="widget-content">
                    <#list articlesTop as article>
                        <article class="post side-post">
                            <div class="content-entry-wrap">
                                <h3 class="entry-title">
                                    <a href="/article/view/${article.id}">${article.title}</a>
                                </h3>
                                <div class="entry-meta-content">
                                    <div class="entry-date">
                                        <span>
                                            <@formatTime unix="${article.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"> </@formatTime>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </article>
                    </#list>


                   <#-- <article class="post side-post">
                        <!--./ thumb-wrap &ndash;&gt;
                        <div class="content-entry-wrap">
                            <h3 class="entry-title">
                                <a href="../black/post-details.html">How to live with some vegeterian when you eat</a>
                            </h3><!--./ entry-title &ndash;&gt;
                            <div class="entry-meta-content">
                                <div class="entry-date"><span>July 24, 2019</span></div>
                                <!--./ entry-date &ndash;&gt;
                            </div>
                            <!--./ entry-meta-content &ndash;&gt;
                        </div>
                    </article>
                    <article class="post side-post">
                        <!--./ thumb-wrap &ndash;&gt;
                        <div class="content-entry-wrap">
                            <h3 class="entry-title">
                                <a href="../black/post-details.html">This gun is advertise as the most popular gun</a>
                            </h3><!--./ entry-title &ndash;&gt;
                            <div class="entry-meta-content">
                                <div class="entry-date"><span>July 24, 2019</span></div>
                                <!--./ entry-date &ndash;&gt;
                            </div>
                            <!--./ entry-meta-content &ndash;&gt;
                        </div>
                    </article>-->

            </aside>
            <!--~./ end popular posts widget ~-->
        </div>
    </div>
</div>