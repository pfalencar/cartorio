package br.com.docket.hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.docket.modelo.Cartorio;

public class CartorioHibernate {
	private static CartorioHibernate instance;
	protected EntityManager entityManager;

	public static CartorioHibernate getInstance() {
		if (instance == null)	instance = new CartorioHibernate();
		return instance;
	}

	private CartorioHibernate() {
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("docketCartorios");
		if (entityManager == null) entityManager = factory.createEntityManager();
		return entityManager;
	}
	
	public void criarCartorio(Cartorio cartorio) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(cartorio);
			entityManager.getTransaction().commit();
		}		
		catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void editarCartorio(Cartorio cartorio) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(cartorio);
			entityManager.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public Cartorio visualizarCartorio(final int id) {
		return entityManager.find(Cartorio.class, id);
	}
	
	public void excluirCartorio(Cartorio cartorio) {
		try {
			entityManager.getTransaction().begin();
			cartorio = entityManager.find(Cartorio.class, cartorio.getId());
			entityManager.remove(cartorio);
			entityManager.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void excluirCartorioPorID(final int id) {
		try {
			Cartorio cartorio = visualizarCartorio(id);
			excluirCartorio(cartorio);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cartorio> listarCartorios() {
		return entityManager.createQuery("FROM " + Cartorio.class.getName()).getResultList();
	}
	
}