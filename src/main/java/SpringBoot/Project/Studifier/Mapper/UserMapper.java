package SpringBoot.Project.Studifier.Mapper;


import SpringBoot.Project.Studifier.Models.User;
import SpringBoot.Project.Studifier.Requests.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    // Convert a single User to UserDTO
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getUsername(),
                null, // Exclude password
                user.getEmail(),
                user.getRole().toString()
        );
    }

    // Convert a list of Users to a list of UserDTOs
    public static List<UserDTO> toDTOList(List<User> users) {
        return users.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}