package lynx.backend.file.management;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Artifact {

    @Id
    private long id;
    private String artifactName;
    private String artifactType;
    @Lob
    private byte[] artifactData;

    private Artifact() {
    }

    public Artifact(String artifactName, String artifactType, byte[] artifactData) {

        this.artifactName = artifactName;
        this.artifactType = artifactType;
        this.artifactData = artifactData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtifactName() {
        return artifactName;
    }

    public void setArtifactName(String artifactName) {
        this.artifactName = artifactName;
    }

    public String getArtifactType() {
        return artifactType;
    }

    public void setArtifactType(String artifactType) {
        this.artifactType = artifactType;
    }

    public byte[] getArtifactData() {
        return artifactData;
    }

    public void setArtifactData(byte[] artifactData) {
        this.artifactData = artifactData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artifact artifact = (Artifact) o;
        return id == artifact.id && Objects.equals(artifactName, artifact.artifactName) && Objects.equals(artifactType, artifact.artifactType) && Arrays.equals(artifactData, artifact.artifactData);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, artifactName, artifactType);
        result = 31 * result + Arrays.hashCode(artifactData);
        return result;
    }
}
