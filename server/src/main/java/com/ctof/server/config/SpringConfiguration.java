package com.ctof.server.config;

import com.ctof.server.interceptor.LogInterceptor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import org.modelmapper.ModelMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
@EnableCaching
public class SpringConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
    }

    @Bean
    public CacheManager cacheManager() {
        return new RedisCacheManager(new RedisTemplate());
    }

    @Bean
    public ObjectMapper objectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new ISO8601DateFormat());
        objectMapper.registerModule(new LocalDateTimeModule());
        return objectMapper;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        converters.add(converter);
        super.configureMessageConverters(converters);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition((context) -> context.getSource() != null);
        return modelMapper;
    }

    public class LocalDateTimeModule extends SimpleModule {
        public LocalDateTimeModule() {
            super();
            addSerializer(LocalDateTime.class, new StdScalarSerializer<LocalDateTime>(LocalDateTime.class) {
                @Override
                public void serialize(LocalDateTime value,
                                      JsonGenerator jgen,
                                      SerializerProvider provider) throws IOException {
                    jgen.writeString(value.toString());
                }
            });
            addDeserializer(LocalDateTime.class, new StdScalarDeserializer<LocalDateTime>(LocalDateTime.class) {
                @Override
                public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                    JsonToken currentToken = jp.getCurrentToken();
                    if (currentToken == JsonToken.VALUE_STRING) {
                        String dateTimeAsString = jp.getText().trim();
                        return LocalDateTime.parse(dateTimeAsString);
                    }

                    throw ctxt.mappingException(handledType());
                }
            });
        }
    }
}
