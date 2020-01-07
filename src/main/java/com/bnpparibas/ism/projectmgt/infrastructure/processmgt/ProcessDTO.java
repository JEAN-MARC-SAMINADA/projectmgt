package com.bnpparibas.ism.projectmgt.infrastructure.processmgt;

import java.util.List;

public class ProcessDTO {
    Long id;
    String displayName;
    ProcessType processType;
    FollowUP followUP;
    List<ProcessActivityDTO> processActivityDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ProcessType getProcessType() {
        return processType;
    }

    public void setProcessType(ProcessType processType) {
        this.processType = processType;
    }

    public FollowUP getFollowUP() {
        return followUP;
    }

    public void setFollowUP(FollowUP followUP) {
        this.followUP = followUP;
    }

    public List<ProcessActivityDTO> getProcessActivityDTOList() {
        return processActivityDTOList;
    }

    public void setProcessActivityDTOList(List<ProcessActivityDTO> processActivityDTOList) {
        this.processActivityDTOList = processActivityDTOList;
    }
}
