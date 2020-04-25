package wooteco.helloworld.controller;

import org.springframework.web.bind.annotation.*;
import wooteco.helloworld.domain.User;

import java.util.Map;

@RestController
public class UserController {
    /**
     * GET /users
     */
    @GetMapping("/users")
    public String sayHi(String name) {//쿼리스트링으로 날린 정보는 인자로 받아서 처리. 앞에 @RequestParam붙여서 추가정보 나타낼수도 있음
        return "Hi " + name;
    }

    /**
     * POST /users
     */
    @PostMapping("/users")
    public String createUserWithJson(@RequestBody User user) {//body에 정보를 포함되어서 왔다면 이렇게 받아야 함
        return "Hello " + user.getName();
    }

    /**
     * POST /users/form
     */
    @PostMapping("/users/form")
    public String createUserWithForm(@RequestParam Map<String, String> paramMap) {//form형식으로 param에 담겨왔을때
        return "Hello " + paramMap.get("name");
    }

    /**
     * GET /users/{id}
     */
    @GetMapping("/users/{id}")
    public String retrieveUser(@PathVariable Long id) {//path로 받는 정보는 이렇게 처리
        return "user's id is " + id;
    }

}