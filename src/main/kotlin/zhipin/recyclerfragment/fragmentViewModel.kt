package zhipin.recyclerfragment

fun fragmentViewModel(
        packageName:String,
        ViewModelName:String
)="""
package ${packageName}.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import com.hpbr.bosszhipin.base.BaseViewModel;


public class ${ViewModelName} extends BaseViewModel {

    public ${ViewModelName}(@NonNull Application application) {
        super(application);
    }
    
    public void requestList(int page) {

    }

}

"""