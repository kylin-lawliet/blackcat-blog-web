(function () {
    var c;
    var e = function () {
    };
    var d = ["assert", "clear", "count", "debug", "dir", "dirxml", "error", "exception", "group", "groupCollapsed", "groupEnd", "info", "log", "markTimeline", "profile", "profileEnd", "table", "time", "timeEnd", "timeline", "timelineEnd", "timeStamp", "trace", "warn"];
    var b = d.length;
    var a = (window.console = window.console || {});
    while (b--) {
        c = d[b];
        if (!a[c]) {
            a[c] = e
        }
    }
}());
!function (a) {
    a.fn.meanmenu = function (c) {
        var d = {
            meanMenuTarget: jQuery(this),
            meanMenuContainer: "body",
            meanMenuClose: "X",
            meanMenuCloseSize: "18px",
            meanMenuOpen: "<span /><span /><span />",
            meanRevealPosition: "right",
            meanRevealPositionDistance: "0",
            meanRevealColour: "",
            meanScreenWidth: "480",
            meanNavPush: "",
            meanShowChildren: !0,
            meanExpandableChildren: !0,
            meanExpand: "+",
            meanContract: "-",
            meanRemoveAttrs: !1,
            onePage: !1,
            meanDisplay: "block",
            removeElements: ""
        };
        c = a.extend(d, c);
        var b = window.innerWidth || document.documentElement.clientWidth;
        return this.each(function () {
            var O = c.meanMenuTarget, Y = c.meanMenuContainer, V = c.meanMenuClose, I = c.meanMenuCloseSize,
                X = c.meanMenuOpen, Z = c.meanRevealPosition, L = c.meanRevealPositionDistance, K = c.meanRevealColour,
                R = c.meanScreenWidth, q = c.meanNavPush, aa = ".meanmenu-reveal", H = c.meanShowChildren,
                B = c.meanExpandableChildren, ae = c.meanExpand, J = c.meanContract, U = c.meanRemoveAttrs,
                F = c.onePage, G = c.meanDisplay, S = c.removeElements, z = !1;
            (navigator.userAgent.match(/iPhone/i) || navigator.userAgent.match(/iPod/i) || navigator.userAgent.match(/iPad/i) || navigator.userAgent.match(/Android/i) || navigator.userAgent.match(/Blackberry/i) || navigator.userAgent.match(/Windows Phone/i)) && (z = !0), (navigator.userAgent.match(/MSIE 8/i) || navigator.userAgent.match(/MSIE 7/i)) && jQuery("html").css("overflow-y", "scroll");
            var ab = "", ad = function () {
                if ("center" === Z) {
                    var f = window.innerWidth || document.documentElement.clientWidth, g = f / 2 - 22 + "px";
                    ab = "left:" + g + ";right:auto;", z ? jQuery(".meanmenu-reveal").animate({left: g}) : jQuery(".meanmenu-reveal").css("left", g)
                }
            }, e = !1, D = !1;
            "right" === Z && (ab = "right:" + L + ";left:auto;"), "left" === Z && (ab = "left:" + L + ";right:auto;"), ad();
            var N = "", T = function () {
                N.html(jQuery(N).is(".meanmenu-reveal.meanclose") ? V : X)
            }, ac = function () {
                jQuery(".mean-bar,.mean-push").remove(), jQuery(Y).removeClass("mean-container"), jQuery(O).css("display", G), e = !1, D = !1, jQuery(S).removeClass("mean-remove")
            }, k = function () {
                var f = "background:" + K + ";color:" + K + ";" + ab;
                if (R >= b) {
                    jQuery(S).addClass("mean-remove"), D = !0, jQuery(Y).addClass("mean-container"), jQuery(".mean-container").prepend('<div class="mean-bar"><a href="#nav" class="meanmenu-reveal" style="' + f + '">Show Navigation</a><nav class="mean-nav"></nav></div>');
                    var g = jQuery(O).html();
                    jQuery(".mean-nav").html(g), U && jQuery("nav.mean-nav ul, nav.mean-nav ul *").each(function () {
                        jQuery(this).is(".mean-remove") ? jQuery(this).attr("class", "mean-remove") : jQuery(this).removeAttr("class"), jQuery(this).removeAttr("id")
                    }), jQuery(O).before('<div class="mean-push" />'), jQuery(".mean-push").css("margin-top", q), jQuery(O).hide(), jQuery(".meanmenu-reveal").show(), jQuery(aa).html(X), N = jQuery(aa), jQuery(".mean-nav ul").hide(), H ? B ? (jQuery(".mean-nav ul ul").each(function () {
                        jQuery(this).children().length && jQuery(this, "li:first").parent().append('<a class="mean-expand" href="#" style="font-size: ' + I + '">' + ae + "</a>")
                    }), jQuery(".mean-expand").on("click", function (h) {
                        h.preventDefault(), jQuery(this).hasClass("mean-clicked") ? (jQuery(this).text(ae), jQuery(this).prev("ul").slideUp(300, function () {
                        })) : (jQuery(this).text(J), jQuery(this).prev("ul").slideDown(300, function () {
                        })), jQuery(this).toggleClass("mean-clicked")
                    })) : jQuery(".mean-nav ul ul").show() : jQuery(".mean-nav ul ul").hide(), jQuery(".mean-nav ul li").last().addClass("mean-last"), N.removeClass("meanclose"), jQuery(N).click(function (h) {
                        h.preventDefault(), e === !1 ? (N.css("text-align", "center"), N.css("text-indent", "0"), N.css("font-size", I), jQuery(".mean-nav ul:first").slideDown(), e = !0) : (jQuery(".mean-nav ul:first").slideUp(), e = !1), N.toggleClass("meanclose"), T(), jQuery(S).addClass("mean-remove")
                    }), F && jQuery(".mean-nav ul > li > a:first-child").on("click", function () {
                        jQuery(".mean-nav ul:first").slideUp(), e = !1, jQuery(N).toggleClass("meanclose").html(X)
                    })
                } else {
                    ac()
                }
            };
            z || jQuery(window).resize(function () {
                b = window.innerWidth || document.documentElement.clientWidth, b > R, ac(), R >= b ? (k(), ad()) : ac()
            }), jQuery(window).resize(function () {
                b = window.innerWidth || document.documentElement.clientWidth, z ? (ad(), R >= b ? D === !1 && k() : ac()) : (ac(), R >= b && (k(), ad()))
            }), k()
        })
    }
}(jQuery);