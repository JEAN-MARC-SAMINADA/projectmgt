package com.bnpparibas.ism.projectmgt.infrastructure.processmgt;

import java.util.List;

public class ProcessDTO {
    Long id;
    String displayName;
    ProcessType processType;
    FollowUP followUP;
    List<ProcessActivityDTO> processActivityDTOList;
}
