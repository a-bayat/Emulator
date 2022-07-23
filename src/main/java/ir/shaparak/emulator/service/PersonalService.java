package ir.shaparak.emulator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.shaparak.emulator.dto.PersonalNatCodeReqBody;
import ir.shaparak.emulator.model.PersonalInfo;
import ir.shaparak.emulator.model.PersonalResponse;
import ir.shaparak.emulator.model.ResponseFactory;
import ir.shaparak.emulator.service.validator.PersonalValidator;
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
public class PersonalService {

    private final List<PersonalInfo> personalInfoList = new ArrayList<>();
    private final Map<String, PersonalInfo> personalNationalHash = new HashMap<>();

    @Value("${personal.info.path}")
    private String personalPath;

    @Autowired
    private ResponseFactory responseFactory;

    @Autowired
    private PersonalValidator validator;

    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            personalInfoList.addAll(Arrays.asList(mapper.readValue(Paths.get(personalPath).toFile(), PersonalInfo[].class)));
            personalNationalHash.putAll(personalInfoList.stream().collect(Collectors.toMap(PersonalInfo::getNationalCode, Function.identity())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonalResponse getPersonal(PersonalNatCodeReqBody natCodeReqBody) {
        PersonalResponse personalResponse = new PersonalResponse();
        if (validator.validate(natCodeReqBody.getNationalCode())) {
            personalResponse.status = HttpStatus.BAD_REQUEST.value();
            personalResponse.error = "BAD Request Body[+ NationalCode Length should be 5 + nationalCode should be a digit Number]";
            return personalResponse;
        }

        personalResponse.status = HttpStatus.OK.value();
        personalResponse.setPersonalInfos(Collections.singletonList(personalNationalHash.get(natCodeReqBody.getNationalCode())));

        return personalResponse;
    }
}
