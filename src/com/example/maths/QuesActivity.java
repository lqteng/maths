package com.example.maths;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QuesActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ques);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		final Integer option = (Integer)bundle.getSerializable("option");

		//		Toast.makeText(getApplicationContext(), "默认Toast样式", Toast.LENGTH_SHORT).show();
		
		TextView tv1 =  (TextView)findViewById(R.id.textView1);
		tv1.setText(option.intValue() + "以内的加减法");
		
		Button b1 =  (Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				next(option);
			}
		});
		
		next(option);
	}
	
	private void next(Integer option) {
		TextView tv3 =  (TextView)findViewById(R.id.textView3);
		TextView tv5 =  (TextView)findViewById(R.id.textView5);
		TextView tv6 =  (TextView)findViewById(R.id.textView6);
		TextView tv7 =  (TextView)findViewById(R.id.textView7);
				
		Maths m = Maths.newMath(option);
		
		tv3.setText(m.getA() + "  " + m.getSign() + "  " + m.getB());
		Random random = new Random();
		int i = random.nextInt(3);
		if (i == 0) {
			tv5.setText(String.valueOf(m.getC()));
			tv6.setText(String.valueOf(m.getC() - 1));
			tv7.setText(String.valueOf(m.getC() + 1));
		} else if (i == 1) {
			tv6.setText(String.valueOf(m.getC()));
			tv5.setText(String.valueOf(m.getC() - 1));
			tv7.setText(String.valueOf(m.getC() + 1));
		} else {
			tv7.setText(String.valueOf(m.getC()));
			tv5.setText(String.valueOf(m.getC() - 1));
			tv6.setText(String.valueOf(m.getC() + 1));
		}
	}
}
