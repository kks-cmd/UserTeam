/*! Copyright (c) 2011 Piotr Rochala (http://rocha.la)
 * Dual licensed under the MIT (http://www.opensource.org/licenses/mit-license.php)
 * and GPL (http://www.opensource.org/licenses/gpl-license.php) licenses.
 *
 * Version: 1.3.8
 *
 */
(function($) {
	
	$.fn.extend({
		slimScroll : function(options) {
			
			var defaults = {
				
				// width in pixels of the visible scroll area
				width : 'auto',
				
				// height in pixels of the visible scroll area
				height : '250px',
				
				// width in pixels of the scrollbar and rail
				size : '7px',
				
				// scrollbar color, accepts any hex/color value
				color : '#000',
				
				// scrollbar position - left/right
				position : 'right',
				
				// distance in pixels between the side edge and the scrollbar
				distance : '1px',
				
				// default scroll position on load - top / bottom / $('selector')
				start : 'top',
				
				// sets scrollbar opacity
				opacity : .4,
				
				// enables always-on mode for the scrollbar
				alwaysVisible : false,
				
				// check if we should hide the scrollbar when user is hovering over
				disableFadeOut : false,
				
				// sets visibility of the rail
				railVisible : false,
				
				// sets rail color
				railColor : '#333',
				
				// sets rail opacity
				railOpacity : .2,
				
				// whether we should use jQuery UI Draggable to enable bar dragging
				railDraggable : true,
				
				// defautlt CSS class of the slimscroll rail
				railClass : 'slimScrollRail',
				
				// defautlt CSS class of the slimscroll bar
				barClass : 'slimScrollBar',

				// defautlt CSS class of the slimscroll rail
				railClass_w : 'slimScrollRail_w',
				
				// defautlt CSS class of the slimscroll bar
				barClass_w : 'slimScrollBar_w',
				
				// defautlt CSS class of the slimscroll wrapper
				wrapperClass : 'slimScrollDiv',
				
				// check if mousewheel should scroll the window if we reach
				// top/bottom
				allowPageScroll : false,
				
				// scroll amount applied to each mouse wheel step
				wheelStep : 20,
				
				// scroll amount applied when user is using gestures
				touchScrollStep : 200,
				
				// sets border radius
				borderRadius : '7px',
				
				// sets border radius of the rail
				railBorderRadius : '7px'
			};
			
			var o = $.extend(defaults, options);
			
			// do it for every element that matches selector
			this.each(function() {
				var isOverPanel, isOverBar, isDragg, queueHide, touchDif, barHeight, barWidth, percentScroll, percentScroll_w, lastScroll, divS = '<div></div>', minBarHeight = 30, minBarWidth = 30, releaseScroll = false;
				
				// used in event handlers and for better minification
				var me = $(this);
				
				// ensure we are not binding it again
				if (me.parent().hasClass(o.wrapperClass)) {
					// start from last bar position
					var offset = me.scrollTop();
					var offsetLeft = me.scrollLeft()
					// find bar and rail
					bar = me.siblings('.' + o.barClass);
					rail = me.siblings('.' + o.railClass);
					bar_w = me.siblings('.' + o.barClass_w);
					rail_w = me.siblings('.' + o.railClass_w);
					
					getBarHeight();
					getBarWidth() // 获取水平滚动条宽度
					
					// check if we should scroll existing instance
					if ($.isPlainObject(options)) {
						// Pass height: auto to an existing slimscroll object to force
						// a resize after contents have changed
						if ('height' in options && options.height == 'auto') {
							me.parent().css('height', 'auto');
							me.css('height', 'auto');
							var height = me.parent().parent().height();
							me.parent().css('height', height);
							me.css('height', height);
						} else if ('height' in options) {
							var h = options.height;
							me.parent().css('height', h);
							me.css('height', h);
						}
						
						if ('width' in options && options.width == 'auto') {
							me.parent().css('width', 'auto');
							me.css('width', 'auto');
							var width = me.parent().parent().width();
							me.parent().css('width', width);
							me.css('width', width);
						} else if ('width' in options) {
							var w = options.width;
							me.parent().css('width', w);
							me.css('width', w);
						}

						if ('scrollTo' in options) {
							// jump to a static point
							if(typeof o.scrollTo !== 'number') {
								offset = $(o.scrollTo).position().top;
							} else {
								offset = o.scrollTo;
							}
						} else if ('scrollBy' in options) {
							// jump by value pixels
							offset += parseInt(o.scrollBy);
						} else if ('destroy' in options) {
							// remove slimscroll elements
							bar.remove();
							rail.remove();
							bar_w.remove();
							rail_w.remove();
							me.unwrap();
							return;
						}
						
						// scroll content by the given offset
						scrollContent(offset, false, true);
						scrollContent_w(offsetLeft, false, true);
					}
					
					return;
				} else if ($.isPlainObject(options)) {
					if ('destroy' in options) {
						return;
					}
				}
				
				// optionally set height to the parent's height
				o.height = (o.height == 'auto') ? me.parent().height() : o.height;
				o.width = (o.width == 'auto') ? 'auto' : o.width;
				
				// wrap content
				var wrapper = $(divS).addClass(o.wrapperClass).css({
					position : 'relative',
					overflow : 'hidden',
					width : o.width,
					height : o.height
				});
				
				// update style for the div
				me.css({
					overflow : 'hidden',
					width : o.width,
					height : o.height
				});
				
				// create scrollbar rail
				var rail = $(divS).addClass(o.railClass).css({
					width : o.size,
					height : '100%',
					position : 'absolute',
					top : 0,
					display : (o.alwaysVisible && o.railVisible) ? 'block' : 'none',
					'border-radius' : o.railBorderRadius,
					background : o.railColor,
					opacity : o.railOpacity,
					zIndex : 90
				});
				// create scrollbar
				var bar = $(divS).addClass(o.barClass).css({
					background : o.color,
					width : o.size,
					position : 'absolute',
					top : 0,
					opacity : o.opacity,
					display : o.alwaysVisible ? 'block' : 'none',
					'border-radius' : o.borderRadius,
					BorderRadius : o.borderRadius,
					MozBorderRadius : o.borderRadius,
					WebkitBorderRadius : o.borderRadius,
					zIndex : 99
				});

				var rail_w = $(divS).addClass(o.railClass_w).css({
					width : '100%',
					height : o.size,
					position : 'absolute',
					// top : 0,
					bottom: 0,
					left: 0,
					display : (o.alwaysVisible && o.railVisible) ? 'block' : 'none',
					'border-radius' : o.railBorderRadius,
					background : o.railColor,
					opacity : o.railOpacity,
					zIndex : 90
				});
				// create scrollbar
				var bar_w = $(divS).addClass(o.barClass_w).css({
					background : o.color,
					height : o.size,
					position : 'absolute',
					// top : 0,
					bottom: 0,
					left: 0,
					opacity : o.opacity,
					display : o.alwaysVisible ? 'block' : 'none',
					'border-radius' : o.borderRadius,
					BorderRadius : o.borderRadius,
					MozBorderRadius : o.borderRadius,
					WebkitBorderRadius : o.borderRadius,
					zIndex : 99
				});
				
				// set position
				var posCss = (o.position == 'right') ? {
					right : o.distance
				} : {
					left : o.distance
				};
				rail.css(posCss);
				bar.css(posCss);

				
				
				// wrap it
				me.wrap(wrapper);
				
				// append to parent div
				me.parent().append(bar);
				me.parent().append(rail);
				me.parent().append(bar_w);
				me.parent().append(rail_w);
				
				// make it draggable and no longer dependent on the jqueryUI
				if (o.railDraggable) {
					bar.bind("mousedown", function(e) {
						var $doc = $(document);
						isDragg = true;
						t = parseFloat(bar.css('top'));
						pageY = e.pageY;
						
						$doc.bind("mousemove.slimscroll", function(e) {
							currTop = t + e.pageY - pageY;
							bar.css('top', currTop);
							scrollContent(0, bar.position().top, false);// scroll
																						// content
						});
						
						$doc.bind("mouseup.slimscroll", function(e) {
							isDragg = false;
							hideBar();
							$doc.unbind('.slimscroll');
						});
						return false;
					}).bind("selectstart.slimscroll", function(e) {
						e.stopPropagation();
						e.preventDefault();
						return false;
					});

					bar_w.bind("mousedown", function(e) {
						var $doc = $(document);
						isDragg = true;
						l = parseFloat(bar_w.css('left'));
						pageX = e.pageX;
						
						$doc.bind("mousemove.slimscroll", function(e) {
							currLeft = l + e.pageX - pageX;
							bar_w.css('left', currLeft);
							scrollContent_w(0, bar_w.position().left, false);// scroll
																						// content
						});
						
						$doc.bind("mouseup.slimscroll", function(e) {
							isDragg = false;
							hideBar();
							$doc.unbind('.slimscroll');
						});
						return false;
					}).bind("selectstart.slimscroll", function(e) {
						e.stopPropagation();
						e.preventDefault();
						return false;
					});
				}
				
				// on rail over
				rail.hover(function() {
					showBar();
				}, function() {
					hideBar();
				});
				
				// on bar over
				bar.hover(function() {
					isOverBar = true;
				}, function() {
					isOverBar = false;
				});

				rail_w.hover(function() {
					showBar();
				}, function() {
					hideBar();
				});
				
				// on bar over
				bar_w.hover(function() {
					isOverBar = true;
				}, function() {
					isOverBar = false;
				});
				
				// show on parent mouseover
				me.hover(function() {
					isOverPanel = true;
					showBar();
					hideBar();
				}, function() {
					isOverPanel = false;
					hideBar();
				});
				
				// support for mobile
				me.bind('touchstart', function(e, b) {
					if (e.originalEvent.touches.length) {
						// record where touch started
						touchDif = e.originalEvent.touches[0].pageY;
					}
				});
				
				me.bind('touchmove', function(e) {
					// prevent scrolling the page if necessary
					if (!releaseScroll) {
						e.originalEvent.preventDefault();
					}
					if (e.originalEvent.touches.length) {
						// see how far user swiped
						var diff = (touchDif - e.originalEvent.touches[0].pageY) / o.touchScrollStep;
						// scroll content
						scrollContent(diff, true);
						touchDif = e.originalEvent.touches[0].pageY;
					}
				});
				
				// set up initial height
				getBarHeight();
				getBarWidth();
				
				// check start position
				if (o.start === 'bottom') {
					// scroll content to bottom
					bar.css({
						top : me.outerHeight() - bar.outerHeight()
					});
					scrollContent(0, true);
				} else if (typeof o.start === 'number') {
					scrollContent(o.start, null, true);
				} else if (o.start !== 'top') {
					// assume jQuery selector
					scrollContent($(o.start).position().top, null, true);
					
					// make sure bar stays hidden
					if (!o.alwaysVisible) {
						bar.hide();
					}
				}
				
				// attach scroll events
				attachWheel(this);
				
				function _onWheel(e) {
					// use mouse wheel only when mouse is over
					if (!isOverPanel) {
						return;
					}
					
					var e = e || window.event;
					
					var delta = 0;
					if (e.wheelDelta) {
						delta = -e.wheelDelta / 120;
					}
					if (e.detail) {
						delta = e.detail / 3;
					}
					
					var target = e.target || e.srcTarget || e.srcElement;
					if ($(target).closest('.' + o.wrapperClass).is(me.parent())) {
						// scroll content
						scrollContent(delta, true);
					}
					
					// stop window scroll
					if (e.preventDefault && !releaseScroll) {
						e.preventDefault();
					}
					if (!releaseScroll) {
						e.returnValue = false;
					}
				}
				
				function scrollContent(y, isWheel, isJump) {
					releaseScroll = false;
					var delta = y;
					var maxTop = me.outerHeight() - bar.outerHeight();
					
					if (isWheel) {
						// move bar with mouse wheel
						delta = parseInt(bar.css('top')) + y * parseInt(o.wheelStep) / 100 * bar.outerHeight();
						
						// move bar, make sure it doesn't go out
						delta = Math.min(Math.max(delta, 0), maxTop);
						
						// if scrolling down, make sure a fractional change to the
						// scroll position isn't rounded away when the scrollbar's CSS
						// is set
						// this flooring of delta would happened automatically when
						// bar.css is set below, but we floor here for clarity
						delta = (y > 0) ? Math.ceil(delta) : Math.floor(delta);
						
						// scroll the scrollbar
						bar.css({
							top : delta + 'px'
						});
					}
					
					// calculate actual scroll amount
					percentScroll = parseInt(bar.css('top')) / (me.outerHeight() - bar.outerHeight());
					delta = percentScroll * (me[0].scrollHeight - me.outerHeight());
					
					if (isJump) {
						delta = y;
						var offsetTop = delta / me[0].scrollHeight * me.outerHeight();
						offsetTop = Math.min(Math.max(offsetTop, 0), maxTop);
						bar.css({
							top : offsetTop + 'px'
						});
					}
					
					// scroll content
					me.scrollTop(delta);
					
					// fire scrolling event
					me.trigger('slimscrolling', ~~delta);
					
					// ensure bar is visible
					showBar();
					
					// trigger hide when scroll is stopped
					hideBar();
				}

				function scrollContent_w(x, isWheel, isJump) {
					releaseScroll = false;
					var delta = x;
					var maxLeft = me.outerWidth() - bar_w.outerWidth();
					
					if (isWheel) {
						// move bar with mouse wheel
						delta = parseInt(bar_w.css('left')) + x * parseInt(o.wheelStep) / 100 * bar_w.outerWidth();
						
						// move bar, make sure it doesn't go out
						delta = Math.min(Math.max(delta, 0), maxLeft);
						
						// if scrolling down, make sure a fractional change to the
						// scroll position isn't rounded away when the scrollbar's CSS
						// is set
						// this flooring of delta would happened automatically when
						// bar.css is set below, but we floor here for clarity
						delta = (x > 0) ? Math.ceil(delta) : Math.floor(delta);
						
						// scroll the scrollbar
						bar_w.css({
							left : delta + 'px'
						});
					}
					
					// calculate actual scroll amount
					percentScroll_w = parseInt(bar_w.css('left')) / (me.outerWidth() - bar_w.outerWidth());
					percentScroll_w = percentScroll_w ? percentScroll_w : 0
					delta = percentScroll_w * (me[0].scrollWidth - me.outerWidth());
					
					if (isJump) {
						delta = x;
						var offsetLeft = delta / me[0].scrollWidth * me.outerWidth();
						offsetLeft = Math.min(Math.max(offsetLeft, 0), maxLeft);
						bar_w.css({
							left : offsetLeft + 'px'
						});
					}
					
					// scroll content
					me.scrollLeft(delta);
					
					// fire scrolling event
					me.trigger('slimscrolling', ~~delta);
					
					// ensure bar is visible
					showBar();
					
					// trigger hide when scroll is stopped
					hideBar();
				}
				
				function attachWheel(target) {
					if (window.addEventListener) {
						target.addEventListener('DOMMouseScroll', _onWheel, false);
						target.addEventListener('mousewheel', _onWheel, false);
					} else {
						document.attachEvent("onmousewheel", _onWheel)
					}
				}
				
				function getBarHeight() {
					// calculate scrollbar height and make sure it is not too small
					barHeight = Math.max((me.outerHeight() / me[0].scrollHeight) * me.outerHeight(), minBarHeight);
					bar.css({
						height : barHeight + 'px'
					});
					
					// hide scrollbar if content is not long enough
					var display = barHeight == me.outerHeight() ? 'none' : 'block';
					bar.css({
						display : display
					});
				}
				
				function getBarWidth() {
					// calculate scrollbar width and make sure it is not too small
					barWidth = Math.max((me.outerWidth() / Math.max(me[0].scrollWidth, me[0].offsetWidth)) * me.outerWidth(), minBarWidth);
					bar_w.css({
						width : barWidth + 'px'
					});
					
					// hide scrollbar if content is not long enough
					var display = barWidth == me.outerWidth() ? 'none' : 'block';
					bar_w.css({
						display : display
					});
				}

				function showBar() {
					// recalculate bar height
					getBarHeight();
					getBarWidth();
					clearTimeout(queueHide);
					
					// when bar reached top or bottom
					if (percentScroll == ~~percentScroll) {
						// release wheel
						releaseScroll = o.allowPageScroll;
						
						// publish approporiate event
						if (lastScroll != percentScroll) {
							var msg = (~~percentScroll == 0) ? 'top' : 'bottom';
							me.trigger('slimscroll', msg);
						}
					} else {
						releaseScroll = false;
					}
					lastScroll = percentScroll;
					
					// show only when required
					if (barHeight >= me.outerHeight() || barWidth >= me.outerWidth()) {
						// allow window scroll
						releaseScroll = true;
						return;
					}
					bar.stop(true, true).fadeIn('fast');
					bar_w.stop(true, true).fadeIn('fast');
					if (o.railVisible) {
						rail.stop(true, true).fadeIn('fast');
						rail_w.stop(true, true).fadeIn('fast');
					}
				}
				
				function hideBar() {
					// only hide when options allow it
					if (!o.alwaysVisible) {
						queueHide = setTimeout(function() {
							if (!(o.disableFadeOut && isOverPanel) && !isOverBar && !isDragg) {
								bar.fadeOut('slow');
								rail.fadeOut('slow');
								bar_w.fadeOut('slow');
								rail_w.fadeOut('slow');
							}
						}, 1000);
					}
				}
				
			});
			
			// maintain chainability
			return this;
		}
	});
	
	$.fn.extend({
		slimscroll : $.fn.slimScroll
	});
	
})(jQuery);
