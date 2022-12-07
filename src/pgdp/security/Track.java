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
            if (i == posts.length - 1) {
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
            if (start <= end) {
                for (int i = start; i <= end; i++) {
                    posts[i].up(type);
                }
            } else {
                //falls circle nötig
                if (posts.length > 0) {
                    for (int i = start; i <= end + posts.length; i++) {
                        int pos = i % posts.length;
                        posts[pos].up(type);
                    }
                }
            }
        } else {
            if (start <= end) {
                for (int i = start; i <= end; i++) {
                    posts[i].down(type);
                }
            } else {
                //falls circle nötig
                if (posts.length > 0) {
                    for (int i = start; i <= end + posts.length; i++) {
                        int pos = i % posts.length;
                        posts[pos].down(type);
                    }
                }
            }
        }
    }

    public void createHazardAt(int start, int end) {
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                if (i == end) {
                    posts[i].up("green");
                    break;
                }
                posts[i].up("yellow");
            }
        } else {
            //falls circle nötig
            for (int i = start; i <= end + posts.length; i++) {
                int pos = i % posts.length;
                if (i == end + posts.length) {
                    posts[pos].up("green");
                    break;
                }
                posts[pos].up("yellow");
            }
        }
    }

    public void removeHazardAt(int start, int end) {
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                posts[i].down("danger");
            }
        } else {
            //falls circle nötig
            for (int i = start; i <= end + posts.length; i++) {
                int pos = i % posts.length;
                posts[pos].down("danger");
            }
        }
    }

    public void createLappedCarAt(int post) {
        if (post >= 0 && post < posts.length) {
            if (post + 3 < posts.length) {
                for (int i = post; i <= post + 3; i++) {
                    posts[i].up("blue");
                }
            } else {
                //falls circle nötig
                for (int i = post; i <= post + 3; i++) {
                    int pos = i % posts.length;
                    posts[pos].up("blue");
                }
            }
        }
    }

    public void removeLappedCarAt(int post) {
        if (post >= 0 && post < posts.length) {
            if (post + 3 < posts.length) {
                for (int i = post; i <= post + 3; i++) {
                    posts[i].down("blue");
                }
            } else {
                //falls circle nötig
                for (int i = post; i <= post + 3; i++) {
                    int pos = i % posts.length;
                    posts[pos].down("blue");
                }
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
