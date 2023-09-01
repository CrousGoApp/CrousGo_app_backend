package com.imt.fw.crousgo_app_backend;

import com.imt.fw.crousgo_app_backend.config.CORSFilter;
import com.imt.fw.crousgo_app_backend.resources.*;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("crousgo_app_backend")
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UserResource.class);
        register(AllergenResource.class);
        register(CategorieResource.class);
        register(ClassroomResource.class);
        register(DishResource.class);
        register(OrderResource.class);
        register(CORSFilter.class);

    }
}
