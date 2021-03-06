/*
 * jqcropper v1.0 2017.6 by CSS WangWeidong
 */
!function(t) {
    function i(t) {
        return null == t || "" == t || "undefined" == t
    }
    function e(t) {
        return "number" == typeof t && !isNaN(t)
    }
    t.fn.jqcropper = function(n) {
        var h, a, o, r, s, p = {
            aspectRatio: 1.8,
            preview: null,
            fileInput: !0,
            pos: null,
            autoFit: .8,
            userListener: null
        }, n = t.extend(p, n), d = !1, c = !1, g = !0, u = t(document), w = t(this), f = w.attr("src"), l = w.parent(), v = l.parent(), y = t('<div class="cropper-container"></div>'), x = t('<div class="cropper-dragger"></div>'), m = document.createElement("img"), R = {}, b = {}, E = {}, I = {}, P = {}, j = {}, C = n.preview, D = "", F = null, L = {
            getNaturalPos: function() {
                return E
            },
            getPreviewPos: function() {
                return I.width = w.width(),
                    I.height = w.height(),
                    I.x = 0,
                    I.y = 0,
                    I
            },
            getCropPos: function() {
                return N(),
                    P
            },
            setCropPos: function(t) {
                P = t,
                    X(),
                    T()
            },
            getCropPosData: function() {
                return N(),
                    q(),
                    h.width = P.width,
                    h.height = P.height,
                    a.drawImage(w[0], P.x, P.y, P.width, P.height, 0, 0, P.width, P.height),
                    h.toDataURL("image/png")
            },
            setUrl: function(t) {
                i(t) || (f = t,
                    w.attr("src", f),
                    w.show(),
                    _(ot))
            },
            getFile: function() {
                return F
            },
            getPos: function() {
                return b
            },
            setPos: function(t) {
                b = t,
                    N(),
                    T()
            }
        }, M = function() {
            i(f) && (w = t('<img style="display:none;" />'));
            var e = '<canvas id="cropCanvas" style="display:none;" /><span class="cropper-viewer"><img /></span>';
            if (e += '<span class="cropper-dashed dashed-h"></span>',
                e += '<span class="cropper-dashed dashed-v"></span>',
                e += '<span class="cropper-face" data-dir="all"></span>',
                e += '<span class="cropper-line line-e" data-dir="e"></span>',
                e += '<span class="cropper-line line-n" data-dir="n"></span>',
                e += '<span class="cropper-line line-w" data-dir="w"></span>',
                e += '<span class="cropper-line line-s" data-dir="s"></span>',
                e += '<span class="cropper-point point-e" data-dir="e"></span>',
                e += '<span class="cropper-point point-n" data-dir="n"></span>',
                e += '<span class="cropper-point point-w" data-dir="w"></span>',
                e += '<span class="cropper-point point-s" data-dir="s"></span>',
                e += '<span class="cropper-point point-ne" data-dir="ne"></span>',
                e += '<span class="cropper-point point-nw" data-dir="nw"></span>',
                e += '<span class="cropper-point point-sw" data-dir="sw"></span>',
                e += '<span class="cropper-point point-se" data-dir="se"></span>',
                U()) {
                var n = "";
                n += '<div class="crop-upload">',
                    n += '	<button type="button" class="btn btn-primary crop-file">',
                    n += '		<i class="fa fa-folder-open-o"> 请选择图片</i>',
                    n += "	</button>",
                    n += '	<input type="file" class="crop-input" accept="image/jpg,image/jpeg,image/png,image/gif" name="crop_file" style="display: none">',
                    n += "</div>",
                    l.before(n),
                    r = v.find(".crop-input"),
                    s = v.find(".crop-file")
            }
            l.empty().append(y),
                x.append(e),
                y.append(w).append('<div class="cropper-canvas cropper-modal cropper-crop"></div>').append(x);
            try {
                h = x.find("#cropCanvas")[0],
                    a = h.getContext("2d")
            } catch (p) {}
            o = x.find(".cropper-line, .cropper-point")
        }, U = function() {
            return n.fileInput;
        }, q = function() {
            a.clearRect(0, 0, h.width, h.height)
        }, N = function() {
            var t = E.width / I.width;
            E.height > E.width && (t = E.height / I.height),
                P = Y(t, b)
        }, X = function() {
            var t = I.width / E.width;
            E.height > E.width && (t = I.height / E.height),
                b = Y(t, P)
        }, Y = function(t, i) {
            return {
                x: Math.round(t * i.x),
                y: Math.round(t * i.y),
                width: Math.round(t * i.width),
                height: Math.round(t * i.height)
            }
        }, k = function(t) {
            var i = t.originalEvent ? t.originalEvent.pageX : t.pageX
                , e = t.originalEvent ? t.originalEvent.pageY : t.pageY;
            return (i = t.pageX,
                e = t.pageY),
                {
                    x: i,
                    y: e
                }
        }, O = function(t) {
            return e(t) ? t + "px" : t
        }, Q = function() {
            x.css({
                left: O(b.x),
                top: O(b.y),
                width: O(b.width),
                height: O(b.height)
            }),
                x.find("img").css({
                    "margin-left": "-" + O(b.x),
                    "margin-top": "-" + O(b.y)
                }),
                it(),
            i(n.userListener) || (N(),
                n.userListener(P))
        }, _ = function(t) {
            i(f) ? t() : (m.onerror = function() {
                t()
            }
                ,
                m.onload = function() {
                    t()
                }
                ,
                m.src = f)
        }, z = function(t, i) {
            t.css("height", b.height * t.width() / b.width);
            var e = t.width()
                , n = t.height()
                , h = e / b.width;
            b.height > b.width && (h = n / b.height);
            var a = Y(h, b);
            i.css({
                width: O(Math.round(h * I.width)),
                height: O(Math.round(h * I.height)),
                "margin-left": "-" + O(a.x),
                "margin-top": "-" + O(a.y)
            })
        }, A = function(t, e) {
            var h = t.x - R.x
                , a = b.x + h;
            if (b.width = b.width + h * (e ? 1 : -1),
            e || (b.x = a),
            b.width < 0 && (b.width = -b.width,
                b.x -= b.width,
                J(1)),
            !i(n.aspectRatio) && 1 == D.length) {
                var o = b.width / n.aspectRatio;
                b.y -= (o - b.height) / 2,
                    b.height = o,
                    b.y + b.height > y.height() ? (b.y = y.height() - b.height,
                    b.y < 0 && (b.y = 0,
                        b.height = y.height(),
                        b.width = b.height * n.aspectRatio)) : b.y < 0 ? b.y = 0 : b.x < 0 && (b.x = 0)
            }
        }, B = function(t, e) {
            var h = t.y - R.y
                , a = b.y + h;
            if (b.height = b.height + h * (e ? 1 : -1),
            e || (b.y = a),
            b.height < 0 && (b.height = -b.height,
                b.y -= b.height,
                J(0)),
            !i(n.aspectRatio) && 1 == D.length) {
                var o = b.height * n.aspectRatio;
                b.x -= (o - b.width) / 2,
                    b.width = o,
                    b.x + b.width > y.width() ? (b.x = y.width() - b.width,
                    b.x < 0 && (b.x = 0,
                        b.width = y.width(),
                        b.height = b.width / n.aspectRatio)) : b.x < 0 ? b.x = 0 : b.y < 0 && (b.y = 0)
            }
        }, G = function() {
            var t, h;
            (!e(b.x) || b.x < 0) && (b.x = 0),
            (!e(b.y) || b.y < 0) && (b.y = 0),
            i(n.aspectRatio) || 2 == D.length && ("ne" == D ? (h = b.height * n.aspectRatio,
                h + b.x > y.width() ? (b.width = y.width() - b.x,
                    t = b.width / n.aspectRatio,
                    b.y += b.height - t,
                    b.height = t) : b.width = h) : "nw" == D ? b.x < 0 ? (b.width += b.x,
                t = b.x / n.aspectRatio,
                b.x = 0,
                b.y -= h) : (t = b.width / n.aspectRatio,
                b.y += b.height - t,
                b.height = t) : "se" == D ? b.height + b.y > y.height() ? (b.height = y.height() - b.y,
                b.width = b.height * n.aspectRatio) : b.height = b.width / n.aspectRatio : "sw" == D && (b.height + b.y > y.height() ? (b.height = y.height() - b.y,
                h = b.height * n.aspectRatio,
                b.x += b.width - h,
                b.width = h) : b.height = b.width / n.aspectRatio))
        }, H = function(t) {
            if (c)
                K(t);
            else {
                if (!d)
                    return;
                S(t)
            }
            Q(),
                R = t
        }, J = function(t) {
            if (1 == D.length)
                D = j[D][0];
            else {
                var i = [];
                i[0] = D.substring(0, 1),
                    i[1] = D.substring(1, 2),
                    i[t] = j[i[t]][0],
                    D = i[0] + i[1]
            }
        }, K = function(t) {
            for (var i = [], e = 0; e < D.length; e++)
                i[e] = D.substring(e, e + 1),
                    j[i[e]][1](t, j[i[e]][2]);
            G()
        }, S = function(t) {
            var i = b.x + (t.x - R.x)
                , e = b.y + (t.y - R.y);
            0 > i ? b.x = 0 : i + b.width > y.width() ? b.x = y.width() - b.width : b.x = i,
                0 > e ? b.y = 0 : e + b.height > y.height() ? b.y = y.height() - b.height : b.y = e
        }, T = function() {
            return b.x >= 0 && b.y >= 0 && b.width > 0 && b.height > 0 && b.x + b.width <= y.width() && b.y + b.height <= y.height() ? void Q() : void et()
        }, V = function() {
            y.on("mousemove touchmove", function(t) {
                t.preventDefault(),
                    H(k(t))
            }),
                u.on("mouseup.jqcropper", function(t) {
                    t.preventDefault(),
                        d = !1,
                        c = !1,
                        W()
                })
        }, W = function() {
            u.unbind("mouseup.jqcropper"),
                y.unbind()
        }, Z = function() {
            u.unbind("mouseup.jqcropper"),
                y.unbind(),
                x.unbind(),
                o.unbind(),
            U() && (r.unbind(),
                s.unbind())
        }, $ = function() {
            Z(),
            U() && (r.on("change", function(i) {
                var e = i.target.files;
                if (e.length > 0) {
                    F = e[0];
                    var n = URL.createObjectURL(F);
                    L.setUrl(n)
                }
                t(this).val("")
            }),
                s.click(function() {
                    r.click()
                })),
                o.on("mousedown touchstart", function(i) {
                    i.preventDefault(),
                        c = !0,
                        V(),
                        R = k(i),
                        D = t(this).attr("data-dir")
                }),
                x.on("mousedown touchstart", function(t) {
                    t.preventDefault(),
                        d = !0,
                        V(),
                        R = k(t)
                })
        }, tt = function() {
            C.each(function() {
                var e = i(f) ? "" : '" src="' + f + '"'
                    , n = t("<img " + e + ' style="min-width: 0px !important; min-height: 0px !important; max-width: none !important; max-height: none !important;">');
                t(this).html(""),
                    t(this).append(n),
                    z(t(this), n)
            })
        }, it = function() {
            C.each(function() {
                var i = t(this).find("img");
                z(t(this), i)
            })
        }, et = function() {
            var t = y.width()
                , e = y.height()
                , h = n.aspectRatio;
            i(h) && (h = t / e),
                h > 1 ? (b.width = t * n.autoFit,
                    b.height = b.width / h,
                b.height > e && (b.height = e * n.autoFit,
                    b.width = b.height * h)) : (b.height = e * n.autoFit,
                    b.width = b.height * h,
                b.width > t && (b.width = t * n.autoFit,
                    b.height = b.width / h)),
                b.x = (t - b.width) / 2,
                b.y = (e - b.height) / 2,
                Q()
        }, nt = function() {
            L.getPreviewPos(),
                g && !i(n.pos) ? (g = !1,
                    L.setCropPos(n.pos)) : et()
        }, ht = function() {
            var t = l.width()
                , i = l.height()
                , e = t
                , n = t * E.height / E.width;
            n > i ? (n = i,
                e = i * E.width / E.height,
                y.css({
                    width: O(e),
                    height: O(n),
                    left: O((t - e) / 2),
                    top: O(0)
                })) : y.css({
                width: O(e),
                height: O(n),
                left: O(0),
                top: O((i - n) / 2)
            }),
                w.css({
                    width: O(e),
                    height: O(n)
                }),
                x.find(".cropper-viewer img").css({
                    width: O(e),
                    height: O(n)
                })
        }, at = function() {
            x.find(".cropper-viewer img").attr("src", f),
                E.x = 0,
                E.y = 0,
                E.width = m.width,
                E.height = m.height
        }, ot = function() {
            at(),
                ht(),
                nt(),
                tt(),
                $()
        }, rt = function() {
            M(),
                j.e = ["w", A, !0],
                j.w = ["e", A, !1],
                j.s = ["n", B, !0],
                j.n = ["s", B, !1],
                _(ot)
        };
        return rt(),
            L
    }
}(jQuery);
