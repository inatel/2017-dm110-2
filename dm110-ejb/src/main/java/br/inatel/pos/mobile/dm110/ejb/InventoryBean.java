package br.inatel.pos.mobile.dm110.ejb;

import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import br.inatel.pos.mobile.dm110.dao.ProductDAO;
import br.inatel.pos.mobile.dm110.entities.Product;
import br.inatel.pos.mobile.dm110.interfaces.InventoryLocal;
import br.inatel.pos.mobile.dm110.interfaces.InventoryRemote;
import br.inatel.pos.mobile.dm110.to.ProductTO;

@Stateless
@Local(InventoryLocal.class)
@Remote(InventoryRemote.class)
public class InventoryBean implements InventoryLocal, InventoryRemote {

	@EJB
	private ProductDAO dao;

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/queue/InventoryQueue")
	private Queue queue;

	@Override
	public void addNewProduct(ProductTO to) {
		try (
				Connection connection = connectionFactory.createConnection();
				Session session = connection.createSession();
				MessageProducer producer = session.createProducer(queue);
		) {
			ObjectMessage objMessage = session.createObjectMessage();
			objMessage.setObject(to);
			producer.send(objMessage);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String[] listProductNames() {
		return dao.findAll()
				.stream()
				.map(Product::getName)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

	@Override
	public ProductTO[] listProducts() {
		return dao.findAll()
				.stream()
				.map(p -> {
					ProductTO to = new ProductTO();
					to.setId(p.getId());
					to.setName(p.getName());
					to.setQuantity(p.getQuantity());
					return to;
				}).collect(Collectors.toList())
				.toArray(new ProductTO[0]);
	}

}









