package ir.shaparak.emulator.model;

import java.util.List;

public class PersonalResponse extends AResponse{
    private List<PersonalInfo> personalInfos;

    public List<PersonalInfo> getPersonalInfos() {
        return personalInfos;
    }

    public void setPersonalInfos(List<PersonalInfo> personalInfos) {
        this.personalInfos = personalInfos;
    }
}
