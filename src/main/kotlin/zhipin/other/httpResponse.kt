package zhipin.other

fun httpResponse(
    packageName:String,
    ResponseClassName : String
) = """
package ${packageName};

import net.bosszhipin.base.HttpResponse;

public class ${ResponseClassName} extends HttpResponse {


}
"""
