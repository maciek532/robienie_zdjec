package com.example.robienie_zdjec;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
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
		}
	}
	
	public void editpicture(View v){
		Intent intent=new Intent(this,Drawingactivity.class);
		intent.putExtra(Drawingactivity.SandwichKey, imageBitmap);
		startActivity(intent);
	}
	
	public void savepicture(View v){
		ContextWrapper wrapper=new ContextWrapper(this);
		File root = Environment.getExternalStorageDirectory();
        File file = new File(root.getAbsolutePath()+"/DCIM/Camera/img.jpg");
		
		FileOutputStream fos=null;
		
		try{
		fos=new FileOutputStream(file);
		
		imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
		fos.close();
		}catch(Exception e){e.printStackTrace();}
		//Toast.makeText(this, directory.getAbsolutePath(), Toast.LENGTH_SHORT).show();
	}
}
