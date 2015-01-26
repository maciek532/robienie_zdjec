package com.example.robienie_zdjec;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class DrawingView extends ImageView {

	private Paint paint=new Paint();
	private Path path=new Path();
	
	public DrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint.setAntiAlias(true);
		paint.setStrokeWidth(5f);
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawPath(path, paint);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float eventX=event.getX();
		float eventY=event.getY();
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			path.moveTo(eventX, eventY);
			return true;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(eventX, eventY);
			break;
		default:
			return false;
		}
		
		invalidate();
		return super.onTouchEvent(event);
	}
	
	public void SetStrokeWidth(float width){
		paint.setStrokeWidth(width);
	}

	public void ChangeColor(int color) {
		paint.setColor(color);
	}
}
