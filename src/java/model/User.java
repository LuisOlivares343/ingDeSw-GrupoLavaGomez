package model;

public class User {
  String rfc, name, lastName, address, tel, birth, mail, psw, type;

  public User() {
  }

  public User(String rfc, String name, String lastName, String address, String tel, String birth, String mail, String psw, String type) {
    this.rfc = rfc;
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.tel = tel;
    this.birth = birth;
    this.mail = mail;
    this.psw = psw;
    this.type = type;
  }

  public String getRfc() {
    return rfc;
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getPsw() {
    return psw;
  }

  public void setPsw(String psw) {
    this.psw = psw;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  
  
}
