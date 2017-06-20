package sample.Model;

/**
 * Created by Lenovo on 6/19/2017.
 */
public class Model implements ModelInterface {
    int number = 0;
    String text = "null";
    boolean check = true;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addOne(){
        number ++;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Model(int number, String text, boolean check) {
        this.number = number;
        this.text = text;
        this.check = check;
    }
}
