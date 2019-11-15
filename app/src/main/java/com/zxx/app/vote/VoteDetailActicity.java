/**
 *
 */
package com.zxx.app.vote;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.zxx.app.Utils;
import com.zxx.app.vote.adapter.VoteOperationAdapter;
import com.zxx.app.vote.adapter.VoteOperationAdapter.CheckBoxOnclick;
import com.zxx.app.vote.bean.Vote;
import com.zxx.app.vote.bean.VoteBean;
import com.zxx.app.vote.bean.VoteInfor;

import com.zxx.app.vote.bean.VoteResult;
import com.zxx.base.activity.BaseActivity;
import com.zxx.lrean2017.R;
import com.zxx.view.SQToolBar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yfy1
 * @Date 2015年11月26日
 * @version 1.0
 * @Desprition
 */
public class VoteDetailActicity extends BaseActivity {

	private final static String TAG = VoteDetailActicity.class.getSimpleName();

	private ExpandableListView listView;


	private VoteOperationAdapter adapter;
	private List<VoteInfor> voteDetailList = new ArrayList<VoteInfor>();


	private boolean isVoted;

	private String session_key = "";
	private String voteId = "";
	private String name = "";
	private String content = "";
	private final String getvotebyid = "getvotebyid";
	private final String vote = "vote";
	private int position;


	private String gson_string ="{\"Votedetail\":" +
			"[" +
				"{\"Votecontent\":" +
					"[" +
						"{\"content\":\"1\",\"id\":\"单选1\",\"isselect\":\"true\"}," +
						"{\"content\":\"2\",\"id\":\"单选2\",\"isselect\":\"false\"}," +
						"{\"content\":\"3\",\"id\":\"单选3\",\"isselect\":\"false\"}," +
						"{\"content\":\"4\",\"id\":\"单选4\",\"isselect\":\"false\"}" +
					"],\"id\":\"1113\",\"maxsize\":1,\"minsize\":1,\"title\":\"选择\",\"type\":\"1\"" +
				"}," +
				"{\"Votecontent\":" +
					"[" +
						"{\"content\":\"1\",\"id\":\"多选1\",\"isselect\":\"false\"}," +
						"{\"content\":\"2\",\"id\":\"多选2\",\"isselect\":\"false\"}," +
						"{\"content\":\"3\",\"id\":\"多选3\",\"isselect\":\"true\"}," +
						"{\"content\":\"4\",\"id\":\"多选4\",\"isselect\":\"false\"}" +
					"],\"id\":\"1114\",\"maxsize\":2,\"minsize\":1,\"title\":\"多选择\",\"type\":\"1\"" +
				"}," +
				"{\"Votecontent\":" +
					"[" +
						"{\"content\":\"\",\"id\":\"1115\",\"isselect\":\"false\"}" +
					"],\"id\":\"问答1\",\"maxsize\":1,\"minsize\":1,\"title\":\"问答1\",\"type\":\"3\"" +
				"}," +
				"{\"Votecontent\":" +
					"[" +
						"{\"content\":\"\",\"id\":\"1115\",\"isselect\":\"false\"}" +
					"],\"id\":\"问答2\",\"maxsize\":1,\"minsize\":1,\"title\":\"问答2\",\"type\":\"3\"" +
				"}," +
				"{\"Votecontent\":" +
					"[" +
						"{\"content\":\"\",\"id\":\"1115\",\"isselect\":\"false\"}" +
					"],\"id\":\"问答3\",\"maxsize\":1,\"minsize\":1,\"title\":\"问答3\",\"type\":\"3\"" +
				"}," +
				"{\"Votecontent\":" +
					"[" +
						"{\"content\":\"\",\"id\":\"问答1\",\"isselect\":\"false\"}" +
					"],\"id\":\"问答4\",\"maxsize\":1,\"minsize\":1,\"title\":\"问答4\",\"type\":\"3\"" +
				"}," +
				"{\"Votecontent\":" +
					"[" +
						"{\"content\":\"\",\"id\":\"1115\",\"isselect\":\"false\"}" +
					"],\"id\":\"问答1\",\"maxsize\":1,\"minsize\":1,\"title\":\"问答1\",\"type\":\"3\"" +
				"}," +
				"{\"Votecontent\":" +
					"[" +
						"{\"content\":\"\",\"id\":\"1115\",\"isselect\":\"false\"}" +
					"],\"id\":\"1115\",\"maxsize\":1,\"minsize\":1,\"title\":\"问答\",\"type\":\"3\"" +
				"}," +
				"{\"Votecontent\":" +
					"[" +
						"{\"content\":\"\",\"id\":\"1115\",\"isselect\":\"false\"}" +
					"],\"id\":\"问答1\",\"maxsize\":1,\"minsize\":1,\"title\":\"问答1\",\"type\":\"3\"" +
				"}" +

			"]}";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vote_detail_activity);

		getData();
		initViews();
		initSQToolbar();

	}


	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

	public void getData() {
		Gson gson=new Gson();
		VoteResult re=gson.fromJson(gson_string, VoteResult.class);
		voteDetailList=re.getVotedetail();
	}


	private void initSQToolbar() {
		assert toolbar!=null;
		toolbar.setTitle("");
		toolbar.addMenuText(1,"提交");
		toolbar.setOnMenuClickListener(new SQToolBar.OnMenuClickListener() {
			@Override
			public void onClick(View view, int position) {
				onWindowFocusChanged(true);
				if (isCanSend()) {

				}
			}
		});
	}






	private CheckBoxOnclick click=new CheckBoxOnclick() {
		@Override
		public void oniBox(int group) {
			adapter.setVoteDetailList(adapter.getVoteDetailList());

			for (int i=0; i<adapter.getVoteDetailList().size(); i++) {
				listView.expandGroup(i);
			}
			listView.collapseGroup(group);
			listView.expandGroup(group);
		}
	};



	private void initViews() {
		listView = (ExpandableListView) findViewById(R.id.listView);
		listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

				return true;
			}
		});
		adapter=new VoteOperationAdapter(mActivity,voteDetailList,false);
		listView.setAdapter(adapter);

		for (int i=0; i<voteDetailList.size(); i++) {
			listView.expandGroup(i);
		}
		adapter.setClick(click);
	}





	private boolean isCanSend() {
		if (isVoted) {
			toastShow("已经投过,无法再次投票");
			return false;
		}
		List<VoteInfor> voteResult = adapter.getVoteDetailList();
		StringBuffer sb = new StringBuffer();
		for (VoteInfor vote : voteResult) {
			if(vote.getType().equals("3")){
				Log.e("zxx","vote.getReply()   "+vote.getReply());
				if (!Utils.isNotEmpty(vote.getReply())) {
//					toastShow("问答题全部完成才能提交");
//					return false;
				}else{
					sb.append(vote.getId().toString())
							.append("^").append("0")
							.append("^").append(vote.getReply());

				}
			}else if(vote.getType().equals("1")){
				if (vote.getMaxsize()==1){
					boolean is=false;
					for (VoteBean bean:vote.getVotecontent()){
						is=bean.getIsselect().equals("true")?true:false;
						if (is){
							sb.append(vote.getId())
									.append("^").append(bean.getId())
									.append("^").append("true");
							break;
						}

					}
					if (!is){
						toast("选择题全部完成才能提交");
						return false;
					}
				}else{
					boolean frist=false;
					boolean is=false;
					for (VoteBean bean:vote.getVotecontent()){
						is=bean.getIsselect().equals("true")?true:false;
						if (is){
							if (frist){
								sb.append("|").append(vote.getId().toString())
										.append("^").append(bean.getId().toString())
										.append("^").append("true");
							}else{
								sb.append(vote.getId())
										.append("^").append(bean.getId().toString())
										.append("^").append("true");
							}
							frist=is;
							continue;
						}
					}
					if (!frist){
						toast("多选题全部完成才能提交");
						return false;
					}
				}
			}
			sb.append("|");
		}

		content = sb.toString().substring(0, sb.length() - 1);
		Log.e("zxx", "" + content);
		return true;
	}



}
