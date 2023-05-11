package main.annotations;

@DBTable(name = "Newspaper")

public class Newspaper {
    @ColumnInteger(name = "id", constraints = @Constraints(primaryKey = true))
    private Integer id;

    @ColumnString (50)
    private String name;

    @ColumnString (30)
    private String theme;

    @ColumnString (30)
    private String frequency;

    @ColumnInteger
    private String price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
