package com.company.projectmanager.view.timeentry;

import com.company.projectmanager.entity.TimeEntry;
import com.company.projectmanager.entity.User;
import com.company.projectmanager.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Route(value = "timeEntries/:id", layout = MainView.class)
@ViewController(id = "TimeEntry.detail")
@ViewDescriptor(path = "time-entry-detail-view.xml")
@EditedEntityContainer("timeEntryDc")
@DialogMode(width = "AUTO", height = "AUTO")
public class TimeEntryDetailView extends StandardDetailView<TimeEntry> {

    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<TimeEntry> event) {
        event.getEntity().setEntryDate(LocalDateTime.now());
        final User user = (User) currentAuthentication.getUser();
        event.getEntity().setUser(user);
    }
}