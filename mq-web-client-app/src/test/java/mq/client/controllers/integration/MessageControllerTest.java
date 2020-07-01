package mq.client.controllers.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import mq.client.controllers.MessageController;
import mq.client.model.dto.MessageDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void startContext(){
    }

    @Test
    public void sendMessage() throws Exception {
        final MessageDTO messageDTO = new MessageDTO("test message");
        this.mockMvc.perform(MockMvcRequestBuilders.post(MessageController.URI_PREFIX)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(messageDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void sendMessage_withNoContent_shouldReturnBadRequest() throws Exception {
        final MessageDTO messageDTO = new MessageDTO();
        this.mockMvc.perform(MockMvcRequestBuilders.post(MessageController.URI_PREFIX)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(messageDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(mvcResult -> {
                    log.info("Api response: {}", mvcResult.getResponse().getContentAsString());
                    Assertions.assertThat(mvcResult.getResponse().getContentAsString()).isNotBlank();
                });
    }

}