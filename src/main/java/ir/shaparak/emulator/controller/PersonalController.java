package ir.shaparak.emulator.controller;

import ir.shaparak.emulator.dto.PersonalNatCodeReqBody;
import ir.shaparak.emulator.model.PersonalResponse;
import ir.shaparak.emulator.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping("/")
    public PersonalResponse getPersonalInfo(@RequestBody PersonalNatCodeReqBody natCode) {
        return personalService.getPersonal(natCode);
    }
}
