package com.perso.sports.db;

import com.perso.sports.entity.UserEntity;
import com.perso.sports.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    UserEntity toto;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
        toto = userRepository.save(UserEntity.create("Toto"));
    }

    @Test
    public void setIdOnSave(){
        UserEntity jules = userRepository.save(UserEntity.create("Jules"));
        assertThat(jules.getId()).isNotNull();
    }

    @Test
    public void findById(){
        Optional<UserEntity> result = userRepository.findById(toto.getId());
        assertThat(result. isPresent()).isTrue();
        assertThat(result.get()).isNotNull();
    }

}
