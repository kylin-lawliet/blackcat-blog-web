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
                            <!--~~~~~ 文章内容 ~~~~~-->
                            <div class="post-share-area pt-40">
                                <#--<h3>221<span>SHARES</span></h3>-->
                                <span>注意：本文归作者所有，未经作者允许，不得转载</span>
                               <#-- <div class="share">
                                    <i class="fa fa-comment-o fa-2x"></i>
                                </div>-->
                            </div>
                            <div class="entry-footer">
                                <h3 class="comment-reply-title"><span>全部评论：</span><span>0</span>&nbsp;条</h3>
                            </div>

                            <div id="comment" class="pt-30">
                                <ul class="c_list">
                                    <li class="c_card">
                                        <div class="c_body">
                                            <div class="c_head">
                                                <img class="vavatar" src="https://v1.alapi.cn/api/avatar?email=530022025@qq.com&amp;size=50">
                                                <a class="c_at" id="6c22f0d6" href="#tagcloud" rel="nofollow"
                                                   data-cid="6c22f0d6" data-at="@Blue">回复</a>
                                                <a class="c_del" id="del6c22f0d6" href="#tagcloud" rel="nofollow" data-did="6c22f0d6">删除</a>
                                            </div>
                                            <div class="c_info">
                                                <a class="c_name" href="http://" target="_blank" rel="nofollow">Blue</a>
                                                <span class="c_time">2020-1-4 23:23:59</span>
                                            </div>
                                            <div class="c_content">
                                                <p>鸡哥，我想请问下这个表情包怎么加载进来的，我查看了valine
                                                    admin的文档，该有的配置都配置了，表情包也下载了，但是就是只有显示评论框</p>
                                            </div>
                                        </div>
                                        <div class="c_list" style="width:92%;float:right;"></div>
                                        <div style="clear:both;"></div>
                                    </li>
                                    <li class="c_card">
                                        <div class="c_body">
                                            <div class="c_head">
                                                <img class="vavatar"
                                                     src="https://v1.alapi.cn/api/avatar?email=793458585@qq.com&amp;size=50">
                                                <a class="c_at" id="5d6de36343e78c0068e9f470" href="#tagcloud"
                                                   rel="nofollow" data-cid="5d6de36343e78c0068e9f470"
                                                   data-at="@北宸">回复</a>
                                                <a class="c_del" id="del5d6de36343e78c0068e9f470" rel="nofollow" href="#tagcloud"
                                                   data-did="5d6de36343e78c0068e9f470">删除</a>
                                            </div>
                                            <div class="c_info">
                                                <a class="c_name" href="https://leafjame.github.io" target="_blank"
                                                   rel="nofollow">北宸</a>
                                                <span class="c_time">2019-09-03 03:52:12</span>
                                            </div>
                                            <div class="c_content">
                                                <p>大佬，您现在的评论界面很赞，和文章里写的不一样了，有教程嘛？学习ing
                                                    <img class="vemoticon-img" alt="献花.png"
                                                         src="https://cloud.panjunwen.com/alu/献花.png">
                                                    <img class="vemoticon-img" alt="献花.png"
                                                         src="https://cloud.panjunwen.com/alu/献花.png">
                                                    <img class="vemoticon-img" alt="献花.png"
                                                         src="https://cloud.panjunwen.com/alu/献花.png">
                                                </p>
                                            </div>
                                        </div>
                                        <div class="c_list" style="width:92%;float:right;"></div>
                                        <div style="clear:both;"></div>
                                    </li>
                                    <li class="c_card">
                                        <div class="c_body">
                                            <div class="c_head">
                                                <img class="vavatar" src="https://v1.alapi.cn/api/avatar?email=korin_dota@163.com&amp;size=50">
                                                <a class="c_at" id="5d1b239630863b0070ff7fa4" href="#tagcloud"
                                                        rel="nofollow" data-cid="5d1b239630863b0070ff7fa4"
                                                        data-at="@korin">回复</a>
                                                <a class="c_del" id="del5d1b239630863b0070ff7fa4" rel="nofollow" data-did="5d1b239630863b0070ff7fa4" href="#tagcloud">删除</a>
                                            </div>
                                            <div class="c_info">
                                                <a class="c_name" href="http://korin.mau5.top" target="_blank" rel="nofollow">korin</a>
                                                <span class="c_time">2019-07-02 09:27:58</span>
                                            </div>
                                            <div class="c_content">以后滴沙发IEhi哇哈
                                            </div>
                                        </div>
                                        <div class="c_list" style="width:92%;float:right;">
                                            <div class="c_card">
                                                <div class="c_body">
                                                    <div class="c_head">
                                                        <img class="vavatar" src="https://v1.alapi.cn/api/avatar?email=flyphp@outlook.com&amp;size=50"><a
                                                                class="c_at" id="5d1ca5ec30863b0070106002"
                                                                href="#tagcloud" rel="nofollow"
                                                                data-cid="5d1b239630863b0070ff7fa4" data-at="@小鸡">回复</a>
                                                        <a class="c_del" id="del5d1ca5ec30863b0070106002" href="#tagcloud"
                                                                rel="nofollow" data-pre="5d1b239630863b0070ff7fa4"
                                                                data-did="5d1ca5ec30863b0070106002">删除</a>
                                                    </div>
                                                    <div class="c_info">
                                                        <a class="c_name" href="http://me.idealli.com" target="_blank" rel="nofollow">小鸡</a>
                                                        <span class="c_time">2019-07-03 12:56:19</span>
                                                    </div>
                                                    <div class="c_content">
                                                        <p>
                                                            <a class="at" href="#5d1b239630863b0070ff7fa4">@korin</a>
                                                            ，现在使用的是另一位作者的valine评论框，具体名字好像叫valine admin
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div style="clear:both;"></div>
                                    </li>
                                </ul>
                            </div>

                            <div class="comments-area pt-40" id="comments">
                                <div class="comment-respond" id="respond">
                                    <h3 class="comment-reply-title headline">
                                        <span>发表评论</span>
                                    </h3>
                                    <form name="contactForm" id="contact_form" action="comments-post.php" method="post">
                                        <div class="row">
                                            <div class="col-12">
                                                <p>
                                                    <textarea name="message" class="form-controllar" id="message"
                                                              aria-required="true" placeholder="请输入评论...."
                                                              rows="8" cols="45"></textarea>
                                                </p>
                                            </div>
                                            <div class="col-lg-4">
                                                <p>
                                                    <input name="name" class="form-controllar" id="name" aria-required="true" type="text" placeholder="昵称*">
                                                </p>
                                            </div>
                                            <div class="col-lg-4">
                                                <p>
                                                    <input name="email" class="form-controllar" id="email-comments" aria-required="true" type="text" placeholder="邮箱*">
                                                </p>
                                            </div>
                                            <div class="col-lg-4">
                                                <p>
                                                    <input name="url" class="form-controllar" id="url" aria-required="true" type="text" placeholder="网址">
                                                </p>
                                            </div>
                                            <div class="col-md-12">
                                                <p class="form-submit">
                                                    <input name="submit" id="submit" type="submit" value="发送">
                                                </p>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <!-- #respond -->
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