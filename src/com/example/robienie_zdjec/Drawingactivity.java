package com.example.robienie_zdjec;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Drawingactivity extends Activity {
	
	public static final String SandwichKey = "key1";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawing);
		
		DrawingView drawing=(DrawingView) findViewById(R.id.drawingView1);
		Bitmap imagebitmap=(Bitmap)getIntent().getParcelableExtra(SandwichKey);
		drawing.setImageBitmap(imagebitmap);
	}
}
