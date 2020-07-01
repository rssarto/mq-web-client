package mq.client.services;

import mq.client.model.dto.MessageDTO;

public interface MessageConnector {
    void send(MessageDTO messageDTO);
    MessageDTO receive();
}
