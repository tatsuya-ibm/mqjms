package jp.ibmcsm.rest;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jp.ibmcsm.messaging.MQProducer;
import jp.ibmcsm.messaging.MQConsumer;

@Path("/mq")
@Stateless
public class MessageApi {

    @Inject
    MQProducer producer;

    @Inject
    MQConsumer consumer;

    @GET
    @Path("/send")
    public String send(@QueryParam("msg") String message) throws Exception {
      // 1件メッセージ送信
      return producer.sendMessage(message);
    }

    @GET
    @Path("/recv")
    public String recv() throws Exception {
      // 1件メッセージ受信
      return consumer.recvMessage();
    }

}
