package zhipin.fragment

fun fragmentViewModel(
        packageName:String,
        ViewModelName:String
)="""
package ${packageName}.viewmodel;

import androidx.annotation.NonNull;
import android.app.Application;
import com.hpbr.bosszhipin.base.BaseViewModel;


public class ${ViewModelName} extends BaseViewModel {

    public ${ViewModelName}(@NonNull Application application) {
        super(application);
    }

}
"""