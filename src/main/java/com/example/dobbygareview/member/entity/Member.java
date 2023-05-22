package com.example.dobbygareview.member.entity;

import com.example.dobbygareview.common.entity.BaseEntity;
import com.example.dobbygareview.member.enums.MemberRole;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	private String email;

	@Setter
	private String pw;

	@Setter
	@Enumerated(EnumType.STRING)
	private MemberRole memberRole;
}
