package jp.ibmcsm.messaging;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSConsumer ;
import jakarta.jms.Destination;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;

@Stateless
public class MQConsumer {

    @Inject
    @JMSConnectionFactory("jms/wmqCF")
    JMSContext context;
  
    @Resource(lookup = "jms/queue1")
    Destination  dest;
  
    public String recvMessage() throws Exception {
      String text = null;
      JMSConsumer  consumer = context.createConsumer(dest);

      Message message = consumer.receive();
      if (message instanceof TextMessage) {
        TextMessage textMessage = (TextMessage) message;
        text = textMessage.getText();
      }
      return text + " dequeued.";
    }
  
}
