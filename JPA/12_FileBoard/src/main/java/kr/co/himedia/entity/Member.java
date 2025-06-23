package kr.co.himedia.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member {
  
  @Id
  private String id; 

  private String pw;

  private String name; 
  
  private String age; 
  
  private String gender; 

  private String email;
 
}
