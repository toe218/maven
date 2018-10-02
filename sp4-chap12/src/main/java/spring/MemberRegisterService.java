package spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(),
				new Date());
		SimpleDateFormat dateFormat = 
				new SimpleDateFormat("MMddHHmmss");
		String prefix = dateFormat.format(new Date());
		long prefix1= Integer.valueOf(prefix);
		newMember.setId(prefix1);
		memberDao.insert(newMember);
	}
}
