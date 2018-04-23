package com.caverock.androidsvg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import org.jetbrains.annotations.Nullable;


public class SVGMapImageView extends ImageView {

    private SVG svg;

    public SVGMapImageView(Context context) {
        super(context);
    }

    public SVGMapImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SVGMapImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SVG getSvg() {
        return svg;
    }

    private void setSvg(SVG svg) {
        this.svg = svg;
    }

    public void setSvgResource(SVG svg) {
        if (svg == null) {
            return;
        }

        setSvg(svg);
        Bitmap newBM = Bitmap.createBitmap((int) Math.ceil(svg.getDocumentWidth()), (int) Math.ceil(svg.getDocumentHeight()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBM);
        // Clear background to white
        canvas.drawRGB(255, 255, 255);

        // Render our document onto our canvas
        svg.renderToCanvas(canvas);
        setImageBitmap(newBM);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }
}
