package com.example.maths;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void init() {
		Button b10 =  (Button)findViewById(R.id.button1);
		Button b20 =  (Button)findViewById(R.id.button2);
		Button b50 =  (Button)findViewById(R.id.button3);
		Button b100 =  (Button)findViewById(R.id.button4);
		
		b10.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				createQues(10);
			}
		});
		
		b20.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				createQues(20);
			}
		});
		
		b50.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				createQues(50);
			}
		});
		
		b100.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				createQues(100);
			}
		});
	}
	
	public void createQues(Integer option) {
		Bundle bundle = new Bundle();
		bundle.putSerializable("option", option);
		Intent intent = new Intent(MainActivity.this, QuesActivity.class);
		intent.putExtras(bundle);
		startActivity(intent);
	}
}
