/**
 * <p> 描述 : 评论相关
 * @author : blackcat
 * @date  : 2020/3/10 13:12
*/
var commentCount=0;// 评论条数
var loadCount=3;// 加载根评论条数
$(function () {
    /**
     * <p> 描述 : 加载评论
     * @author : blackcat
     * @date  : 2020/3/10 16:06
    */
    $.get("/comment/getAllByArticleId/"+$("#articleId").val(),function (json) {
        if (json){
            var data=json.data;
            var html='';
            var loadMore=0;
            for (var i=0; i<data.length; i++) {
                var comment = data[i];
                html+='<li class="c_card"';
                if(i>loadCount){
                    html+='style="display: none"';
                    loadMore=1;
                }
                html+='>';

                html+='<div class="c_body">';
                html+='<div class="c_head">';
                html+='<img class="vavatar" src="'+comment.avatar+'">';
                html+='<a class="c_at" pid="'+comment.id+'" data-at="'+comment.nickName+'" data-root="1" onclick="toComment(this)" href="javascript:;;;" rel="nofollow">回复</a>';
                html+='</div>';
                html+='<div class="c_info">';
                html+='<span class="c_name">'+comment.nickName+'</span>';
                html+='<span class="c_time">'+comment.createTime+'</span>';
                html+='</div>';
                html+='<div class="c_content"><p>'+comment.comment+'</p></div>';
                html+='</div>';
                html+='<div class="c_list" id="'+comment.id+'" style="width:92%;float:right;">';
                if (comment.nodes.length > 0) {
                    html+=loadChildComment(comment);
                }
                html+='</div>';
                html+='<div style="clear:both;"></div>';
                html+='</li>';
                commentCount++;
            }
            $("#comment").append(html);
            $("#commentCount").html(commentCount);
            if(loadMore==1){
                $(".load-more-area .loadmore").addClass("active");
            }
        }
    });

    // 提交评论
    $("#comment_submit").click(function () {
        if ($("#isLogin").length>0) {
            alert("请先登录再评论！");
        } else {
            $.ajax({
                type: "post",
                url: "/comment/add",
                data: $("#contact_form").serialize(),
                success: function (json) {
                    var html='';
                    if($("#commentType").val()==0){// 对文章进行评论
                        html=initLi(json.data);
                        $("#comment").prepend(html);
                    }else {// 回复用户评论
                        html=initDiv(json.data);
                        $("#"+$("#commentParentId").val()).append(html);
                    }
                    $("#commentText").val("");
                    $("#parentId").val("");
                    $("#comment_at").html("");
                    $("#commentType").val(0);
                }
            });
        }
    });

    // 加载更多
    $(".loadmore").on("click", function (f) {
        f.preventDefault();
        $("li.c_card:hidden").slice(0, 2).fadeIn(2000);
        if ($("li.c_card:hidden").length == 0) {
            $(".loadmore").fadeOut(100);
            $(".no-posts").show().fadeIn("slow")
        }
        $("html,body").animate({scrollTop: $(this).offset().top - 300}, 1200)
    })
});

/**
 * <p> 描述 : 回复页面填充-回复用户评论
 * @author : blackcat
 * @date  : 2020/3/10 17:19
*/
function initDiv(comment) {
    var div='';
    div+='<div class="c_card">';
    div+='<div class="c_body">';
    div+='<div class="c_head">';
    div+='<img class="vavatar" src="'+$("#userAvatar").val()+'">';
    div+='<a class="c_at" pid="'+comment.id+'" data-at="'+$("#userNick").val()+'" data-root="0" onclick="toComment(this)" href="javascript:;;;" rel="nofollow">回复</a>';
    div+='</div>';
    div+='<div class="c_info">';
    div+='<span class="c_name">'+$("#userNick").val()+'</span>';
    div+='<span class="c_time">'+getTime()+'</span>';
    div+='</div>';
    div+='<div class="c_content">';
    div+='<p>';
    div+='<span  class="at">'+$("#comment_at").html()+': </span>';
    div+=comment.comment;
    div+='</p>';
    div+='</div>';
    div+='</div>';
    div+='</div>';
    return div;
}

/**
 * <p> 描述 : 回复页面填充-文章评论
 * @author : blackcat
 * @date  : 2020/3/10 16:06
*/
function initLi(comment) {
    var html='';
    html+='<li class="c_card">';
    html+='<div class="c_body">';
    html+='<div class="c_head">';
    html+='<img class="vavatar" src="'+$("#userAvatar").val()+'">';
    html+='<a class="c_at" pid="'+comment.id+'" data-at="'+$("#userNick").val()+'" data-root="1" onclick="toComment(this)" href="javascript:;;;" rel="nofollow">回复</a>';
    html+='</div>';
    html+='<div class="c_info">';
    html+='<span class="c_name">'+$("#userNick").val()+'</span>';
    html+='<span class="c_time">'+getTime()+'</span>';
    html+='</div>';
    html+='<div class="c_content"><p>'+comment.comment+'</p></div>';
    html+='</div>';
    html+='<div class="c_list" id="'+comment.id+'" style="width:92%;float:right;">';
    html+='</div>';
    html+='<div style="clear:both;"></div>';
    html+='</li>';
    return html;
}

/**
 * <p> 描述 : 加载评论回复
 * @author : blackcat
 * @date  : 2020/3/10 16:05
*/
function loadChildComment(comment) {
    var div='';
    for(var i=0;i<comment.nodes.length;i++){
        var child=comment.nodes[i];
        div+='<div class="c_card">';
        div+='<div class="c_body">';
        div+='<div class="c_head">';
        div+='<img class="vavatar" src="'+child.avatar+'">';
        div+='<a class="c_at" pid="'+child.id+'" data-at="'+child.nickName+'" data-root="0" onclick="toComment(this)" href="javascript:;;;" rel="nofollow">回复</a>';
        div+='</div>';
        div+='<div class="c_info">';
        div+='<span class="c_name">'+child.nickName+'</span>';
        div+='<span class="c_time">'+child.createTime+'</span>';
        div+='</div>';
        div+='<div class="c_content">';
        div+='<p>';
        div+='<span  class="at">@'+comment.nickName+': </span>';
        div+=child.comment;
        div+='</p>';
        div+='</div>';
        div+='</div>';
        div+='</div>';
        if(child.nodes.length > 0) {//如果有子集
            div+=loadChildComment(child);
        }
        commentCount++;
    }
    return div;
}

/**
 * <p> 描述 : 按钮事件填充数据
 * @author : blackcat
 * @date  : 2020/3/10 16:06
*/
function toComment(obj) {
    $("#parentId").val($(obj).attr("pid"));
    $("#comment_at").html("@"+$(obj).attr("data-at"));
    $("#commentType").val(1);
    $("#commentText").focus();
    if($(obj).attr("data-root")==0){
        $("#commentParentId").val($(obj).parent().parent().parent().parent().attr("id"));
    }else{
        $("#commentParentId").val($(obj).attr("pid"));
    }
}

/**
 * <p> 描述 : 获取当前时间
 * @author : blackcat
 * @date  : 2020/3/10 16:50
*/
function getTime() {
    var nowDate = new Date();
    var year = nowDate.getFullYear();
    var month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1) : nowDate.getMonth() + 1;
    var date = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate.getDate();
    var hour = nowDate.getHours()< 10 ? "0" + nowDate.getHours() : nowDate.getHours();
    var minute = nowDate.getMinutes()< 10 ? "0" + nowDate.getMinutes() : nowDate.getMinutes();
    var second = nowDate.getSeconds()< 10 ? "0" + nowDate.getSeconds() : nowDate.getSeconds();
    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
}
