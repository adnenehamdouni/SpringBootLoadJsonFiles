package com.qugenx.jsonfiles.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO implements Serializable {

    private long id;
    private String name;
    private String author;
    private boolean isDeleted;
    private Date createdAt;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
