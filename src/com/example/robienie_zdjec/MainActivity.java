package com.example.robienie_zdjec;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	static final int REQUEST_IMAGE_CAPTURE=1;
	Bitmap imageBitmap;
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void camera(View v){
		Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if(intent.resolveActivity(getPackageManager())!=null){
			startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
			Bundle extras=data.getExtras();
			imageBitmap=(Bitmap) extras.get("data");			
		}if(requestCode==2){
			bmp=data.getParcelableExtra("SandwichKey");
		}
	}
	
	public void editpicture(View v){
		Intent intent=new Intent(this,Drawingactivity.class);
		intent.putExtra(Drawingactivity.SandwichKey, imageBitmap);
		startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
	}
	
	public void savepicture(View v){
		ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
       File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
       // Create imageDir
       File mypath=new File(directory,"profile.jpg");

       FileOutputStream fos = null;
       try {           

           fos = new FileOutputStream(mypath);

      // Use the compress method on the BitMap object to write image to the OutputStream
           imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
           fos.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
       DrawingView drawing=(DrawingView) findViewById(R.id.drawingView1);
       BitmapDrawable drawable=new BitmapDrawable(getResources(),bmp);
       drawing.setBackground(drawable);
		//Toast.makeText(this, directory.getAbsolutePath(), Toast.LENGTH_SHORT).show();		
	}
}
