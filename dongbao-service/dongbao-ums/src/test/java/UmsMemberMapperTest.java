import com.msb.dongbaoums.entity.UmsMember;
import com.msb.dongbaoums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = com.msb.dongbaoums.DongbaoUMSApplication.class)
public class UmsMemberMapperTest {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Test
//	@Rollback
//	@Transactional
    void testInsert(){
        UmsMember t = new UmsMember();
        t.setUsername("cpf2");
        t.setStatus(0);
        t.setPassword("1");
        t.setNote("note");
        t.setNickName("nick");
        t.setEmail("email");

        umsMemberMapper.insert(t);

//		UmsMember cpf1 = umsMemberMapper.selectByName("nick");
//        Long id = cpf1.getId();
//        System.out.println("id:"+id);
    }


}