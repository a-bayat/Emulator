package ir.shaparak.emulator.model;

import ir.shaparak.emulator.enums.ResponseEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseFactory {
    private final Map<ResponseEnum, AResponse> responseRegistry = new HashMap<>();

    public void registerResponses(ResponseEnum responseEnum, AResponse response) {
        responseRegistry.put(responseEnum, response);
    }

    public AResponse getResponse(ResponseEnum responseType) {
        return responseRegistry.get(responseType);
    }
}
