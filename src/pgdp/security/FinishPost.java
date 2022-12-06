package pgdp.security;

public class FinishPost extends FlagPost {
    public FinishPost(int postNumber) {
        super(postNumber);
    }

    public boolean up(String type) {
        super.up(type);
        return false;
    }

    @Override
    public boolean down(String type) {
        super.down(type);
        return false;
    }
}
