package com.kh.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
//@AllArgsConstructor	// 모든 매개변수를 받을 수 있는 생성자.
//@Getter
//@Setter
// @Builder
@ToString(exclude = "content")
//@ToString
@EqualsAndHashCode(of="boardNo")
public class Member 
{
	@NotBlank(message = "Not Blank...")
	private String userId; 
	@NotBlank(message = "Not Blank...")
	@Size(max=3)
	private String userName; 
	private String password;
	@Email
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private int coin;
	// private String car;
	// private ArrayList <String> car;
//	private String [] car;
//	private Address address;
	
	private List <String> hobbyList;
	
	private String gender;
}