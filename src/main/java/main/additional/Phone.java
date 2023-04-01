package main.additional;

import java.util.List;

public class Phone {
    String number;
    String model;
    Integer weight;

    public Phone(String number, String model, Integer weight) {
        this(number, model);
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String receiveCall(String name) {
        return "Звонит " + name;
    }

    public String receiveCall(String name, String number) {
        return "Звонит " + name + " " + number;
    }

    public List<String> sendMessage(List<String> numbers) {
        return numbers;
    }
}
