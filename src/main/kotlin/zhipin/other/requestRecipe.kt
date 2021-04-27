package zhipin.other

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.requestRecipe(
    moduleData: ModuleTemplateData,
    requestName: String,
    responseName: String,
    packageName: String,
    isGet : Boolean
) {
    val (projectData, srcOut, resOut) = moduleData
    val getString = if (isGet) {
        "RequestMethod.GET"
    } else {
        "RequestMethod.POST"
    }
    // 保存
    save(httpRequest(packageName, requestName, responseName, getString), srcOut.resolve("${requestName}.java"))
    // 保存
    save(httpResponse(packageName, responseName), srcOut.resolve("${responseName}.java"))


}