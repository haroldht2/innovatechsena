package com.registro.usuarios.modelo;

public enum Role {
	
    USER("User"),
    ADMIN("Admin"),
	OPERADOR("Operador");

    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

