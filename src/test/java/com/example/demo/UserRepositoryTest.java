package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void TestCreateUser(){
        var email = "indra3@example.com";
        User user = new User("indraadian3", email, "Rahasia123");
        User saved = userRepository.save(user);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getEmail()).isEqualTo(email);
    }

    @Test
    void TestFindUserById(){
        var email = "indra3@example.com";
        User user = new User("indraadian3", email, "Rahasia123");
        User saved = userRepository.save(user);

        long id = saved.getId();
        Optional<User> found = userRepository.findById(id);
        assertThat(found.isPresent());
        assertThat(found.get().getEmail()).isEqualTo(email);
    }
}
