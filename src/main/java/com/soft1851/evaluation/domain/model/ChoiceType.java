package com.soft1851.evaluation.domain.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/9 8:54
 * @Description: 每个选项的类型
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChoiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer choice_type_id;

    /**
     * 0 文本
     * 1 单选按钮
     * 2 多选按钮
     */
    @NotNull
    @Column
    private Integer status;

}
