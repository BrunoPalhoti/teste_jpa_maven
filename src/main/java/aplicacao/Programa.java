package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
	
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		Pessoa p4 = new Pessoa(null, "Isadora Palhoti", "isadora@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		 
		// aonde add pessoas no banco de dados
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.getTransaction().commit();
		
		//aonde eu faço a pesquisa de uma pessoa no banco de dados
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		//aonde eu faço a remoção de uma pessoa no banco de daodos
		Pessoa deletar = em.find(Pessoa.class, 4);
		em.getTransaction().begin();
		em.remove(deletar);
		em.getTransaction().commit();
		
		System.out.println("Pronto");
		em.close();
		emf.close();
		
	}
}
