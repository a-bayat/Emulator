package ir.shaparak.emulator.model;

import java.util.List;

public class PostalResponse extends AResponse {
    private List<PostalCode> personalInfos;

    public List<PostalCode> getPersonalInfos() {
        return personalInfos;
    }

    public void setPersonalInfos(List<PostalCode> personalInfos) {
        this.personalInfos = personalInfos;
    }
}
