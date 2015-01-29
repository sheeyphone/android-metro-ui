package com.eephone.metrotile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private RelativeLayout container;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		// ÈÝÆ÷
		container = (RelativeLayout) findViewById(R.id.container);

		// TEST
		TileItemTest itemTest = new TileItemTest(this, container,
				AnimationUtils.loadAnimation(this, R.anim.alpha_anim_show));
		itemTest.test();
	}

}
