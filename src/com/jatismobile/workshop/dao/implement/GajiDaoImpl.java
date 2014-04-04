/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.dao.implement;

import com.jatismobile.workshop.dao.service.GajiDao;
import com.jatismobile.workshop.main.Main;
import com.jatismobile.workshop.model.Gaji;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lukman
 */
public class GajiDaoImpl implements GajiDao{

    private SessionFactory sessionFactory;
    
    @Override
    public void save(Gaji gaji) {
        Session session = Main.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(gaji);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        }
        session.close();
    }

    @Override
    public void delete(Gaji gaji) {
        Session session = Main.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(gaji);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        }
        session.close();
    }

    @Override
    public List findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Gaji").list();
    }

    @Override
    public Gaji findById(int id) {
        return (Gaji) sessionFactory.getCurrentSession().get(Gaji.class, id);
    }
    
}
