/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mati
 */
public class HibernateEjemplo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.addClass(Profesor.class);
// Read mappings as a application resourceName
        // addResource is for add hbml.xml files in case of declarative approach
      
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();

        Profesor prof1 = new Profesor(101, "Juan", "Perez", "Perez");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(prof1);
        
        session.getTransaction().commit();
        session.close();
        System.out.println("dembow");

    }

}
