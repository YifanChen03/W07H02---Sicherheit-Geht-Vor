package pgdp.security;

public class FlagPost extends SignalPost {
    public FlagPost(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {
        return false;
    }

    @Override
    public boolean down(String type) {
        return false;
    }

    public String toString() {
        return null;
    }
}
