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
 * @Date: 2020/6/16 9:39
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moduleId;

    @NotNull
    @Column
    private String title;

    /**
     * 欢迎语
     */
    @NotNull
    @Column
    private String introduction;

    /**
     * 欢迎图片
     */
    @Column
    private String img;

    /**
     * 状态
     */
    @NotNull
    @Column
    private Integer status;

    @NotNull
    @Column
    private Integer userId;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id1")
    private List<ModuleType> typeList;
}
