package rocks.vinu.jenkinsdocker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home(HttpServletRequest httpServletRequest,
                                    @RequestHeader Map<String, String> headers) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ts", System.currentTimeMillis() + "");
        map.put("env", System.getenv());
        map.put("headers", headers);
        return map;
    }
}
