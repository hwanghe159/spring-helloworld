package wooteco.helloworld.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wooteco.helloworld.domain.User;

@Controller//모든 메서드에 @ResponseBody가 붙으면 @RestController로 바꾸고 @ResponseBody제거 가능
public class WelcomeController {
    /**
     * GET /welcome
     */
    @GetMapping("/welcome")
    @ResponseBody//얘를 붙임으로써 문자열로 응답할 수 있게됨
    public String welcome() {
        return "welcome";
    }

    /**
     * GET /welcome-page
     */
    @GetMapping("/welcome-page")
    public String welcomePage(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);//model에 add하여 프론트에 전달 가능
        return "welcome";
    }

    /**
     * GET /welcome-user
     */
    @GetMapping("/welcome-user")
    public ResponseEntity welcomeUser() {
        return ResponseEntity.ok(new User("브라운", "brown@email.com", 20));
    }

    @GetMapping("/post-form")
    public String postForm() {
        return "post_form";
    }
}