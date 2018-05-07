package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class Editors extends GenericJson {
    @Key
    private Boolean domainUsersCanEdit;
    @Key
    private List<String> groups;
    @Key
    private List<String> users;

    public Boolean getDomainUsersCanEdit() {
        return this.domainUsersCanEdit;
    }

    public Editors setDomainUsersCanEdit(Boolean bool) {
        this.domainUsersCanEdit = bool;
        return this;
    }

    public List<String> getGroups() {
        return this.groups;
    }

    public Editors setGroups(List<String> list) {
        this.groups = list;
        return this;
    }

    public List<String> getUsers() {
        return this.users;
    }

    public Editors setUsers(List<String> list) {
        this.users = list;
        return this;
    }

    public Editors set(String str, Object obj) {
        return (Editors) super.set(str, obj);
    }

    public Editors clone() {
        return (Editors) super.clone();
    }
}
