package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null,"Herbert Vianna", "hebert@email.com");
		Pessoa p2 = new Pessoa(null,"Marcela Lopes", "marcela@email.com");
		Pessoa p3 = new Pessoa(null,"Bruna Marquezine", "bruna@email.com");
		Pessoa p4 = new Pessoa(null,"Lucas Lucco", "lucco@email.com");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Buscar registro no BD com o ID 2
		
		//Pessoa pessoa = entityManager.find(Pessoa.class, 2);
		
		//System.out.println(pessoa);
		
		entityManager.getTransaction().begin();
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		entityManager.persist(p4);
		entityManager.getTransaction().commit();
		
		System.out.println("Dados Gravados Com Sucesso!!!");
		System.out.println("Fechando a conexão!");

		
		entityManager.close();
		entityManagerFactory.close();		

	}

}
