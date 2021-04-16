package zhipin.activity

fun acitivityKt(
        applicationPackage:String?,
        activityClass:String,
        layoutName:String,
        packageName:String,
        ViewModelName:String
)="""
package ${packageName};

import android.os.Bundle;
import com.hpbr.bosszhipin.base.BaseAwareActivity;
import ${applicationPackage}.R;
import com.hpbr.bosszhipin.views.AppTitleView;
import ${packageName}.viewmodel.${ViewModelName};

public class ${activityClass} extends BaseAwareActivity<${ViewModelName}> {

    private AppTitleView titleView;


    @Override
    protected int contentLayout() {
        return R.layout.${layoutName};
    }

    @Override
    protected void onAfterCreate(Bundle savedInstanceState) {
        initView();
        initData();
    }
    
    private void initView() {
        titleView = (AppTitleView) findViewById(R.id.title_view);
	    titleView.setDividerInvisible();
        titleView.setBackClickListener();
    }
    
    private void initData() {
    
    }
}
"""