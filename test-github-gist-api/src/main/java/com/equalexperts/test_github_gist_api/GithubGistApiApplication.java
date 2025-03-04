package com.equalexperts.test_github_gist_api;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class GithubGistApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubGistApiApplication.class, args);
    }

    @GetMapping("/{user}")
    public List<Map<String, Object>> getUserGists(@PathVariable String user) {
        String url = "https://api.github.com/users/" + user + "/gists";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, List.class);
    }
}
