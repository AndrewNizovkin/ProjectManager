package com.company.projectmanager.security;

import com.company.projectmanager.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "ProjectManager", code = ProjectManagerRole.CODE)
public interface ProjectManagerRole {
    String CODE = "project-manager";

    @EntityAttributePolicy(entityClass = ProjectStats.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = ProjectStats.class, actions = EntityPolicyAction.ALL)
    void projectStats();

    @EntityAttributePolicy(entityClass = Task.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Task.class, actions = EntityPolicyAction.ALL)
    void task();

    @EntityAttributePolicy(entityClass = TimeEntry.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = TimeEntry.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.CREATE, EntityPolicyAction.DELETE})
    void timeEntry();

    @EntityAttributePolicy(entityClass = User.class, attributes = {"firstName", "lastName", "id"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = User.class, attributes = {"version", "username", "password", "email", "active", "timeZoneId", "avatar"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = {EntityPolicyAction.UPDATE, EntityPolicyAction.READ})
    void user();

    @MenuPolicy(menuIds = {"User.list", "Project.list", "TimeEntry.list", "Task_.list", "ProjectStats.list"})
    @ViewPolicy(viewIds = {"User.list", "Project.list", "TimeEntry.list", "Task_.list", "ProjectStats.list", "Project.detail", "Task__.detail", "Task_.detail", "TimeEntry.detail", "LoginView", "MainView"})
    void screens();

    @SpecificPolicy(resources = "ui.loginToUi")
    void specific();

    @EntityAttributePolicy(entityClass = Project.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Project.class, actions = EntityPolicyAction.ALL)
    void project();
}