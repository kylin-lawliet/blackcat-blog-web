<!--********************************************************-->
<!--********************* 页头 **********************-->
<!--********************************************************-->
<#include "layout/header.ftl"/>

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


                        </div>
                    </main>
                    <!--面内容主体结束~-->

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