package com.company.projectmanager.view.taskdetail;


import com.company.projectmanager.entity.Task;
import com.company.projectmanager.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "task/:id", layout = MainView.class)
@ViewController(id = "Task_.detail")
@ViewDescriptor(path = "task-detail-view.xml")
@EditedEntityContainer("taskDc")
public class TaskDetailView extends StandardDetailView<Task> {
}