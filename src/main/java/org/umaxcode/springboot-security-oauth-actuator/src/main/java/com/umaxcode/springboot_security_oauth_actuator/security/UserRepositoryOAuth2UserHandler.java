package com.umaxcode.springboot_security_oauth_actuator.security;

import com.umaxcode.springboot_security_oauth_actuator.domain.entity.User;
import com.umaxcode.springboot_security_oauth_actuator.domain.enums.Role;
import com.umaxcode.springboot_security_oauth_actuator.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserRepositoryOAuth2UserHandler implements Consumer<OAuth2User> {

    private final UserRepository userRepository;
    private final JWTService jwtService;

    @Override
    public void accept(OAuth2User oAuth2User) {
        // Capture user in a local data store on first authentication
        String email = oAuth2User.getAttribute("email");
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            log.info("Saving first-time user: name={}, claims={}, authorities={}", oAuth2User.getName(), oAuth2User.getAttributes(), oAuth2User.getAuthorities());
            User userInstance = User.builder()
                    .username(oAuth2User.getAttribute("given_name"))
                    .email(email)
                    .role(Role.USER)
                    .build();
            user = this.userRepository.save(userInstance);
        }

        String token = jwtService.generateToken(SecureUser.builder()
                .user(user)
                .build());

        // Send the token as a response (assumes HttpServletResponse is available)
        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
        if (response != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            try {
                response.getWriter().write("{\"token\": \"" + token + "\"}");
                response.getWriter().flush();
            } catch (IOException e) {
                log.error("Error writing token to response", e);
            }
        }
    }

}
