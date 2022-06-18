package payload;

import entity.Product;

import java.util.Date;

public class ProductResponse {
    private Long id;
    private String titles;
    private String description;
    private String sourcelinkTo;
    private Date createdTime;
    private String photofile;
    private String name;

    public ProductResponse(
                           String titles,
                           String description,
                           String sourcelinkTo,
                           Date createdTime,
                           String photofile,
                           String name) {
        this.titles = titles;
        this.description = description;
        this.sourcelinkTo = sourcelinkTo;
        this.createdTime = createdTime;
        this.photofile = photofile;
        this.name = name;
    }

    public ProductResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourcelinkTo() {
        return sourcelinkTo;
    }

    public void setSourcelinkTo(String sourcelinkTo) {
        this.sourcelinkTo = sourcelinkTo;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getPhotofile() {
        return photofile;
    }

    public void setPhotofile(String photofile) {
        this.photofile = photofile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
