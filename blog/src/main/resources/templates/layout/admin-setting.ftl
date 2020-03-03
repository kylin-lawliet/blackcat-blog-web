<#assign basePath=request.contextPath />
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>
            <#--<ul class="nav navbar-nav navbar-right">-->
                <#--<li class="">-->
                    <#--<a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">-->
                        <#--<img src="${basePath}/images/author.png" alt=""><#if user?exists>${user.username?if_exists}<#else>管理员</#if>-->
                        <#--<span class=" fa fa-angle-down"></span>-->
                    <#--</a>-->
                    <#--<ul class="dropdown-menu dropdown-usermenu pull-right">-->
                        <#--<li><a href="/logout"><i class="fa fa-sign-out pull-right"></i> 退出系统</a></li>-->
                    <#--</ul>-->
                <#--</li>-->
                <#--<li class="">-->
                    <#--<i class="fa fa-sign-out pull-right"></i><a href="${basePath}/logout"> 退出系统</a>-->
                <#--</li>-->
            <#--</ul>-->
            <ul class="nav navbar-nav navbar-right list-unstyled d-flex flex-md-row align-items-md-center">

                <!-- Logout    -->
                <li class="nav-item">
                    <a class="nav-link logout" href="${basePath}/logout">
                        <span class="d-none d-sm-inline">Logout &nbsp;</span>
                        <i class="fa fa-sign-out"></i>
                    </a>
                </li>

                <!-- Notifications-->
                <li class="nav-item dropdown"> <a class="nav-link" id="notifications" aria-expanded="false" aria-haspopup="true" href="#" rel="nofollow" data-toggle="dropdown" data-target="#"><i class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">12</span></a>
                    <ul class="dropdown-menu" aria-labelledby="notifications">
                        <li><a class="dropdown-item" href="#" rel="nofollow">
                                <div class="notification">
                                    <div class="notification-content">
                                        <i class="fa fa-envelope bg-green"></i>
                                        &nbsp; You have 6 new messages
                                    </div>
                                    <div class="notification-time">
                                        <small>4 minutes ago</small>
                                    </div>
                                </div></a></li>
                        <li><a class="dropdown-item" href="#" rel="nofollow">
                                <div class="notification">
                                    <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have 2 followers</div>
                                    <div class="notification-time"><small>4 minutes ago</small></div>
                                </div></a></li>
                        <li><a class="dropdown-item" href="#" rel="nofollow">
                                <div class="notification">
                                    <div class="notification-content"><i class="fa fa-upload bg-orange"></i>Server Rebooted</div>
                                    <div class="notification-time"><small>4 minutes ago</small></div>
                                </div></a></li>
                        <li><a class="dropdown-item" href="#" rel="nofollow">
                                <div class="notification">
                                    <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have 2 followers</div>
                                    <div class="notification-time"><small>10 minutes ago</small></div>
                                </div></a></li>
                        <li><a class="dropdown-item all-notifications text-center" href="#" rel="nofollow"> <strong>view all notifications                                            </strong></a></li>
                    </ul>
                </li>
                <!-- Messages                        -->
                <li class="nav-item dropdown"> <a class="nav-link" id="messages" aria-expanded="false" aria-haspopup="true" href="#" rel="nofollow" data-toggle="dropdown" data-target="#"><i class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>
                    <ul class="dropdown-menu" aria-labelledby="notifications">
                        <li><a class="dropdown-item d-flex" href="#" rel="nofollow">
                                <div class="msg-body" style="white-space:nowrap;text-overflow:ellipsis;overflow:hidden;width:190px;">
                                    <h3 class="h5">Jason DoeJason</h3>'
                                    <span >Sent You MessageSent You MessageSent You Message</span>
                                </div></a></li>
                        <li><a class="dropdown-item d-flex" href="#" rel="nofollow">
                                <div class="msg-body">
                                    <h3 class="h5">Frank Williams</h3><span>Sent You Message</span>
                                </div></a></li>
                        <li><a class="dropdown-item d-flex" href="#" rel="nofollow">
                                <div class="msg-body">
                                    <h3 class="h5">Ashley Wood</h3><span>Sent You Message</span>
                                </div></a></li>
                        <li><a class="dropdown-item all-notifications text-center" href="#" rel="nofollow"> <strong>Read all messages   </strong></a></li>
                    </ul>
                </li>

                <li><a href="${basePath}/" title="跳转到前台"><i class="fa fa-desktop"></i></a></li>
            </ul>
        </nav>
    </div>
</div>