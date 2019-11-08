package com.solicitacoesanexos.filedemo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "anexos")
public class DBFile {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fileName;

    private String fileType;

    public DBFile(String id, String fileName, String fileType, int idSolicitacao, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.idSolicitacao = idSolicitacao;
        this.data = data;
    }

    public int getIdSolicitacao() {
        return this.idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public DBFile id(String id) {
        this.id = id;
        return this;
    }

    public DBFile fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public DBFile fileType(String fileType) {
        this.fileType = fileType;
        return this;
    }

    public DBFile idSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
        return this;
    }

    public DBFile data(byte[] data) {
        this.data = data;
        return this;
    }

    private int idSolicitacao;

    @Lob
    private byte[] data;

    public DBFile() {

    }

    public DBFile(String fileName, String fileType, byte[] data, int idSolicitacao) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
