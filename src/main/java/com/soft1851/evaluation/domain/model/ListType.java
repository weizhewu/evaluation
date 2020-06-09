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
 * @Date: 2020/6/9 8:56
 * @Description: 模块类型
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ListType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer list_type_id;

    /**
     * 类型名字
     */
    @NotNull
    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "list_type_id")
    private List<com.soft1851.evaluation.domain.model.List> lists;
}
