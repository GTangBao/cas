package com.goodidea.sso.authentication;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.AttributeNamedPersonImpl;
import org.jasig.services.persondir.support.StubPersonAttributeDao;
import org.springframework.stereotype.Component;

import com.goodidea.sso.entity.User;
import com.goodidea.sso.jdbc.UserDaoJdbc;

@Component(value="attributeRepository")
public class UserStubPersonAttributeDao extends StubPersonAttributeDao  {
	
	@Resource
    private UserDaoJdbc userDaoJdbc;
    @Override
    public IPersonAttributes getPerson(String uid) {
        Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();
        try {
            User user = userDaoJdbc.getByUsername(uid);
            attributes.put("userId", Collections.singletonList((Object)user.getId()));
            attributes.put("username", Collections.singletonList((Object)user.getUsername()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AttributeNamedPersonImpl(attributes);
    }
}
