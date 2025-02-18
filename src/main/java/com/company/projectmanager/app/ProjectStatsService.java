package com.company.projectmanager.app;

import com.company.projectmanager.entity.Project;
import com.company.projectmanager.entity.ProjectStats;
import com.company.projectmanager.entity.Task;
import io.jmix.core.DataManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProjectStatsService {
    private final DataManager dataManager;

    public ProjectStatsService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    /**
     * Gets projects statistics
     * @return Instance of ProjectStats list
     */
    public List<ProjectStats> fetchProjectStatistics() {
        List<Project> projects = dataManager.load(Project.class).all().list();

        List<ProjectStats> projectStats = projects.stream().map(project -> {
            ProjectStats stats = dataManager.create(ProjectStats.class);
            stats.setId(project.getId());
            stats.setProjectName(project.getName());
            stats.setTasksCount(project.getTasks().size());
            Integer plannedEfforts = project.getTasks().stream().map(Task::getEstimation).reduce(0, Integer::sum);
            stats.setPlannedEfforts(plannedEfforts);
            stats.setActualEfforts(getActualEfforts(project.getId()));
            return stats;
        }).toList();

        return projectStats;
    }

    /**
     * Gets actual Efforts from timeSpent by projectId
     * @param projectId
     * @return sum all timeSpent by projectId
     */
    public Integer getActualEfforts(UUID projectId) {

        return dataManager.loadValue("select SUM(t.timeSpent) from TimeEntry t " +
                "where t.task.project.id = :projectId", Integer.class)
                .parameter("projectId", projectId)
                .one();
    }
}