package SpringBoot.Project.Studifier.Helpers;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

@Schema(description = "Standard API Response wrapper")
public class ApiResponse<T> {
    @Schema(description = "Indicates if the request was successful", example = "true")
    private boolean success;

    @Schema(description = "Response message providing additional context", example = "Operation completed successfully")
    private String message;

    @Schema(description = "Response payload data")
    private T data;

    @Schema(description = "HTTP status code", example = "200 OK")
    private HttpStatus status;

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(T data, HttpStatus status) {
        this.success = true;
        this.data = data;
        this.status = status;
        this.message = status.getReasonPhrase();
    }

    public ApiResponse(String message, HttpStatus status) {
        this.success = status.is2xxSuccessful();
        this.message = message;
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}