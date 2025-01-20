package com.umaxcode.springboot_security_oauth_actuator.service;

import com.umaxcode.springboot_security_oauth_actuator.domain.dto.request.LoginUserDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.dto.request.RegisterUserDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.dto.response.LoginSuccessDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.dto.response.RegisterSuccessDto;

public interface AuthenticationService {

     RegisterSuccessDto signup(RegisterUserDto request);

    LoginSuccessDto authenticate(LoginUserDto request);
}
