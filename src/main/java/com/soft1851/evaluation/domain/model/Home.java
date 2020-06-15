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
 * @Date: 2020/6/8 8:16
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer home_id;

    @Column
    @NotNull
    private String img;

    @Column
    @NotNull
    private Integer participate;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String link;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "home_id")
    private List<HomeType> typeList;

}
