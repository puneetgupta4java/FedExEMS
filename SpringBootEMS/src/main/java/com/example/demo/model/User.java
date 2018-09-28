package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	private String name;
	private String mail;
	private String designation;
	private String project;
	private String oracleid;
	private String seat;
	private String img;
	private String imgurl;
	private String extension;
	private String du;

	public User() {
	}

	public User(String id, String name, String mail, String designation, String project, String oracleid, String seat,
			String img, String imgurl, String extension, String du) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.designation = designation;
		this.project = project;
		this.oracleid = oracleid;
		this.seat = seat;
		this.img = img;
		this.imgurl = imgurl;
		this.extension = extension;
		this.du = du;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getOracleid() {
		return oracleid;
	}

	public void setOracleid(String oracleid) {
		this.oracleid = oracleid;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getDu() {
		return du;
	}

	public void setDu(String du) {
		this.du = du;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mail=" + mail + ", designation=" + designation + ", project="
				+ project + ", oracleid=" + oracleid + ", seat=" + seat + ", img=" + img + ", imgurl=" + imgurl
				+ ", extension=" + extension + ", du=" + du + "]";
	}

}