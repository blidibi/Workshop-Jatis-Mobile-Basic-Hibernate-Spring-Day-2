/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.dao.service;

import com.jatismobile.workshop.model.Gaji;
import java.util.List;

/**
 *
 * @author lukman
 */
public interface GajiDao {
    public void save(Gaji gaji);
    public void delete(Gaji gaji);
    public List findAll();
    public Gaji findById(int id);
}
