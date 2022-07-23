package ir.shaparak.emulator.controller;

import ir.shaparak.emulator.dto.PostalCodeReqBody;
import ir.shaparak.emulator.model.PostalResponse;
import ir.shaparak.emulator.service.PostalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("postal-code")
public class PostalCodeController {

    @Autowired
    private PostalCodeService postalCodeService;

    @GetMapping("/")
    public PostalResponse getPostalCode(@RequestBody PostalCodeReqBody natCode) {
        return postalCodeService.getPostCode(natCode);
    }
}
