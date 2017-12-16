package br.inatel.pos.mobile.dm110.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType",
								  propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination",
								  propertyValue = "java:/jms/queue/dm110queue"),
		@ActivationConfigProperty(propertyName = "maxSession",
								  propertyValue = "4")
})
public class HelloMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("#### Iniciando processamento...");
				Thread.sleep(10000);
				System.out.println("#### Processando mensagem: " +  text);
				Thread.sleep(10000);
				System.out.println("#### Finalizando processamento...");
			}
		} catch (JMSException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}







