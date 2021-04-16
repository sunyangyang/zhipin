package zhipin.fragment
import com.android.tools.idea.wizard.template.*
//

val fragmentTemplate
    get() = template {
        revision = 5
        name = "MVVM Fragment"
        description = "适用于直聘MVVM框架的Fragment"
        minApi = 7
        minBuildApi = 14

        category = Category.Fragment
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        lateinit var layoutName: StringParameter

        val MVVMName = stringParameter {
            name = "MVVM Name"
            default = "Main"
            constraints = listOf(Constraint.NONEMPTY)
        }
        val fragmentClass = stringParameter {
            name = "Fragment Name"
            default = "${MVVMName.value}Fragment"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${MVVMName.value}Fragment" }
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "get_fragment_${MVVMName.value.toLowerCase()}" }
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
                TextFieldWidget(fragmentClass),
                TextFieldWidget(layoutName),
                TextFieldWidget(viewModelName),
                PackageNameWidget(packageName),
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            fragmentRecipe(
                    data as ModuleTemplateData,
                    fragmentClass.value,
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