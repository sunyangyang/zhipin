package com.twl.zhipin.services

import com.intellij.openapi.project.Project
import com.twl.zhipin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
