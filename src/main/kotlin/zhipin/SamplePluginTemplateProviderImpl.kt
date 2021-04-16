package zhipin

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import zhipin.activity.activityTemplate
import zhipin.fragment.fragmentTemplate
import zhipin.other.httpRequestTemplate
import zhipin.recycleractivity.recyclerActivityTemplate
import zhipin.recyclerfragment.recyclerFragmentTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(

            activityTemplate,
            fragmentTemplate,
            recyclerActivityTemplate,
            recyclerFragmentTemplate,
            httpRequestTemplate
    )
}