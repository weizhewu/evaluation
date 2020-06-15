package com.soft1851.evaluation.domain.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 8:26
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HomeChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer homeChoiceId;

    @NotNull
    @Column
    private String content;

    @NotNull
    @Column
    private Integer code;


}
