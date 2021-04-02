/*=========================================*/
/* fix .live menthor in jquery 1.9 and above */
jQuery.fn.extend({
    live: function (event, callback) {
        if (this.selector) {
            jQuery(document).on(event, this.selector, callback);
        }
        return this;
    }
});
/*=========================================*/
function getQueryParams(qs) {
    qs = qs.split('+').join(' ');
    var params = {},
        tokens,
        re     = /[?&]?([^=]+)=([^&]*)/g;
    while (tokens = re.exec(qs)) {
        params[decodeURIComponent(tokens[1])] = decodeURIComponent(tokens[2]);
    }
    return params;
}
/*check empty content element*/
function isEmpty(el) {
    return !$.trim(el.html()).length;
}
function detectIsMobile() {
    return navigator && navigator.userAgent && navigator.userAgent.match(/(iPad|iPhone|iPod|Android)/g) ? true : false
}
/*Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position*/
function sticky_menu(menu, sticky) {
    if (typeof sticky === 'undefined' || !jQuery.isNumeric(sticky)) sticky = 0;
    if ($(window).scrollTop() >= sticky) {
        if ($('#just-for-height').length === 0) {
            menu.after('<div id="just-for-height" style="height:' + menu.height() + 'px"></div>')
        }
        menu.addClass("sticky");
    } else {
        menu.removeClass("sticky");
        $('#just-for-height').remove();
    }
}
/*change position of submenu to left*/
function submenu_left() {
    var ww = $(window).width();
    var ratio = 0.7;
    $('.main-menu li.item-level0 .level1').each(function () {
        var offsetLv1 = $(this).parent().offset().left;
        var offsetLv2 = offsetLv1 + $(this).width();
        if (offsetLv1 > (ww * ratio)) {
            $(this).css({
                'left' : 'auto',
                'right': '0'
            });
        }
        $(this).find('.level2').each(function () {
            if (offsetLv2 > (ww * ratio)) {
                $(this).css({
                    'left' : 'auto',
                    'right': '100%'
                });
            }
        });
    });
}
/*=========================================*/
/* check current page in menu header */
var curren_page = $('#bottom_header .main-menu a[href="' + window.location.href + '"]');
/*curren_page.parent().addClass('active');*/
/*curren_page.closest('#bottom_header .main-menu > li').addClass('active');*/
/**/
$(document).ready(function () {
    submenu_left();
    $(window).resize(function () {
        submenu_left();
    });
    /*Get the navbar*/
    /*var menu = $("#header #bottom_header .main-menu");
    if (menu.length) {
        var sticky = menu.offset().top + 1;
        if ($(window).width() > 767) {
            sticky_menu(menu, sticky);
            $(window).on('scroll', function () {
                sticky_menu(menu, sticky);
            });
        }
    }*/
    $('.pagination').each(function () {
        $(this).find('a').addClass('page-node');
        $(this).find('span').addClass('page-node current').parent().removeClass('active');
    });
});