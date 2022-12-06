package pgdp.security;

public class Track {

    private SignalPost[] posts;
    public Track(int n) {
        if (n >= 0) {
            posts = new SignalPost[n];
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    posts[i] = new FinishPost(i);
                } else if (i % 3 == 0) {
                    posts[i] = new LightPanel(i);
                } else {
                    posts[i] = new FlagPost(i);
                }
            }
        } else {
            posts = new SignalPost[10];
            for (int i = 0; i < 10; i++) {
                if (i == 9) {
                    posts[i] = new FinishPost(i);
                } else if (i % 3 == 0) {
                    posts[i] = new LightPanel(i);
                } else {
                    posts[i] = new FlagPost(i);
                }
            }
        }
    }

    public void setAll(String type, boolean up) {

    }

    public void setRange(String type, boolean up, int start, int end) {

    }

    public void createHazardAt(int start, int end) {

    }

    public void removeHazardAt(int start, int end) {

    }

    public void createLappedCarAt(int post) {

    }

    public void removeLappedCarAt(int post) {

    }

    public void printStatus() {

    }

    //Getter und Setter

    public SignalPost[] getPosts() {
        return posts;
    }

    public void setPosts(SignalPost[] posts) {
        this.posts = posts;
    }
}
