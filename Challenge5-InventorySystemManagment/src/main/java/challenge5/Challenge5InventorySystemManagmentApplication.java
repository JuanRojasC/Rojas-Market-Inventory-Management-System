package challenge5;

import challenge5.Model.DAO.IDAO;
import challenge5.Model.DAO.Implement.ProductImplementation;
import challenge5.Model.ProductRepository;
import challenge5.Model.ProductService;
import challenge5.View.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@ComponentScan("challenge5.Model")
@EnableJdbcRepositories("challenge5.Model")
public class Challenge5InventorySystemManagmentApplication {

    @Autowired
    ProductRepository repositorio;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Challenge5InventorySystemManagmentApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            IDAO productImplementation = ProductImplementation.getInstance(repositorio);
            MainWindow mainWindow = MainWindow.getInstance();
            mainWindow.initWindow();
        };
    }

}
