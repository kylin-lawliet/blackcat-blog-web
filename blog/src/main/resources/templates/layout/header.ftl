<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${options['site_name']}</title>
    <!--字体-->
    <link rel="stylesheet" href="${basePath}/bootstrap/css/font-awesome.css">
    <!-- 插件样式 -->
    <link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${basePath}/css/animate.min.css">
    <link rel="stylesheet" href="${basePath}/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${basePath}/css/breaking-news-ticker.css">
    <link rel="stylesheet" href="${basePath}/css/trackpad-scroll-emulator.css">
    <link rel="stylesheet" href="${basePath}/css/meanmenu.min.css">
    <link rel="stylesheet" href="${basePath}/css/editor.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${basePath}/css/style.css">
</head>
<body>
<header class="site-header header-style-two">

    <div class="site-navigation">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="navbar navbar-expand-lg navigation-area">

                        <!--博客图标-->
                        <div class="site-logo-block">
                            <a class="navbar-brand site-logo" href="/admin">
                                <img src="${basePath}${options['site_logo']}" alt="logo">
                            </a>
                        </div>

                        <!--导航菜单-->
                        <input type="hidden" id="codeType" value="1">
                        <input type="hidden" id="codeId" value="${options['navigation']}">
                        <div class="mainmenu-area">
                            <nav class="menu">
                                <ul id="nav"></ul>
                            </nav>
                        </div>

                        <!--搜索框-->
                        <div class="header-navigation-right">
                            <div class="search-wrap">
                                <div class="search-btn">
                                    <img src="/images/search.png" alt="icon">
                                    <span>Search</span>
                                </div>
                                <div class="search-form">
                                    <form action="#">
                                        <input type="search" placeholder="Search">
                                        <button type="submit">
                                            <i class='fa fa-search'></i>
                                        </button>
                                    </form>
                                </div>
                            </div>
                            <div>
                                <a href="/admin" id="bt-admin" title="后台管理">
                                    <i class="fa fa-laptop"></i>
                                </a>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~            Start Breaking News Area        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
    <div class="breaking-news-area">
        <div class="container">
            <div class="row">
                <div class="col -12">
                    <div id="newsTicker" class="breaking-news-ticker">
                        <div class="bn-label">最新消息</div>
                        <div class="bn-news">
                            <ul>
                                <li><a href="#">Taiwanese flag on artwork painted very pretty in australia & canada
                                        <span>Politics</span></a></li>
                                <li><a href="#">The five biggest fashion looks for next spring <span>Fashion</span></a>
                                </li>
                                <li><a href="#">Cold skateboard an annual booking release in brazil
                                        <span>Food</span></a></li>
                                <li><a href="#">Return of the bench seat Concept show space big for
                                        sofas<span>Lifestyle</span></a></li>
                            </ul>
                        </div>
                        <!--./ bn-news -->
                        <div class="bn-controls">
                            <button><span class="bn-arrow bn-prev"></span></button>
                            <button><span class="bn-arrow bn-next"></span></button>
                        </div>
                        <!--./ bn-controls -->
                    </div>
                </div>
            </div>
        </div>
    </div><!--~./ end breaking news area ~-->
</header>