package pe.sysrasoc.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
@GetMapping
public String mensaje() {
	return "Spring Oracle";
	}
}
