package com.example.robienie_zdjec;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class Drawingactivity extends Activity {
	
	
	SeekBar seekBar=null;
	DrawingView drawing;
	ExpandableListView listview=null;
	Bitmap imagebitmap;
	
	public static final String SandwichKey = "key1";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawing);
		
		seekBar=(SeekBar) findViewById(R.id.seekBar1);
		drawing =(DrawingView) findViewById(R.id.drawingView1);
		imagebitmap=(Bitmap)getIntent().getParcelableExtra(SandwichKey);
		BitmapDrawable drawable=new BitmapDrawable(getResources(),imagebitmap);
		drawing.setBackground(drawable);
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
	
	@Override
	public void finish() {
		imagebitmap=((BitmapDrawable)drawing.getBackground()).getBitmap();
		Intent intent=new Intent();
		intent.putExtra("SandwichKey",imagebitmap);
		setResult(2, intent);
		Toast.makeText(this, "fasada",Toast.LENGTH_SHORT).show();
		super.finish();
	}
}
