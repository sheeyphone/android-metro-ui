package com.eephone.metrotile.tile;

import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;

public interface TileItemBuilder {

	void buildTileBackground(TileSize tileSize, int color, int marginSize);

	void buildTileImage(Drawable drawable, int paddingSize);

	void buildTileText(String text, int paddingSize, int textSize);

	void buildTileClickable(int selectorDrawableId,
			OnClickListener listener, int callbackId);

	TileItem BuildItem();

}
