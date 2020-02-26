/*!
 * TrackpadScrollEmulator
 * Version: 1.0.8
 * Author: Jonathan Nicol @f6design
 * https://github.com/jnicol/trackpad-scroll-emulator
 */
!function (a) {
    function b(b, d) {
        function e() {
            A.hasClass("horizontal") && (D = "horiz", E = "scrollLeft", F = "width", G = "left"), A.prepend('<div class="tse-scrollbar"><div class="drag-handle"></div></div>'), v = A.find(".tse-scrollbar:first"), w = A.find(".drag-handle:first"), d.wrapContent && B.wrap('<div class="tse-scroll-content" />'), u = A.find(".tse-scroll-content:first"), o(), d.autoHide && A.on("mouseenter", l), w.on("mousedown", f), v.on("mousedown", i), u.on("scroll", j), k(), a(window).on("resize.trackpadScollEmulator", q), d.autoHide || m()
        }

        function f(b) {
            b.preventDefault();
            var c = b.pageY;
            "horiz" === D && (c = b.pageX), x = c - w.offset()[G], a(document).on("mousemove", g), a(document).on("mouseup", h)
        }

        function g(a) {
            a.preventDefault();
            var b = a.pageY;
            "horiz" === D && (b = a.pageX);
            var c = b - v.offset()[G] - x, d = c / v[F](), e = d * B[F]();
            u[E](e)
        }

        function h() {
            a(document).off("mousemove", g), a(document).off("mouseup", h)
        }

        function i(a) {
            if (a.target !== w[0]) {
                var b = C * u[F](), c = "vert" === D ? a.originalEvent.layerY : a.originalEvent.layerX,
                    d = w.position()[G], e = d > c ? u[E]() - b : u[E]() + b;
                u[E](e)
            }
        }

        function j() {
            l()
        }

        function k() {
            var a = "height" === F ? B.outerHeight() : B.outerWidth(), b = u[E](), c = v[F](), d = c / a,
                e = Math.round(d * b) + 2, f = Math.floor(d * (c - 2)) - 2;
            a > c ? (w.css("vert" === D ? {top: e, height: f} : {left: e, width: f}), v.show()) : v.hide()
        }

        function l() {
            k(), m()
        }

        function m() {
            w.addClass("visible"), d.autoHide && ("number" == typeof y && window.clearTimeout(y), y = window.setTimeout(function () {
                n()
            }, 1e3))
        }

        function n() {
            w.removeClass("visible"), "number" == typeof y && window.clearTimeout(y)
        }

        function o() {
            "vert" === D ? (u.width(A.width() + p()), u.height(A.height())) : (u.width(A.width()), u.height(A.height() + p()), B.height(A.height()))
        }

        function p() {
            var b = a('<div class="scrollbar-width-tester" style="width:50px;height:50px;overflow-y:scroll;position:absolute;top:-200px;left:-200px;"><div style="height:100px;"></div>');
            a("body").append(b);
            var c = a(b).innerWidth(), d = a("div", b).innerWidth();
            return b.remove(), c === d && navigator.userAgent.toLowerCase().indexOf("firefox") > -1 ? 17 : c - d
        }

        function q() {
            o(), k()
        }

        function r(a, b) {
            return b ? void (d[a] = b) : d[a]
        }

        function s() {
            B.insertBefore(v), v.remove(), u.remove(), B.css({
                height: A.height() + "px",
                "overflow-y": "scroll"
            }), a(window).off("resize.trackpadScollEmulator"), t("onDestroy"), A.removeData("plugin_" + c)
        }

        function t(a) {
            void 0 !== d[a] && d[a].call(z)
        }

        var u, v, w, x, y, z = b, A = a(b), B = A.find(".tse-content:first"), C = 7 / 8, D = "vert", E = "scrollTop",
            F = "height", G = "top";
        return d = a.extend({}, a.fn[c].defaults, d), e(), {option: r, destroy: s, recalculate: q}
    }

    var c = "TrackpadScrollEmulator";
    a.fn[c] = function (d) {
        if ("string" == typeof arguments[0]) {
            var e, f = arguments[0], g = Array.prototype.slice.call(arguments, 1);
            return this.each(function () {
                if (!a.data(this, "plugin_" + c) || "function" != typeof a.data(this, "plugin_" + c)[f]) throw new Error("Method " + f + " does not exist on jQuery." + c);
                e = a.data(this, "plugin_" + c)[f].apply(this, g)
            }), void 0 !== e ? e : this
        }
        return "object" != typeof d && d ? void 0 : this.each(function () {
            a.data(this, "plugin_" + c) || a.data(this, "plugin_" + c, new b(this, d))
        })
    }, a.fn[c].defaults = {
        onInit: function () {
        }, onDestroy: function () {
        }, wrapContent: !0, autoHide: !0
    }
}(jQuery);
