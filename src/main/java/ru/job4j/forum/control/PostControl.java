package ru.job4j.forum.control;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/post")
    public String post(@RequestParam(value = "id") int id, Model model) {
        Post post = posts.findPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", posts.getCommentsForPostAsList(post));
        return "post";
    }
}
