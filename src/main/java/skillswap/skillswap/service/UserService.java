package skillswap.skillswap.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import skillswap.skillswap.repository.UserRepository;
import skillswap.skillswap.dto.UserDTO;
import skillswap.skillswap.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create new user
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setGmail(userDTO.getGmail());
        user.setPhone(userDTO.getPhone());
        user.setRole(userDTO.getRole());

        User saved = userRepository.save(user);

        return mapToDTO(saved);
    }

    // Get all users
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Helper mapper
    private UserDTO mapToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setGmail(user.getGmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        return dto;
    }
}
