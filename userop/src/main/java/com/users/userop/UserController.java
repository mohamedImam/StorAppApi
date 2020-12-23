package com.users.userop;

import com.data.models.ConstantClass;
import com.data.models.CommonResponse;
import com.data.models.users.User;
import com.users.userop.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 15:05
 */
@RestController
@RequestMapping(value = "api/users")
public class UserController {
@Autowired
    MainService mainService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public CommonResponse changPassword(@RequestBody User user) {
        try {
            return mainService.AddUser(user);

        }catch (Exception e){
            return new CommonResponse(ConstantClass.ErorrMesseges.FailMes,ConstantClass.ErorrCodes.FailCode,ConstantClass.StatusMesseges.FalseStatus,ConstantClass.HelperClass.getUUID());
        }

    }
}
