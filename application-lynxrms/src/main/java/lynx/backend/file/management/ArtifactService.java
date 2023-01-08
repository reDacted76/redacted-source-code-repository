package lynx.backend.file.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ArtifactService {

    @Autowired
    private ArtifactRepository artifactRepository;

    public void artifactIngestToLocal(MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
    }

    public void artifactIngestToData(MultipartFile file) throws IOException {
        Artifact artifact = new Artifact(file.getName(), file.getContentType(), file.getBytes());
        artifactRepository.save(artifact);
    }
}
