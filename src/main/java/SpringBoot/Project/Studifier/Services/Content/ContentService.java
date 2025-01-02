package SpringBoot.Project.Studifier.Services.Content;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Repositories.CourseRepository;
import SpringBoot.Project.Studifier.Requests.ContentRequestDTO;
import SpringBoot.Project.Studifier.Responses.ContentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringBoot.Project.Studifier.Models.Content;
import SpringBoot.Project.Studifier.Repositories.ContentRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService implements IContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<ContentResponseDTO> getContentsByCourseId(Long courseId) {
        List<Content> contents = contentRepository.findByCourseId(courseId);
        return contents.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public ContentResponseDTO createContent(ContentRequestDTO contentRequestDTO) {
        Course course = courseRepository.findById(contentRequestDTO.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        Content content = new Content(
                contentRequestDTO.getTitle(),
                contentRequestDTO.getType(),
                contentRequestDTO.getUrl(),
                null,
                course
        );
        Content savedContent = contentRepository.save(content);
        return mapToResponseDTO(savedContent);
    }

    @Override
    public void deleteContent(Long id) {
        if (!contentRepository.existsById(id)) {
            throw new IllegalArgumentException("Content not found");
        }
        contentRepository.deleteById(id);
    }

    private ContentResponseDTO mapToResponseDTO(Content content) {
        ContentResponseDTO dto = new ContentResponseDTO();
        dto.setId(content.getId());
        dto.setTitle(content.getTitle());
        dto.setType(content.getType());
        dto.setUrl(content.getUrl());
        dto.setCreationDate(content.getCreationDate());
        dto.setCourseId(content.getCourse().getId());
        return dto;
    }
}
