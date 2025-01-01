package SpringBoot.Project.Studifier.Services.Content;


import SpringBoot.Project.Studifier.Models.Content;
import java.util.List;

public interface IContentService {
    List<Content> getAllContents();
    Content getContentById(Long id);
    Content createContent(Content content);
    Content updateContent(Long id, Content content);
    void deleteContent(Long id);
}
