package com.resorces.user;

import com.app.happy.R;

public class Birthday_res {
	
	public int [] product_img;
	public String [] product_name,product_price,product_place;
	
	
	
	public void cakes()
	{
		 product_img= new int []{R.drawable.birthdaycake1,R.drawable.birthdaycake2,R.drawable.birthdaycake3,R.drawable.birthdaycake4};
		 product_name=new String []{"Choclate cake","cream cake","cake with ur name","cake with eggs"};
		 product_price=new String []{"40 LE","50 LE","80 LE","10 LE"};
		 product_place=new String []{"Shobra el khema","El giza","saft el labn","Cairo"};
	}
	
	public void candles()
	{
		product_img= new int []{R.drawable.birthdaycandle1,R.drawable.birthdaycandle2,R.drawable.birthdaycandle3,R.drawable.birthdaycandle4};
		 product_name=new String []{"red candle","line candle1","suck candle1","suck too candle1"};
		 product_price=new String []{"40 LE","50 LE","80 LE","10 LE"};
		 product_place=new String []{"Shobra el khema","El giza","saft el labn","Cairo"};
	}
	
	public void gifts()
	{
		product_img= new int []{R.drawable.birthdaygifts1,R.drawable.birthdaygifts2,R.drawable.birthdaygifts3,R.drawable.birthdaygifts4};
		 product_name=new String []{"boby gift","gift with gift","suck gift","nice gift"};
		 product_price=new String []{"40 LE","50 LE","80 LE","10 LE"};
		 product_place=new String []{"Shobra el khema","El giza","saft el labn","Cairo"};
	}
	

}
