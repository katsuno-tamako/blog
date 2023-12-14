package com.neko.neko.POJO.VO.ArticleVO;

import org.springframework.stereotype.Component;
import java.util.List;
import java.io.Serializable;

@Component
public class ArticleVO implements Serializable {

    private int id;
    private String date;                        // 日期
    private String articleId;                   // 文章id
    private String context_mainTitle;           // 主标题
    private String context_subTitle;            // 副标题
    private String context;                     // 文章内容
    private String mainClassify;                // 一级分类
    private String subClassify;                 // 二级分类
    private List<String> context_label;         // 文章标签
    private String isComment;                   // 可否评论
    private String isCover;                     // 是否有封面图片
    private String coverImg;                    // 封面图片

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getContext_mainTitle() {
        return context_mainTitle;
    }

    public void setContext_mainTitle(String context_mainTitle) {
        this.context_mainTitle = context_mainTitle;
    }

    public String getContext_subTitle() {
        return context_subTitle;
    }

    public void setContext_subTitle(String context_subTitle) {
        this.context_subTitle = context_subTitle;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getMainClassify() {
        return mainClassify;
    }

    public void setMainClassify(String mainClassify) {
        this.mainClassify = mainClassify;
    }

    public String getSubClassify() {
        return subClassify;
    }

    public void setSubClassify(String subClassify) {
        this.subClassify = subClassify;
    }

    public List<String> getContext_label() {
        return context_label;
    }

    public void setContext_label(List<String> context_label) {
        this.context_label = context_label;
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment;
    }

    public String getIsCover() {
        return isCover;
    }

    public void setIsCover(String isCover) {
        this.isCover = isCover;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    @Override
    public String toString() {
        return "ArticleVO{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", articleId='" + articleId + '\'' +
                ", context_mainTitle='" + context_mainTitle + '\'' +
                ", context_subTitle='" + context_subTitle + '\'' +
                ", context='" + context + '\'' +
                ", mainClassify='" + mainClassify + '\'' +
                ", subClassify='" + subClassify + '\'' +
                ", context_label=" + context_label +
                ", isComment='" + isComment + '\'' +
                ", isCover='" + isCover + '\'' +
                ", coverImg='" + coverImg + '\'' +
                '}';
    }
}
