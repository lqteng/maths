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
		final Button b2 =  (Button)findViewById(R.id.button2);
		final Button b3 =  (Button)findViewById(R.id.button3);
		final Button b4 =  (Button)findViewById(R.id.button4);
				
		final Maths m = Maths.newMath(option);
		
		tv3.setText("  " + m.getA() + "  " + m.getSign() + "  " + m.getB());
		Random random = new Random();
		int i = random.nextInt(3);
		if (i == 0) {
			b2.setText(String.valueOf(m.getC()));
			b3.setText(String.valueOf(m.getC() - 1));
			b4.setText(String.valueOf(m.getC() + 1));
		} else if (i == 1) {
			b3.setText(String.valueOf(m.getC()));
			b2.setText(String.valueOf(m.getC() - 1));
			b4.setText(String.valueOf(m.getC() + 1));
		} else {
			b4.setText(String.valueOf(m.getC()));
			b2.setText(String.valueOf(m.getC() - 1));
			b3.setText(String.valueOf(m.getC() + 1));
		}

	}
}
