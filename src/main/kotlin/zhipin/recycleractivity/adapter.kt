package zhipin.recycleractivity

fun adapter(
    applicationPackage:String?,
    packageName:String,
    AdapterName:String,
    ModelName:String,
    ItemLayoutName:String
) = """
package ${packageName}.adapter;

import ${applicationPackage}.R;
import androidx.annotation.NonNull;
import com.hpbr.bosszhipin.recycleview.BaseRvAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import ${packageName}.model.${ModelName};

public class ${AdapterName} extends BaseRvAdapter<${ModelName}, BaseViewHolder> {
    public ${AdapterName}() {
        super(R.layout.${ItemLayoutName}, null);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, ${ModelName} item) {
        
    }

}
"""