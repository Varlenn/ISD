package main.patterns;

public class BookController {
    Book model = new Book();
    BookView view = new BookView();

    public BookController(int bshifr, String bookName, String genre) {
    }

    public BookController() {

    }

    public void setBookName(String name) {
        model.setName(name);
    }

    public String returnModelName() {
        return model.getName();
    }

    public void setBookBshifr(int bshifr) {
        model.setBshifr(bshifr);
    }

    public int returnModelBshifr() {
        return model.getBshifr();
    }

    public void setBookGenre(String genre) {
        model.setGenre(genre);
    }

    public String returnModelGenre() {
        return model.getGenre();
    }

    public void updateView() {
        view.printBook(model.bshifr, model.name, model.genre);
    }
}
