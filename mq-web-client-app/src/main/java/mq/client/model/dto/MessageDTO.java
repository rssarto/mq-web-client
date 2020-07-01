package mq.client.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    @NotBlank(message = "O campo mensagem é obrigatório")
    private String message;

}
