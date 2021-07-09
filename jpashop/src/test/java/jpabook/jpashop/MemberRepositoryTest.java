package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired MemberRepository memberRepository;
	
	@Test
	@Transactional
//	@Rollback(false) // 이거하면 테스트후에 데이터 안지움.
	public void testMember() throws Exception {
		//given
		Member member = new Member();
		member.setUsername("memberA");
		
		//when
		Long savedId = memberRepository.save(member);
		Member findMember = memberRepository.find(savedId);
		
		//then
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		
		Assertions.assertThat(findMember).isEqualTo(member);
		System.out.println("findMember == member : " + (findMember == member));
		// 영속성 컨텍스트에서 (같은 트랜잭션) 저장하고 조회하면 영속성 컨테스트가 같고, id가 같으면 같은 엔티티로 인식. 1차 캐시 참조. 
	
	}

}
