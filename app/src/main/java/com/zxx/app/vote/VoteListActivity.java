/**
 *
 */
package com.zxx.app.vote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


import com.zxx.app.vote.adapter.VoteListAdapter;
import com.zxx.app.vote.bean.Vote;
import com.zxx.base.activity.BaseActivity;
import com.zxx.lrean2017.R;
import com.zxx.xlist.xlist.XListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @author yfy1
 * @Date 2015年11月26日
 * @version 1.0
 * @Desprition
 */
public class VoteListActivity extends BaseActivity {

	@Bind(R.id.vote_group_xlist)
	XListView xlist;

	private VoteListAdapter adapter;
	private List<Vote> voteList = new ArrayList<Vote>();



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vote_main);
		initSQToolbar();
		initViews();
		
	}

	private void initSQToolbar() {


		for (int i=0;i<5;i++){
			Vote v=new Vote("id"+i,"title  "+i,"time","false");
			voteList.add(v);
		}
	}


	private void initViews() {

		xlist.setPullLoadEnable(true);
		xlist.setPullLoadEnable(true);
		adapter = new VoteListAdapter(this, voteList);
		xlist.setAdapter(adapter);


		xlist.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

				Intent intent = new Intent(mActivity, VoteDetailActicity.class);
				startActivity(intent);
			}
		});

	}





}

