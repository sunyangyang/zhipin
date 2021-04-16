package zhipin.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest

fun RecipeExecutor.fragmentRecipe(
        moduleData: ModuleTemplateData,
        fragmentClass: String,
        layoutName: String,
        packageName: String,
        viewModelName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val mvvmFragment = fragmentKt(projectData.applicationPackage, fragmentClass, layoutName, packageName, viewModelName)
    // 保存Activity
    save(mvvmFragment, srcOut.resolve("${fragmentClass}.java"))
    // 保存xml
    save(fragmentXml(), resOut.resolve("layout/${layoutName}.xml"))
    // 保存viewModel
    save(fragmentViewModel(packageName, viewModelName), srcOut.resolve("viewmodel/${viewModelName}.java"))
}