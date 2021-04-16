package zhipin.recyclerfragment
import com.android.tools.idea.wizard.template.*
//

val recyclerFragmentTemplate
    get() = template {
        revision = 5
        name = "MVVM Fragment With RecyclerView"
        description = "适用于直聘MVVM框架带有Recyclerview的Activity"
        minApi = 7
        minBuildApi = 14

        category = Category.Fragment
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        lateinit var layoutName: StringParameter
        lateinit var itemLayoutName : StringParameter

        val MVVMName = stringParameter {
            name = "MVVM Name"
            default = "Main"
            constraints = listOf(Constraint.NONEMPTY)
        }
        val fragmentClass = stringParameter {
            name = "Activity Name"
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

        itemLayoutName = stringParameter {
            name = "Layout Name"
            default = "item_fragment_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "get_item_${MVVMName.value.toLowerCase()}" }
        }

        val viewModelName = stringParameter {
            name = "viewModel Name"
            default = "MainViewModel"
            help = "请输入viewModel的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${MVVMName.value}ViewModel" }
        }

        val adapterName = stringParameter {
            name = "adapter Name"
            default = "MainAdapter"
            help = "请输入adapter的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${MVVMName.value}Adapter" }
        }

        val modelName = stringParameter {
            name = "model Name"
            default = "MainModel"
            help = "请输入model的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${MVVMName.value}Model" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(MVVMName),
            TextFieldWidget(fragmentClass),
            TextFieldWidget(layoutName),
            TextFieldWidget(itemLayoutName),
            TextFieldWidget(viewModelName),
            TextFieldWidget(adapterName),
            TextFieldWidget(modelName),
            PackageNameWidget(packageName),
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            fragmentRecipe(
                    data as ModuleTemplateData,
                    fragmentClass.value,
                    layoutName.value,
                    packageName.value,
                    viewModelName.value,
                    adapterName.value,
                    itemLayoutName.value,
                    modelName.value)
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