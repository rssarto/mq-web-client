package mq.client.controllers;

import mq.client.model.dto.MessageDTO;
import mq.client.services.MessageConnector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = MessageController.URI_PREFIX)
@RestController
public class MessageController {
    public static final String URI_PREFIX = "/api/v1/message";

    private final MessageConnector messageConnector;

    public MessageController(MessageConnector messageConnector) {
        this.messageConnector = messageConnector;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void sendMessage(@RequestBody @Valid MessageDTO messageDTO){
        this.messageConnector.send(messageDTO);
    }

    @GetMapping
    public ResponseEntity<MessageDTO> receiveMessage(){
        final MessageDTO responseMessage = this.messageConnector.receive();
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
