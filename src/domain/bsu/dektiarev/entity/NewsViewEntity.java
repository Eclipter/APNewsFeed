package domain.bsu.dektiarev.entity;

/**
 * Created by USER on 05.05.2016.
 */
public class NewsViewEntity {

    private static final int PREVIEW_LENGTH = 100;
    private Integer id;
    private String title;
    private String imageUrl;
    private String description;
    private String preDescription;

    public NewsViewEntity(Integer id, String title, String imageUrl, String description) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.preDescription = description.length() >= PREVIEW_LENGTH ?
                description.substring(0, PREVIEW_LENGTH - 1) + "..." :
                description;
    }

    public String getPreDescription() {
        return preDescription;
    }

    public void setPreDescription(String preDescription) {
        this.preDescription = preDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
