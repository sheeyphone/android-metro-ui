package com.eephone.metrotile.tile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;

/**
 * 默认创建者，使用者可以自行implements TileItemBuilder
 * 
 * @author Eephone Xu
 * 
 */
public final class TileBuilder implements TileItemBuilder {

	private TileItem tileItem;

	public TileBuilder(Context context) {
		tileItem = new TileItem(context);
	}

	@Override
	public void buildTileBackground(TileSize tileSize, int color, int marginSize) {
		tileItem.setTileBackground(tileSize, color, marginSize);
	}

	@Override
	public void buildTileImage(Drawable drawable, int paddingSize) {
		tileItem.setTileImage(drawable, paddingSize);
	}

	@Override
	public void buildTileText(String text, int paddingSize, int textSize) {
		tileItem.setTileText(text, paddingSize, textSize);
	}

	@Override
	public void buildTileClickable(int selectorDrawableId,
			OnClickListener listener, int callbackId) {
		tileItem.setTileClickable(selectorDrawableId, listener, callbackId);
	}

	@Override
	public TileItem BuildItem() {
		return tileItem;
	}

}
