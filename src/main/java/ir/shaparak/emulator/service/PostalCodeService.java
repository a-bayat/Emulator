package ir.shaparak.emulator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PostalCodeService {

    @Value("${postalcode.info.path}")
    private String postalCodePath;
}
