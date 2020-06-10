package com.soft1851.evaluation.domain.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/9 8:50
 * @Description: 选项
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer choice_id;

    @NotNull
    @Column
    private String content;

    @NotNull
    @Column
    private Integer tem;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "choice_type_id")
    private ChoiceType choiceType;
}
