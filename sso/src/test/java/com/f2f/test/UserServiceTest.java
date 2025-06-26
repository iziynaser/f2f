package com.f2f.test;

//import com.f2f.dto.UserAccountDTO;
//import com.f2f.entity.UserAccountEntity;
//import com.f2f.mapper.UserAccountMapper;
//import com.f2f.persisence.PasswordPolicyEntity;
//import com.f2f.repository.PasswordPolicyRepository;
//import com.f2f.repository.UserAccountRepository;
//import com.f2f.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;

public class UserServiceTest {
}

//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @Mock
//    private UserAccountRepository userAccountRepository;
//
//    @Mock
//    private PasswordPolicyRepository passwordPolicyRepository;
//
//    @Mock
//    private UserAccountMapper userAccountMapper;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void createUser_withValidPassword_shouldSaveUser() {
//        // Arrange
//        PasswordPolicyEntity policy = new PasswordPolicyEntity();
//        policy.setMinLength(8);
//        policy.setRequireUppercase(true);
//        policy.setRequireLowercase(true);
//        policy.setRequireNumber(true);
//        policy.setRequireSpecialChar(false);
//
//        when(passwordPolicyRepository.findTopByOrderByIdDesc()).thenReturn(Optional.of(policy));
//
//        UserAccountDTO dto = UserAccountDTO.builder()
//                .username("testuser")
//                .password("Abcdef123")
//                .build();
//
//        UserAccountEntity entity = new UserAccountEntity();
//        when(userAccountMapper.toEntity(dto)).thenReturn(entity);
//        when(userAccountRepository.save(entity)).thenReturn(entity);
//        when(userAccountMapper.toDTO(entity)).thenReturn(dto);
//
//        // Act
//        UserAccountDTO result = userService.createUser(dto);
//
//        // Assert
//        assertNotNull(result);
//        verify(userAccountRepository).save(entity);
//    }
//
//    @Test
//    void createUser_withInvalidPassword_shouldThrowException() {
//        // Arrange
//        PasswordPolicyEntity policy = new PasswordPolicyEntity();
//        policy.setMinLength(8);
//        policy.setRequireUppercase(true);
//        policy.setRequireLowercase(true);
//        policy.setRequireNumber(true);
//        policy.setRequireSpecialChar(false);
//
//        when(passwordPolicyRepository.findTopByOrderByIdDesc()).thenReturn(Optional.of(policy));
//
//        UserAccountDTO dto = UserAccountDTO.builder()
//                .username("testuser")
//                .password("abcdefg") // بدون حرف بزرگ و عدد
//                .build();
//
//        // Act & Assert
//        assertThrows(IllegalArgumentException.class, () -> userService.createUser(dto));
//        verify(userAccountRepository, never()).save(any());
//    }
//}
