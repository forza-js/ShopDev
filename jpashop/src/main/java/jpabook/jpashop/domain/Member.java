package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	@Id @GeneratedValue
	@Column(name = "member_id") //외래키로 합쳐야하므로 name 지정.
	private Long id;
	
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>(); // NullpointException 나올일 없음. 컬렉션은 필드에서 초기화하는게 안전.
	// 하이버네이트는 영속화때,컬렉션을 감싸서, 하이버네이트가제공하는 내장 컬렉션으로 변경함. 
	
	
}
