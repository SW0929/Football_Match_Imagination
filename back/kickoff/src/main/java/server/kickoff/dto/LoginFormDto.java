package server.kickoff.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginFormDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;
}
