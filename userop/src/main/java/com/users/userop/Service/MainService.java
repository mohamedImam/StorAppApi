package com.users.userop.Service;



import com.data.models.CommonResponse;
import com.data.models.ConstantClass;
import com.data.models.Repositories.UserRepository;
import com.data.models.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 15:20
 */
@Service
public class MainService {

    @Autowired
    UserRepository userRepository;
    public CommonResponse AddUser(User user) throws Exception
    {
        /*   userRepository.save(new AddUserModel(addUserModel.getUserName(),addUserModel.getUserEmail()));*/

        return new CommonResponse(
                ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        );
    }
}
