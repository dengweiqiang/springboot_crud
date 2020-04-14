package top.dengwq.springboot_crud.test;

import com.alibaba.druid.filter.config.ConfigTools;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dengweiqiang on 2020/4/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EncryptorTest {

    @Autowired
    StringEncryptor encryptor;

    /**
     * ulisesbocchio 加密组件
     */
    @Test
    public void getPass() {
        String url = encryptor.encrypt("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("123456");
        System.out.println("URL加密后明文: " + url);
        System.out.println("Name加密后明文: " + name);
        System.out.println("Password加密后明文: " + password);
        Assert.assertTrue(name.length() > 0);
        Assert.assertTrue(password.length() > 0);
    }

    /**
     * druid 加密组件
     * @throws Exception
     */
    @Test
    public void druidEncrypt() throws Exception {
        //密码明文
        String password = "123456";
        System.out.println("明文密码: " + password);
        String[] keyPair = ConfigTools.genKeyPair(512);
        //私钥
        String privateKey = keyPair[0];
        //公钥
        String publicKey = keyPair[1];

        //用私钥加密后的密文
        password = ConfigTools.encrypt(privateKey, password);

        System.out.println("privateKey:" + privateKey);
        System.out.println("publicKey:" + publicKey);

        System.out.println("password:" + password);

        String decryptPassword = ConfigTools.decrypt(publicKey, password);
        System.out.println("解密后:" + decryptPassword);
    }

}
