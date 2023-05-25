package com.example.app.service;

import com.example.app.dto.UserDto;
import com.example.app.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class UserServiceTest {
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserService userService;

    private UserDto userDto;

    @BeforeEach
    void setUp(){
        userDto = new UserDto();
        userDto.setUserId("testId");
        userDto.setUserPassword("1234");
        userDto.setUserGender("M");
        userDto.setUserEmail("test@email.com");
        userDto.setUserAddress("test address");
    }

    @Test
    @DisplayName("회원 등록")
    void register() {
        doNothing().when(userMapper).insert(any(UserDto.class));

        userService.register(userDto);

        verify(userMapper, times(1)).insert(userDto);
    }

    @Test
    @DisplayName("회원 번호 조회 : 존재하지 않는 회원 예외 검사")
    void findUserNumberException(){
        doReturn(null).when(userMapper).selectUserNumber(any(String.class), any(String.class));

        assertThatThrownBy(() -> userService.findUserNumber("a", "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지");
    }



    @Test
    @DisplayName("회원 번호 조회")
    void findUserNumber() {
        doReturn(1L).when(userMapper).selectUserNumber(any(String.class), any(String.class));

        Long userNumber = userService.findUserNumber("test", "1234");

        assertThat(userNumber).isEqualTo(1L);
    }
}






