package Model;

import java.io.Serializable;

/**
 * Created by Lenovo on 6/22/2017.
 */
public class Parse implements Serializable {
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Parse(String message) {
        this.message = message;

    }


}
