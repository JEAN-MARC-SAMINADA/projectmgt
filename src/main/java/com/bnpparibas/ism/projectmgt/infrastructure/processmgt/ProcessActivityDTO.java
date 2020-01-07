package com.bnpparibas.ism.projectmgt.infrastructure.processmgt;

import java.util.List;

public class ProcessActivityDTO {
    Long id;
    String name;
    List<ArtifactDTO> artifactDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArtifactDTO> getArtifactDTOList() {
        return artifactDTOList;
    }

    public void setArtifactDTOList(List<ArtifactDTO> artifactDTOList) {
        this.artifactDTOList = artifactDTOList;
    }
}
