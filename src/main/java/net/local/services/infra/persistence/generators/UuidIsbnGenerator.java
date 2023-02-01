package net.local.services.infra.persistence.generators;

import java.util.UUID;

import net.local.services.application.ports.persistence.IsbnGenerator;

public class UuidIsbnGenerator implements IsbnGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
    
}
