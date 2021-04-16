package zhipin.recycleractivity

fun acitivityKt(
        applicationPackage:String?,
        activityClass:String,
        layoutName:String,
        packageName:String,
        ViewModelName:String,
        AdapterName:String
)="""
package ${packageName};

import android.view.View;
import android.os.Bundle;
import com.hpbr.bosszhipin.base.BaseAwareActivity;
import ${applicationPackage}.R;
import com.hpbr.bosszhipin.views.AppTitleView;
import ${packageName}.viewmodel.${ViewModelName};
import zpui.lib.ui.refreshlayout.ZPUIRefreshLayout;
import zpui.lib.ui.statelayout.ZPUIStateLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ${packageName}.adapter.${AdapterName};
import com.hpbr.bosszhipin.views.AppTitleView;
import com.hpbr.bosszhipin.views.OnClickNoFastListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.annotation.NonNull;

public class ${activityClass} extends BaseAwareActivity<${ViewModelName}> implements OnLoadMoreListener, OnRefreshListener {

    private AppTitleView titleView;
    /**
     * 刷新
     */
    private ZPUIRefreshLayout mRefreshLayout;
    /**
     * 状态view
     */
    private ZPUIStateLayoutManager mZPUIStateLayoutManager;
    private int mPage = 1;
    private RecyclerView mRecyclerView;
    private ${AdapterName} mAdapter;


    @Override
    protected int contentLayout() {
        return R.layout.${layoutName};
    }

    @Override
    protected void onAfterCreate(Bundle savedInstanceState) {
        titleView = (AppTitleView) findViewById(R.id.title_view);
	    titleView.setDividerInvisible();
        titleView.setBackClickListener();
        mRecyclerView = findViewById(R.id.recyclerView);
        mRefreshLayout = findViewById(R.id.refresh_layout);
        mRefreshLayout.setOnLoadMoreListener(this);
        mRefreshLayout.setOnRefreshListener(this);
        initEmpty();
        initAdapter();
    }

    private void initEmpty() {
        mZPUIStateLayoutManager = new ZPUIStateLayoutManager(this, mRefreshLayout);
        View errorView = new ZPUIStateLayoutManager.Builder(this).setBottomBtn("重新加载", new OnClickNoFastListener() {
            @Override
            public void onNoFastClick(View v) {
                mZPUIStateLayoutManager.showLoadingScene();
                mPage = 1;
                mViewModel.requestList(mPage);
            }
        })
                .setSubTitle("网络异常，请尝试重新加载")
            .build();
        mZPUIStateLayoutManager.getErrorLayout().setCustomView(errorView);
        View emptyView = new ZPUIStateLayoutManager.Builder(this).setBottomBtn("emptyText", new OnClickNoFastListener() {
            @Override
            public void onNoFastClick(View v) {
                
            }
        })
                .setImage(R.mipmap.ic_empty_page)
                .setSubTitle("subTitle")
                .build();
        mZPUIStateLayoutManager.getEmptyLayout().setCustomView(emptyView);
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ${AdapterName}();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPage++;
        mViewModel.requestList(mPage);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPage = 1;
        mViewModel.requestList(mPage);
    }
}


"""