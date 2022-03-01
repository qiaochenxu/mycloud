package com.personage.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @BelongsProject: mycloud
 * @BelongsPackage: com.personage.springcloud.entities
 * @CreateTime: 2021-11-13 02:33
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
