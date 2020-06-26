package com.soft1851.evaluation.domain.vo;

import com.soft1851.evaluation.domain.model.ModuleChoice;
import com.soft1851.evaluation.domain.model.ModuleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/6/22 10:33
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuleVo {
    private Integer moduleId;

    private String title;

    private String introduction;

    private String img;

    private Integer status;

    private List<ModuleType> typeList;

    private List<ModuleChoice> choiceList;

    private Integer userId;
}
