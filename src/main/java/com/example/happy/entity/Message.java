package com.example.happy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    /**
     * 类型
     */
    private String type;

    /**
     * 内容
     */
    @NotBlank(message = "消息内容content不能为空")
    private String content;

}
