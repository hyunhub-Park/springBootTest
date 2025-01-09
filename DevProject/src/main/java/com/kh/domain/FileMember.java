package com.kh.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
//@AllArgsConstructor	// 모든 매개변수를 받을 수 있는 생성자.
//@Getter
//@Setter
// @Builder
@ToString(exclude = "content")
//@ToString
@EqualsAndHashCode(of="boardNo")
public class FileMember 
{
	private String userId; 
	private String password;
	// private MultipartFile picture;
	private List <MultipartFile> picture;

}
