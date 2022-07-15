package payload;

import java.util.Date;

public class ProductResponse {
    private Long id;
    private String titles;
    private String textData;
    private String description;
    private String sourcelinkTo;
    private String photofile;
    private String name;
    private Date created_at;
    private Date updated_at;

    public ProductResponse() {
    }

    public ProductResponse(Long id, String titles, String description, String sourcelinkTo, String photofile, String name, Date created_at) {
        this.id = id;
        this.titles = titles;
        this.description = description;
        this.sourcelinkTo = sourcelinkTo;
        this.photofile = photofile;
        this.name = name;
        this.created_at = created_at;
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

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
