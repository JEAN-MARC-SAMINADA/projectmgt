package com.bnpparibas.ism.projectmgt.infrastructure.processmgt;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "http://localhost:9090")
public interface ProcessManagerDAO {
    @RequestMapping(method = RequestMethod.GET, path = {"/methods/{name}/ptype/{ptype}/pfollow/{pfollow}"})
    List<ProcessDTO> listProccessByMappedNameAndProcessTypeFollow  (@PathVariable("name") String name,
                                                                    @PathVariable("ptype") String ptype,
                                                                    @PathVariable("pfollow") String pfollow);
}
