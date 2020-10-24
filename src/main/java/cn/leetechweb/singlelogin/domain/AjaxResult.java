package cn.leetechweb.singlelogin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Project Name: single_spot_login
 * Create Time: 2020/10/11 20:02
 *
 * @author junyu lee
 **/
@Data
@AllArgsConstructor
public class AjaxResult {
    public boolean hasError;
    public Object data;

    public static AjaxResult success(Object data) {
        return new AjaxResult(false, data);
    }

    public static AjaxResult fail(Object data) {
        return new AjaxResult(true, data);
    }
}
