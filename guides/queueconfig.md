# Configuração da fila no WildFly 10

* Acessar o administration console do WildFly

* Acessar: Configuration -> Subsystems -> Messaging - ActiveMQ

* Clicar em "default" e em "Queue/Topics"

* Escolher "Add" e inserir as configurações
  * Name: `DM110Queue`
  * JNDI Names: `java:/jms/queue/dm110queue`
