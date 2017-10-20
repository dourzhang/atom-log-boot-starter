package com.watent.log.filter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties("atom.log")
public class AccountFilterProperties {
    private String key = "key";
}
