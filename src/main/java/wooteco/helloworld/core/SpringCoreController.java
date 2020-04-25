package wooteco.helloworld.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCoreController {
    @Autowired
    private SpringCoreService springCoreService;

    @GetMapping("/my-name")
    public String myName(@RequestParam String name) throws InterruptedException {
        return springCoreService.sayName(name);
    }
}
