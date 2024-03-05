package com.priyakdey.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.nio.file.Files
import java.nio.file.Paths
import java.util.regex.Pattern

/**
 * Plugin to validate that every solution has a Leetcode Link in the class javadoc.
 *
 * @author Priyak Dey
 */
class VerifyJavadocsPlugin : Plugin<Project> {


    override fun apply(project: Project) {
        project.task("verifyJavadocs") {
            doLast {
                project.fileTree("src/main/java/com/priyakdey/solutions").forEach { file ->
                    val content = Files.readString(Paths.get(file.path))
                    // TODO: Have a better logic for this
                    if (!content.contains("https://leetcode.com/problems/")) {
                        throw RuntimeException("Missing problem statement in ${file.path}")
                    }
                }
            }
        }
    }

}
