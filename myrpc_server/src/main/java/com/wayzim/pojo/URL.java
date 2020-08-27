package com.wayzim.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-26 20:47
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class URL {

    private String hostName;

    private Integer port;
}
