package br.com.fiap.helpcentern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;

@SpringBootApplication
@Theme(value = "my-theme", variant = "dark")
public class HelpcenterNApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(HelpcenterNApplication.class, args);
    }
}
