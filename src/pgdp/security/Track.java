package pgdp.security;

public class Track {

    private SignalPost[] posts;
    public Track(int n) {
        if (n > 0) {
            posts = new SignalPost[n];
        } else {
            posts = new SignalPost[10];
        }
        for (int i = 0; i < posts.length; i++) {
            if (i == n - 1) {
                posts[i] = new FinishPost(i);
            } else if (i % 3 == 0) {
                posts[i] = new LightPanel(i);
            } else {
                posts[i] = new FlagPost(i);
            }
        }
    }

    public void setAll(String type, boolean up) {
        if (up) {
            for (int i = 0; i < posts.length; i++) {
                posts[i].up(type);
            }
        } else {
            for (int i = 0; i < posts.length; i++) {
                posts[i].down(type);
            }
        }
    }

    public void setRange(String type, boolean up, int start, int end) {
        if (up) {
            for (int i = start; i <= end; i++) {
                posts[i].up(type);
                if (i == posts.length) {
                    i = 0;
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                posts[i].down(type);
                if (i == posts.length) {
                    i = 0;
                }
            }
        }
    }

    public void createHazardAt(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i == end) {
                posts[i].up("green");
                break;
            }
            posts[i].up("yellow");
            if (i == posts.length) {
                i = 0;
            }
        }
    }

    public void removeHazardAt(int start, int end) {
        for (int i = start; i <= end; i++) {
            posts[i].down("danger");
            if (i == posts.length) {
                i = 0;
            }
        }
    }

    public void createLappedCarAt(int post) {
        for (int i = post; i <= post + 3; i++) {
            posts[i].up("blue");
            if (i == posts.length) {
                i = 0;
            }
        }
    }

    public void removeLappedCarAt(int post) {
        for (int i = post; i <= post + 3; i++) {
            posts[i].down("blue");
            if (i == posts.length) {
                i = 0;
            }
        }
    }

    public void printStatus() {
        String output = "";
        for (int i = 0; i < posts.length; i++) {
            output = output + posts[i].toString() + "\n";
        }
        System.out.println(output);
    }

    //Getter und Setter

    public SignalPost[] getPosts() {
        return posts;
    }

    public void setPosts(SignalPost[] posts) {
        this.posts = posts;
    }
}
