package com.eephone.metrotile.tile;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

final class TileLayout extends RelativeLayout {

	private int mLeft = 0, mRight = 0, mSize = 0;
	private LinearLayout.LayoutParams mLeftParams, mRightParams;

	private View mDivider;
	private LinearLayout mLeftLayout;
	private LinearLayout mRightLayout;

	private TileLayout(Context context) {
		super(context);
	}

	public TileLayout(Context context, int size, int dividerId) {
		this(context);
		mSize = size;
		// 内部布局
		LayoutParams params;
		// Divider
		params = new LayoutParams(0, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL);
		mDivider = new View(context);
		mDivider.setLayoutParams(params);
		mDivider.setId(dividerId);
		addView(mDivider);
		// LeftLayout
		params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		params.addRule(RelativeLayout.ALIGN_RIGHT, mDivider.getId());
		mLeftLayout = new LinearLayout(context);
		mLeftLayout.setOrientation(LinearLayout.VERTICAL);
		mLeftLayout.setLayoutParams(params);
		addView(mLeftLayout);
		// RightLayout
		params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		params.addRule(RelativeLayout.ALIGN_LEFT, mDivider.getId());
		mRightLayout = new LinearLayout(context);
		mRightLayout.setOrientation(LinearLayout.VERTICAL);
		mRightLayout.setLayoutParams(params);
		addView(mRightLayout);
	}

	public int getWeight() {
		return mLeft + mRight;
	}

	public void addTileItem(TileItem item) {
		mLeftParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				mSize);
		mRightParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				mSize);
		if (mLeft <= mRight || mLeft > mRight && mRight == 3) {
			item.setLayoutParams(mLeftParams);
			mLeftLayout.addView(item);
			mLeft += item.getWeight();
		} else {
			item.setLayoutParams(mRightParams);
			mRightLayout.addView(item);
			mRight += item.getWeight();
		}
	}

	public void addTileLayout(TileLayout layout) {
		mLeftParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		mRightParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		if (mLeft <= mRight || mLeft > mRight && mRight == 3) {
			layout.setLayoutParams(mLeftParams);
			mLeftLayout.addView(layout);
			mLeft += layout.getWeight();
		} else {
			layout.setLayoutParams(mRightParams);
			mRightLayout.addView(layout);
			mRight += layout.getWeight();
		}
	}
}
