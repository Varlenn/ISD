package main.annotations;

@Description(title = "title", version = 2, text = "text")

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.speak();
        cat.speak();

        Main main = new Main();
        System.out.println(main.getClass().getAnnotation(Description.class).title());

        Newspaper newspaper = new Newspaper();
        TableCreator tableCreator = new TableCreator();
        tableCreator.temp(newspaper);
    }


//    public static String create(User user) {
//        String id = UUID.randomUUID().toString();
//        User user1 = User.builder()
//                .id(id)
//                .login(user.getLogin())
//                .password(user.getPassword())
//                .build();
//
//        return id;
//    }
}
