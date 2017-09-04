package Service;
import Member.Member;

import java.util.Map;

public interface MemberService {

    void add(Map<String, String> member);

    void update(Member member);

    Map<String, String> get(String id);

    Map<String, Map<String,String>> list();

    void delete(String id);

}
