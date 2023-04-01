package main.additional;


import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainPhone {
    public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
        Phone phone1  = new Phone("+72208691690", "Samsung Galaxy S21", 156);
        Phone phone2  = new Phone("+73578066199", "Asus Zenfone 6", 130);
        Phone phone3  = new Phone("+72442764945", "Sony Xperia 10", 162);

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);

        for (Phone phone : phoneList) {
            System.out.println(phone.getNumber() + ", " + phone.getModel() + ", " + phone.getWeight());
        }
        System.out.println("\n");


        String res = phone1.receiveCall("Олег");
        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));
        res = phone1.receiveCall("Катя", "+72442764945");
        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));
        System.out.println("\n");


        System.out.println(phone1.sendMessage(new ArrayList(Arrays.asList(phone2.getNumber(), phone3.getNumber()))));
    }
}
