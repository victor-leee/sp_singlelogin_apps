package cn.leetechweb.singlelogin.domain;

import lombok.Data;

/**
 * Project Name: single_spot_login
 * Create Time: 2020/10/11 18:53
 *
 * @author junyu lee
 **/
@Data
public class User {
    public String nickname;

    public Address address;
}
