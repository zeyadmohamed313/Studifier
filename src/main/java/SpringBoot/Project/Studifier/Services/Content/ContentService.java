package SpringBoot.Project.Studifier.Services.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringBoot.Project.Studifier.Models.Content;
import SpringBoot.Project.Studifier.Repositories.ContentRepository;
import java.util.List;

@Service
public class ContentService implements IContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    @Override
    public Content getContentById(Long id) {
        return contentRepository.findById(id).orElse(null);
    }

    @Override
    public Content createContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public Content updateContent(Long id, Content content) {
        if(contentRepository.existsById(id)) {
            content.setId(id);
            return contentRepository.save(content);
        }
        return null;
    }

    @Override
    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }
}
