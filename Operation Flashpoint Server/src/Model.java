/**
 * Created by Lenovo on 6/20/2017.
 */
public class Model {
    int a = 1;
    int b = 2;
    int c = 3;
    String txt = "Text";

    public Model(int a, int b, int c, String txt) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.txt = txt;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
