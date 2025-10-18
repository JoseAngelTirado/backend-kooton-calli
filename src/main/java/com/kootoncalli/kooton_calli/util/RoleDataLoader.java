package com.kootoncalli.kooton_calli.util;

// ... (tus otros imports)
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.kootoncalli.kooton_calli.model.Role;
import com.kootoncalli.kooton_calli.repository.RoleRepository;

@Component
@Order(1)
@Profile("dev")
public class RoleDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RoleDataLoader.class);

    private final RoleRepository roleRepository;

    public RoleDataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Cargando datos iniciales para roles...");

        // Crear roles si no existen
        // CORRECCIÓN AQUÍ: de existsByName a existsByRoleName
        if (!roleRepository.existsByRoleName("Admin")) {
            roleRepository.save(new Role(null, "Admin"));
            log.info("Rol 'Admin' creado.");
        }

        // CORRECCIÓN AQUÍ: de existsByName a existsByRoleName
        if (!roleRepository.existsByRoleName("Customer")) {
            roleRepository.save(new Role(null, "Customer"));
            log.info("Rol 'Customer' creado.");
        }

        // Listar todos los roles en BD
        Iterable<Role> roles = roleRepository.findAll();
        for (Role role : roles) {
            log.info("Rol cargado: {}", role);
        }

        // Buscar un rol específico
        // CORRECCIÓN AQUÍ: de findByName a findByRoleName
        Optional<Role> adminRole = roleRepository.findByRoleName("Admin");
        if (adminRole.isPresent()) {
            log.info("Rol 'Admin' encontrado: {}", adminRole.get());
        } else {
            log.warn("Rol 'Admin' no encontrado.");
        }

        // Verificar existencia de otro rol
        // CORRECCIÓN AQUÍ: de existsByName a existsByRoleName
        boolean existingRole = roleRepository.existsByRoleName("Customer");
        log.info("¿Existe el rol 'Customer'? {}", existingRole);

        log.info("Carga de datos iniciales de roles completada.");
    }
}