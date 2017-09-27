package net.jiawa.pullnestedscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import net.jiawa.pullnestedscrollview.widgets.PullNestedScrollView;

public class MainActivity extends AppCompatActivity {

    PullNestedScrollView mPullNestedScrollView;
    ImageView mImageView;
    protected RecyclerView mPopularComments;
    protected RecyclerView mCasts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWindow();
        initWidgets();
    }

    private void initWindow() {
        setFullScreen(false);
        // on before initWindow call
        ViewStub stub = (ViewStub) findViewById(R.id.lay_content);
        stub.setLayoutResource(R.layout.sub_page);
        stub.inflate();
    }

    private void initWidgets() {
        if (null == mPullNestedScrollView) {
            mPullNestedScrollView = (PullNestedScrollView) findViewById(R.id.pnv_scroll_view);
            mImageView = (ImageView) findViewById(R.id.iv_header_image);
        }
        mPullNestedScrollView.setHeader(mImageView);

        mCasts = (RecyclerView) this.findViewById(R.id.rv_casts);
        mCasts.setLayoutManager(getLayoutManager(LinearLayoutManager.HORIZONTAL));
        mCasts.setAdapter(new CastsAdapter());

        mPopularComments = (RecyclerView) findViewById(R.id.rv_popular_comments);
        mPopularComments.setLayoutManager(getLayoutManager(LinearLayoutManager.VERTICAL));
        mPopularComments.setAdapter(new PopularCommentsAdapter());
    }

    protected void setFullScreen(boolean flush) {
        if (flush) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        } else {
            // 这样设置不会冲掉原来的设置项目
            int oldSystemUiFlags = getWindow().getDecorView().getSystemUiVisibility();
            int newSystemUiFlags = oldSystemUiFlags;
            newSystemUiFlags |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            newSystemUiFlags |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
            newSystemUiFlags |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            if (newSystemUiFlags != oldSystemUiFlags) {
                getWindow().getDecorView().setSystemUiVisibility(newSystemUiFlags);
            }
        }
    }

    protected RecyclerView.LayoutManager getLayoutManager(int orientation) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(orientation);
        return linearLayoutManager;
    }

    class CastsAdapter extends RecyclerView.Adapter {

        int[] images = new int[]{ R.drawable.actor_000, R.drawable.actor_001, R.drawable.actor_002, R.drawable.actor_003,
                R.drawable.actor_004, R.drawable.actor_005, R.drawable.actor_006, R.drawable.actor_007, R.drawable.actor_008 };
        String[] names = new String[]{ "唐季礼", "成龙", "金喜善", "梁家辉",
                "玛丽卡", "孙周", "邵兵", "于荣光", "谭耀文" };

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CastsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_douban_casts, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            CastsViewHolder h = (CastsViewHolder) holder;
            // h.title.setText(title);
            h.name.setText(names[position]);
            h.avater.setImageDrawable(getResources().getDrawable(images[position]));
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }

    private static class CastsViewHolder extends RecyclerView.ViewHolder {

        ImageView avater;
        // TextView title;
        TextView name;

        public CastsViewHolder(View itemView) {
            super(itemView);
            avater = (ImageView) itemView.findViewById(R.id.iv_avater);
            // title = (TextView) itemView.findViewById(R.id.tv_title);
            name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    class PopularCommentsAdapter extends RecyclerView.Adapter {

        String[] authors = new String[] {
                "蒜 | BOY A",
                "战国客",
                "香水瓶",
                "暖鱼",
                "蓉儿"/*,
                "UrthónaD'Mors",
                "蓝下老婆",
                "芝麻酱",
                "AMONK.EY峰"*/
        };

        String[] creates = new String[] {
                "2008-07-04",
                "2008-09-03",
                "2006-04-18",
                "2005-10-14",
                "2017-01-11"/*,
                "2009-01-29",
                "2017-03-08",
                "2011-10-05",
                "2017-02-09"*/
        };

        String[] contents = new String[] {
                "2008.7.3 CCTV6 home 电影歌曲再次超越电影本身的范例。",
                "主题曲确实很好听~~",
                "看过一遍不太想再看第二遍了，不过主题曲真的很好听！",
                "一个等待千年待郎归，一个千年之后迷梦连连回妃旁，见面了却又草草结束，莫名其妙。",
                "影片给人的感觉是凄美绝然，蒙毅将军和玉漱公主的爱情很短也很长，两个人身份悬殊，却在生死面前心生情愫，阴阳两隔之后却穿越时空再续前缘，影片将三千年前的故事与今日相融合，营造岀一种浪漫气氛，深深地感染了观众，带给观众强烈的感情冲激，却不觉得突兀，心绪也随着剧中人物的遭遇而跌宕起伏。"/*,
                "额，金喜善在坟墓了活了那么久他吃什么？莫非仙单真的可以羽化登仙",
                "神话电视剧版男主是帅哥靓女，神话电影版是大叔和美女，想想如果一个高帅的男的来演蒙放，那是不是更好看了，嘿嘿??",
                "即使在长途车上消磨时光也觉得太烂了",
                "了功夫瑜伽之后，我才惊觉当年这部神话是很好的。"*/
        };

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PopularCommentsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_douban_popular_comments, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            PopularCommentsViewHolder h = (PopularCommentsViewHolder) holder;
            h.author.setText(authors[position]);
            h.createdTime.setText(creates[position]);
            h.content.setText(contents[position]);
        }

        @Override
        public int getItemCount() {
            return authors.length;
        }
    }

    private static class PopularCommentsViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        TextView createdTime;
        TextView content;

        public PopularCommentsViewHolder(View itemView) {
            super(itemView);
            author = (TextView) itemView.findViewById(R.id.tv_author);
            createdTime = (TextView) itemView.findViewById(R.id.tv_created_time);
            content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
