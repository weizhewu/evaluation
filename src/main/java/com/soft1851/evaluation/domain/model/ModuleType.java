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
 * @Date: 2020/6/16 9:48
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ModuleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moduleTypeId;

    @Column
    @NotNull
    private String question;

    @Column
    @NotNull
    private Integer status;

    @Column
    @NotNull
    private boolean need;

    @Column
    @NotNull
    private Integer moduleId1;

    @Column
    @NotNull
    private Integer min;

    @Column
    @NotNull
    private Integer max;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "list_type_id")
    private List<ModuleChoice> choiceList;
}
