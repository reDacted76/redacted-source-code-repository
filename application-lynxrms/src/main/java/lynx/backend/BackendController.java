package lynx.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BackendController {

    private String mode;
    private String name;
    private String module;
    private String version;
    private String developer;


    @Autowired
    public void getBackendProperties(Environment environment) {
        mode = environment.getProperty("application.mode");
        name = environment.getProperty("application.name");
        module = environment.getProperty("application.module");
        version = environment.getProperty("application.version");
        developer = environment.getProperty("application.developer");
    }


    @RequestMapping("/")
    public String viewIndex(Model model) {
        model.addAttribute("mode", mode);
        model.addAttribute("name", name);
        model.addAttribute("name", module);
        model.addAttribute("version", version);
        model.addAttribute("developer", developer);
        return "template";
    }
}
