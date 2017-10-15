package com.book.library.repository.mongo.request;

public class SearchBookRequest {
    public String authorName;
    public String countryName;
    public Integer publishYearStart;
    public Integer publishYearEnd;
    public String editionName;
    public String editionCreatorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getPublishYearStart() {
        return publishYearStart;
    }

    public void setPublishYearStart(Integer publishYearStart) {
        this.publishYearStart = publishYearStart;
    }

    public Integer getPublishYearEnd() {
        return publishYearEnd;
    }

    public void setPublishYearEnd(Integer publishYearEnd) {
        this.publishYearEnd = publishYearEnd;
    }

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public String getEditionCreatorName() {
        return editionCreatorName;
    }

    public void setEditionCreatorName(String editionCreatorName) {
        this.editionCreatorName = editionCreatorName;
    }

    @Override
    public String toString() {
        return "SearchBookRequest{" +
                "authorName='" + authorName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", publishYearStart=" + publishYearStart +
                ", publishYearEnd=" + publishYearEnd +
                ", editionName='" + editionName + '\'' +
                ", editionCreatorName='" + editionCreatorName + '\'' +
                '}';
    }
}
