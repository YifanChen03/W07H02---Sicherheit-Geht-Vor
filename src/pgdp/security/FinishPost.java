package pgdp.security;

import java.util.Arrays;

public class FinishPost extends FlagPost {
    public FinishPost(int postNumber) {
        super(postNumber);
    }

    public boolean up(String type) {
        if (type == "end") {
            setDepiction("chequered");
            setLevel(5);
            return true;
        } else {
            return super.up(type);
        }
    }

    @Override
    public boolean down(String type) {
        return super.down(type);
    }

    public String toString() {
        String output;
        if (getLevel() == 0) {
            output = "Signal post " + getPostNumber() + " of type finish post is in level " + getLevel()
                    + " and is  doing nothing";
        } else {
            output = "Signal post " + getPostNumber() + " of type finish post is in level " + getLevel()
                    + " and is  waving  " + getDepiction();
        }
        return output;
    }
}
