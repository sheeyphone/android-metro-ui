package com.eephone.metrotile.tile;

import com.eephone.metrotile.tile.TileManager.TileParamsCreator;

/**
 * Tile布局参数
 * 
 * @author Eephoen Xu
 * 
 */
public final class TileParams implements TileParamsCreator {

	// Version 1.0
	private int marginSize;
	private int paddingImageSize;
	private int paddingTextSize;
	private int textSize;
	private int selectorDrawableId;

	// Version 1.1
	private int paddingSmallImageSize;

	protected TileParams() {

	}

	public int getPaddingSmallImageSize() {
		return paddingSmallImageSize;
	}

	public int getMarginSize() {
		return marginSize;
	}

	public int getPaddingMiddleImageSize() {
		return paddingImageSize;
	}

	public int getPaddingTextSize() {
		return paddingTextSize;
	}

	public int getTextSize() {
		return textSize;
	}

	public int getSelectorDrawableId() {
		return selectorDrawableId;
	}

	@Override
	public TileParams create() {
		return this;
	}

	@Override
	public TileParamsCreator setTileMarginSize(int size) {
		this.marginSize = size;
		return this;
	}

	@Override
	public TileParamsCreator setTileMiddleImagePaddingSize(int size) {
		this.paddingImageSize = size;
		return this;
	}

	@Override
	public TileParamsCreator setTileMiddleTextPaddingSize(int size) {
		this.paddingTextSize = size;
		return this;
	}

	@Override
	public TileParamsCreator setTileMiddleTextSize(int size) {
		this.textSize = size;
		return this;
	}

	@Override
	public TileParamsCreator setTileSmallImagePaddingSize(int size) {
		this.paddingSmallImageSize = size;
		return this;
	}

	@Override
	public TileParamsCreator setTileDrawableId(int id) {
		this.selectorDrawableId = id;
		return this;
	}
}
