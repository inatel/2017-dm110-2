package br.inatel.pos.mobile.dm110.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.inatel.pos.mobile.dm110.dao.ProductDAO;
import br.inatel.pos.mobile.dm110.entities.Product;
import br.inatel.pos.mobile.dm110.to.ProductTO;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType",
								  propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination",
								  propertyValue = "java:/jms/queue/InventoryQueue"),
		@ActivationConfigProperty(propertyName = "maxSession",
								  propertyValue = "4")
})
public class InventoryMDB implements MessageListener {

	@EJB
	private ProductDAO dao;

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof ObjectMessage) {
				ObjectMessage objMessage = (ObjectMessage) message;
				Object obj = objMessage.getObject();
				if (obj instanceof ProductTO) {
					ProductTO to = (ProductTO) obj;
					Product product = new Product();
					product.setName(to.getName());
					product.setQuantity(to.getQuantity());
					dao.insert(product);
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}





