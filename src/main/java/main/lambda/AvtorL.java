package main.lambda;

import lombok.Data;

@Data
public class AvtorL {

    int id;
    String fam;
    String name;
    Integer god_r;
    Character pol;

    public AvtorL(String fam, String name, Integer god_r, Character pol) {
        this.fam = fam;
        this.name = name;
        this.god_r = god_r;
        this.pol = pol;
    }

    public AvtorL(String fam, String name, int god_r) {
        this.fam = fam;
        this.name = name;
        this.god_r = god_r;
    }

    public String name() {
        return null;
    }
}
