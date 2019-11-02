package com.sicau.one_car.util;

import com.sicau.one_car.common.Const;
import com.sicau.one_car.entity.vo.ResultVO;
import org.springframework.stereotype.Component;

/**
 * Description:
 * @author tzw
 * CreateTime 15:45 2019/11/2
 **/
@Component
public class ResultVOUtil {

    public ResultVO success()
    {
        ResultVO resultVO=new ResultVO();
        resultVO.setCode( Const.ResultEnum.SUCESS.getCode());
        resultVO.setMsg(Const.ResultEnum.SUCESS.getMsg());
        return resultVO;
    }
    public ResultVO success(String msg)
    {
        ResultVO resultVO=this.success();
        resultVO.setMsg(msg);
        return resultVO;
    }

    public ResultVO success(Object data)
    {
        ResultVO resultVO=this.success();
        resultVO.setData(data);
        return resultVO;
    }

    public ResultVO success(String msg,Object data)
    {
        ResultVO resultVO=this.success();
        resultVO.setMsg(msg);
        resultVO.setData(data);
        return resultVO;
    }

    public ResultVO fail()
    {
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(Const.ResultEnum.Fail.getCode());
        resultVO.setMsg(Const.ResultEnum.Fail.getMsg());
        return resultVO;
    }
    public ResultVO fail(String msg)
    {
        ResultVO resultVO=this.fail();
        resultVO.setMsg(msg);
        return resultVO;
    }

    public ResultVO unknownError()
    {
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(Const.ResultEnum.UNKNOWN_ERROR.getCode());
        resultVO.setMsg(Const.ResultEnum.UNKNOWN_ERROR.getMsg());
        return resultVO;
    }
    public ResultVO unknownError(String msg)
    {
        ResultVO resultVO=this.fail();
        resultVO.setMsg(msg);
        return resultVO;
    }
}
