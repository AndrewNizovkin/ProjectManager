package com.company.projectmanager.view.projectstats;

import com.company.projectmanager.app.ProjectStatsService;
import com.company.projectmanager.entity.ProjectStats;
import com.company.projectmanager.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "projectStatses", layout = MainView.class)
@ViewController(id = "ProjectStats.list")
@ViewDescriptor(path = "project-stats-list-view.xml")
@LookupComponent("projectStatsesDataGrid")
@DialogMode(width = "50em")
public class ProjectStatsListView extends StandardListView<ProjectStats> {
    @Autowired
    private ProjectStatsService projectStatsService;

    @Install(to = "projectStatsesDl", target = Target.DATA_LOADER)
    protected List<ProjectStats> projectStatsesDlLoadDelegate(LoadContext<ProjectStats> loadContext) {
        // Here you can load entities from an external storage.
        // Set the loaded entities to the not-new state using EntityStates.setNew(entity, false).
        return projectStatsService.fetchProjectStatistics();
    }
}
