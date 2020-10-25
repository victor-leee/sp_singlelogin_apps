package cn.leetechweb.singlelogin.dao.impl;

import cn.leetechweb.singlelogin.dao.AddressDao;
import cn.leetechweb.singlelogin.domain.Address;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Project Name: single_spot_login
 * Create Time: 2020/10/11 19:03
 *
 * @author junyu lee
 **/
public class InMemoryAddressDaoImpl implements AddressDao {

    private static InMemoryAddressDaoImpl inMemoryAddressDao;

    private static Map<String,Address> addressMap;

    @Override
    public Address findAddressByNickname(String nickname) {
        return addressMap.get(nickname);
    }

    private InMemoryAddressDaoImpl() {

    }

    public static InMemoryAddressDaoImpl getInstance() {
        if (inMemoryAddressDao == null) {
            synchronized (InMemoryAddressDaoImpl.class) {
                if (inMemoryAddressDao == null) {
                    init();
                }
            }
        }
        return inMemoryAddressDao;
    }

    private static void init() {
        inMemoryAddressDao = new InMemoryAddressDaoImpl();
        //初始化一些用户信息
        addressMap = new ConcurrentHashMap<>(16);
        //一号用户
        Address ljyAddress = new Address();
        ljyAddress.setDistrict("沙坪坝区");
        ljyAddress.setProvince("重庆市");
        ljyAddress.setCity("重庆市");
        addressMap.put("王赛宇", ljyAddress);
        //二号用户
        Address unkAdd = new Address();
        unkAdd.setProvince("四川省");
        unkAdd.setCity("成都市");
        unkAdd.setDistrict("哈哈区");
        addressMap.put("哈哈", unkAdd);
        //三号用户
        Address fzb = new Address();
        fzb.setProvince("重庆市");
        fzb.setCity("重庆市");
        fzb.setDistrict("沙坪坝区");
        addressMap.put("fangzhibin", fzb);
    }
}
