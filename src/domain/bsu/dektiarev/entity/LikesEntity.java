package domain.bsu.dektiarev.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by USER on 31.03.2016.
 */
@Entity
@Table(name = "likes", schema = "newsdb")
public class LikesEntity implements Serializable {

    private static final long serialVersionUID = 1148903404164551073L;

    @Id
    @Column(name = "news_id")
    private Integer newsEntityId;

    @PrimaryKeyJoinColumn
    @OneToOne
    private NewsEntity newsByNewsId;

    @Column(name = "q_likes")
    private Integer likesCount;

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

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LikesEntity)) return false;
        LikesEntity that = (LikesEntity) o;
        return Objects.equals(getNewsByNewsId(), that.getNewsByNewsId()) &&
                Objects.equals(getLikesCount(), that.getLikesCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNewsByNewsId(), getLikesCount());
    }

    @Override
    public String toString() {
        return "LikesEntity{" +
                "newsByNewsId=" + newsByNewsId +
                ", likesCount=" + likesCount +
                '}';
    }
}
