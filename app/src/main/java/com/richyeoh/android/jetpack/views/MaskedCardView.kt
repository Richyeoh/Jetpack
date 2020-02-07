package com.richyeoh.android.jetpack.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.shape.ShapeAppearancePathProvider
import com.richyeoh.android.jetpack.R

class MaskedCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.materialCardViewStyle
) : MaterialCardView(context, attrs, defStyleAttr) {
    private val pathProvider = ShapeAppearancePathProvider()
    private val path = Path()
    private val rectF = RectF()
    private val shapeAppearance = ShapeAppearanceModel.builder(
        context,
        attrs,
        defStyleAttr,
        R.style.Widget_MaterialComponents_CardView
    ).build()

    override fun onDraw(canvas: Canvas) {
        canvas.clipPath(path)
        super.onDraw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        rectF.right = w.toFloat()
        rectF.bottom = h.toFloat()
        pathProvider.calculatePath(shapeAppearance, 1F, rectF, path)
        super.onSizeChanged(w, h, oldw, oldh)
    }
}
