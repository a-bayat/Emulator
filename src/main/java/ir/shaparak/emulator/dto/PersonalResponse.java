package ir.shaparak.emulator.dto;

import ir.shaparak.emulator.model.PersonalInfo;

public class PersonalResponse {
    private int status;
    private PersonalInfo personalInfo;
    private String error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
