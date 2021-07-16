package ru.job4j.forum;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.control.PostControl;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService posts;

    @MockBean
    private UserService users;

    @Test
    @WithMockUser
    public void whenPostThenReturnPost() throws Exception {
        this.mockMvc.perform(get("/post")
        .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

    @Test
    @WithMockUser
    public void whenCreateThenReturnEdit() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void whenSaveThenRedirect() throws Exception {
        PostControl mockPostControl = PowerMockito.spy(new PostControl(posts, users));
        PowerMockito.when(mockPostControl, "findUserByPrincipal").thenReturn(User.of("Robert"));
        this.mockMvc.perform(post("/save")
        .param("name", "New BMW for sale."))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(posts).save(argument.capture());
        assertThat(argument.getValue().getAuthor().getUsername(), is("Robert"));
        assertThat(argument.getValue().getName(), is("New BMW for sale."));
    }

    @Test
    @WithMockUser
    public void whenCommentThenReturnPost() throws Exception {
        Post post = Post.of("First post");
        post.setAuthor(User.of("Oleg"));
        when(posts.findPostById(1)).thenReturn(post);

        this.mockMvc.perform(post("/comment")
                .param("postId", "1")
                .param("text", "Commenting"))
                .andDo(print())
                .andExpect(status().isOk())
        .andExpect(view().name("post"));

        assertThat(post.getComments().get(0).getText(), is("Commenting"));
    }
}