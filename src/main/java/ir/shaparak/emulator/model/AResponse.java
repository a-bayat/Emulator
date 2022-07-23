package ir.shaparak.emulator.model;

import ir.shaparak.emulator.enums.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class AResponse {
    public String error;
    public Integer status;



}
