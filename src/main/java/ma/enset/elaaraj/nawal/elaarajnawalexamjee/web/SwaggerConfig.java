package ma.enset.elaaraj.nawal.elaarajnawalexamjee.web;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API Gestion Assurance",
                version = "1.0",
                description = "API REST pour la gestion des contrats d'assurance - ENSET Exam JEE"
        )
)
public class SwaggerConfig {}