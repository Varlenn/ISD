package main.dto.tables;

import java.util.List;

public class Reader {
    int kod_user;
    String fam;
    String name;
    Integer god_r;
    Integer gruppa;
    String[] phone;

    public Reader() {}

    public Reader(Integer kod_user, String fam, String name, Integer god_r, Integer gruppa, String[] phone) {
        this.kod_user = kod_user;
        this.fam = fam;
        this.name = name;
        this.god_r = god_r;
        this.gruppa = gruppa;
        this.phone = phone;
    }

    public Integer getKod_user() {
        return kod_user;
    }

    public void setKod_user(Integer kod_user) {
        this.kod_user = kod_user;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGod_r() {
        return god_r;
    }

    public void setGod_r(Integer god_r) {
        this.god_r = god_r;
    }

    public Integer getGruppa() {
        return gruppa;
    }

    public void setGruppa(Integer gruppa) {
        this.gruppa = gruppa;
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }
}
