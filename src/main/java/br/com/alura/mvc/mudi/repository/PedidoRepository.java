package br.com.alura.mvc.mudi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Pedido;

@Repository
public class PedidoRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@SuppressWarnings("unchecked")
	public List<Pedido> recuraTodosOsPedidos(){
		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);		
		return query.getResultList();		  
	}
}
