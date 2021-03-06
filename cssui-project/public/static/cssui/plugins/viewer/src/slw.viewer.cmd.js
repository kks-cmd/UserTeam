/**
 * SlwViewer.Cmd v2.1 2016.7 by CSS WangWeidong
 */
SlwViewer.Cmd = function(main) {
	this.main = main;
	this.option = main.option;
	this.view = main.view;
	this.iePosition = false;
	this.wheeling = false;
};
/**
 * SlwViewer.Cmd方法
 */
SlwViewer.Cmd.prototype = {
	initEvent : function() {
		var that = this;
		var EVENT_WHEEL = 'wheel.slwViewer mousewheel.slwViewer DOMMouseScroll.slwViewer';
		var EVENT_CLICK = 'click.slwViewer';
		var EVENT_KEYDOWN = 'keydown.slwViewer';
		var EVENT_RESIZE = 'resize.slwViewer';
		$(window).on(EVENT_RESIZE, function(e) {
			that.view.initRender();
		});
		
		$(document).on(EVENT_KEYDOWN, function(e) {
			that.keydown(e)
		});
		that.view.container.on(EVENT_CLICK, function(e) {
			that.click(e)
		});
		that.view.container.on(EVENT_WHEEL, function(e) {
			that.wheel(e);
		});
	},
	click : function(e) {
		var view = this.view;
		var o = this.option;
		var image = view.getImage();
		var $target = $(e.target);
		var action = $target.attr('data-action');
		e.preventDefault();
		switch (action) {
			case 'mix':
				view.hide();
				break;
			case 'view':
				view.view($target.attr('data-index'));
				break;
			case 'zoom-in':
				this.zoom(o.zoomRatio);
				break;
			case 'zoom-out':
				this.zoom(-o.zoomRatio);
				break;
			case 'one-to-one':
				this.zoomToNatural();
				break;
			case 'reset':
				this.zoomToFit();
				break;
			case 'prev':
				this.prev();
				break;
			case 'next':
				this.next();
				break;
			case 'rotate-left':
				this.rotate(-90);
				break;
			case 'rotate-right':
				this.rotate(90);
				break;
			case 'flip-horizontal':
				this.scaleX(image, -image.scaleX || -1);
				break;
			case 'flip-vertical':
				this.scaleY(image, -image.scaleY || -1);
				break;
		}
	},
	keydown : function(e) {
		var view = this.view;
		if (!view.isShow) return;
		var o = this.option;
		var image = view.getImage();
		var which = e.which;
		switch (which) {
			case 27: // Esc
				view.hide();
				break;
			case 37: // ←
				if (e.ctrlKey || e.shiftKey)
					this.rotate(-90);
				else
					this.prev();
				break;
			case 39: // →
				if (e.ctrlKey || e.shiftKey)
					this.rotate(90);
				else
					this.next();
				break;
			case 38: // ↑
				if (e.ctrlKey || e.shiftKey)
					this.scaleY(image, -image.scaleY || -1);
				else
					this.zoom(o.zoomRatio);
				break;
			case 40: // ↓
				if (e.ctrlKey || e.shiftKey)
					this.scaleX(image, -image.scaleX || -1);
				else
					this.zoom(-o.zoomRatio);
				break;
			case 49: // Ctrl + 1
				if (e.ctrlKey || e.shiftKey) this.zoomToNatural();
				break;
		}
	},
	wheel : function(event) {
		var view = this.view;
		if (!view.isShow) return;
		var o = this.option;
		var image = view.getImage();
		var that = this;
		
		var e = event.originalEvent || event;
		var ratio = Number(o.zoomRatio) || 0.1;
		var delta = 1;
		event.preventDefault();
		if (that.wheeling) return;
		that.wheeling = true;
		setTimeout(function() {
			that.wheeling = false;
		}, 50);
		if (e.deltaY) {
			delta = e.deltaY > 0 ? 1 : -1;
		}
		else if (e.wheelDelta) {
			delta = -e.wheelDelta / 120;
		}
		else if (e.detail) {
			delta = e.detail > 0 ? 1 : -1;
		}
		that.zoom(-delta * ratio);
	},
	prev : function() {
		var view = this.view;
		view.view(Math.max(view.curIndex - 1, 0));
	},
	next : function() {
		var view = this.view;
		view.view(Math.min(view.curIndex + 1, view.getLength() - 1));
	},
	rotate : function(deg) {
		this.iePosition = !this.iePosition;
		if (deg == 0) this.iePosition = false;
		var image = this.view.getImage();
		image.rotate += deg;
		this.renderImage();
	},
	scale : function(image, scaleX, scaleY) {
		var changed = false;
		if (Slw.Utils.isUndefined(scaleY)) {
			scaleY = scaleX;
		}
		scaleX = Number(scaleX);
		scaleY = Number(scaleY);
		if (Slw.Utils.isNumber(scaleX)) {
			image.scaleX = scaleX;
			changed = true;
		}
		if (Slw.Utils.isNumber(scaleY)) {
			image.scaleY = scaleY;
			changed = true;
		}
		if (changed) this.renderImage();
	},
	scaleX : function(image, scaleX) {
		this.scale(image, scaleX, image.scaleY);
	},
	scaleY : function(image, scaleY) {
		this.scale(image, image.scaleX, scaleY);
	},
	zoomToFit : function() {
		var view = this.view;
		var image = view.getImage();
		image.rotate = 0;
		image.scaleX = 1;
		image.scaleY = 1;
		this.rotate(0);
		view.imageToFit();
	},
	zoom : function(ratio) {
		var image = this.view.getImage();
		ratio = Number(ratio);
		if (ratio < 0)
			ratio = 1 / (1 - ratio);
		else
			ratio = 1 + ratio;
		var width = image.width * ratio;
		var height = image.height * ratio
		this.zoomTo(width, height);
	},
	zoomTo : function(width, height) {
		var image = this.view.getImage();
		image.width = width;
		image.height = height;
		image.ratio = image.width / image.naturalWidth;
		this.renderImage();
		this.view.initTooltip(image);
	},
	zoomToNatural : function() {
		var view = this.view;
		var image = view.getImage();
		this.zoomTo(image.naturalWidth, image.naturalHeight);
	},
	getPosition : function() {
		var view = this.view;
		var image = view.getImage();
		var width = image.width;
		var height = image.height;
		if (this.iePosition && Slw.Utils.isIE() && Slw.Utils.ieVersion() < 9) {
			var width = image.height;
			var height = image.width;
		}
		var cw = view.canvas.width();
		var ch = view.canvas.height();
		if (Slw.Utils.ieVersion() == 6) {
			image.left = (cw - width) / 2 + view.container.position().left;
			image.top = (ch - height) / 2 + view.container.position().top;
		}
		else {
			image.left = (cw - width) / 2 + $(document).scrollLeft();
			image.top = (ch - height) / 2 + $(document).scrollTop();
		}
		return image;
	},
	renderImage : function() {
		var view = this.view;
		var that = this;
		var image = that.getPosition();
		var transform = that.getTransform(image);
		view.curImage.css({
			width : image.width,
			height : image.height,
			marginLeft : image.left,
			marginTop : image.top,
			transform : transform
		});
		if (Slw.Utils.isIE() && Slw.Utils.ieVersion() < 9) {
			var ie_filter = that.getIeFilter(image);
			view.curImage.css("filter", ie_filter);
			view.curImage.css("-ms-filter", ie_filter);
		}
	},
	getTransform : function(img) {
		var transforms = [];
		transforms.push('rotate(' + img.rotate + 'deg)');
		transforms.push('scale(' + img.scaleX + ',' + img.scaleY + ')');
		return transforms.length ? transforms.join(' ') : 'none';
	},
	getIeFilter : function(img) {
		var deg = img.rotate % 360;
		deg = deg >= 0 ? deg : 360 + deg;
		var deg2radians = Math.PI * 2 / 360;
		var rad = deg * deg2radians;
		var cos = Math.cos(rad);
		var sin = Math.sin(rad);
		return "filter: progid:DXImageTransform.Microsoft.Matrix(sizingMethod='auto expand',M11=" + (cos * img.scaleX) + ", M12=" + (-sin * img.scaleY) + ",M21=" + (sin * img.scaleX) + ", M22=" + (cos * img.scaleY) + ")";
	}
};