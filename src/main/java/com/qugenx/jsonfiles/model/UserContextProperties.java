package com.qugenx.jsonfiles.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qugenx.jsonfiles.dto.ArticleDTO;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class UserContextProperties implements Serializable {

    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("articles")
    private List<ArticleDTO> articles;

    public UserContextProperties(){}

    public UserContextProperties(String status, String message, List<ArticleDTO> articles) {
        this.status = status;
        this.message = message;
        this.articles = articles;
    }

}
