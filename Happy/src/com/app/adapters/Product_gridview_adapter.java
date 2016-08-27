package com.app.adapters;

import com.app.happy.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Product_gridview_adapter extends BaseAdapter{

	int []productimg;
	String []productname;
	String []product_price;
	String []product_place;
	Context ctx;
	
	
	public Product_gridview_adapter(int[] product, String[] product_price,
			String[] product_place ,String [] productname,Context ctx) {
		super();
		this.productimg = product;
		this.productname=productname;
		this.product_price = product_price;
		this.product_place = product_place;
		this.ctx=ctx;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return productname.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return productname[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View root=inflater.inflate(R.layout.inf_products_gridlayout, parent,false);
		
		ImageView img=(ImageView)root.findViewById(R.id.imageView1);
		TextView name=(TextView)root.findViewById(R.id.textView1);
		TextView price=(TextView)root.findViewById(R.id.textView2);
		TextView place=(TextView)root.findViewById(R.id.textView3);
		
		img.setImageResource(productimg[position]);
		name.setText(productname[position]);
		price.setText(product_price[position]);
		place.setText(product_place[position]);
		
		
		
		
		
		return root;
	}

}
