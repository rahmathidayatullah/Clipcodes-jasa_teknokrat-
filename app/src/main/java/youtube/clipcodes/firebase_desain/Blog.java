package youtube.clipcodes.firebase_desain;

/**
 * Created by Windows on 1/12/2018.
 */

public class Blog {

    private String title;
    private String desc;

    public Blog(){

    }

    public Blog(String title, String desc, String image, String hp, String git) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.hp = hp;
        this.git = git;
    }

    private String image;
    private String hp;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    private String git;

}
