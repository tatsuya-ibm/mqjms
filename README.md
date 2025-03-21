## Preparations:
Please change all instances of XXXXXXXX in server.xml to match the MQ you are using.  
channel is a server connection channel such as 'CLOUD.APP.SVRCONN'.  

## Execute
After Liberty enabled to your computer and download repogitory, execute the following command.   
mvn liberty:dev -DserverStartTimeout=180  

## Access:
Please send a request to the following URLs from your browser.  

### Send:
Sends one message to specified MQ queue. The XXXX part will be the message data sent to MQ.  
http://localhost:9080/mqjms/mq/send?msg=XXXX

### Recieve:
Retrieves one message from specified MQ queue.  
http://localhost:9080/mqjms/mq/recv
