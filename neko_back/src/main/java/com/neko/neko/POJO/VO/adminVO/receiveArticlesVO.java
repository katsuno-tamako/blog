package com.neko.neko.POJO.VO.adminVO;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class receiveArticlesVO {

    private String context_mainTitle;
    private String context_subTitle;
    private String context;
    private String chooseMainClassify;
    private String chooseSubClassify;
    private List<String> context_label;
    private String isComment;
    private String isCover;
    private String coverImg;

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

    public String getChooseMainClassify() {
        return chooseMainClassify;
    }

    public void setChooseMainClassify(String chooseMainClassify) {
        this.chooseMainClassify = chooseMainClassify;
    }

    public String getChooseSubClassify() {
        return chooseSubClassify;
    }

    public void setChooseSubClassify(String chooseSubClassify) {
        this.chooseSubClassify = chooseSubClassify;
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
        return "receiveArticlesVO{" +
                "context_mainTitle='" + context_mainTitle + '\'' +
                ", context_subTitle='" + context_subTitle + '\'' +
                ", context='" + context + '\'' +
                ", chooseMainClassify='" + chooseMainClassify + '\'' +
                ", chooseSubClassify='" + chooseSubClassify + '\'' +
                ", context_label=" + context_label +
                ", isComment='" + isComment + '\'' +
                ", isCover='" + isCover + '\'' +
                ", coverImg='" + coverImg + '\'' +
                '}';
    }
}
