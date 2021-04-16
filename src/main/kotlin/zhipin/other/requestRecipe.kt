package zhipin.other

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.requestRecipe(
    moduleData: ModuleTemplateData,
    requestName: String,
    responseName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData

    // 保存
    save(httpRequest(packageName, requestName, responseName), srcOut.resolve("${requestName}.java"))
    // 保存
    save(httpResponse(packageName, responseName), srcOut.resolve("${responseName}.java"))


}