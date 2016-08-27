package com.app.happy;

import java.util.Timer;
import java.util.TimerTask;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	TextView t,t2;
	int counter=0;
	String[]x={"Birthday","Wedding anniversary","Valantain","other"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		 t=(TextView)findViewById(R.id.textView2);
		 t2=(TextView)findViewById(R.id.textView1);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(counter=0;counter<7;counter++)
				{
	
				
					
			
				
			
						runOnUiThread( new Runnable() {
							public void run() {
								if(t.getAlpha()==0 &&counter<4){
								t.animate().alpha(1f).setDuration(500);
								t.setText(x[counter]);
								}else if(t.getAlpha()==1  &&counter<4)
								{
									t.animate().alpha(0f).setDuration(500);
									counter--;
								} 
								
								if(counter==5){t.animate().alpha(0f).setDuration(500);
													 t2.animate().translationXBy(230f).setDuration(1000);
													 
												}
								if(counter==6) startActivity(new Intent(MainActivity.this,Sign_in.class));
								
							}
						});
					
						
				
					
					try {
						Thread.sleep(1000);
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
		}
				
				
				
			
		}).start(); 
		 
		 
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
}
