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
 * @Date: 2020/6/8 8:21
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HomeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer homeTypeId;

    @Column
    @NotNull
    private String question;

    @Column
    @NotNull
    private  Integer status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "home_type_id")
    private List<HomeChoice> choiceList;

}
