package spring.contactApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import spring.contactApp.repository.PacketRepository;
import spring.contactApp.repository.SimCardRepository;
import spring.contactApp.repository.TarifRepository;

@Service
public class DashbordService {
    @Autowired
    SimCardRepository simCardRepository;
    @Autowired
    TarifRepository tarifRepository;
    @Autowired
    PacketRepository packetRepository;

    @GetMapping("/simcard")
    public Integer getReport(){

        return 5;
    }
}
