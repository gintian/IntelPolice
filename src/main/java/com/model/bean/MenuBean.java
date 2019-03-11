package com.model.bean;

import java.util.HashSet;
import java.util.Set;

import com.model.Menu;

/**
 * Created by Administrator on 2018/3/12 0012.
 */
public class MenuBean extends Menu{
    private Set<MenuBean> children = new HashSet<MenuBean>();

    public Set<MenuBean> getChildren() {
        return children;
    }

    public void setChildren(Set<MenuBean> children) {
        this.children = children;
    }
}
