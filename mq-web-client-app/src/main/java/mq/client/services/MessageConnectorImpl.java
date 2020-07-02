package mq.client.services;

import lombok.extern.slf4j.Slf4j;
import mq.client.config.ConnectionConfigProperties;
import mq.client.model.dto.MessageDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class MessageConnectorImpl implements MessageConnector {

    private final ApplicationContext applicationContext;
    private final JmsTemplate jmsTemplate;
    private final ConnectionConfigProperties connectionConfigProperties;

    public MessageConnectorImpl(ApplicationContext applicationContext,
                                ConnectionConfigProperties connectionConfigProperties) {
        this.applicationContext = applicationContext;
        this.connectionConfigProperties = connectionConfigProperties;
        this.jmsTemplate = this.applicationContext.getBean(JmsTemplate.class);
    }

    @Override
    public void send(MessageDTO messageDTO) {
        try{
            if(log.isDebugEnabled()){
                log.info("enviando mensagem para o mq '{}'", messageDTO.getMessage());
            }
            log.info("enviando mensagem com tamanho de: {} caracteres", messageDTO.getMessage().length());
            this.jmsTemplate.convertAndSend(this.connectionConfigProperties.getQueue(), messageDTO.getMessage());
            log.info("mensagem enviada com sucesso.");
        }catch (JmsException ex){
            log.error("falha ao tentar comunicacao com mq", ex);
            throw ex;
        }catch (Exception ex){
            log.error("falha inesperada ao tentar comunicacao com o mq", ex);
            throw ex;
        }
    }

    @Override
    public MessageDTO receive() {
        try {
            final MessageDTO messageDTO = new MessageDTO();
            log.info("solicitando mensagem na fila {}", this.connectionConfigProperties.getQueue());
            final Object response = this.jmsTemplate.receiveAndConvert(this.connectionConfigProperties.getQueue());
            if (Objects.nonNull(response)) {
                messageDTO.setMessage(Objects.toString(response));
                if(log.isDebugEnabled()){
                    log.info("mensagem recebida {}", messageDTO.getMessage());
                }
                log.info("tamanho da mensagem rebida: {} caracteres", messageDTO.getMessage().length());
            } else {
                log.info("nenhuma mensagem encontrada na fila {}", this.connectionConfigProperties.getQueue());
            }
            return messageDTO;
        } catch (JmsException ex) {
            log.error("falha ao tentar comunicacao com mq", ex);
            throw ex;
        } catch (Exception ex) {
            log.error("falha inesperada ao tentar comunicacao com o mq", ex);
            throw ex;
        }
    }
}
