package com.bookshopapp;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import com.bookshopapp.model.repository.BookRepo;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(SpringRunner.class)
@PactFolder("../acceptedPacts")
@Provider("mybookservice")
@VerificationReports({ "console", "markdown", "json" })
@SpringBootTest
public class BookShopMaintenanceApplicationTests {
        private static BookRepo repo;
        private int PORT = 8090;
        @TestTarget
	public final Target target = new HttpTarget("http", "localhost", PORT);
	
        @BeforeClass
	public static void start() {
		System.setProperty("pact.provider.version", "94");
		ConfigurableApplicationContext context = SpringApplication.run(BookShopMaintenanceApplication.class);
		repo = context.getBean(BookRepo.class);
        }
	
        @Test
	public void contextLoads() {
	}
}
