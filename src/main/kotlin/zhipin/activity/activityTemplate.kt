package zhipin.activity
import com.android.tools.idea.wizard.template.*
//

val activityTemplate
    get() = template {
        revision = 5
        name = "MVVM Activity"
        description = "适用于直聘MVVM框架的Activity"
        minApi = 7
        minBuildApi = 14

        category = Category.Activity
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        lateinit var layoutName: StringParameter

        val MVVMName = stringParameter {
            name = "MVVM Name"
            default = "Main"
            constraints = listOf(Constraint.NONEMPTY)
        }
        val activityClass = stringParameter {
            name = "Activity Name"
            default = "${MVVMName.value}Activity"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${MVVMName.value}Activity" }
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "get_activity_${MVVMName.value.toLowerCase()}" }
        }

        val viewModelName = stringParameter {
            name = "viewModel Name"
            default = "MainViewModel"
            help = "请输入viewModel的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${MVVMName.value}ViewModel" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
                TextFieldWidget(MVVMName),
                TextFieldWidget(activityClass),
                TextFieldWidget(layoutName),
                TextFieldWidget(viewModelName),
                PackageNameWidget(packageName),
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            activityRecipe(
                    data as ModuleTemplateData,
                    activityClass.value,
                    layoutName.value,
                    packageName.value,
                    viewModelName.value)
        }
    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.twl.zhipin"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }