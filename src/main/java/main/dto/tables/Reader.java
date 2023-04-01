package main.dto.tables;

import java.util.List;

public class Reader {
    int kod_bilet;
    String fam;
    String name;
    Integer god_r;
    Integer gruppa;
    List<String> phone;

    public Reader(Integer kod_bilet, String fam, String name, Integer god_r, Integer gruppa, List<String> phone) {
        this.kod_bilet = kod_bilet;
        this.fam = fam;
        this.name = name;
        this.god_r = god_r;
        this.gruppa = gruppa;
        this.phone = phone;
    }

    public Integer getKod_bilet() {
        return kod_bilet;
    }

    public void setKod_bilet(Integer kod_bilet) {
        this.kod_bilet = kod_bilet;
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

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }
}
