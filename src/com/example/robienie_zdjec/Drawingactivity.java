package com.example.robienie_zdjec;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Drawingactivity extends Activity {
	
	
	SeekBar seekBar=null;
	DrawingView drawing;
	ExpandableListView listview=null;
	
	public static final String SandwichKey = "key1";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawing);
		
		seekBar=(SeekBar) findViewById(R.id.seekBar1);
		drawing =(DrawingView) findViewById(R.id.drawingView1);
		Bitmap imagebitmap=(Bitmap)getIntent().getParcelableExtra(SandwichKey);
		drawing.setImageBitmap(imagebitmap);
		listview =(ExpandableListView) findViewById(R.id.expandableListView1);
		String[] tablica=new String[]{"zielony","niebieski","czerwony","¿ó³ty","czarny"};
		ArrayAdapter adapter=new ArrayAdapter<String>(this, TRIM_MEMORY_BACKGROUND, tablica);		
		
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				drawing.SetStrokeWidth(progress);
			}
		});
	}	
}
