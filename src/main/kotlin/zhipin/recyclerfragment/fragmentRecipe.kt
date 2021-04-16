package zhipin.recyclerfragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest

fun RecipeExecutor.fragmentRecipe(
        moduleData: ModuleTemplateData,
        fragmentClass: String,
        layoutName: String,
        packageName: String,
        viewModelName: String,
        adapterName: String,
        itemLayoutName: String,
        modelName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension


    val mvvmFragment = fragmentKt(projectData.applicationPackage, fragmentClass, layoutName, packageName, viewModelName, adapterName)
    // 保存Activity
    save(mvvmFragment, srcOut.resolve("${fragmentClass}.java"))
    // 保存xml
    save(fragmentXml(), resOut.resolve("layout/${layoutName}.xml"))

    save(itemLayoutXML(), resOut.resolve("layout/${itemLayoutName}.xml"))
    // 保存viewModel
    save(fragmentViewModel(packageName, viewModelName), srcOut.resolve("viewmodel/${viewModelName}.java"))

    save(model(packageName, modelName), srcOut.resolve("model/${modelName}.java"))

    save(adapter(projectData.applicationPackage, packageName, adapterName, modelName, itemLayoutName), srcOut.resolve("adapter/${adapterName}.java"))
}