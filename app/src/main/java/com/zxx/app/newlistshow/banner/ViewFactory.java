package com.zxx.app.newlistshow.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.zxx.lrean2017.R;


/**
 * ImageView创建工厂
 */
public class ViewFactory {

	/**
	 * 获取ImageView视图的同时加载显示url
	 * @return
	 */
	public static ImageView getImageView(Context context, String url) {
		ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(
				R.layout.banner_view_item, null);
//		Glide.with(context).load(url)
//				.centerCrop()
//				.placeholder(R.drawable.ic_launcher)
//				.crossFade()
//				.into(imageView);
		return imageView;
	}
}
