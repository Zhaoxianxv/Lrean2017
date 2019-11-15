package com.zxx.app.newlistshow.adpater;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.zxx.app.newlistshow.banner.ADInfo;
import com.zxx.app.newlistshow.banner.CycleViewPager;
import com.zxx.app.newlistshow.banner.ViewFactory;
import com.zxx.app.BaseAdapter;
import com.zxx.app.newlistshow.viewpager.News;
import com.zxx.app.newlistshow.viewpager.Utils;
import com.zxx.lrean2017.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2016-05-03
 * Time: 13:47
 * FIXME
 */


public class CounselAdpater extends BaseAdapter {
    public static final int VIEW_TYPE_LIVE_TAG = 1;//轮播
    public static final int VIEW_TYPE_NEWS = 2;//新闻
    private static final int VIEW_TYPE_LOAD_MORE = 6;//底部自动加载区
    private Context context;

    private List<ADInfo> adInfos = new ArrayList<>();
    private List<News> newses = new ArrayList<>();
    private ViewPagerHolder viewPagerHolder;

    public CounselAdpater(Context context) {
        super(context);
        this.context = context;
        viewPagerHolder = new ViewPagerHolder(View.inflate(context, R.layout.show_banner, null));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_LIVE_TAG) {
            //轮播
            return viewPagerHolder;
        } else if (viewType == VIEW_TYPE_NEWS) {
            //新闻
            View root = LayoutInflater.from(context).inflate(R.layout.show_news_adpater, parent, false);
            return new NewsHolder(root);
        } else {
            return loadMoreViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NewsHolder) {
            bindNewsData((NewsHolder)holder,position);
        }   else if (holder instanceof LoadMoreViewHolder) {
            //加载数据
            loadMore(newses.size());
        }
    }

    @Override
    public int getItemCount() {
        return newses.size() + 2;//新闻数+轮播+提醒
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) { //广告
            return VIEW_TYPE_LIVE_TAG;
        }else if (position == getItemCount() - 1) { //最后一个元素显示加载
            return VIEW_TYPE_LOAD_MORE;
        } else { //新闻
            return VIEW_TYPE_NEWS;
        }
    }

    /**
     * 轮播图
     */
    class ViewPagerHolder extends RecyclerView.ViewHolder {
        CycleViewPager pager_ads;
        public ViewPagerHolder(View itemView) {
            super(itemView);
            FragmentActivity activity = (FragmentActivity) context;
            pager_ads = (CycleViewPager) activity.getSupportFragmentManager().findFragmentById(R.id.fragment_cycle_viewpager_content);
            // 设置循环，在调用setData方法前调用
            pager_ads.setCycle(true);
            pager_ads.setWheel(true);
            pager_ads.setTime(5000);
            //设置圆点指示图标组居中显示，默认靠右
            pager_ads.setIndicatorCenter();
        }
    }

    /**
     * 新闻列表
     */
    class NewsHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        ImageView img;
        View more;
        News news;
        public NewsHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.news_title);
            content = (TextView) itemView.findViewById(R.id.news_content);
            img = (ImageView) itemView.findViewById(R.id.news_img);
            more = itemView.findViewById(R.id.more);
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.e("zxx","点击了");
//                    ActivityLauncher.toBrowserActivity(context ,news);

                }
            });
        }
    }


    /**
     * 刷新“广告”的显示数据
     *
     * @param adInfos 刷新的数据
     */
    public void setADInfos(List<ADInfo> adInfos) {
        if (Utils.isEmpty(adInfos)) {
            return;
        }
        this.adInfos.addAll(adInfos);
        List<ImageView> views = generateImageViews(adInfos);
        viewPagerHolder.pager_ads.setData(views, adInfos, imageCycleViewListener);
    }

    /**
     * 初始化广告的操作
     *
     * @param infos
     * @return
     */
    public List<ImageView> generateImageViews(List<ADInfo> infos) {
        List<ImageView> views = new ArrayList<>();
        // 将最后一个ImageView添加进来
        views.add(ViewFactory.getImageView(context, infos.get(infos.size() - 1).getUrl()));
        for (int i = 0; i < infos.size(); i++) {
            views.add(ViewFactory.getImageView(context, infos.get(i).getUrl()));
        }
        // 将第一个ImageView添加进来
        views.add(ViewFactory.getImageView(context, infos.get(0).getUrl()));
        return views;
    }

    /**
     * 首页轮播图片点击事件
     */
    CycleViewPager.ImageCycleViewListener imageCycleViewListener = new CycleViewPager.ImageCycleViewListener() {
        @Override
        public void onImageClick(ADInfo info, int postion, View imageView) {
            Log.e("time",info.getUrl());
        }
    };

    private void bindNewsData(NewsHolder holder, int position) {
        News news =newses.get(position-1);
        assert news != null;
        if(news.getContent()!=null){
            holder.content.setText(Html.fromHtml(news.getContent()));
        }
        holder.title.setText(news.getTitle());
        Glide.with(context).load(news.getNews_img()).into(holder.img);
        holder.news = news;
    }

    public void addNewses(List<News> newses) {
        if (Utils.isNotEmpty(newses)) {
            this.newses.addAll(newses);
        }
    }
    public void clearNewses(){
        newses.clear();
    }

    public int livesCount() {
        return newses.size();
    }
}
