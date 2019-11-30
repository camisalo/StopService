package pl.agh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.agh.stopapp.repository.StopRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses= {StopRepository.class})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
