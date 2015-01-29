package com.eephone.metrotile.tile;

import com.eephone.metrotile.tile.TileManager.TileContentHolderCreator;

import android.graphics.drawable.Drawable;

public final class TileContentHolder implements TileContentHolderCreator {

	private int id;
	private int color;
	private Drawable drawable;
	private String string;
	private TileSize weight;

	protected TileContentHolder() {
		drawable = null;
		string = "";
		weight = TileSize.Middle;
	}

	public int getId() {
		return id;
	}

	public int getColor() {
		return color;
	}

	public Drawable getDrawable() {
		return drawable;
	}

	public String getString() {
		return string;
	}

	public TileSize getWeight() {
		return weight;
	}

	@Override
	public TileContentHolder create() {
		return this;
	}

	@Override
	public TileContentHolderCreator setId(int id) {
		this.id = id;
		return this;
	}

	@Override
	public TileContentHolderCreator setColor(int color) {
		this.color = color;
		return this;
	}

	@Override
	public TileContentHolderCreator setDrawable(Drawable drawable) {
		this.drawable = drawable;
		return this;
	}

	@Override
	public TileContentHolderCreator setString(String string) {
		this.string = string;
		return this;
	}

	@Override
	public TileContentHolderCreator setWeight(TileSize weight) {
		this.weight = weight;
		return this;
	}

}
