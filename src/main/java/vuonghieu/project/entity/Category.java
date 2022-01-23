package vuonghieu.project.entity;

import javax.persistence.*;
import java.util.Date;

public class Category {


    private String codeCategory;

    private String nameCategory;

    private String createdOn;

    private String modifiedOn;


    public Category(){}

    public Category(String codeCategory, String nameCategory, String createdOn, String modifiedOn) {
        this.codeCategory = codeCategory;
        this.nameCategory = nameCategory;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }


    public String getCodeCategory() {
        return codeCategory;
    }

    public void setCodeCategory(String codeCategory) {
        this.codeCategory = codeCategory;
    }
}
