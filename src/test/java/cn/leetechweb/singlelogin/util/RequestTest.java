package cn.leetechweb.singlelogin.util;

import cn.leetechweb.singlelogin.domain.RemoteResponse;
import org.junit.Test;

/**
 * Project Name: single_spot_login
 * Create Time: 2020/10/11 20:22
 *
 * @author junyu lee
 **/
public class RequestTest {
    @Test
    public void testCon() {
        RemoteResponse remoteResponse = TokenUtil.sendTokenVerification("17228C4A5F834EE813969003119qq");
        System.out.println(remoteResponse);
    }
}
