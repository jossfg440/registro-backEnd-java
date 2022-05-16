package ec.gob.como;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//(scanBasePackages = {"test"} , exclude = JpaRepositoriesAutoConfiguration.class)
@EnableTransactionManagement
public class ClienteAplicacionLauncher {
	public static void main(String[] args) {
        SpringApplication.run(ClienteAplicacionLauncher.class);
    }

}
