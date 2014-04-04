/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.dao.service;

import com.jatismobile.workshop.model.Project;
import java.util.List;

/**
 *
 * @author lukman
 */
public interface ProjectDao {
    public void save(Project project);
    public void delete(Project project);
    public List findAll();
    public Project findById(int id);
}
