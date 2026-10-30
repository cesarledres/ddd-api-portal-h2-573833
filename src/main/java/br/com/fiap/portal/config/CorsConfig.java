package br.com.fiap.portal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {
    public CorsFilter corsFilter(){
        CorsConfiguration config = new CorsConfiguration();

        //apontar o endereço do front-end
        config.setAllowedOrigins(List.of(
                "http://localhost:5173"
        ));

        //definindo os metodos do http que podem ser acessados
        config.setAllowedMethods(List.of(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "PATCH"
        ));

        //informando as propriedades do cabeçalho
        config.setAllowedHeaders(List.of(
                "Content-Type",
                "Autorization"
        ));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
