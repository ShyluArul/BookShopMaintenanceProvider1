package com.bookshopapp;
import java.util.Arrays;
import java.util.Map;
import org.apache.http.HttpRequest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.bookshopapp.model.entities.Book;
import com.bookshopapp.model.repository.BookRepo;
import com.bookshopapp.model.service.BookService;
import au.com.dius.pact.provider.junit.IgnoreNoPactsToVerify;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.TargetRequestFilter;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
@RunWith(PactRunner.class)
@PactFolder("../acceptedPacts")
@Provider("mybookservice")
@VerificationReports({"console", "markdown", "json"})
@IgnoreNoPactsToVerify
public class BookShopMaintenanceApplicationTests {
	private int PORT = 8090;

	@TestTarget
	public final Target target = new HttpTarget("http", "localhost", PORT);
	private static ConfigurableApplicationContext applicationContext;

	@BeforeClass
	public static void start() {
		System.setProperty("pact.provider.version", "94");
		SpringApplication.run(BookShopMaintenanceApplication.class);
	}
	
        // This method acts as an interceptor before the validation happens
	// so if the provider needs to inject andything in the header or body
	// like access token,encrypted password can be done in a secured way
	// without putting the secret/access token in the pact document
	@TargetRequestFilter
	public void printTheRequestHeaders(HttpRequest request) {
		Arrays.asList(request.getAllHeaders())
				.forEach(header -> System.out.println(header.getName() + "->" + header.getValue()));
	}

	@State("SomeState")
	public void withSomeState() {
		System.out.println("do something with state");
		BookService bookservice = applicationContext.getBean(BookService.class);
		bookservice.addBook(new Book("C++", 324, "Manoj", 2001));
	}

	@State("SomeStateWithMap")
	public void withSomeStateAndMap(Map<String, Object> params) {
		System.out.println("do something with state");
		params.forEach((key, value) -> System.out.println(key + " -> " + value));
		BookService bookservice = applicationContext.getBean(BookService.class);
		@SuppressWarnings("unchecked")
		Map<String, Object> values = (Map<String, Object>) params.get("MyKey");
		Book bookFromParseInPactState = new Book(values.get("bookName").toString(),
				Double.parseDouble(values.get("bookPrice").toString()), values.get("publisherName").toString(),
				Integer.parseInt(values.get("publishingYear").toString()));
		bookservice.addBook(bookFromParseInPactState);
	}
}
