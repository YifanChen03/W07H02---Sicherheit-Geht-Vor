package pgdp.security;

import java.util.*;

public class LightPanel extends SignalPost{

    public LightPanel(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {
        String[] types = new String[] {"green", "blue", "yellow", "doubleYellow", "[SC]", "red", "end"};
        if (Arrays.asList(types).contains(type)) {
            int ind = Arrays.asList(types).indexOf(type);
            if (ind > super.getLevel()) {
                if (type == "green" || type == "blue") {
                    super.setLevel(1);
                }
                if (type == "yellow") {
                    super.setLevel(2);
                }
                if (type == "doubleYellow" || type == "[SC]") {
                    super.setLevel(3);
                }
                if (type == "red") {
                    super.setLevel(4);
                }
                if (type == "end") {
                    super.setLevel(5);
                }
                super.setDepiction(type);
                if (type == "end") {
                    super.setDepiction("yellow");
                }
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
