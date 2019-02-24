package com.sym.shopping.base;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ResponseResult {

    // 响应code
    private Integer code;
    // 消息内容
    private String msg;
    // 返回data
    private Object data;

    public ResponseResult(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
