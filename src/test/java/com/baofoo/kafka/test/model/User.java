package com.baofoo.kafka.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by LZQ on 14-10-17.
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 6977402643848374753L;

    private String userName;

    private String passWord;

    private String withSpring;
}
