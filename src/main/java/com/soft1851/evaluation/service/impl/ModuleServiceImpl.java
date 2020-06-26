package com.soft1851.evaluation.service.impl;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.common.ResultCode;
import com.soft1851.evaluation.domain.model.Module;
import com.soft1851.evaluation.domain.model.ModuleChoice;
import com.soft1851.evaluation.domain.model.ModuleType;
import com.soft1851.evaluation.repository.ModuleChoiceRepository;
import com.soft1851.evaluation.repository.ModuleRepository;
import com.soft1851.evaluation.repository.ModuleTypeRepository;
import com.soft1851.evaluation.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/22 10:38
 * @Description:
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Resource
    private ModuleRepository moduleRepository;
    @Resource
    private ModuleTypeRepository moduleTypeRepository;
    @Resource
    private ModuleChoiceRepository moduleChoiceRepository;


    @Override
    public ResponseResult insert(Module module) {
        Module module2 = Module.builder()
                .img(module.getImg())
                .introduction(module.getImg())
                .status(module.getStatus())
                .title(module.getTitle())
                .userId(1)
                .build();
        Module module11 = moduleRepository.save(module2);
        module11.setUserId(2);
        Module module1 = moduleRepository.saveAndFlush(module11);


        for (ModuleType moduleType : module.getTypeList()){
            moduleType.setModuleId(1);
            moduleType.setModuleId(null);
            ModuleType moduleType11 = moduleTypeRepository.save(moduleType);
            moduleType11.setModuleId(module1.getModuleId());
            ModuleType moduleType1 = moduleTypeRepository.saveAndFlush(moduleType11);

            for (ModuleChoice moduleChoice : moduleType.getChoiceList()){
                moduleChoice.setModuleTypeId(1);
                ModuleChoice moduleChoice1 = moduleChoiceRepository.save(moduleChoice);
                moduleChoice1.setModuleTypeId(moduleType1.getModuleTypeId());
                moduleChoiceRepository.saveAndFlush(moduleChoice1);
            }
        }

        return ResponseResult.success();
    }
}
