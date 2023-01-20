package by.hayel.license.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "example")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigurationService {
  String property;
}
