package com.testForJR.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {
 
 private static final long serialVersionUID = -5527566248002296042L;
  
 @Id
 @Column(name = "id")
 @GeneratedValue
 private Integer id;

 @Column(name = "name")

 private String name;
  
 @Column(name = "age")
 private Integer age;

 @Column(name = "isAdmin")
 private boolean admin;

 @Column(name = "createdDate")
 private Date date;

 public boolean isAdmin() {
  return admin;
 }

 public void setAdmin(boolean admin) {
  this.admin = admin;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public static long getSerialVersionUID() {
  return serialVersionUID;
 }

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public Integer getAge() {
  return age;
 }

 public void setAge(Integer age) {
  this.age = age;
 }

 public Date getDate() {
  return date;
 }

 public void setDate(Date date) {
  this.date = date;
 }
}