package pgdp.security;

import java.util.Arrays;

public class FlagPost extends SignalPost {
    public FlagPost(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {
        String o_type = type;
        int o_level = super.getLevel();
        String c_depiction = super.getDepiction();
        String[] types = new String[] {"green", "blue", "yellow", "doubleYellow", "[SC]", "red", "end"};
        if (Arrays.asList(types).contains(type)) {
            int a_level = super.getLevel();
            switch (type) {
                case "green":
                    if (a_level == 0) {
                        super.setLevel(1);
                        super.setDepiction(type);
                    } else if (a_level == 1 && c_depiction == "blue") {
                        super.setLevel(1);
                        super.setDepiction("green/blue");
                    }
                    break;
                case "blue":
                    if (a_level == 0) {
                        super.setLevel(1);
                        super.setDepiction(type);
                    } else if (a_level == 1 && c_depiction == "green") {
                        super.setLevel(1);
                        super.setDepiction("green/blue");
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
                    if (a_level < 3) {
                        super.setLevel(3);
                        super.setDepiction(type);
                    } else if (a_level == 3 && c_depiction == "doubleYellow") {
                        super.setLevel(3);
                        super.setDepiction("doubleYellow/[SC]");
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
                        super.setDepiction("green/yellow/red/blue");
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
                    } else if (super.getDepiction() == "green/blue"){
                        super.setLevel(1);
                        super.setDepiction("blue");
                    }
                    break;
                case "blue":
                    if (super.getDepiction() == "blue") {
                        super.setLevel(0);
                        super.setDepiction("");
                    } else if (super.getDepiction() == "green/blue"){
                        super.setLevel(1);
                        super.setDepiction("green");
                    }
                    break;
                case "danger":
                    if (super.getDepiction() == "yellow" || super.getDepiction() == "doubleYellow"
                            || super.getDepiction() == "doubleYellow/[SC]" || super.getDepiction() == "red") {
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
            output = "Signal post " + super.getPostNumber() + " of type  flag post  is in level " + super.getLevel()
                    + " and is doing nothing";
        } else {
            output = "Signal post " + super.getPostNumber() + " of type  flag post  is in level " + super.getLevel()
                    + " and is  waving  " + super.getDepiction();
        }
        return output;
    }
}
