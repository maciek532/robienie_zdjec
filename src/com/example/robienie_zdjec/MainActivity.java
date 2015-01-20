package com.example.robienie_zdjec;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	static final int REQUEST_IMAGE_CAPTURE=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void camera(){
		Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if(intent.resolveActivity(getPackageManager())!=null){
			startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
			Bundle extras=data.getExtras();
			Bitmap imageBitmap=(Bitmap) extras.get("data");
		}
	}
}
