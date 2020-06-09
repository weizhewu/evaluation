package com.soft1851.evaluation.domain.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/9 8:42
 * @Description: 所有的模块
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer list_id;

    /**
     * 封面
     */
    @Column
    @NotNull
    private String img;

    /**
     * 参与人数
     */
    @Column
    @NotNull
    private Integer participate;

    /**
     * 该条数据的主题
     */
    @Column
    @NotNull
    private String title;

    /**
     * 确定该条内容属于疫情防控模块还是首页还是新型冠状病毒模块
     */
    @Column
    @NotNull
    private Integer type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "list_id")
    private java.util.List<One> oneList;

}
