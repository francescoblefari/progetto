package it.francesco.progetto.conrollers;

import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin("http://localhost:4200")
public class DemoController {

    /*
    @GetMapping("/home")
    public String getIndex(@AuthenticationPrincipal OidcUser oidcUser) {
        return "<h1> ciao a " + oidcUser.getName() + "</h1>";
    }

    @GetMapping("/")
    public RedirectView message(@AuthenticationPrincipal OidcUser p) {
        RedirectView r = new RedirectView("http://localhost:4200/", true);
        r.addStaticAttribute("email", p.getEmail());
        return r;
    }*/


}
