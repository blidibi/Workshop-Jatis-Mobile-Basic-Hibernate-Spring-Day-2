/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.dao.service;

import com.jatismobile.workshop.model.Karyawan;
import java.util.List;

/**
 *
 * @author lukman
 */
public interface KaryawanDao {
    public void save(Karyawan karyawan);
    public void delete(Karyawan karyawan);
    public List<Karyawan> findAll();
    public Karyawan findById(int id);
    public List<Karyawan> findByName(String name);
}
