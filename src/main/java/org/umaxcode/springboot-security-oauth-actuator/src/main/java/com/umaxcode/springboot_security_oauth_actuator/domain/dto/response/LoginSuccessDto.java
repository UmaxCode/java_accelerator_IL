package com.umaxcode.springboot_security_oauth_actuator.domain.dto.response;

import lombok.Builder;

@Builder
public record LoginSuccessDto (
     String accessToken
){
}
