package com.soft1851.evaluation.domain.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/16 9:54
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ModuleChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moduleChoiceId;

    @NotNull
    @Column
    private String content;

    @NotNull
    @Column
    private Integer code;

    @NotNull
    @Column
    private Integer moduleTypeId;
}
