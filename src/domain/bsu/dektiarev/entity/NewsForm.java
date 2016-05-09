package domain.bsu.dektiarev.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by USER on 08.05.2016.
 */
public class NewsForm {

    private String title;
    private String description;
    private MultipartFile image;

    public NewsForm(String title, String description, MultipartFile image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
