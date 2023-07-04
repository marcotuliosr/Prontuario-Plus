package com.iftm.api.prontuarioplus.config;

import com.iftm.api.prontuarioplus.utils.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        // Via HEADER PARAM
        configurer.favorParameter(false) // Não aceita parametros pela url
                .ignoreAcceptHeader(false)   // aceita os parametros no header (não aceita pela url)
                .useRegisteredExtensionsOnly(false)   // usar apenas as extensões registradas -> false
                .defaultContentType(MediaType.APPLICATION_JSON)   // por padrão é JSON
                .mediaType("json", MediaType.APPLICATION_JSON)   // porém se o cliente passar como parametro o JSON, deve-se aceitar
                .mediaType("xml", MediaType.APPLICATION_XML)  // adicionando o mediatype do tipo XML
                .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter());
    }
}
