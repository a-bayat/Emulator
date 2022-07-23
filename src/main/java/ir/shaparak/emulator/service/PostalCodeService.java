package ir.shaparak.emulator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.shaparak.emulator.dto.PostalCodeReqBody;
import ir.shaparak.emulator.model.PostalCode;
import ir.shaparak.emulator.model.PostalResponse;
import ir.shaparak.emulator.model.ResponseFactory;
import ir.shaparak.emulator.service.validator.CustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PostalCodeService {

    private final List<PostalCode> postalCodeList = new ArrayList<>();
    private final Map<String, PostalCode> postalCodeHash = new HashMap<>();

    @Value("${postalcode.info.path}")
    private String postalCodePath;

    @Autowired
    private ResponseFactory responseFactory;

    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            postalCodeList.addAll(Arrays.asList(mapper.readValue(Paths.get(postalCodePath).toFile(), PostalCode[].class)));
            postalCodeHash.putAll(postalCodeList.stream().collect(Collectors.toMap(PostalCode::getPostalCode, Function.identity())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PostalResponse getPostCode(PostalCodeReqBody postalCodeReq) {
        PostalResponse postalResponse = new PostalResponse();
        if (CustomValidator.check(s -> !s.isEmpty(), postalCodeReq.getPostalCode()) ||
                CustomValidator.check(s -> s.length() > 10, postalCodeReq.getPostalCode()) ||
                CustomValidator.check(CustomValidator::isNumber, postalCodeReq.getPostalCode())) {

            postalResponse.status = HttpStatus.BAD_REQUEST.value();
            postalResponse.error = "BAD Request Body[+ PostalCode Length should be 10 + PostalCode should be a digit Number]";

            return postalResponse;
        }

        postalResponse.status = HttpStatus.OK.value();
        postalResponse.setPersonalInfos(Collections.singletonList(postalCodeHash.get(postalCodeReq.getPostalCode())));

        return postalResponse;
    }
}
