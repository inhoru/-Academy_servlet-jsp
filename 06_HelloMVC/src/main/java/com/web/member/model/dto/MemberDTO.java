package com.web.member.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
	
	private String userId;
	private String password;
	private String userName;
	private char gender;
	private int age;
	private String phone;
	private String address;
	private String email;
	private String[] hobby;
	private Date enrollDate;
	
}
