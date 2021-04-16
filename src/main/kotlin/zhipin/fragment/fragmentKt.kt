package zhipin.fragment

fun fragmentKt(
        applicationPackage:String?,
        FragmentName:String,
        layoutName:String,
        packageName:String,
        ViewModelName:String
)="""
package ${packageName};

import android.view.View;
import android.os.Bundle;
import com.hpbr.bosszhipin.base.BaseAwareFragment;
import ${applicationPackage}.R;
import ${packageName}.viewmodel.${ViewModelName};

public class ${FragmentName} extends BaseAwareFragment<${ViewModelName}> {


    public static ${FragmentName} newInstance(Bundle data) {
        ${FragmentName} f = new ${FragmentName}();
        f.setArguments(data);
        return f;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.${layoutName};
    }

    @Override
    protected void initViews(View view) {
        
    }

}

"""