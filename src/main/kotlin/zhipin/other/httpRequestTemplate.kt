package zhipin.other
import com.android.tools.idea.wizard.template.*
//

val httpRequestTemplate
    get() = template {
        revision = 5
        name = "HttpRequest"
        description = "适用于HttpRequest"
        minApi = 7
        minBuildApi = 14

        category = Category.Activity
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule, WizardUiContext.MenuEntry)

        val httpName = stringParameter {
            name = "http request Name"
            default = "Main"
            constraints = listOf(Constraint.NONEMPTY)
        }
        val requestName = stringParameter {
            name = "request Name"
            default = "${httpName.value}Request"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${httpName.value}Request" }
        }

        val responseName = stringParameter {
            name = "response Name"
            default = "MainResponse"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${httpName.value}Response" }
        }

//        val isGet = booleanParameter {
//            name = "Method is Get"
//            default = false
//            help = "请输入是否是get方法，默认是POST"
//        }

        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(httpName),
            TextFieldWidget(requestName),
            TextFieldWidget(responseName),
//            CheckBoxWidget(isGet),
            PackageNameWidget(packageName),
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            requestRecipe(
                data as ModuleTemplateData,
                requestName.value,
                responseName.value,
                packageName.value,
            )
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