/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author lukman
 */
@Entity
public class Karyawan implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "karyawan_id")
    private long idKaryawan;
    @Column(name = "nama_karyawan")
    private String namaKaryawan;
    private String alamat;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "karyawan")
    private List<Gaji> listgaji;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "listKaryawan")
    private List<Project> listProject;

    public long getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(long idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<Gaji> getListgaji() {
        return listgaji;
    }

    public void setListgaji(List<Gaji> listgaji) {
        this.listgaji = listgaji;
    }

    public List<Project> getListProject() {
        return listProject;
    }

    public void setListProject(List<Project> listProject) {
        this.listProject = listProject;
    }
}
