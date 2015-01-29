package com.eephone.metrotile.tile;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

final class TileItem extends RelativeLayout {

	// 内部布局参数
	private LayoutParams params;
	// 组件
	private RelativeLayout container;
	private ImageView imageView;
	private TextView textView;
	private Button button;
	// 参数
	private TileSize weight;

	public TileItem(Context context) {
		super(context);
	}

	public void setTileBackground(TileSize tileSize, int color, int marginSize) {
		// ContentLayout
		params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		params.setMargins(marginSize, marginSize, marginSize, marginSize);
		container = new RelativeLayout(getContext());
		container.setLayoutParams(params);
		addView(container);
		// 设置值
		container.setBackgroundColor(color);
		weight = tileSize;
	}

	public void setTileImage(Drawable drawable, int paddingSize) {
		// ImageView
		params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		imageView = new ImageView(getContext());
		imageView
				.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		imageView.setLayoutParams(params);
		container.addView(imageView);
		// 设置值
		imageView.setImageDrawable(drawable);
	}

	public void setTileText(String text, int paddingSize, int textSize) {
		// TextView
		params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		textView = new TextView(getContext());
		textView.setTextColor(Color.WHITE);
		textView.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
		textView.setTextSize(textSize);
		textView.setLayoutParams(params);
		container.addView(textView);
		// 设置值
		textView.setText(text);
		if (weight == TileSize.Small) {
			textView.setVisibility(INVISIBLE);
		}
	}

	public void setTileClickable(int selectorDrawableId,
			OnClickListener listener, int callbackId) {
		// Button
		button = new Button(getContext());
		params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		button.setLayoutParams(params);
		button.setOnClickListener(listener);
		button.setBackgroundResource(selectorDrawableId);
		container.addView(button);
		// 设置值
		button.setId(callbackId);
	}

	public int getWeight() {
		switch (weight) {
		case Middle:
			return 4;
		case Small:
			return 1;
		default:
			return 1;
		}
	}
}