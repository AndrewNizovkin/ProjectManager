package com.company.projectmanager.security;

import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "CombinedProjectManagerRole", code = CombinedProjectManagerRole.CODE)
public interface CombinedProjectManagerRole extends ProjectManagerRole, UiMinimalRole{
    String CODE = "combined-project-manager-role";
}