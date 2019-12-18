package com.ip.bookstoreip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class Files {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
	@Column
    private byte[] filecontent;
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public byte[] getFilecontent() {
        return filecontent;
    }

    public void setFilecontent(byte[] filecontent) {
        this.filecontent = filecontent;
    }
}
