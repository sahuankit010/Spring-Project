package springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/secure")
    public String secure() {
        return "secure";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
