/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.dao.implement;

import com.jatismobile.workshop.dao.service.ProjectDao;
import com.jatismobile.workshop.main.Main;
import com.jatismobile.workshop.model.Project;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lukman
 */
public class ProjectDaoImpl implements ProjectDao{

    private SessionFactory sessionFactory;
    
    @Override
    public void save(Project project) {
        Session session = Main.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(project);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        }
        session.close();
    }

    @Override
    public void delete(Project project) {
        Session session = Main.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(project);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        }
        session.close();
    }

    @Override
    public List findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Project").list();
    }

    @Override
    public Project findById(int id) {
        return (Project) sessionFactory.getCurrentSession().get(Project.class, id);
    }
}
