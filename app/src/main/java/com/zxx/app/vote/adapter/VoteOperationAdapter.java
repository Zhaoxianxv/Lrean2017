package com.zxx.app.vote.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.zxx.app.vote.bean.VoteBean;
import com.zxx.app.vote.bean.VoteInfor;
import com.zxx.lrean2017.R;
import com.zxx.view.ExtendedEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfy1 on 2017/3/22.
 */

public class VoteOperationAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private boolean isCheck;
    private int mTouchItemPosition= -1;
    private int gray;
    private int black;

    private List<VoteInfor> voteDetailList = new ArrayList<VoteInfor>();

    public void setVoteDetailList(List<VoteInfor> voteDetailList) {
        this.voteDetailList = voteDetailList;

    }

    public List<VoteInfor> getVoteDetailList() {
        return voteDetailList;
    }

    public VoteOperationAdapter(Context context, List<VoteInfor> voteDetailList, boolean isCheck) {
        super();
        inflater=LayoutInflater.from(context);
        this.voteDetailList=voteDetailList;
        this.isCheck=isCheck;
        gray=context.getResources().getColor(R.color.gray);
        black=context.getResources().getColor(R.color.app_base_text_color);

    }

    /**----------得到armTypes和arms中每一个元素的ID-------------------------------------------*/
    //获取组在给定的位置编号，即armTypes中元素的ID
    @Override
    public long getGroupId(int i) {
        return i;
    }
    //获取在给定的组的儿童的ID，就是arms中元素的ID
    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }
    /**----------根据上面得到的ID的值，来得到armTypes和arms中元素的个数 ------------------------*/

    //获取的群体数量，得到armTypes里元素的个数
    @Override
    public int getGroupCount() {
        return voteDetailList.size();
    }
    //取得指定组中的儿童人数，就是armTypes中每一个种族它军种的个数
    @Override
    public int getChildrenCount(int i) {
        return voteDetailList.get(i).getVotecontent().size();
    }

    //获取与给定的组相关的数据，得到数组armTypes中元素的数据
    @Override
    public Object getGroup(int i) {
        return voteDetailList.get(i);
    }

    //获取与孩子在给定的组相关的数据,得到数组arms中元素的数据
    @Override
    public Object getChild(int i, int i1) {
        return voteDetailList.get(i).getVotecontent().get(i1);
    }


    // 是否指定分组视图及其子视图的ID对应的后台数据改变也会保持该ID。
    @Override
    public boolean hasStableIds() {
        return true;
    }
    //孩子在指定的位置是可选的，即：arms中的元素是可点击的
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        final ViewHolderChildChoice viewHolderCheckBox;
        VoteInfor vote=voteDetailList.get(i);
        if (view==null){
            viewHolderCheckBox=new ViewHolderChildChoice();
            view=inflater.inflate(R.layout.vote_question_title_view,null);
            viewHolderCheckBox.title= (TextView) view.findViewById(R.id.vote_group_title);
            view.setTag(viewHolderCheckBox);
        }else{
            viewHolderCheckBox= (ViewHolderChildChoice) view.getTag();
        }
        viewHolderCheckBox.title.setText(vote.getTitle());
        return view;

    }
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String type=voteDetailList.get(i).getType();
        if (type.equals("3")){
            return getChoiceQuestion(view,i,i1,true);
        }else if (type.equals("1")){
            return getChoiceQuestion(view,i,i1,false);
        }
        return view;
    }





    private View getChoiceQuestion(View view, final int group, final int child,boolean hide) {

        final ViewHolderChildChoice choice;
        final VoteBean bean=voteDetailList.get(group).getVotecontent().get(child);
//        Log.e("zx",bean.toString());
        final int max=voteDetailList.get(group).getMaxsize();
        if (view==null){
            choice=new ViewHolderChildChoice();
            view=inflater.inflate(R.layout.vote_question_chioce_view,null);
            choice.content= (TextView) view.findViewById(R.id.vote_child_text);
            choice.layout= (LinearLayout) view.findViewById(R.id.vote_chioce_layout);
            choice.checkbox= (CheckBox) view.findViewById(R.id.vote_child_checkbox);
            choice.edit= (ExtendedEditText) view.findViewById(R.id.vote_question_edit);

            view.setTag(choice);
        }else{
            choice= (ViewHolderChildChoice) view.getTag();
        }
        choice.content.setText(bean.getContent());
        final List<VoteBean> beans=voteDetailList.get(group).getVotecontent();
        choice.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){
                    choice.content.setTextColor(black);
                    if (max==1){
                        for(VoteBean bean1:voteDetailList.get(group).getVotecontent()) {
                            bean1.setIsselect("false");
                        }
                        bean.setIsselect("true");
                        if (click!=null){
                            click.oniBox(group);
                        }
                    }else{
                        bean.setIsselect("true");
                    }
                }else{
                    choice.content.setTextColor(gray);
                    bean.setIsselect("false");
                }
            }
        });
        final boolean check=bean.getIsselect().equals("true")?true:false;
        if (check){
            choice.content.setTextColor(black);
        }else{
            choice.content.setTextColor(gray);
        }
        choice.checkbox.setChecked(check);
        if (isCheck){
            choice.checkbox.setClickable(false);

        }else{
            choice.checkbox.setClickable(true);

        }

        choice.edit.setText(voteDetailList.get(group).getReply());
        choice.edit.setTag(group + ":" + child);
        choice.edit.clearTextChangedListeners();
        setInput(choice.edit, group, child);

        if (isCheck){
            choice.edit.setFocusable(false);
            choice.edit.setText(bean.getContent());
        }else{
            choice.edit.setFocusable(true);
        }
        if (hide){
            choice.edit.setVisibility(View.VISIBLE);
            choice.layout.setVisibility(View.GONE);
        }else{
            choice.layout.setVisibility(View.VISIBLE);
            choice.edit.setVisibility(View.GONE);
        }
        return view;
    }









    class ViewHolderChildChoice {
        TextView title;
        ExtendedEditText edit;

        LinearLayout layout;
        CheckBox checkbox;
        TextView content;

    }



    private void setInput(final ExtendedEditText a, final int g, final int c) {

        a.setOnFocusChangeListener( new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

                VoteInfor bean=voteDetailList.get(g);
                bean.setReply(a.getText().toString());
            }
        });
        a.setOnTouchListener(new  View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:


                        break;
                    default:
                        break;
                }



                return false;
            }
        });

    }







    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void notifyDataSetChanged(List<VoteInfor> voteDetailList ) {
        super.notifyDataSetChanged();
    }

    private CheckBoxOnclick  click;

    public void setClick(CheckBoxOnclick click) {
        this.click = click;
    }

    public interface CheckBoxOnclick {
        void oniBox(int group);
    }
}
