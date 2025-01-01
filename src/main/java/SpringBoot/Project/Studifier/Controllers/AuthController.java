package SpringBoot.Project.Studifier.Controllers;

import SpringBoot.Project.Studifier.Config.JwtTokenUtil;
import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Requests.AuthRequest;
import SpringBoot.Project.Studifier.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody AuthRequest authRequest) {
        try {
            // Authenticate the user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            // Load user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

            // Generate the JWT token
            String token = jwtTokenUtil.generateToken(userDetails);

            // Return a successful response with the token
            return ResponseEntity.ok(new ApiResponse<>(true, "Login successful", token));
        } catch (BadCredentialsException e) {
            // Return an error response for bad credentials
            return ResponseEntity.status(401)
                    .body(new ApiResponse<>(false, "Authentication failed: Bad credentials", null));
        } catch (Exception e) {
            // Return an error response for any other exceptions
            return ResponseEntity.status(500)
                    .body(new ApiResponse<>(false, "Authentication failed: " + e.getMessage(), null));
        }
    }
}
