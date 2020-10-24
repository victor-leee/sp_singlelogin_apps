package cn.leetechweb.singlelogin.dao;

import cn.leetechweb.singlelogin.domain.Address;

/**
 * 地址修改接口
 * Project Name: single_spot_login
 * Create Time: 2020/10/11 19:02
 *
 * @author junyu lee
 **/
public interface AddressDao {
    /**
     * 根据用户名查询其对应的地址信息
     * @param nickname 用户名昵称
     * @return  该用户名对应的地址信息
     */
    Address findAddressByNickname(String nickname);
}
