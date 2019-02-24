package com.sym.shopping.base;

public class BaseController {

    // 返回成功 ,data值为null
    public ResponseResult setResultSuccess() {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
    }
    // 返回成功 ,data可传
    public ResponseResult setResultSuccess(Object data) {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
    }
    // 返回失败
    public ResponseResult setResultError(String msg){
        return setResult(Constants.HTTP_RES_CODE_500,msg, null);
    }
    // 自定义返回结果
    public ResponseResult setResult(Integer code, String msg, Object data) {

        ResponseResult.ResponseResultBuilder responseResult = ResponseResult.builder();
        if(data!=null){
            return responseResult.code(code).msg(msg).data(data).build();
        }
        return responseResult.code(code).msg(msg).build();
    }
}
