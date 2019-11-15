/**
 *
 */
package com.zxx.app.vote.adapter;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;


import com.zxx.app.vote.bean.Vote;
import com.zxx.base.adapter.AbstractAdapter;
import com.zxx.lrean2017.R;

import java.util.List;

/**
 * @author yfy1
 * @Date 2015年11月26日
 * @version 1.0
 * @Desprition
 */
public class VoteListAdapter extends AbstractAdapter<Vote> {

	private int gray;
	private int black;

	public VoteListAdapter(Context context, List<Vote> list) {
		super(context, list);
		gray = context.getResources().getColor(R.color.gray);
		black = context.getResources().getColor(R.color.app_base_color);
	}


	@Override
	public void renderData(int position, AbstractAdapter<Vote>.DataViewHolder holder, List<Vote> list) {
		Vote vote = list.get(position);
		TextView title=holder.getView(TextView.class, R.id.title);

		TextView time=holder.getView(TextView.class, R.id.date);

		TextView isSendTv = holder.getView(TextView.class, R.id.issend);

		time.setText(vote.getData());
		title.setText(vote.getTitle());
		if (vote.getIsend().equals("false")) {
			isSendTv.setText("未投票");
			isSendTv.setTextColor(Color.RED);
			title.setTextColor(black);
			time.setTextColor(black);
		} else {
			isSendTv.setText("已投票");
			isSendTv.setTextColor(gray);
			title.setTextColor(gray);
			time.setTextColor(gray);
		}
	}

	@Override
	public ResInfo getResInfo() {
		ResInfo resInfo=new ResInfo();
		resInfo.layout=R.layout.vote_main_item_lv;
		resInfo.initIds=new int[]{
				R.id.title,
				R.id.date,
				R.id.issend,
		};
		return resInfo;
	}

}
