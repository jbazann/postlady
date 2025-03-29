package dev.jbazann.postlady.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Theme("my-theme")
public class ServerApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
