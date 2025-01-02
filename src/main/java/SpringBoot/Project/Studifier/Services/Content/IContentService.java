package SpringBoot.Project.Studifier.Services.Content;


import SpringBoot.Project.Studifier.Models.Content;
import SpringBoot.Project.Studifier.Requests.ContentRequestDTO;
import SpringBoot.Project.Studifier.Responses.ContentResponseDTO;

import java.util.List;

public interface IContentService {
    List<ContentResponseDTO> getContentsByCourseId(Long courseId);
    ContentResponseDTO createContent(ContentRequestDTO contentRequestDTO);
    void deleteContent(Long id);
}
