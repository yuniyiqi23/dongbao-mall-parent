import com.msb.dongbao.ums.DongbaoUMSApplication;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DongbaoUMSApplication.class)
public class UmsMemberMapperTest {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Test
//	@Rollback
//	@Transactional
    void testInsert() {
        UmsMember t = new UmsMember();
        t.setUsername("李四");
        t.setStatus(0);
        t.setPassword("1");
        t.setNote("note");
        t.setNickName("nick");
        t.setEmail("email");
//        LocalDateTime now = LocalDateTime.now();
//        t.setGmtCreate(now);
//        t.setGmtModified(now);

        umsMemberMapper.insert(t);

//		UmsMember cpf1 = umsMemberMapper.selectByName("nick");
//        Long id = cpf1.getId();
//        System.out.println("id:"+id);
    }


    @Test
    public void testUpdate() {
        UmsMember t = new UmsMember();
        t.setId(65L);
        umsMemberMapper.updateById(t);
    }

}
