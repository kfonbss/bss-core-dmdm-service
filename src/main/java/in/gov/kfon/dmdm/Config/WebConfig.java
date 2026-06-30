package in.gov.kfon.dmdm.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedOrigins(
                "http://localhost:5173",
                "https://dev.kfonbss.co.in",
                "https://dev.kfon.co.in",
                "https://qa.kfon.co.in",
                "https://*.sritindia.com",
                "https://bssdemo.sritindia.com")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
            .allowedHeaders("*")
            .allowCredentials(true);
      }
    };
  }
}
