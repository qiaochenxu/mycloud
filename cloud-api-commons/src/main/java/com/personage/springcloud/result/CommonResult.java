package com.personage.springcloud.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud.entities
 * @CreateTime: 2021-11-13 02:36
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private  T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }

    public static CommonResult sueecss(){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(200);
        commonResult.setMessage("成功");
        return commonResult;
    }

}
