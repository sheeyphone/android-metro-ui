package com.eephone.metrotile.tile;

import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;

/**
 * Tile����ָ��
 * 
 * @author Eephoen Xu
 * 
 */
final class TileDirector {

	/**
	 * ����TileItem
	 * 
	 * @param builder
	 *            TileItemBuilder
	 * @param params
	 *            Tile���ֲ���
	 * @param drawable
	 *            ͼƬ
	 * @param text
	 *            ���֣�ע�⣺С�����ǲ���ʾ���ֵģ�S
	 * @param listener
	 *            ��������¼���OnClickListener��
	 * @param callbackId
	 *            ����ص�View��ID
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
