package com.tli.amin.company;

import com.tli.amin.enums.DocumentType;
import com.tli.amin.model.BaseEntity;

import javax.persistence.*;

@Entity
public class CompanyDocument extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private DocumentType documentType;

    private String documentName;

    private String uploadedBy;

    private String filePath;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
