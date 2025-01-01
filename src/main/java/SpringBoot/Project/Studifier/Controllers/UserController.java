package SpringBoot.Project.Studifier.Controllers;

import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Models.User;
import SpringBoot.Project.Studifier.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")  // Updated the base path to /api/users for consistency
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to get the current logged-in user
    @GetMapping("/current")
    public ResponseEntity<ApiResponse<String>> getCurrentUserName() {
        String currentUserName = userService.getCurrentUsername();
        if (currentUserName == null || currentUserName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("Current user not found", HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.ok(new ApiResponse<>(currentUserName, HttpStatus.OK));
    }

    // Endpoint to get all users
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ApiResponse<>("No users found", HttpStatus.NO_CONTENT));
        }
        return ResponseEntity.ok(new ApiResponse<>(users, HttpStatus.OK));
    }

    // Endpoint to get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("User not found with ID: " + id, HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.ok(new ApiResponse<>(user, HttpStatus.OK));
    }

    // Endpoint to create a new user
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(createdUser, HttpStatus.CREATED));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>("Failed to create user: " + e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    // Endpoint to update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("User not found with ID: " + id, HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.ok(new ApiResponse<>(user, HttpStatus.OK));
    }

    // Endpoint to delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("User not found with ID: " + id, HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.ok(new ApiResponse<>("User deleted successfully", HttpStatus.OK));
    }
}
