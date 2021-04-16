package zhipin.recycleractivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest

fun RecipeExecutor.activityRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        layoutName: String,
        packageName: String,
        viewModelName: String,
        adapterName: String,
        itemLayoutName: String,
        modelName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    generateManifest(
            moduleData = moduleData,
            activityClass = "${activityClass}",
            activityTitle = activityClass,
            packageName = packageName,
            isLauncher = false,
            hasNoActionBar = false,
            generateActivityTitle = true
    )

    val mvvmActivity = acitivityKt(projectData.applicationPackage, activityClass, layoutName, packageName, viewModelName, adapterName)
    // 保存Activity
    save(mvvmActivity, srcOut.resolve("${activityClass}.java"))
    // 保存xml
    save(activityXml(), resOut.resolve("layout/${layoutName}.xml"))

    save(itemLayoutXML(), resOut.resolve("layout/${itemLayoutName}.xml"))
    // 保存viewModel
    save(activityViewModel(packageName, viewModelName), srcOut.resolve("viewmodel/${viewModelName}.java"))

    save(model(packageName, modelName), srcOut.resolve("model/${modelName}.java"))

    save(adapter(projectData.applicationPackage, packageName, adapterName, modelName, itemLayoutName), srcOut.resolve("adapter/${adapterName}.java"))
}