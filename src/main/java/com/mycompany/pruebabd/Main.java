
package com.mycompany.pruebabd;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_PruebaBD_jar_1.0-SNAPSHOTPU"); 
        EntityManager em = emf.createEntityManager();
        
        //Provincia provinciaCadiz = new Provincia(0, "Cádiz");

        Provincia provinciaSevilla = new Provincia();
        provinciaSevilla.setNombre("Sevilla");

        em.getTransaction().begin();
        //em.persist(provinciaCadiz);
        em.persist(provinciaSevilla);
        em.getTransaction().commit();
        
        em.close(); 
        emf.close(); 
        try { 
            DriverManager.getConnection("jdbc:derby:BaseDatosPrueba;shutdown=true"); 
        } catch (SQLException ex) { 
        }
    }
    
}
