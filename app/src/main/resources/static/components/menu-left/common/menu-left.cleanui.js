/////////////////////////////////////////////////////////////////////////////////////////
// "menu-right" module scripts

(function($) {
  "use strict";
  $(function () {

    /////////////////////////////////////////////////////////////////////////////////////////
    // add backdrop

    $('.menu-left').after('<div class="menu-left__backdrop menu-left__action--backdrop-toggle"><!-- --></div>')

    /////////////////////////////////////////////////////////////////////////////////////////
    // submenu

    $('.menu-left__submenu > a').on('click', function () {

      if ($('body').hasClass('config--vertical') || $('body').width() < 768) {

        var parent = $(this).parent(),
          opened = $('.menu-left__submenu--toggled')

        if (!parent.hasClass('menu-left__submenu--toggled') && !parent.parent().closest('.menu-left__submenu').length)
          opened.removeClass('menu-left__submenu--toggled').find('> .menu-left__list').slideUp(200)

        parent.toggleClass('menu-left__submenu--toggled')
        parent.find('> .menu-left__list').slideToggle(200)

      }

    })

    // remove submenu toggle class when viewport back to full view
    $(window).on('resize', function () {
      if ($('body').hasClass('config--horizontal') || $('body').width() > 768) {
        $('.menu-left__submenu--toggled').removeClass('menu-left__submenu--toggled').find('> .menu-left__list').attr('style', '')
      }
    })

    /////////////////////////////////////////////////////////////////////////////////////////
    // custom scroll init

    if ($('body').hasClass('config--vertical')) {
      if (!(/Mobi/.test(navigator.userAgent)) && jQuery().perfectScrollbar) {
        $('.menu-left__inner').perfectScrollbar({
          theme: 'cleanui'
        })
      }
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    // toggle menu

    $('.menu-left__action--menu-toggle').on('click', function () {
      if ($('body').width() < 768) {
        $('body').toggleClass('menu-left--visible--mobile')
      } else {
        $('body').toggleClass('menu-left--visible')
      }
    })

    $('.menu-left__action--backdrop-toggle').on('click', function () {
      $('body').removeClass('menu-left--visible--mobile')
    })

    /////////////////////////////////////////////////////////////////////////////////////////
    // colorful menu

    var colorfulClasses = 'menu-left--colorful--primary menu-left--colorful--secondary menu-left--colorful--primary menu-left--colorful--default menu-left--colorful--info menu-left--colorful--success menu-left--colorful--warning menu-left--colorful--danger menu-left--colorful--yellow',
      colorfulClassesArray = colorfulClasses.split(' ')

    function setColorfulClasses() {
      $('.menu-left__list--root > .menu-left__item').each(function () {
        var randomClass = colorfulClassesArray[Math.floor(Math.random() * colorfulClassesArray.length)]
        $(this).addClass(randomClass)
      })
    }

    function removeColorfulClasses() {
      $('.menu-left__list--root > .menu-left__item').removeClass(colorfulClasses)
    }

    if ($('body').hasClass('menu-left--colorful')) {
      setColorfulClasses()
    }

    $('body').on('setColorfulClasses', function () {
      setColorfulClasses()
    })

    $('body').on('removeColorfulClasses', function () {
      removeColorfulClasses()
    })

  })
})(jQuery)