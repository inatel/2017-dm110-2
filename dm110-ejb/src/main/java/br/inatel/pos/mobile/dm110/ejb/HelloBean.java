package br.inatel.pos.mobile.dm110.ejb;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.pos.mobile.dm110.interfaces.HelloLocal;
import br.inatel.pos.mobile.dm110.interfaces.HelloRemote;

@Stateless
@Local(HelloLocal.class)
@Remote(HelloRemote.class)
public class HelloBean implements HelloLocal, HelloRemote {

	@EJB
	private HelloMessageSender messageSender;

	@Override
	public String sayHello(String name) {
		messageSender.sendTextMessage(name);
		return "Hello " + name + "!!!";
	}

}
