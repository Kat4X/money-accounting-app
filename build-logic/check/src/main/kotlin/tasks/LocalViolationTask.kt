package tasks

import org.gradle.api.tasks.TaskAction
import se.bjurr.violations.gradle.plugin.ViolationsTask

/**
 * Собирает отчёты статического анализа
 *
 * Отличается от [ViolationsTask] только тем, что создаёт каталог для отчёта, если его нет.
 */
abstract class LocalViolationTask : ViolationsTask() {
    @TaskAction
    override fun violationsPluginTasks() {
        codeClimateFile.parentFile.mkdirs()
        super.violationsPluginTasks()
    }
}
