package domain.bsu.dektiarev.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by USER on 31.03.2016.
 */
@Entity
@Table(name = "views", schema = "newsdb")
public class ViewsEntity implements Serializable {

    private static final long serialVersionUID = 1148903404164551073L;

    @Id
    @Column(name = "news_id")
    private Integer newsEntityId;

    @PrimaryKeyJoinColumn
    @OneToOne
    private NewsEntity newsByNewsId;

    @Column(name = "q_views")
    private Integer viewsCount;

    public Integer getNewsEntityId() {
        return newsEntityId;
    }

    public void setNewsEntityId(Integer newsEntityId) {
        this.newsEntityId = newsEntityId;
    }

    public NewsEntity getNewsByNewsId() {
        return newsByNewsId;
    }

    public void setNewsByNewsId(NewsEntity newsByNewsId) {
        this.newsByNewsId = newsByNewsId;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ViewsEntity)) return false;
        ViewsEntity that = (ViewsEntity) o;
        return Objects.equals(getNewsByNewsId(), that.getNewsByNewsId()) &&
                Objects.equals(getViewsCount(), that.getViewsCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNewsByNewsId(), getViewsCount());
    }

    @Override
    public String toString() {
        return "LikesEntity{" +
                "newsByNewsId=" + newsByNewsId +
                ", viewsCount=" + viewsCount +
                '}';
    }
}
