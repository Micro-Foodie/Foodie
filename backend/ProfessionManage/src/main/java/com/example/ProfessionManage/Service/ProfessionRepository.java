package com.example.ProfessionManage.Service;

import com.example.ProfessionManage.DTO.PROFESSION;
import com.example.ProfessionManage.DTO.T_COMMENT;
import com.example.ProfessionManage.DTO.T_USER;
import com.example.ProfessionManage.Mapper.ProfessionMapper;
import com.example.ProfessionManage.Mapper.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProfessionRepository {

    @Autowired
    private ProfessionMapper ProfessionMapper;
    @Autowired
    private UserDataMapper UserDataMapper;

    public Map<String, Object> getUnprocessedProfessions() {
        Map<String, Object> result = new HashMap<>();
        List<PROFESSION> professionData=ProfessionMapper.findUnprocessedProfessions();

        if (!professionData.isEmpty()) {
            result.put("code", 200);
            result.put("msg", "success");
            result.put("data", professionData);
        } else {
            result.put("code", 400);
            result.put("msg", "当前没有新的专业申请");
        }

        return result;
    }
    public Map<String, Object> findProfessionById(int requestId, int response) {
        Map<String, Object> result = new HashMap<>();
        int code = 200;
        String msg = "success";

        List<PROFESSION> professionOptional = ProfessionMapper.findByRequestId(requestId);

        if (professionOptional.isEmpty()) {
            code = 400;
            msg = "认证申请不存在";
        } else {
            PROFESSION profession = professionOptional.get(0);
            T_USER user = UserDataMapper.findUserByUserId(profession.getUserId()).get(0);

            if (response == 2) {
                ProfessionMapper.updateIsAcceptedById(profession.getUserId(),2);
                msg = "申请已拒绝";
            } else if (response == 1) {
                ProfessionMapper.updateIsAcceptedById(profession.getUserId(),1);
                if (user != null) {
                    UserDataMapper.updateProfessionalById(profession.getIllustrate(),user.getuserId());
                    msg = "申请已通过";
                }
            } else {
                code = 400;
                msg = "response参数错误";
            }
        }

        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

}
