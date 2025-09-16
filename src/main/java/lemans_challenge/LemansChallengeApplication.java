package lemans_challenge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class LemansChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemansChallengeApplication.class, args);
	}

	@Bean
	public CommandLineRunner showDb(DataSource ds) {
		return args -> {
			try (var conn = ds.getConnection();
				 var rs   = conn.createStatement().executeQuery("SELECT DATABASE()")) {
				if (rs.next()) {
					System.out.println(">>> conectado ao schema: " + rs.getString(1));
				}
			}
		};
	}

}
