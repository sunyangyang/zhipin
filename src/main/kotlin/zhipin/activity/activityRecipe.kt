package zhipin.activity

import android.util.Log
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.ThemeData
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifestStrings
import org.jetbrains.kotlin.cli.common.arguments.mergeBeans
import java.io.File

fun RecipeExecutor.activityRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        layoutName: String,
        packageName: String,
        viewModelName: String
) {
    val (projectData, srcOut, resOut, manifestOut) = moduleData

    val mvvmActivity = acitivityKt(projectData.applicationPackage, activityClass, layoutName, packageName, viewModelName)
    // 保存Activity
    save(mvvmActivity, srcOut.resolve("${activityClass}.java"))
    // 保存xml
    save(activityXml(), resOut.resolve("layout/${layoutName}.xml"))
    // 保存viewModel
    save(activityViewModel(packageName, viewModelName), srcOut.resolve("viewmodel/${viewModelName}.java"))

    mergeXml(manifestXml(packageName, activityClass), manifestOut.resolve("AndroidManifest.xml"))
}