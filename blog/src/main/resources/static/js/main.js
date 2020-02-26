(function (a) {
    var b = {
        scroll_top: function () {
            a("body").append("<a href='#top' id='scroll-top' class='topbutton btn-hide'><span class='fa fa-angle-double-up'></span></a>");
            var c = a("#scroll-top");
            a(window).on("scroll", function () {
                if (a(this).scrollTop() > a(this).height()) {
                    c.addClass("btn-show").removeClass("btn-hide")
                } else {
                    c.addClass("btn-hide").removeClass("btn-show")
                }
            });
            a("a[href='#top']").on("click", function () {
                a("html, body").animate({scrollTop: 0}, "normal");
                return false
            })
        }, background_fit_image: function () {
            a.fn.bgImage = function () {
                a(this).each(function () {
                    var c = a(this).find("img");
                    var d = c.attr("src");
                    c.css("visibility", "hidden");
                    a(this).css("backgroundImage", "url(" + d + ")");
                    if (!c.length) {
                        a(this).css("backgroundImage", "none")
                    }
                })
            };
            a(".frontpage-featured-posts.featured-style-one .featured-item .featured-media").bgImage();
            a(".frontpage-featured-posts.featured-style-two .featured-item .featured-media").bgImage();
            a(".post-grid.style-five .thumb-wrap").bgImage();
            a(".post-grid.style-six .thumb-wrap").bgImage();
            a(".slider-item .slider-thumb").bgImage();
            a(".singlePost-item .slider-thumb").bgImage()
        }, sidebar_menu_and_search: function () {
            a(".sidebar-menu-btn").on("click", function () {
                a(".sidebar-menu").toggleClass("active")
            });
            a(".sidebar-menu-close-button, .sidebar-menu-close-all-window").on("click", function () {
                a(".sidebar-menu").toggleClass("active");
                return false
            });
            a(".site-header .navigation-area .mainmenu-area").clone().appendTo(".sidebar-menu-inner");
            a(".sidebar-menu-inner li.dropdown-trigger > a").on("click", function () {
                a(this).siblings(".dropdown-content").slideToggle(500);
                a(this).toggleClass("active")
            });
            a("#bt-show-sidebar").on("click", function () {
                a("body").addClass("off-canves-opend");
                return false
            });
            a(".magala-close-all-window, .sidebar-close-button").on("click", function () {
                a("body").removeClass("off-canves-opend");
                return false
            })
        }, mobile_menu: function () {
            var c = a(".site-header .navigation-area .search-wrap").clone().appendTo(".mobile-menu");
            a(".site-navigation .mainmenu-area nav").meanmenu({
                meanMenuClose: "<i class='fa fa-close'></i>",
                meanMenuCloseSize: "18px",
                meanScreenWidth: "991",
                meanExpandableChildren: true,
                meanMenuContainer: ".mobile-menu"
            })
        }, news_ticker: function () {
            a("#newsTicker").breakingNews({effect: "typography"})
        }, scroll_bar: function () {
            if (a(".magala-side-sidebar").length) {
                var c = a(".magala-side-sidebar");
                c.TrackpadScrollEmulator();
                a(window).resize(function () {
                    setTimeout(function () {
                        c.TrackpadScrollEmulator("recalculate")
                    }, 250)
                })
            }
            if (a(".video-channels-inner").length) {
                var e = a(".video-channels-inner");
                e.TrackpadScrollEmulator();
                a(window).resize(function () {
                    setTimeout(function () {
                        e.TrackpadScrollEmulator("recalculate")
                    }, 250)
                })
            }
            if (a(".sidebar-menu").length) {
                var d = a(".sidebar-menu");
                d.TrackpadScrollEmulator();
                a(window).resize(function () {
                    setTimeout(function () {
                        d.TrackpadScrollEmulator("recalculate")
                    }, 250)
                })
            }
        }, sticky_sidebar: function () {
            if (a(".sidebar").length) {
                a(".sidebar").theiaStickySidebar({
                    containerSelector: ".main-wrapper",
                    additionalMarginTop: 0,
                    minWidth: 992,
                })
            }
        }, frontpage_slider: function () {
            if (a("#frontpage-slider.frontpage-slider-one").length) {
                a("#frontpage-slider.frontpage-slider-one").owlCarousel({
                    center: true,
                    items: 1,
                    autoplay: true,
                    autoplayTimeout: 5000,
                    loop: true,
                    margin: 0,
                    singleItem: true,
                    nav: false,
                    dots: false,
                    thumbs: true,
                    thumbsPrerendered: true,
                    animateIn: "fadeIn",
                    animateOut: "fadeOut"
                })
            }
            if (a("#frontpage-slider.frontpage-slider-two").length) {
                a("#frontpage-slider.frontpage-slider-two").owlCarousel({
                    center: true,
                    items: 2,
                    autoplay: true,
                    autoplayTimeout: 3000,
                    smartSpeed: 800,
                    loop: true,
                    margin: 30,
                    singleItem: true,
                    dots: false,
                    nav: true,
                    navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
                    responsive: {280: {items: 1}, 576: {items: 2}, 768: {items: 2}}
                })
            }
            if (a("#frontpage-slider.frontpage-slider-three").length) {
                a("#frontpage-slider.frontpage-slider-three").owlCarousel({
                    center: true,
                    items: 1,
                    autoplay: false,
                    autoplayTimeout: 3000,
                    smartSpeed: 800,
                    loop: true,
                    margin: 0,
                    singleItem: true,
                    dots: false,
                    nav: true,
                    navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
                })
            }
        }, widget_posts_slider: function () {
            if (a("#post-widget-carousel").length) {
                a("#post-widget-carousel").owlCarousel({
                    center: true,
                    items: 1,
                    smartSpeed: 800,
                    autoplay: false,
                    autoplayTimeout: 3000,
                    loop: true,
                    margin: 0,
                    nav: true,
                    dots: false,
                    singleItem: true,
                    navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
                })
            }
        }, popular_posts_carousel: function () {
            if (a("#popular-posts-carousel").length) {
                a("#popular-posts-carousel").owlCarousel({
                    center: false,
                    items: 3,
                    smartSpeed: 800,
                    autoplay: false,
                    autoplayTimeout: 3000,
                    loop: true,
                    margin: 30,
                    nav: true,
                    dots: false,
                    singleItem: false,
                    navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
                    responsive: {
                        280: {items: 1},
                        450: {items: 1},
                        768: {items: 2},
                        992: {items: 3},
                        1300: {items: 3},
                        1400: {items: 3}
                    }
                })
            }
        }, trending_posts_carousel: function () {
            if (a("#trending-posts-carousel").length) {
                a("#trending-posts-carousel").owlCarousel({
                    center: false,
                    items: 3,
                    smartSpeed: 800,
                    autoplay: false,
                    autoplayTimeout: 3000,
                    loop: true,
                    margin: 1,
                    nav: false,
                    dots: true,
                    singleItem: false,
                    responsive: {
                        280: {items: 1},
                        450: {items: 1},
                        768: {items: 2},
                        992: {items: 3},
                        1300: {items: 3},
                        1400: {items: 3}
                    }
                })
            }
        }, featured_slider: function () {
            if (a("#featured-carousel").length) {
                a("#featured-carousel").owlCarousel({
                    center: false,
                    items: 4,
                    autoplay: true,
                    autoplayTimeout: 5000,
                    smartSpeed: 800,
                    margin: 0,
                    singleItem: false,
                    loop: true,
                    nav: false,
                    dots: false,
                    responsive: {
                        280: {items: 1},
                        680: {items: 2},
                        768: {items: 2},
                        1080: {items: 3},
                        1300: {items: 3},
                        1400: {items: 4}
                    }
                })
            }
            if (a("#featured-carousel-two").length) {
                a("#featured-carousel-two").owlCarousel({
                    center: false,
                    items: 5,
                    autoplay: false,
                    autoplayTimeout: 5000,
                    margin: 0,
                    singleItem: false,
                    loop: true,
                    nav: false,
                    dots: true,
                    responsive: {
                        280: {items: 1},
                        450: {items: 2},
                        768: {items: 2},
                        800: {items: 3},
                        1200: {items: 4},
                        1400: {items: 5}
                    }
                })
            }
        }, category_carousel: function () {
            if (a("#category-carousel").length) {
                a("#category-carousel").owlCarousel({
                    center: false,
                    items: 6,
                    autoplay: false,
                    autoplayTimeout: 5000,
                    margin: 30,
                    singleItem: false,
                    loop: true,
                    nav: false,
                    dots: false,
                    responsive: {
                        280: {items: 1},
                        450: {items: 2},
                        768: {items: 3},
                        800: {items: 4},
                        1000: {items: 5},
                        1200: {items: 6},
                        1400: {items: 6}
                    }
                })
            }
        }, single_post_slider: function () {
            if (a("#singlePost-slider").length) {
                a("#singlePost-slider").owlCarousel({
                    center: true,
                    items: 2,
                    autoplay: true,
                    autoplayTimeout: 3000,
                    smartSpeed: 800,
                    loop: true,
                    margin: 1,
                    singleItem: true,
                    dots: false,
                    nav: true,
                    navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
                    responsive: {280: {items: 1}, 576: {items: 2}, 768: {items: 2}}
                })
            }
        }, posts_load_more: function () {
            a(function () {
                var d = 8;
                var c = a(".site-main .load-post").length;
                a(".site-main .load-post").slice(0, d).show();
                if (d < c) {
                    if (d < c) {
                        a(".load-more-area .loadmore").addClass("active");
                        a(".loadmore").on("click", function (f) {
                            f.preventDefault();
                            a(".load-post:hidden").slice(0, 2).fadeIn(2000);
                            if (a(".load-post:hidden").length == 0) {
                                a(".loadmore").fadeOut(100);
                                a(".no-posts").show().fadeIn("slow")
                            }
                            a("html,body").animate({scrollTop: a(this).offset().top - 300}, 1200)
                        })
                    } else {
                        a(".load-more-area .no-posts").addClass("active")
                    }
                }
            })
        }, grid_masonry: function () {
            if (a("#masonry-posts").length > 0) {
                a("#masonry-posts").masonry({itemSelector: ".grid-item"})
            }
        }, search: function () {
            a(".search-btn").on("click", function () {
                if (a(this).siblings(".search-form").hasClass("active")) {
                    a(this).siblings(".search-form").removeClass("active").slideUp();
                    a(this).removeClass("active")
                } else {
                    a(this).siblings(".search-form").removeClass("active").slideUp();
                    a(this).siblings(".search-form").removeClass("active");
                    a(this).addClass("active");
                    a(this).siblings(".search-form").addClass("active").slideDown()
                }
            })
        }, initializ: function () {
            b.scroll_top();
            b.background_fit_image();
            b.sidebar_menu_and_search();
            b.mobile_menu();
            b.news_ticker();
            b.scroll_bar();
            b.sticky_sidebar();
            b.frontpage_slider();
            b.widget_posts_slider();
            b.popular_posts_carousel();
            b.trending_posts_carousel();
            b.featured_slider();
            b.category_carousel();
            b.single_post_slider();
            b.posts_load_more();
            b.grid_masonry();
            b.search()
        }
    };
    a(function () {
        b.initializ()
    })
})(jQuery);