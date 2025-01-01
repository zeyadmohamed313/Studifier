package SpringBoot.Project.Studifier.Controllers;

import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Models.Content;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Services.Content.ContentService;
import SpringBoot.Project.Studifier.Services.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Content>>> getAllContents() {
        List<Content> contents = contentService.getAllContents();
        return ResponseEntity.ok(new ApiResponse<>(true, "Contents fetched successfully", contents));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Content>> getContentById(@PathVariable Long id) {
        Content content = contentService.getContentById(id);
        if (content == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Content not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Content fetched successfully", content));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Content>> createContent(@RequestBody Content content) {
        Content createdContent = contentService.createContent(content);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Content created successfully", createdContent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Content>> updateContent(@PathVariable Long id, @RequestBody Content updatedContent) {
        Content content = contentService.updateContent(id, updatedContent);
        if (content == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Content not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Content updated successfully", content));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Content deleted successfully", null));
    }
}
