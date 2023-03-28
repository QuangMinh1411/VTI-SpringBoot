package vn.training.vti.i18demo.config;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleResolverConfig {
    @Bean
    public LocaleResolver localeResolver(){
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        AcceptHeaderLocaleResolver headerLocaleResolver = new AcceptHeaderLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(Locale.US);
        headerLocaleResolver.setDefaultLocale(Locale.US);
//        return sessionLocaleResolver;
        return headerLocaleResolver;
    }

}
