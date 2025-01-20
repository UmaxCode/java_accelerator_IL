package com.umaxcode.springboot_security_oauth_actuator.domain.enums;

public enum Role {

    USER, ADMIN;

    public String getUserRole() {
        return "ROLE_" + this.name();
    }
}
