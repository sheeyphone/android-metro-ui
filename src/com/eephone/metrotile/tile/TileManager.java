package com.eephone.metrotile.tile;

import java.util.Iterator;
import java.util.List;

import com.eephone.metrotile.anim.Rotate3DAnimation;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

/**
 * TileManager 对Context，容器和动画进行管理
 * 
 * @author Eephone Xu
 * 
 */
public final class TileManager implements OnTouchListener {

	private Activity activity;
	private RelativeLayout container;
	private Animation animation;
	private TileLayout mainlayout;
	private int middlePx, tinyPx;
	private int dividerId;
	// 动画
	private Rotate3DAnimation rotate3dAnimation;
	private Rotate3DAnimation rotate3dAnimationReverse;

	/**
	 * 构造函数
	 * 
	 * @param activity
	 *            Context
	 * @param container
	 *            容器（RelativeLayout）
	 * @param showAnimation
	 *            （方块显示动画）
	 */
	public TileManager(final Activity activity, RelativeLayout container,
			Animation showAnimation, int dividerId) {
		this.activity = activity;
		this.container = container;
		this.animation = showAnimation;
		this.dividerId = dividerId;
		// 计算屏幕大小动态调整方块大小
		float screenWidthPx = getWidthPx(activity);
		middlePx = (int) (screenWidthPx / 2);
		tinyPx = (int) (screenWidthPx / 4);
		// 初始化一级模块
		mainlayout = new TileLayout(activity, middlePx, dividerId);
		this.container.addView(mainlayout);
	}

	private void initAnimation(int size) {
		// 动画
		rotate3dAnimation = new Rotate3DAnimation(0, 20, size / 2, size / 2,
				310.0f, false);
		rotate3dAnimation.setDuration(1000);
		rotate3dAnimation.setFillAfter(true);
		rotate3dAnimation.setInterpolator(new DecelerateInterpolator());
		rotate3dAnimationReverse = new Rotate3DAnimation(20, 0, size / 2,
				size / 2, 310.0f, true);
		rotate3dAnimationReverse.setDuration(1000);
		rotate3dAnimationReverse.setFillAfter(true);
		rotate3dAnimationReverse.setInterpolator(new DecelerateInterpolator());
	}

	public void initialTileFlow(TileItemBuilder builder, TileParams params,
			List<TileContentHolder> holders, OnClickListener listener) {
		// Layout&Item
		TileLayout inlayout = null;
		TileItem item = null;
		// 遍历添加
		Iterator<TileContentHolder> iterator = holders.iterator();
		while (iterator.hasNext()) {
			TileContentHolder tileHolder = iterator.next();
			// 中码
			if (tileHolder.getWeight() == TileSize.Middle) {
				// 如果有小的方块集，就先添加小的
				if (inlayout != null) {
					mainlayout.addTileLayout(inlayout);
					inlayout.startAnimation(animation);
					inlayout = null;
				}
				item = TileDirector.constructTileItem(
						new TileBuilder(activity), params, TileSize.Middle,
						tileHolder.getColor(), tileHolder.getDrawable(),
						tileHolder.getString(), listener, tileHolder.getId());
				// 动画
				initAnimation(tinyPx);
				item.setOnTouchListener(this);
				// End
				mainlayout.addTileItem(item);
				item.startAnimation(animation);
			}
			// 小码
			else if (tileHolder.getWeight() == TileSize.Small) {
				// 如果是第一个小的块
				if (inlayout == null) {
					inlayout = new TileLayout(activity, tinyPx, dividerId);
					item = TileDirector.constructTileItem(new TileBuilder(
							activity), params, TileSize.Small, tileHolder
							.getColor(), tileHolder.getDrawable(), tileHolder
							.getString(), listener, tileHolder.getId());
					// 动画
					initAnimation(tinyPx);
					item.setOnTouchListener(this);
					// End
					inlayout.addTileItem(item);
					item.startAnimation(animation);
				}
				// 否则续编
				else {
					// 如果还不足4块
					if (inlayout.getWeight() < 4) {
						item = TileDirector.constructTileItem(new TileBuilder(
								activity), params, TileSize.Small, tileHolder
								.getColor(), tileHolder.getDrawable(),
								tileHolder.getString(), listener, tileHolder
										.getId());

						// 动画
						initAnimation(tinyPx);
						item.setOnTouchListener(this);
						// End

						inlayout.addTileItem(item);
						item.startAnimation(animation);
					}
					// 4块满了
					else {
						mainlayout.addTileLayout(inlayout);
						inlayout.startAnimation(animation);
						inlayout = new TileLayout(activity, tinyPx, dividerId);
						item = TileDirector.constructTileItem(new TileBuilder(
								activity), params, TileSize.Small, tileHolder
								.getColor(), tileHolder.getDrawable(),
								tileHolder.getString(), listener, tileHolder
										.getId());

						// 动画
						initAnimation(tinyPx);
						item.setOnTouchListener(this);
						// End

						inlayout.addTileItem(item);
						item.startAnimation(animation);
					}
				}
			}
		}
		// 最后检查一遍有没有小的方块集
		if (inlayout != null) {
			mainlayout.addTileLayout(inlayout);
			inlayout = null;
		}
	}

	public static TileParamsCreator createParams() {
		return new TileParams();
	}

	public static TileContentHolderCreator createHolder() {
		return new TileContentHolder();
	}

	public interface TileParamsCreator {
		// 创建方法
		TileParams create();

		// Version 1.1
		TileParamsCreator setTileMarginSize(int size);

		TileParamsCreator setTileMiddleImagePaddingSize(int size);

		TileParamsCreator setTileMiddleTextPaddingSize(int size);

		TileParamsCreator setTileMiddleTextSize(int size);

		TileParamsCreator setTileSmallImagePaddingSize(int size);

		TileParamsCreator setTileDrawableId(int id);
	}

	public interface TileContentHolderCreator {
		// 创建方法
		TileContentHolder create();

		// Version 1.1
		TileContentHolderCreator setId(int id);

		TileContentHolderCreator setColor(int color);

		TileContentHolderCreator setDrawable(Drawable drawable);

		TileContentHolderCreator setString(String string);

		TileContentHolderCreator setWeight(TileSize weight);
	}

	@SuppressWarnings("deprecation")
	public synchronized int getWidthPx(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		return width;
	}

	public synchronized int getDpToPx(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
			arg0.startAnimation(rotate3dAnimation);
		} else if (arg1.getAction() == MotionEvent.ACTION_UP) {
			arg0.startAnimation(rotate3dAnimationReverse);
		}
		return false;
	}
}
