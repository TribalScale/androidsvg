package com.caverock.androidsvg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import org.jetbrains.annotations.Nullable;


public class SVGMapImageView extends SVGImageView {

    private SVG svg;

    public SVGMapImageView(Context context) {
        super(context);
    }

    public SVGMapImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SVGMapImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SVG getSvg() {
        return svg;
    }

    private void setSvg(SVG svg) {
        this.svg = svg;
    }

    @Override
    public void setSVG(SVG svg) {
        if (svg == null) {
            throw new IllegalArgumentException("SVG can not be null");
        }

        setSvg(svg);

        Bitmap bitmap = Bitmap.createBitmap((int) Math.ceil(svg.getDocumentWidth()), (int) Math.ceil(svg.getDocumentHeight()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        svg.renderToCanvas(canvas);
        setImageBitmap(bitmap);
    }
}