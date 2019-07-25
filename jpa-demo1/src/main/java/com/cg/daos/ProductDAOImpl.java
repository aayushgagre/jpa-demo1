package com.cg.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.entities.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void save(Product p) {
		// TODO Auto-generated method stub
		em.persist(p);
		em.flush();
	}

	public Product findById(Integer productId) {
		// TODO Auto-generated method stub
		return em.find(Product.class, productId);
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("from Product p"); //That's \"JPQL\" not SQL !!!
		 return q.getResultList();
	}

}
