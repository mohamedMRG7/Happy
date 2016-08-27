package com.app.happy;

import com.app.interfaces.Isregested;
import com.resorces.user.User_info;
import com.user.database.Check_user;
import com.user.database.Regester;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_up extends ActionBarActivity {

	
	
	EditText username,pass,email;
	Context ctx=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		
		
		username=(EditText)findViewById(R.id.ed__Rusername);
		pass=(EditText)findViewById(R.id.ed_Rpass);
		email=(EditText)findViewById(R.id.ed_Remail);
		
		
		
	}

	 public void signup (View view)
	 {	
		 
		 final String Uusername=username.getText().toString();
		 final String Upass=pass.getText().toString();
		 final String Uemail=email.getText().toString();
		 User_info user=new User_info(Uusername, Upass, Uemail);
		 new Check_user().fetchUserDataAsyncTask(user, new Isregested() {
			
			@Override
			public void regester_done(User_info user) {
				// TODO Auto-generated method stub
				try{
				 Toast.makeText(ctx,  user.getEmail()+" is already found", Toast.LENGTH_SHORT).show();
				}catch(Exception e)
				{			
					User_info usern=new User_info(Uusername,Upass ,Uemail );
				new Regester(ctx).storinbackground(usern, new Isregested() {
					
					@Override
					public void regester_done(User_info user) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "Thanks for regesting", Toast.LENGTH_SHORT).show();
						startActivity(new Intent(Sign_up.this,Select_product.class));
						
					}
				}, ctx);}
			}
		});
		 
		
	 }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
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
