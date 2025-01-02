package SpringBoot.Project.Studifier.Helpers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;


import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Schema(description = "Standard API Response wrapper")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    // Getters and setters with updated statusCode
    @Schema(description = "Indicates if the request was successful", example = "true")
    private boolean success;

    @Schema(description = "Response message providing additional context", example = "Operation completed successfully")
    private String message;

    @Schema(description = "Response payload data")
    private T data;

    @Schema(description = "HTTP status", example = "OK")
    private String statusCode;  // Changed from HttpStatus to String

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(T data, HttpStatus status) {
        this.success = true;
        this.data = data;
        this.statusCode = status.name();  // Convert HttpStatus to String
        this.message = status.getReasonPhrase();
    }

    public ApiResponse(String message, HttpStatus status) {
        this.success = status.is2xxSuccessful();
        this.message = message;
        this.statusCode = status.name();  // Convert HttpStatus to String
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatusCode(HttpStatus status) {
        this.statusCode = status.name();
    }
}