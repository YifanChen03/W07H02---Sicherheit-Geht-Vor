package pgdp.security;

import java.util.*;

public class LightPanel extends SignalPost{

    public LightPanel(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {
        String o_type = type;
        int o_level = super.getLevel();
        String[] types = new String[] {"green", "blue", "yellow", "doubleYellow", "[SC]", "red", "end"};
        if (Arrays.asList(types).contains(type)) {
            int a_level = super.getLevel();
            switch (type) {
                case "green":
                    if (a_level < 1) {
                        super.setLevel(1);
                        super.setDepiction(type);
                    }
                    break;
                case "blue":
                    if (a_level <= 1) {
                        super.setLevel(1);
                        super.setDepiction(type);
                    }
                    break;
                case "yellow":
                    if (a_level < 2) {
                        super.setLevel(2);
                        super.setDepiction(type);
                    }
                    break;
                case "doubleYellow":
                    if (a_level < 3) {
                        super.setLevel(3);
                        super.setDepiction(type);
                    }
                    break;
                case "[SC]":
                    if (a_level <= 3) {
                        super.setLevel(3);
                        super.setDepiction(type);
                    }
                    break;
                case "red":
                    if (a_level < 4) {
                        super.setLevel(4);
                        super.setDepiction(type);
                    }
                    break;
                case "end":
                    if (a_level < 5) {
                        super.setLevel(5);
                        super.setDepiction("yellow");
                    }
                    break;
            }
            if (o_type != type || o_level != super.getLevel()) {
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
                    super.setLevel(0);
                    super.setDepiction("");
                    break;
                case "green":
                    if (super.getDepiction() == "green") {
                        super.setLevel(0);
                        super.setDepiction("");
                    }
                    break;
                case "blue":
                    if (super.getDepiction() == "blue") {
                        super.setLevel(0);
                        super.setDepiction("");
                    }
                    break;
                case "danger":
                    if (super.getDepiction() == "yellow" || super.getDepiction() == "doubleYellow"
                            || super.getDepiction() == "[SC]" || super.getDepiction() == "red"
                            && super.getLevel() != 5) {
                        super.setLevel(1);
                        super.setDepiction("green");
                    }
                    break;
            }
        }
        return false;
    }

    public String toString() {
        String output;
        if (super.getLevel() == 0) {
            output = "Signal post " + super.getPostNumber() + " of type light panel is in level " + super.getLevel()
                    + " and is switched off";
        } else {
            output = "Signal post " + super.getPostNumber() + " of type light panel is in level " + super.getLevel()
                    + " and is blinking " + super.getDepiction();
        }
        return output;
    }
}
