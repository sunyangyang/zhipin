package zhipin.other

fun httpRequest(
    packageName:String,
    RequestClassName:String,
    ResponseClassName : String,
    isGet : String
) = """
package ${packageName};

import com.google.gson.annotations.Expose;
import ${packageName}.${ResponseClassName};
import com.twl.http.callback.AbsRequestCallback;
import com.twl.http.config.RequestMethod;
import net.bosszhipin.base.BaseApiRequest
import net.bosszhipin.base.HttpResponse;

public class ${RequestClassName} extends BaseApiRequest<${ResponseClassName}> {
    
    public ${RequestClassName}(AbsRequestCallback<${ResponseClassName}> callback) {
        super(callback);
    }

    @Override
    public String getUrl() {
        return "";
    }

    @Override
    public RequestMethod getMethod() {
        return ${isGet};
    }
}
"""