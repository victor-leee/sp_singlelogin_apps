package cn.leetechweb.singlelogin.controller;

import cn.leetechweb.singlelogin.dao.AddressDao;
import cn.leetechweb.singlelogin.dao.impl.InMemoryAddressDaoImpl;
import cn.leetechweb.singlelogin.domain.Address;
import cn.leetechweb.singlelogin.domain.AjaxResult;
import cn.leetechweb.singlelogin.domain.RemoteResponse;
import cn.leetechweb.singlelogin.util.IOUtil;
import cn.leetechweb.singlelogin.util.TokenUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project Name: single_spot_login
 * Create Time: 2020/10/11 18:56
 *
 * @author junyu lee
 **/
public class AddressController extends HttpServlet {

    AddressDao addressDao = InMemoryAddressDaoImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tokenValue = TokenUtil.extractTokenFromHttpRequest(req);
        RemoteResponse authResp = TokenUtil.sendTokenVerification(tokenValue);
        if (authResp.isError()) {
            IOUtil.writeObjectToOutputStream(resp, AjaxResult.fail("获取信息失败：您没有登录"));
        }else {
            //根据服务器返回的用户昵称查询地址信息
            String nickname = authResp.getData();
            Address address = addressDao.findAddressByNickname(nickname);
            if (address != null) {
                IOUtil.writeObjectToOutputStream(resp, AjaxResult.success(address));
            }else {
                IOUtil.writeObjectToOutputStream(resp, AjaxResult.fail("获取信息失败：没有您的地址信息"));
            }
        }
    }
}
