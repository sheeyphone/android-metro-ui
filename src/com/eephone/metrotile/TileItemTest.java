package com.eephone.metrotile;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eephone.metrotile.tile.TileBuilder;
import com.eephone.metrotile.tile.TileContentHolder;
import com.eephone.metrotile.tile.TileManager;
import com.eephone.metrotile.tile.TileParams;
import com.eephone.metrotile.tile.TileSize;

public class TileItemTest implements OnClickListener {

	private Activity activity;
	private TileManager manager;

	public TileItemTest(Activity activity, RelativeLayout container,
			Animation showAnimation) {
		this.activity = activity;
		manager = new TileManager(activity, container, showAnimation,
				R.id.divider);
	}

	public Drawable getDrawable(int id) {
		return activity.getResources().getDrawable(id);
	}

	public void test() {
		// 默认ID
		int idCreator = 0;
		// 默认颜色
		int orange = activity.getResources().getColor(R.color.tile_orange);
		int blue = activity.getResources().getColor(R.color.tile_blue);
		int green = activity.getResources().getColor(R.color.tile_green);
		int purple = activity.getResources().getColor(R.color.tile_purple);
		int red = activity.getResources().getColor(R.color.tile_red);

		List<TileContentHolder> holders = new ArrayList<TileContentHolder>();

		// Version 1.1 如何添加holder
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_key))
				.setWeight(TileSize.Middle).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_list))
				.setWeight(TileSize.Small).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_mail))
				.setWeight(TileSize.Small).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_near))
				.setWeight(TileSize.Middle).create());
		holders.add(TileManager.createHolder().setId(idCreator++).setColor(red)
				.setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_nib))
				.setWeight(TileSize.Small).create());
		holders.add(TileManager.createHolder().setId(idCreator++).setColor(red)
				.setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_notes))
				.setWeight(TileSize.Small).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_road))
				.setWeight(TileSize.Middle).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(green).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_user))
				.setWeight(TileSize.Middle).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_road_z))
				.setWeight(TileSize.Small).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_tag))
				.setWeight(TileSize.Small).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_user))
				.setWeight(TileSize.Small).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_vinyl))
				.setWeight(TileSize.Small).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(purple).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_wiggle))
				.setWeight(TileSize.Middle).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_list))
				.setWeight(TileSize.Middle).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_notes))
				.setWeight(TileSize.Small).create());
		holders.add(TileManager.createHolder().setId(idCreator++)
				.setColor(blue).setString("TEST")
				.setDrawable(getDrawable(R.drawable.tile_tag))
				.setWeight(TileSize.Small).create());

		// Version 1.1 如何添加TileParams
		int tileMargin = (int) activity.getResources().getDimension(
				R.dimen.padding);
		TileParams tileParams = TileManager.createParams()
				.setTileMarginSize(tileMargin)
				.setTileMiddleImagePaddingSize(tileMargin * 7)
				.setTileMiddleTextPaddingSize(tileMargin)
				.setTileMiddleTextSize((int) (tileMargin * 2.5))
				.setTileSmallImagePaddingSize(tileMargin * 4)
				.setTileDrawableId(R.drawable.layout_selector).create();
		manager.initialTileFlow(new TileBuilder(activity), tileParams, holders,
				this);
	}

	@Override
	public void onClick(View arg0) {
		Toast.makeText(activity, "" + arg0.getId(), Toast.LENGTH_SHORT).show();
	}
}
