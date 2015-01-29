package com.eephone.metrotile.tile;

import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;

/**
 * Tile创建指引
 * 
 * @author Eephoen Xu
 * 
 */
final class TileDirector {

	/**
	 * 创建TileItem
	 * 
	 * @param builder
	 *            TileItemBuilder
	 * @param params
	 *            Tile布局参数
	 * @param drawable
	 *            图片
	 * @param text
	 *            文字（注意：小方块是不显示文字的）S
	 * @param listener
	 *            点击监听事件（OnClickListener）
	 * @param callbackId
	 *            点击回调View的ID
	 */
	public static TileItem constructTileItem(TileItemBuilder builder,
			TileParams params, TileSize tileSize, int color, Drawable drawable,
			String text, OnClickListener listener, int callbackId) {
		builder.buildTileBackground(tileSize, color, params.getMarginSize());
		if (tileSize == TileSize.Middle) {
			builder.buildTileImage(drawable, params.getPaddingMiddleImageSize());
		} else if (tileSize == TileSize.Small) {
			builder.buildTileImage(drawable, params.getPaddingSmallImageSize());
		}
		builder.buildTileText(text, params.getPaddingTextSize(),
				params.getTextSize());
		builder.buildTileClickable(params.getSelectorDrawableId(), listener,
				callbackId);
		return builder.BuildItem();
	}

}
