package SpringBoot.Project.Studifier.Controllers;

import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Requests.ContentRequestDTO;
import SpringBoot.Project.Studifier.Responses.ContentResponseDTO;
import SpringBoot.Project.Studifier.Services.Content.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class ContentController {
    @Autowired
    private IContentService contentService;

    @GetMapping("/{courseId}/getContentsByCourse")
    public ResponseEntity<ApiResponse<List<ContentResponseDTO>>> getContentsByCourse(@PathVariable Long courseId) {
        List<ContentResponseDTO> contents = contentService.getContentsByCourseId(courseId);
        return ResponseEntity.ok(new ApiResponse<>(contents, HttpStatus.OK));
    }

    @PostMapping("/{courseId}/createContent")
    public ResponseEntity<ApiResponse<ContentResponseDTO>> createContent(
            @PathVariable Long courseId,
            @RequestBody @Valid ContentRequestDTO contentRequestDTO) {
        contentRequestDTO.setCourseId(courseId);
        ContentResponseDTO createdContent = contentService.createContent(contentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(createdContent, HttpStatus.CREATED));
    }

    @DeleteMapping("/contents/{contentId}")
    public ResponseEntity<ApiResponse<String>> deleteContent(@PathVariable Long contentId) {
        contentService.deleteContent(contentId);
        return ResponseEntity.ok(new ApiResponse<>("Content deleted successfully", HttpStatus.OK));
    }
}
