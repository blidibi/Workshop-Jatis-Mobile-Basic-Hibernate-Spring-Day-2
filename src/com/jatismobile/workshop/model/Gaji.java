/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author lukman
 */
@Entity
public class Gaji implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "gaji_id")
    private long idGaji;
    private Double nominal;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="tanggal_gajian")
    private Date tanggalGajian;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "karyawan_id", nullable = false)
    private Karyawan karyawan;

    public long getIdGaji() {
        return idGaji;
    }

    public void setIdGaji(long idGaji) {
        this.idGaji = idGaji;
    }

    public Double getNominal() {
        return nominal;
    }

    public void setNominal(Double nominal) {
        this.nominal = nominal;
    }

    public Date getTanggalGajian() {
        return tanggalGajian;
    }

    public void setTanggalGajian(Date tanggalGajian) {
        this.tanggalGajian = tanggalGajian;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }
    
}
