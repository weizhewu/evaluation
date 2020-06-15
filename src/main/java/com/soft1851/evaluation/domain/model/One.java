package com.soft1851.evaluation.domain.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/6/9 8:48
 * @Description: 每个小模块
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class One {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer one_id;

    /**
     * 每个小模块的题目
     */
    @NotNull
    @Column
    private String question;

    /**
     * 是否多选、单选、选填
     */
    @NotNull
    @Column
    private Integer status;

    @NotNull
    @Column
    private Integer tem;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "one_id")
    private List<Choice> list;


}
