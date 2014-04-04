/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

/**
 *
 * @author lukman
 */
@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private long id;
    @Column(name = "project_name")
    private String projectName;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datestart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateend;
    @ManyToMany
    @JoinTable(name = "JOIN_KARYAWAN_PROJECT",joinColumns= {@JoinColumn(name = "project_id")},inverseJoinColumns = {@JoinColumn(name = "karyawan_id")})
    private List<Karyawan> listKaryawan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }

    public List<Karyawan> getListKaryawan() {
        return listKaryawan;
    }

    public void setListKaryawan(List<Karyawan> listKaryawan) {
        this.listKaryawan = listKaryawan;
    }
}
