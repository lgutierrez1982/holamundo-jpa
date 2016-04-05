package test;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.dominio.Persona;

public class TestEntidadPersona {
	
	static EntityManager em = null;
	static EntityTransaction tx = null;
	static EntityManagerFactory emf = null;
	Logger log = Logger.getLogger("TestEntidadPersona");
	
	@BeforeClass
	public static void init() throws Exception{
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}
	
	@Before
	public void setup(){
		try{
			em = emf.createEntityManager();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPersonaEntity(){
		log.debug("Iniciando test Persona Entity con JPA");
	
		assertTrue(em != null);
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		//No debemos especificar el ID, se genera en automatico
		Persona persona1 = new Persona("Luis", "Gutierrez", "Loyola", "lgutierrez1982@gmail.com", "68333444");
		
		log.debug("Objeto a persistir:" +persona1);//aun no cuenta cin llave primaria
		
		em.persist(persona1);//aun no se guarda en BD para guardarla se debe concluir la trx commmit
		
		tx.commit();//se guarda en BD y debe crearle automaticamente el id autoincremental
		
		log.debug("Objeto persistido:" +persona1);
		
		log.debug("Fin Test Persona Entity con JPA");
	}

}
