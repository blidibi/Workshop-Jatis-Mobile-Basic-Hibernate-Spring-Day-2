/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author lukman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static SessionFactory sessionFactory;
    
    public static void main(String[] args) {
        sessionFactory = buildSessionFactory();
    }
     
    private static SessionFactory buildSessionFactory() {
        try {
            return new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static void shutdown() {
    	sessionFactory.close();
    }
}
