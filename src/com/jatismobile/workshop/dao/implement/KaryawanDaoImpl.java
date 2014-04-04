/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.dao.implement;

import com.jatismobile.workshop.dao.service.KaryawanDao;
import com.jatismobile.workshop.main.Main;
import com.jatismobile.workshop.model.Karyawan;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lukman
 */
public class KaryawanDaoImpl implements KaryawanDao{

    private SessionFactory sessionFactory;
    
    @Override
    public void save(Karyawan karyawan) {
        Session session = Main.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(karyawan);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        }
        session.close();
    }

    @Override
    public void delete(Karyawan karyawan) {
        Session session = Main.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(karyawan);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        }
        session.close();
    }

    @Override
    public List<Karyawan> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Karyawan").list();
    }

    @Override
    public Karyawan findById(int id) {
        return (Karyawan) sessionFactory.getCurrentSession().get(Karyawan.class, id);
    }

    @Override
    public List<Karyawan> findByName(String name) {
        return sessionFactory.getCurrentSession().createQuery("from Karyawan where namaKaryawan=:name")
                .setParameter("name", name).list();
    }
    
}
