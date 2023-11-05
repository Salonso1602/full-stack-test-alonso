package com.api.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("file-locations")
public record DataLocationConfig(String compensation, String employee) {

}
