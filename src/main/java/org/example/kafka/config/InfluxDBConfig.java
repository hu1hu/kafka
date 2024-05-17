package org.example.kafka.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Data
@Configuration
public class InfluxDBConfig {
    @Value("${spring.influx.url}")
    private String url;

    @Value("${spring.influx.token}")
    private String token;

    @Value("${spring.influx.org}")
    private String org;

    @Value("${spring.influx.bucket}")
    private String bucket;

}
