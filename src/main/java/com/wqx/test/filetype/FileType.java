package com.wqx.test.filetype;

import lombok.Data;

@Data
public class FileType {
    //文件扩展名
    private String type;
    //文件头标识HEX
    private String hex;
    //文件描述
    private String description;

}
