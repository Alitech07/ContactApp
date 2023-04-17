package spring.contactApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.contactApp.entity.Packet;
import spring.contactApp.entity.PassportInfo;
import spring.contactApp.entity.SimCard;
import spring.contactApp.entity.Tariff;
import spring.contactApp.payload.ApiResponse;
import spring.contactApp.payload.SimCardDTO;
import spring.contactApp.repository.PassportInfoRepository;
import spring.contactApp.repository.SimCardRepository;
import spring.contactApp.repository.TarifRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SimCardSerivice {
    @Autowired
    SimCardRepository simCardRepository;
    @Autowired
    PassportInfoRepository passportInfo;
    @Autowired
    TarifRepository tarifRepository;

    public List<SimCard> getSimCardsService(){
        return simCardRepository.findAll();
    }

    public SimCard getSimCard(UUID id){
        Optional<SimCard> optionalSimCard = simCardRepository.findById(id);
        return optionalSimCard.orElse(null);
    }

    public ApiResponse addSimCardService(SimCardDTO simCardDTO){
        boolean existsed = simCardRepository.existsSimCardByNumber(simCardDTO.getNumber());
        if (existsed) return new ApiResponse("Bunday raqam mavjud ",false);
        SimCard simCard = new SimCard();
        simCard.setCountryCode(simCardDTO.getCountryCode());
        simCard.setCompanyCode(simCardDTO.getCompanyCode());
        simCard.setNumber(simCardDTO.getNumber());
        simCard.setBalance(simCardDTO.getBalance());
        simCard.setClientPI(simCardDTO.getPassportInfo());

        Optional<Tariff> optionalTariff = tarifRepository.findById(simCardDTO.getTarifId());
        if (!optionalTariff.isPresent()) return new ApiResponse("Bunday tarif rejasi yuq",false);
        simCard.setTariff(optionalTariff.get());
        simCard.setPacket(simCardDTO.getPackets());
        simCardRepository.save(simCard);
        return new ApiResponse("Simkarta saqlandi.",true);
    }

    public ApiResponse deleteSimCardService(UUID id){
        Optional<SimCard> optionalSimCard = simCardRepository.findById(id);
        if (!optionalSimCard.isPresent()) return new ApiResponse("Bunday simkarta mavjud emas.",false);
        simCardRepository.deleteById(id);
        return new ApiResponse("Sim Karta o'chirildi.",true);
    }
}
