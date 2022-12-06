package pgdp.security;

import java.util.*;

public class LightPanel extends SignalPost{

    public LightPanel(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {
        String o_type = type;
        int o_level = getLevel();
        String[] types = new String[] {"green", "blue", "yellow", "doubleYellow", "[SC]", "red", "end"};
        if (Arrays.asList(types).contains(type)) {
            int a_level = getLevel();
            switch (type) {
                case "green":
                    if (a_level < 1) {
                        setLevel(1);
                        setDepiction(type);
                    }
                    break;
                case "blue":
                    if (a_level <= 1) {
                        setLevel(1);
                        setDepiction(type);
                    }
                    break;
                case "yellow":
                    if (a_level < 2) {
                        setLevel(2);
                        setDepiction(type);
                    }
                    break;
                case "doubleYellow":
                    if (a_level < 3) {
                        setLevel(3);
                        setDepiction(type);
                    }
                    break;
                case "[SC]":
                    if (a_level <= 3) {
                        setLevel(3);
                        setDepiction(type);
                    }
                    break;
                case "red":
                    if (a_level < 4) {
                        setLevel(4);
                        setDepiction(type);
                    }
                    break;
                case "end":
                    if (a_level < 5) {
                        setLevel(5);
                        setDepiction("yellow");
                    }
                    break;
            }
            if (o_type != type || o_level != getLevel()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean down(String type) {
        String[] types = new String[] {"clear", "green", "blue", "danger"};
        if (Arrays.asList(types).contains(type)) {
            switch (type) {
                case "clear":
                    setLevel(0);
                    setDepiction("");
                    break;
                case "green":
                    if (getDepiction() == "green") {
                        setLevel(0);
                        setDepiction("");
                    }
                    break;
                case "blue":
                    if (getDepiction() == "blue") {
                        setLevel(0);
                        setDepiction("");
                    }
                    break;
                case "danger":
                    if ((getDepiction() == "yellow" || getDepiction() == "doubleYellow"
                            || getDepiction() == "[SC]" || getDepiction() == "red")
                            && getLevel() != 5) {
                        setLevel(1);
                        setDepiction("green");
                    }
                    break;
            }
        }
        return false;
    }

    public String toString() {
        String output;
        if (getLevel() == 0) {
            output = "Signal post " + getPostNumber() + " of type light panel is in level " + getLevel()
                    + " and is switched off";
        } else {
            output = "Signal post " + getPostNumber() + " of type light panel is in level " + getLevel()
                    + " and is blinking " + getDepiction();
        }
        return output;
    }
}
