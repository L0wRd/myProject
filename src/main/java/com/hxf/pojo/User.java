package com.hxf.pojo;

import lombok.*;

/**
 * @author: hxf
 * @date: 2019/9/11 17:08
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class User {

    private Long id;

    private String name;

    private Integer age;
}
