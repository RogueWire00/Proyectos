/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial3.aplicacion.bd;

import hn.uth.pa1.parcial3.aplicacion.Palabras;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gustavo
 */
public class gestorJPA {

private static EntityManager em;

    public static void showError(String funcion, String mensaje) {
        System.out.println("Error " + funcion + ": " + mensaje);
    }

    public static EntityManager getEm() {
        try {
            String pu = "traductor?zeroDateTimeBehavior=convertToNullPU";

            EntityManagerFactory ef
                    = Persistence.createEntityManagerFactory(pu);
            return ef.createEntityManager();
        } catch (Exception e) {
            showError("getEm", e.toString());
        }
        return null;
    }

    public static void insertarPalabra(Palabras palabras) {
        iniciarTransaccion();
        em.persist(palabras);
        guardarCambios();
    }

    public static Palabras getPalabra(String Codigo) {
        return em.find(Palabras.class, Codigo);
    }

    public static void eliminarPalabra(Palabras palabras) {
        iniciarTransaccion();
        String Codigo=palabras.getCodigo();
        Palabras PalabraConsultada=getPalabra(Codigo);
        em.remove(PalabraConsultada);
        guardarCambios();
    }

    public static void actualizarPalabra(Palabras palabras) {
        iniciarTransaccion();
        
        String Codigo=palabras.getCodigo();
        Palabras PalabraConsultada=gestorJPA.getPalabra(Codigo);
        PalabraConsultada.setCodigo(palabras.getCodigo());
        PalabraConsultada.setIdioma(palabras.getIdioma());
        PalabraConsultada.setPalabraOrigen(palabras.getPalabraOrigen());
        PalabraConsultada.setPalabraResultado(palabras.getPalabraResultado());
       
        
        em.persist(PalabraConsultada);
        guardarCambios();
    }
    
    public static void iniciarTransaccion(){
        em=getEm();
        em.getTransaction().begin();
    }
    
    public static void guardarCambios(){
        em.getTransaction().commit();
    }
}
