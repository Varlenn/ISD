package main.dto.tables;

public class Avtor {

    int id;
    String fam;
    String name;
    Integer god_r;
    Character pol;

    public Avtor(String fam, String name, Integer god_r, Character pol) {
        this.fam = fam;
        this.name = name;
        this.god_r = god_r;
        this.pol = pol;
    }

    public int getId() {
        return id;
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

    public Character getPol() {
        return pol;
    }

    public void setPol(Character pol) {
        this.pol = pol;
    }
}
